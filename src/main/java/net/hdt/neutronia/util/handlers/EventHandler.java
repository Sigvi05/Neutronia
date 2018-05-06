package net.hdt.neutronia.util.handlers;

import net.hdt.neutronia.init.HMItems;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ListIterator;
import java.util.Random;

@SuppressWarnings("ConstantConditions")
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        IBlockState state = event.getState();

        if (!(event.getPlayer() instanceof FakePlayer)) {
            EntityPlayer player = event.getPlayer();

            if (state.getBlock() == Blocks.MAGMA) {
                if (ConfigHandler.blockConfig.magma.turnIntoLava) {
                    if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand()) == 0) {
                        world.setBlockState(pos, Blocks.LAVA.getDefaultState(), 3);
                        player.getHeldItemMainhand().damageItem(1, player);
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onBlockPlaced(BlockEvent.PlaceEvent event) {
        BlockPos pos = event.getPos();
        IBlockState state = event.getState();
        EntityPlayer player = event.getPlayer();

        if (state.getBlock() == Blocks.BEDROCK) {
            if (player.dimension != DimensionType.NETHER.getId() || pos.getY() < 120) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onCreateFluidSource(BlockEvent.CreateFluidSourceEvent event) {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        IBlockState state = event.getState();

        if (world.provider.getDimension() == DimensionType.NETHER.getId()) {
            if (state.getBlock() == Blocks.LAVA || state.getBlock() == Blocks.FLOWING_LAVA) {
                event.setResult(ConfigHandler.dimensionConfig.nether.isLavaInfinite ? Event.Result.ALLOW : Event.Result.DEFAULT);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        Random rand = new Random();
        BlockPos deathPoint = event.getEntity().getPosition();

        if (event.getEntity() instanceof EntityWitherSkeleton) {
            ListIterator<EntityItem> iter = event.getDrops().listIterator();

            while (iter.hasNext()) {
                EntityItem entityItem = iter.next();
                ItemStack stack = entityItem.getItem();

                if (stack.getItem() == Items.BONE || stack.getItem() == Items.COAL) {
                    iter.remove();
                }
            }

            event.getDrops().add(new EntityItem(event.getEntity().world, deathPoint.getX(), deathPoint.getY(), deathPoint.getZ(), new ItemStack(HMItems.witherBone, rand.nextInt(3), 0)));
        }
    }
}