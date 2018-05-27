package net.hdt.neutronia.blocks.overworld;

import net.hdt.huskylib2.blocks.BlockModStairs;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOverworldStairBase extends BlockModStairs {

    public BlockOverworldStairBase(String name, IBlockState state, CreativeTabs tab) {
        super(name, state);
        setCreativeTab(tab);
    }

    @Override
    public String getModNamespace() {
        return Reference.MOD_ID;
    }

    @Override
    public String getPrefix() {
        return Reference.MOD_ID;
    }
}