package net.hdt.neutronia.events;

import betterwithmods.common.potion.BWPotion;
import net.hdt.neutronia.base.BWRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class PotionEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onHarvestBlock(BlockEvent.HarvestDropsEvent event) {
        if (event.getHarvester() != null && !event.isSilkTouching() && event.getHarvester().isPotionActive(BWRegistry.POTION_FORTUNE)) {
            PotionEffect effect = event.getHarvester().getActivePotionEffect(BWRegistry.POTION_FORTUNE);
            int level = effect.getAmplifier() + 1;
            if (event.getFortuneLevel() < level) {
                event.getDrops().clear();
                event.getDrops().addAll(event.getState().getBlock().getDrops(event.getWorld(), event.getPos(), event.getState(), level));
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LootingLevelEvent event) {
        if (event.getEntityLiving() != null && event.getEntityLiving().isPotionActive(BWRegistry.POTION_LOOTING)) {
            PotionEffect effect = event.getEntityLiving().getActivePotionEffect(BWRegistry.POTION_LOOTING);
            int level = effect.getAmplifier() + 1;
            if (event.getLootingLevel() < level) {
                event.setLootingLevel(level);
            }
        }
    }

    @SubscribeEvent
    public static void onPotionUpdate(LivingEvent.LivingUpdateEvent e) {
        if (e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntity();
            for (PotionEffect potion : player.getActivePotionEffects()) {
                if (potion.getPotion() instanceof BWPotion) {
                    ((BWPotion) potion.getPotion()).tick(player);
                }
            }
        }
    }

    @SubscribeEvent
    public static void saveSoup(LivingEntityUseItemEvent.Finish event) {
        ItemStack item = event.getItem();
        if (item.getItem() instanceof ItemSoup) {
            if (item.getCount() > 0) {
                ItemStack result = event.getResultStack();
                ItemStack copy = item.copy();
                copy.shrink(1);
                event.setResultStack(copy);
                if (event.getEntityLiving() instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) event.getEntityLiving();
                    if (!player.inventory.addItemStackToInventory(result)) {
                        player.dropItem(result, false);
                    }
                }
            }
        }
    }
}
