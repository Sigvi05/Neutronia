package net.hdt.neutronia.base.blocks;

import net.hdt.huskylib2.blocks.BlockMod;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class BlockNeutroniaPillar extends BlockMod implements INeutroniaBlock {

	public BlockNeutroniaPillar(Material materialIn, String name, String... variants) {
		super(materialIn, name, MOD_ID, variants);
	}

	@Override
	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis) {
		IBlockState state = world.getBlockState(pos);
		for(IProperty<?> prop : state.getProperties().keySet()) {
			if(prop == BlockRotatedPillar.AXIS) {
				world.setBlockState(pos, state.cycleProperty(prop));
				return true;
			}
		}
		return false;
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		switch (rot) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:
			switch (state.getValue(BlockRotatedPillar.AXIS)) {
			case X:
				return state.withProperty(BlockRotatedPillar.AXIS, EnumFacing.Axis.Z);
			case Z:
				return state.withProperty(BlockRotatedPillar.AXIS, EnumFacing.Axis.X);
			default:
				return state;
			}

		default:
			return state;
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing.Axis enumfacing$axis = EnumFacing.Axis.Y;
		int i = meta & 12;

		if (i == 4)
			enumfacing$axis = EnumFacing.Axis.X;
		else if (i == 8)
			enumfacing$axis = EnumFacing.Axis.Z;

		return getDefaultState().withProperty(BlockRotatedPillar.AXIS, enumfacing$axis);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		EnumFacing.Axis enumfacing$axis = state.getValue(BlockRotatedPillar.AXIS);

		if(enumfacing$axis == EnumFacing.Axis.X)
			i |= 4;
		else if(enumfacing$axis == EnumFacing.Axis.Z)
			i |= 8;

		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, BlockRotatedPillar.AXIS);
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(BlockRotatedPillar.AXIS, facing.getAxis());
	}

}