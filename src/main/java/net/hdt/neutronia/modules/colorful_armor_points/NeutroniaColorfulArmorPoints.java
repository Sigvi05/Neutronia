package net.hdt.neutronia.modules.colorful_armor_points;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.colorful_armor_points.features.ColoredArmorPoints;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class NeutroniaColorfulArmorPoints extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new ColoredArmorPoints());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Items.LEATHER_CHESTPLATE);
    }

}
