package net.hdt.neutronia.groups.building.blocks.slab;

import net.hdt.neutronia.base.blocks.BlockNeutroniaSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;

public class BlockVanillaSlab extends BlockNeutroniaSlab {

    public BlockVanillaSlab(String name, IBlockState state, boolean doubleSlab) {
        super(name, state.getMaterial(), doubleSlab);

        setHardness(state.getBlockHardness(null, new BlockPos(0, 0, 0)));
        setResistance(state.getBlock().getExplosionResistance(null) * 5F / 3F);
        setSoundType(state.getBlock().getSoundType());
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

}
