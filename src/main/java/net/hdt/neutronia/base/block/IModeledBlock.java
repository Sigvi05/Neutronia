package net.hdt.neutronia.base.block;

import net.hdt.neutronia.base.client.models.BlockModelDefinition;
import net.hdt.neutronia.base.client.models.ItemModelDefinition;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public interface IModeledBlock {
	@SideOnly(Side.CLIENT)
	public BlockModelDefinition getBlockModelDefinition();

	@Nullable
	@SideOnly(Side.CLIENT)
	public ItemModelDefinition getItemModelDefinition();
}
