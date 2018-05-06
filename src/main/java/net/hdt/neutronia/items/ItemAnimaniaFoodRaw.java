package net.hdt.neutronia.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

public class ItemAnimaniaFoodRaw extends ItemAnimaniaFood {

    public ItemAnimaniaFoodRaw(String name) {
        super(1, 1f, name, new PotionEffect(MobEffects.NAUSEA, 200, 3, false, false));
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

    }

}