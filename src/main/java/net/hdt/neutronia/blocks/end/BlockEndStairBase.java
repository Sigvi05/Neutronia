package net.hdt.neutronia.blocks.end;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;

public class BlockEndStairBase extends BlockModStairs {

    public BlockEndStairBase(String name, IBlockState state) {
        super(name, state);
        setCreativeTab(Main.END_EXPANSION_TAB);
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
