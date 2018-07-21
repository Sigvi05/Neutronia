package net.hdt.neutronia.modules.decoration;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.decoration.features.DecorativeCorals;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class NeutroniaDecoration extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new DecorativeCorals());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Blocks.BOOKSHELF);
    }

}
