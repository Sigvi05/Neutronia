package net.thegaminghuskymc.mcaddon.blocks.overworld;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IBOPBlock {
    
    Class<? extends ItemBlock> getItemClass();
    IProperty[] getPresetProperties();
    IProperty[] getNonRenderingProperties();
    String getStateName(IBlockState state);

	@SideOnly(Side.CLIENT)
    IBlockColor getBlockColor();
	@SideOnly(Side.CLIENT)
    IItemColor getItemColor();
}