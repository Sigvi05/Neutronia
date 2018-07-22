package net.hdt.neutronia.modules.management;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.management.features.FavoriteItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class NeutroniaManagement extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new FavoriteItems());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Blocks.CHEST);
    }

}