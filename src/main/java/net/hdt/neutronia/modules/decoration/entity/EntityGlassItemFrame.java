package net.hdt.neutronia.modules.decoration.entity;

import net.hdt.neutronia.modules.decoration.features.GlassItemFrame;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGlassItemFrame extends EntityFlatItemFrame {

	public EntityGlassItemFrame(World worldIn) {
		super(worldIn);
	}
	
	public EntityGlassItemFrame(World worldIn, BlockPos p_i45852_2_, EnumFacing p_i45852_3_) {
		super(worldIn, p_i45852_2_, p_i45852_3_);
	}

	@Override
	protected void dropFrame() {
		entityDropItem(new ItemStack(GlassItemFrame.glass_item_frame, 1, 0), 0.0F);
	}
	
	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(GlassItemFrame.glass_item_frame, 1, 0);
	}
}