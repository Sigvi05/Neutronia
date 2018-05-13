package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;

public class BlockOverworldSlabBase extends BlockModSlab {

    public BlockOverworldSlabBase(String name, Material material, boolean isDouble) {
        super(name, Reference.MOD_ID, material, isDouble);
        setCreativeTab(Main.OVERWORLD_EXPANSION_TAB);
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return isDouble();
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return isDouble();
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        if (blockState != iblockstate) {
            return true;
        }

        if (block == this) {
            return false;
        }

        return block != this && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return HALF;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return (Comparable<Object>) o -> 0;
    }

}
