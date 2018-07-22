package net.hdt.neutronia.modules.client;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.client.features.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class NeutroniaClient extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new ShulkerBoxTooltip());
        registerFeature(new FoodTooltip());
        registerFeature(new GreenerGrass());
        registerFeature(new MapTooltip());
        registerFeature(new VisualStatDisplay());
        registerFeature(new ImprovedSignEdit());
        registerFeature(new UsageTicker());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Items.ENDER_EYE);
    }
}
