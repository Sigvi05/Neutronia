package net.hdt.neutronia.proxy;

import net.hdt.neutronia.client.rendering.RenderTileCustomChest;
import net.hdt.neutronia.client.rendering.ResourceProxy;
import net.hdt.neutronia.tileentity.TileCustomChest;
import net.hdt.neutronia.util.LibObfuscation;
import net.hdt.neutronia.util.handlers.EntityEventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientProxy extends CommonProxy {

    public static final Map<Item, ModelBiped> armorModels = new HashMap<>();

    static ResourceProxy resourceProxy;

    static {
        List<IResourcePack> packs = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), LibObfuscation.DEFAULT_RESOURCE_PACKS);
        resourceProxy = new ResourceProxy();
        packs.add(resourceProxy);
    }

    public static void registerArmorRenders() {

        /*ModelCustomArmor custom_armor = new ModelCustomArmor(1F);
        ModelCustomArmor custom_legs = new ModelCustomArmor(0.5F);

        armorModels.put(HMItems.healmet, custom_armor);
        armorModels.put(HMItems.chestplate, custom_armor);
        armorModels.put(HMItems.leggings, custom_legs);
        armorModels.put(HMItems.boots, custom_armor);*/

    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());

        overrideBlock("stone_granite", true);
        overrideBlock("stone_andesite", true);
        overrideBlock("stone_diorite", true);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        /*ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
        IItemColor floorTile = (stack, tintIndex) -> tintIndex < 2 && stack.hasTagCompound() ? Objects.requireNonNull(stack.getTagCompound()).getInteger("color" + tintIndex) : 0xFFFFFF;
        itemColors.registerItemColorHandler(floorTile, HMBlocks.floorTile);

        BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
        IBlockColor floorTileBlock = (state, worldIn, pos, tintIndex) -> {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TileEntityFloorTile) {
                return ((TileEntityFloorTile) te).getColor(tintIndex);
            }
            return 0xFFFFFF;
        };
        blockColors.registerBlockColorHandler(floorTileBlock, HMBlocks.floorTile);*/
        ClientRegistry.bindTileEntitySpecialRenderer(TileCustomChest.class, new RenderTileCustomChest());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public void addResourceOverride(String space, String dir, String file, String ext) {
        resourceProxy.addResource(space, dir, file, ext);
    }

    private void overrideBlock(String str, boolean flag) {
        if (flag)
            addResourceOverride("textures", "blocks", str, "png");
    }

    private void overrideBlockModel(String str, boolean flag) {
        if (flag)
            addResourceOverride("models", "block", str, "json");
    }

    private void overrideItemModel(String str, boolean flag) {
        if (flag)
            addResourceOverride("models", "item", str, "json");
    }

}
