package net.hdt.neutronia.blocks.nether;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;

public class BlockNetherStairBase extends BlockModStairs {

    public BlockNetherStairBase(String name, IBlockState state) {
        super(name, state);
        setCreativeTab(Main.NETHER_EXPANSION_TAB);
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
