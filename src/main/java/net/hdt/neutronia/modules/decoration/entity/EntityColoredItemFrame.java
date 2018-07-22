/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 *
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 *
 * File Created @ [19/06/2016, 23:52:04 (GMT)]
 */
package net.hdt.neutronia.modules.decoration.entity;

import net.hdt.neutronia.modules.decoration.features.ColoredItemFrames;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityColoredItemFrame extends EntityFlatItemFrame {

	private static final DataParameter<Integer> COLOR = EntityDataManager.createKey(EntityColoredItemFrame.class, DataSerializers.VARINT);
	private static final String TAG_COLOR = "DyeColor";

	public EntityColoredItemFrame(World worldIn) {
		super(worldIn);
	}

	public EntityColoredItemFrame(World worldIn, BlockPos p_i45852_2_, EnumFacing p_i45852_3_, int color) {
		super(worldIn, p_i45852_2_, p_i45852_3_);
		dataManager.set(COLOR, color);
	}

	@Override
	protected void entityInit() {
		super.entityInit();

		dataManager.register(COLOR, 0);
	}

	public int getColor() {
		return dataManager.get(COLOR);
	}

	@Override
	protected void dropFrame() {
		entityDropItem(new ItemStack(ColoredItemFrames.colored_item_frame, 1, getColor()), 0.0F);
	}
	
	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(ColoredItemFrames.colored_item_frame, 1, getColor());
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		compound.setInteger(TAG_COLOR, getColor());
		super.writeEntityToNBT(compound);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		dataManager.set(COLOR, compound.getInteger(TAG_COLOR));
		super.readEntityFromNBT(compound);
	}
}