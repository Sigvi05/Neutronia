package net.hdt.neutronia.modules.moon;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.moon.features.MoonBiomes;
import net.hdt.neutronia.modules.moon.features.MoonDimension;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class NeutroniaMoon extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new MoonBiomes());
        registerFeature(new MoonDimension());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Blocks.END_STONE);
    }

}
