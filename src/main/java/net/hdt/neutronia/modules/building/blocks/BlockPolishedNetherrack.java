package net.hdt.neutronia.modules.building.blocks;

import net.hdt.huskylib2.block.BlockMetaVariants;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPolishedNetherrack extends BlockMetaVariants implements INeutroniaBlock {

	public BlockPolishedNetherrack() {
		super("polished_netherrack", Material.ROCK, Variants.class);
		setHardness(1.5F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	public enum Variants implements EnumBase {
		
		POLISHED_NETHERRACK,
		POLISHED_NETHERRACK_BRICKS
		
	}

}
