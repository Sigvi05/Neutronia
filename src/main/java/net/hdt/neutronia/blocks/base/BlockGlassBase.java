package net.hdt.neutronia.blocks.base;

import net.hdt.neutronia.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;

import java.util.Random;

public class BlockGlassBase extends BlockMod {

    public BlockGlassBase(String name) {
        super(Material.ICE, Reference.MOD_ID, name);
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    protected boolean canSilkHarvest() {
        return true;
    }

}
