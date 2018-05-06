package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;

public class BlockOverworldStairBase extends BlockModStairs {

    public BlockOverworldStairBase(String name, IBlockState state) {
        super(name, state);
        setCreativeTab(Main.OVERWORLD_EXPANSION_TAB);
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