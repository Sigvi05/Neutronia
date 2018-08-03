package net.hdt.neutronia.groups.building.blocks;

import net.hdt.huskylib2.block.BlockMetaVariants;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCarvedWood extends BlockMetaVariants implements INeutroniaBlock {

	public BlockCarvedWood() {
		super("carved_wood", Material.WOOD, Variants.class);
		setHardness(2.0F);
		setResistance(5.0F);
		setSoundType(SoundType.WOOD);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	public enum Variants implements EnumBase {
		CARVED_OAK_WOOD,
		CARVED_SPRUCE_WOOD,
		CARVED_BIRCH_WOOD,
		CARVED_JUNGLE_WOOD,
		CARVED_ACACIA_WOOD,
		CARVED_DARK_OAK_WOOD
	}

}
