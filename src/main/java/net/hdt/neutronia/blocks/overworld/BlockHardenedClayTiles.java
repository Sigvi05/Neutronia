package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.util.Reference;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

public class BlockHardenedClayTiles extends BlockMod implements IModBlock {

    public BlockHardenedClayTiles() {
        super(Material.ROCK, Reference.MOD_ID, "hardened_clay_tiles");
        setHardness(1.25F);
        setResistance(7.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
        return MapColor.ADOBE;
    }

}