package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.modules.building.blocks.BlockStainedClayTiles;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.thegaminghuskymc.huskylib2.interf.IRecipeGrouped;

public class BlockStainedClayTilesSlab extends BlockOverworldSlabBase implements IRecipeGrouped {

    public BlockStainedClayTilesSlab(BlockStainedClayTiles.Variants variant, boolean doubleSlab) {
        super(variant.getName() + "_slab", Material.ROCK, doubleSlab);
        setHardness(1.25F);
        setResistance(7.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
        return MapColor.ADOBE;
    }

    @Override
    public String getRecipeGroup() {
        return "stained_clay_tiles_slab";
    }

}