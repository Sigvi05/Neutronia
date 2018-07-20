package net.hdt.neutronia.blocks;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.neutronia.init.NBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

import static net.hdt.neutronia.base.util.Reference.MOD_ID;

public class BlockSoulGlass extends BlockMod {

    boolean ignoreSimilarity = true;
    private boolean isOn;

    public BlockSoulGlass(boolean isOn, Material material, String name, CreativeTabs creativeTab) {
        super(material, MOD_ID, name);
        this.isOn = isOn;
        setHardness(0.3F);
        setResistance(7.0F);
        setLightOpacity(3);
        setCreativeTab(creativeTab);
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return this.isOn ? NULL_AABB : FULL_BLOCK_AABB;
    }

    @Override
    public BlockSoulGlass setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        if (this == NBlocks.soulGlass) {
            if (blockState != iblockstate) {
                return true;
            }

            if (block == this) {
                return false;
            }
        }
        if (this == NBlocks.soulGlassOn) {
            if (blockState != iblockstate) {
                return true;
            }

            if (block == this) {
                return false;
            }
        }

        return (this.ignoreSimilarity || block != this) && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            if (!this.isOn && !worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, NBlocks.soulGlass.getDefaultState(), 2);
            } else if (!this.isOn && worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, NBlocks.soulGlassOn.getDefaultState(), 2);
            }
        }
    }

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if (!worldIn.isRemote) {
            if (this.isOn && !worldIn.isBlockPowered(pos)) {
                worldIn.scheduleUpdate(pos, this, 4);
            } else if (!this.isOn && worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, NBlocks.soulGlassOn.getDefaultState(), 2);
            }
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            if (this.isOn && !worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, NBlocks.soulGlass.getDefaultState(), 2);
            }
        }
    }

    public int quantityDropped(Random random) {
        return 0;
    }

    protected boolean canSilkHarvest() {
        return true;
    }
}
