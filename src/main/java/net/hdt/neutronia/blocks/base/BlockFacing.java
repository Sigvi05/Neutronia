package net.hdt.neutronia.blocks.base;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.huskylib2.blocks.BlockModContainer;

import javax.annotation.Nullable;

public abstract class BlockFacing extends BlockModContainer {

    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public BlockFacing(Material materialIn, String modid, String name, String... variants) {
        super(materialIn, modid, name, variants);
        setDefaultState(makeDefaultState());
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

    public IBlockState makeDefaultState() {
        return blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    /**
     * Called after the animation.animations.blocks is set in the Chunk data, but before the Tile Entity is set
     */
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        this.setDefaultFacing(worldIn, pos, state);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            IBlockState iblockstate4 = worldIn.getBlockState(pos.up());
            IBlockState iblockstate5 = worldIn.getBlockState(pos.down());
            EnumFacing enumfacing = state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock()) {
                enumfacing = EnumFacing.SOUTH;
            } else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock()) {
                enumfacing = EnumFacing.NORTH;
            } else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock()) {
                enumfacing = EnumFacing.EAST;
            } else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock()) {
                enumfacing = EnumFacing.WEST;
            } else if (enumfacing == EnumFacing.UP && iblockstate4.isFullBlock() && !iblockstate4.isFullBlock()) {
                enumfacing = EnumFacing.UP;
            } else if (enumfacing == EnumFacing.DOWN && iblockstate5.isFullBlock() && !iblockstate5.isFullBlock()) {
                enumfacing = EnumFacing.DOWN;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
            enumfacing = EnumFacing.UP;
        if (enumfacing.getAxis() == EnumFacing.Axis.X)
            enumfacing = EnumFacing.NORTH;
        if (enumfacing.getAxis() == EnumFacing.Axis.Z)
            enumfacing = EnumFacing.EAST;

        return getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

}
