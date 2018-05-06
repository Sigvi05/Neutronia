package net.hdt.neutronia.blocks.overworld;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockHardenedClayTilesSlab extends BlockOverworldSlabBase {

    public BlockHardenedClayTilesSlab(boolean doubleSlab) {
        super("hardened_clay_tiles_slab", Material.ROCK, doubleSlab);
        setHardness(1.25F);
        setResistance(7.0F);
        setSoundType(SoundType.STONE);
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
        return MapColor.ADOBE;
    }

}