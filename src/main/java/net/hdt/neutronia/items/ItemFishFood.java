package net.hdt.neutronia.items;

import net.hdt.neutronia.properties.FishType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFishFood extends ItemFood {
    /**
     * Indicates whether this fish is "cooked" or not.
     */
    private final boolean cooked;
    private FishType fishType;

    public ItemFishFood(String name, CreativeTabs creativeTabs, FishType fishType, boolean cooked) {
        super(name + fishType.getName(), creativeTabs, 0, 0.0F, false);
        this.cooked = cooked;
        this.fishType = fishType;
    }

    public int getHealAmount(ItemStack stack) {
        fishType = FishType.byItemStack(stack);
        return this.cooked && fishType.canCook() ? fishType.getCookedHealAmount() : fishType.getUncookedHealAmount();
    }

    public float getSaturationModifier(ItemStack stack) {
        fishType = FishType.byItemStack(stack);
        return this.cooked && fishType.canCook() ? fishType.getCookedSaturationModifier() : fishType.getUncookedSaturationModifier();
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        fishType = FishType.byItemStack(stack);

        if (fishType == FishType.PUFFERFISH) {
            player.addPotionEffect(new PotionEffect(MobEffects.POISON, 1200, 3));
            player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 2));
            player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 300, 1));
        }

        super.onFoodEaten(stack, worldIn, player);
    }

}