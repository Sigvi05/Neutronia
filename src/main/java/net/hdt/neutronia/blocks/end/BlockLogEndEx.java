/*
package net.hdt.neutronia.blocks.end;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockLogEndEx extends BlockEndEx
{
    public static final PropertyEnum<EnumAxis> AXIS = PropertyEnum.create("axis", EnumAxis.class);

    public BlockLogEndEx(String name, Material material)
    {
        super(name, material);
    }

    @Override
    public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return true;
    }

    @Override
    public boolean isWood(IBlockAccess world, BlockPos pos)
    {
        return true;
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
    {
        return getStateFromMeta(meta).withProperty(AXIS, EnumAxis.fromAxis(facing.getAxis()));
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if(worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5)))
        {
            for(BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4)))
            {
                IBlockState iblockstate = worldIn.getBlockState(blockpos);

                if(iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos))
                {
                    iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
                }
            }
        }
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        switch(rot)
        {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:

                switch(state.getValue(AXIS))
                {
                    case X:
                        return state.withProperty(AXIS, EnumAxis.Z);
                    case Z:
                        return state.withProperty(AXIS, EnumAxis.X);
                    default:
                        return state;
                }

            default:
                return state;
        }
    }

    public enum EnumAxis implements IStringSerializable
    {
        X,
        Y,
        Z,
        NONE;

        @Override
        public String getName()
        {
            return toString().toLowerCase();
        }

        public static EnumAxis fromAxis(EnumFacing.Axis axis)
        {
            switch(axis)
            {
                case X:
                    return X;
                case Y:
                    return Y;
                case Z:
                    return Z;
                default:
                    return NONE;
            }
        }
    }
}
*/
