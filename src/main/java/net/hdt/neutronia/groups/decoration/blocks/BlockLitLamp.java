package net.hdt.neutronia.groups.decoration.blocks;

import net.hdt.huskylib2.block.BlockMod;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.hdt.neutronia.groups.experimental.features.ColoredLights;
import net.hdt.neutronia.groups.experimental.lighting.IColoredLightSource;
import net.minecraft.block.BlockColored;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockLitLamp extends BlockMod implements INeutroniaBlock, IColoredLightSource {

    public BlockLitLamp() {
        super("lit_lamp", Material.GLASS);
        setHardness(0.3F);
        setLightLevel(1F);
        setSoundType(SoundType.GLASS);
        setCreativeTab(CreativeTabs.REDSTONE);
    }

    @Override
    public int getLightOpacity(IBlockState state, IBlockAccess world, BlockPos pos) {
        ColoredLights.addLightSource(world, pos, state);
        return super.getLightOpacity(state, world, pos);
    }

    @Override
    public float[] getColoredLight(IBlockAccess world, BlockPos pos) {
        int index = 0;

        BlockPos down = pos.down();
        IBlockState state = world.getBlockState(down);
        if (state.getBlock() == Blocks.CONCRETE)
            index = state.getValue(BlockColored.COLOR).ordinal();

        return VANILLA_SPECTRUM_COLORS[index];
    }

}
