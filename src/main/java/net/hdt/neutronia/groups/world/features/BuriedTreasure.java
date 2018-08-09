package net.hdt.neutronia.groups.world.features;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.base.lib.LibMisc;
import net.hdt.neutronia.groups.tweaks.util.ItemNBTHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapDecoration.Type;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.LootFunctionManager;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BuriedTreasure extends Component {

    public static String TAG_TREASURE_MAP = "Neutronia:TreasureMap";
    public static String TAG_TREASURE_MAP_DELEGATE = "Neutronia:TreasureMapDelegate";

    ImmutableSet<ResourceLocation> tablesToEdit = ImmutableSet.of(LootTableList.CHESTS_DESERT_PYRAMID, LootTableList.CHESTS_JUNGLE_TEMPLE, LootTableList.CHESTS_STRONGHOLD_CORRIDOR);
    Map<ResourceLocation, String> customPools = new HashMap();

    int rarity, quality;

    @Override
    public void setupConfig() {
        rarity = loadPropInt("Treasure map Rarity", "", 10);
        quality = loadPropInt("Treasure map item quality", "This is used for the luck attribute in loot tables. It doesn't affect the loot you get from the map itself.", 2);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        LootFunctionManager.registerFunction(new SetAsTreasureFunction.Serializer());
    }

    @SubscribeEvent
    public void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation res = event.getName();
        if (tablesToEdit.contains(res)) {
            if (customPools.containsKey(res))
                customPools.get(res);

            event.getTable().getPool("main").addEntry(new LootEntryItem(Items.FILLED_MAP, rarity, quality, new LootFunction[]{new SetAsTreasureFunction()}, new LootCondition[0], "neutronia:treasure_map"));
        }
    }

    @SubscribeEvent
    public void onUpdate(LivingUpdateEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
                ItemStack stack = player.inventory.getStackInSlot(i);
                if (!stack.isEmpty() && stack.hasTagCompound()) {
                    if (ItemNBTHelper.getBoolean(stack, TAG_TREASURE_MAP_DELEGATE, false))
                        makeMap(stack, player.getEntityWorld(), player.getPosition());
                }
            }
        }
    }

    public ItemStack makeMap(ItemStack itemstack, World world, BlockPos sourcePos) {
        Random r = world.rand;

        BlockPos treasurePos;
        boolean validPos = false;
        int tries = 0;

        do {
            if (tries > 100)
                return null;

            int distance = 400 + r.nextInt(200);
            double angle = r.nextFloat() * (Math.PI * 2);
            int x = (int) (sourcePos.getX() + Math.cos(angle) * distance);
            int z = (int) (sourcePos.getZ() + Math.sin(angle) * distance);
            treasurePos = world.getTopSolidOrLiquidBlock(new BlockPos(x, 255, z)).add(0, -4, 0);
            IBlockState state = world.getBlockState(treasurePos);
            if (state.getBlock() == Blocks.DIRT)
                validPos = true;
            tries++;
        } while (!validPos);

        String s = "map_" + itemstack.getMetadata();
        MapData mapdata = new MapData(s);
        world.setData(s, mapdata);
        mapdata.scale = 1;
        mapdata.xCenter = treasurePos.getX() + (int) ((Math.random() - 0.5) * 100);
        mapdata.zCenter = treasurePos.getZ() + (int) ((Math.random() - 0.5) * 100);
        mapdata.dimension = 0;
        mapdata.trackingPosition = true;
        mapdata.unlimitedTracking = true;
        ItemMap.renderBiomePreviewMap(world, itemstack);
        mapdata.addTargetDecoration(itemstack, treasurePos, "x", Type.TARGET_X);

        mapdata.markDirty();

        world.setBlockState(treasurePos, Blocks.CHEST.getDefaultState());
        TileEntityChest chest = (TileEntityChest) world.getTileEntity(treasurePos);

        chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, r.nextLong());

        ItemNBTHelper.setBoolean(itemstack, TAG_TREASURE_MAP, true);
        ItemNBTHelper.setBoolean(itemstack, TAG_TREASURE_MAP_DELEGATE, false);

        return itemstack;
    }

    public int xy(int x, int y) {
        return x + y * 128;
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

    public static class SetAsTreasureFunction extends LootFunction {

        protected SetAsTreasureFunction() {
            super(new LootCondition[0]);
        }

        @Override
        public ItemStack apply(ItemStack stack, Random rand, LootContext context) {
            int id = context.getWorld().getUniqueDataId("map");
            stack.setItemDamage(id);
            stack.setTranslatableName("neutroniaMisc.buried_chest_map");
            NBTTagCompound cmp = ItemNBTHelper.getCompound(stack, "display", false);
            cmp.setInteger("MapColor", 0x8C0E0E);
            ItemNBTHelper.setCompound(stack, "display", cmp);
            ItemNBTHelper.setBoolean(stack, TAG_TREASURE_MAP_DELEGATE, true);

            return stack;
        }

        public static class Serializer extends LootFunction.Serializer<SetAsTreasureFunction> {

            protected Serializer() {
                super(new ResourceLocation(LibMisc.MOD_ID, "set_treasure"), SetAsTreasureFunction.class);
            }

            @Override
            public void serialize(JsonObject object, SetAsTreasureFunction functionClazz,
                                  JsonSerializationContext serializationContext) {
            }

            @Override
            public SetAsTreasureFunction deserialize(JsonObject object, JsonDeserializationContext deserializationContext,
                                                     LootCondition[] conditionsIn) {
                return new SetAsTreasureFunction();
            }
        }
    }

}
