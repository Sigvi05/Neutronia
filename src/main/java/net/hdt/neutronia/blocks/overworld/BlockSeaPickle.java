package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.properties.Properties;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSeaPickle extends BlockWaterBlockBase implements IGrowable {

    private static final PropertyInteger PICKLES = Properties.PICKLES;
    private static final PropertyBool WATERLOGGED = Properties.WATERLOGGED;

    public BlockSeaPickle(String name) {
        super(name);
        setDefaultState(getDefaultState().withProperty(PICKLES, 1));
    }

    private boolean isWaterLogged(IBlockState blockState) {
        return !blockState.getValue(WATERLOGGED);
    }

    public int getLightValue(IBlockState aIBlockState) {
        return this.isWaterLogged(aIBlockState) ? 0 : super.getLightValue(aIBlockState) + 3 * aIBlockState.getValue(PICKLES);
    }

    /*@Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();

        if (state.getValue(PART) == BlockBed.EnumPartType.HEAD)
        {
            i |= 8;

            if (((Boolean)state.getValue(OCCUPIED)).booleanValue())
            {
                i |= 4;
            }
        }

        return i;
    }*/

    @Override
    public int getMetaFromState(IBlockState state) {
        int count = state.getValue(PICKLES);
        boolean waterlogged = state.getValue(WATERLOGGED);
        return (count & 0b111) << 1 | (waterlogged ? 1 : 0);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        int count = (meta >> 1) & 0b111;
        boolean waterlogged = (meta & 0b1) != 0;
        return this.getDefaultState().withProperty(PICKLES, count).withProperty(WATERLOGGED, waterlogged);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, PICKLES, WATERLOGGED);
    }

    @Override
    public int quantityDropped(Random random) {
        return getDefaultState().getValue(PICKLES);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        int picles = state.getValue(PICKLES);
        if (playerIn.getActiveItemStack() == new ItemStack(this)) {
            int i = 0;
            while (i < picles) {
                worldIn.setBlockState(pos, state.withProperty(PICKLES, i));
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        if (!this.isWaterLogged(state) && worldIn.getBlockState(pos.down()) == NBlocks.livingCorals.listIterator().next().getDefaultState()) {
            int vInteger6 = 1;
            int vInteger8 = 0;
            int vInteger9 = pos.getX() - 2;
            int vInteger10 = 0;

            for (int vInteger11 = 0; vInteger11 < 5; ++vInteger11) {
                for (int vInteger12 = 0; vInteger12 < vInteger6; ++vInteger12) {
                    int vInteger13 = 2 + pos.getY() - 1;

                    for (int vInteger14 = vInteger13 - 2; vInteger14 < vInteger13; ++vInteger14) {
                        BlockPos vBlockPos15 = new BlockPos(vInteger9 + vInteger11, vInteger14, pos.getZ() - vInteger10 + vInteger12);
                        if (vBlockPos15 != pos && rand.nextInt(6) == 0 && worldIn.getBlockState(vBlockPos15).getBlock() == Blocks.WATER) {
                            IBlockState vIBlockState16 = worldIn.getBlockState(vBlockPos15.down());
                            if (vIBlockState16 == NBlocks.livingCorals.listIterator().next().getDefaultState()) {
                                worldIn.setBlockState(vBlockPos15, NBlocks.seaPickle.getDefaultState().withProperty(PICKLES, rand.nextInt(4) + 1), 3);
                            }
                        }
                    }
                }

                if (vInteger8 < 2) {
                    vInteger6 += 2;
                    ++vInteger10;
                } else {
                    vInteger6 -= 2;
                    --vInteger10;
                }

                ++vInteger8;
            }

            worldIn.setBlockState(pos, state.withProperty(PICKLES, 4), 2);
        }
    }

}