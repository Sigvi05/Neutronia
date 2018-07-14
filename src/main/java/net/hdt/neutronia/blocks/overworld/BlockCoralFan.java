package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.properties.EnumCoralColor;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created on 7/5/18 by alexiy.
 * This decorativeCoralBlock turns dead if no water blocks are adjacent to it
 */
public class BlockCoralFan extends BlockWaterBlockBase {

    private boolean dead;
    private ArrayList<Block> livingVersion, deadVersion;
    private static final PropertyBool ON_FLOOR = PropertyBool.create("on_floor");
    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public BlockCoralFan(EnumCoralColor colorIn, boolean isDead, ArrayList<Block> livingVersion, ArrayList<Block> deadVersion) {
        super(isDead ? "dead_" + colorIn.getNewName() + "_coral_fan" : colorIn.getNewName() + "_coral_fan");
        this.dead = isDead;
        this.livingVersion = livingVersion;
        this.deadVersion = deadVersion;
        if (isDead) {
            deadVersion.add(this);
        } else {
            livingVersion.add(this);
        }
        setDefaultState(getDefaultState().withProperty(ON_FLOOR, false).withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!dead && !canLive(worldIn, pos))
            worldIn.scheduleUpdate(pos, this, 100);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        worldIn.scheduleUpdate(pos, this, 100);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!this.dead && !canLive(worldIn, pos))
            worldIn.setBlockState(pos, deadVersion.get(livingVersion.indexOf(this)).getDefaultState());
        if (this.dead && canLive(worldIn, pos))
            worldIn.setBlockState(pos, livingVersion.get(deadVersion.indexOf(this)).getDefaultState());
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        IBlockState state = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand);
        return state.withProperty(FACING, placer.getHorizontalFacing()).withProperty(ON_FLOOR, facing.getHorizontalIndex() != -1);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex() + (state.getValue(ON_FLOOR) ? 3 : 0);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta)).withProperty(ON_FLOOR, meta - 4 >= 0);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, ON_FLOOR);
    }

    protected boolean canLive(World world, BlockPos itsPosition) {
        for (EnumFacing facing : EnumFacing.values()) {
            IBlockState sidestate = world.getBlockState(itsPosition.offset(facing));
            if (sidestate.getBlock() == Blocks.WATER || sidestate.getBlock() == Blocks.FLOWING_WATER) {
                return true;
            }
        }
        return false;
    }

}