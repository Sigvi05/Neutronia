package net.hdt.neutronia.groups.building.blocks;

import net.hdt.huskylib2.block.BlockMetaVariants;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBark extends BlockMetaVariants implements INeutroniaBlock {

	public BlockBark() {
		super("bark", Material.WOOD, Variants.class);
		setHardness(2.0F);
		setSoundType(SoundType.WOOD);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	public enum Variants implements EnumBase {
		BARK_OAK,
		BARK_SPRUCE,
		BARK_BIRCH,
		BARK_JUNGLE,
		BARK_ACACIA,
		BARK_DARK_OAK
	}

}
