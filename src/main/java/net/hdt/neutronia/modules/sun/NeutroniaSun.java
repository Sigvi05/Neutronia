package net.hdt.neutronia.modules.sun;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.sun.features.SunDimension;
import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

public class NeutroniaSun extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new SunDimension());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW).getBlock());
    }

}
