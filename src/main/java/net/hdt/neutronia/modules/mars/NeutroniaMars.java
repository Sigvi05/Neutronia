package net.hdt.neutronia.modules.mars;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.mars.features.MarsDimension;
import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

public class NeutroniaMars extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new MarsDimension());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED).getBlock());
    }

}
