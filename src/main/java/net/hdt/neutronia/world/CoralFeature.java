package net.hdt.neutronia.world;

import net.hdt.neutronia.base.tags.BlockTags;
import net.hdt.neutronia.modules.world.blocks.corals.BlockCoralWallFan;
import net.hdt.neutronia.modules.world.blocks.corals.BlockSeaPickle;
import net.hdt.neutronia.modules.world.features.SeaPickles;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public abstract class CoralFeature extends WorldGenerator {

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        BlockPos blockpos = position.up();
        IBlockState iblockstate = worldIn.getBlockState(position);

        if ((iblockstate.getBlock() == Blocks.WATER || worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER))
        {
            worldIn.setBlockState(position, iblockstate, 3);

            if (rand.nextFloat() < 0.25F)
            {
                worldIn.setBlockState(blockpos, BlockTags.field_204116_z.func_205596_a(rand).getDefaultState(), 2);
            }
            else if (rand.nextFloat() < 0.05F)
            {
                worldIn.setBlockState(blockpos, SeaPickles.SEA_PICKLE.getDefaultState().withProperty(BlockSeaPickle.field_204902_a, rand.nextInt(4) + 1), 2);
            }

            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                if (rand.nextFloat() < 0.2F)
                {
                    BlockPos blockpos1 = position.offset(enumfacing);

                    if (worldIn.getBlockState(blockpos1).getBlock() == Blocks.WATER)
                    {
                        IBlockState iblockstate1 = BlockTags.field_211922_B.func_205596_a(rand).getDefaultState().withProperty(BlockCoralWallFan.FACING, enumfacing);
                        worldIn.setBlockState(blockpos1, iblockstate1, 2);
                    }
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    protected void setBlockAndNotifyAdequately(World p_204624_1_, BlockPos p_204624_3_, IBlockState p_204624_4_)
    {
        Random p_204624_2_ = new Random();
        BlockPos blockpos = p_204624_3_.up();
        IBlockState iblockstate = p_204624_1_.getBlockState(p_204624_3_);

        if ((iblockstate.getBlock() == Blocks.WATER) && p_204624_1_.getBlockState(blockpos).getBlock() == Blocks.WATER)
        {
            p_204624_1_.setBlockState(p_204624_3_, p_204624_4_, 3);

            if (p_204624_2_.nextFloat() < 0.25F)
            {
                p_204624_1_.setBlockState(blockpos, BlockTags.field_204116_z.func_205596_a(p_204624_2_).getDefaultState(), 2);
            }
            else if (p_204624_2_.nextFloat() < 0.05F)
            {
                p_204624_1_.setBlockState(blockpos, SeaPickles.SEA_PICKLE.getDefaultState().withProperty(BlockSeaPickle.field_204902_a, p_204624_2_.nextInt(4) + 1), 2);
            }

            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                if (p_204624_2_.nextFloat() < 0.2F)
                {
                    BlockPos blockpos1 = p_204624_3_.offset(enumfacing);

                    if (p_204624_1_.getBlockState(blockpos1).getBlock() == Blocks.WATER)
                    {
                        IBlockState iblockstate1 = BlockTags.field_211922_B.func_205596_a(p_204624_2_).getDefaultState().withProperty(BlockCoralWallFan.FACING, enumfacing);
                        p_204624_1_.setBlockState(blockpos1, iblockstate1, 2);
                    }
                }
            }
        }
    }
}
