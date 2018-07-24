package net.hdt.neutronia.modules.dimensions;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.dimensions.features.MarsDimension;
import net.hdt.neutronia.modules.dimensions.features.MoonBiomes;
import net.hdt.neutronia.modules.dimensions.features.MoonDimension;
import net.hdt.neutronia.modules.dimensions.features.SunDimension;
import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

public class NeutroniaDimensions extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new MarsDimension());
        registerFeature(new MoonBiomes());
        registerFeature(new MoonDimension());
        registerFeature(new SunDimension());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE).getBlock());
    }

}
