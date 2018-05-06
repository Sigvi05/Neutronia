package net.hdt.neutronia.items;

import net.hdt.neutronia.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemEasterEgg extends ItemModFood {

    public ItemEasterEgg() {
        super(Reference.MOD_ID, "easter_egg_item", CreativeTabs.FOOD, 4, 0.3F, false);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 300, 2));
        player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 300, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 300, 10));
    }

}
