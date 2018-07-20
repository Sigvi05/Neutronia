package net.hdt.neutronia.modules.building.blocks;

import net.hdt.huskylib2.blocks.BlockMetaVariants;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class BlockSoulSandstone extends BlockMetaVariants implements INeutroniaBlock {

	public BlockSoulSandstone() {
		super("soul_sandstone", MOD_ID, Material.ROCK, Variants.class);
		setHardness(1F);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	public enum Variants implements EnumBase {
		SOUL_SANDSTONE,
		CHISELED_SOUL_SANDSTONE,
		SMOOTH_SOUL_SANDSTONE
	}
	
}
