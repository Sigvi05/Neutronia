package net.hdt.neutronia.modules.building.blocks;

import net.hdt.huskylib2.blocks.BlockMetaVariants;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class BlockPolishedNetherrack extends BlockMetaVariants implements INeutroniaBlock {

	public BlockPolishedNetherrack() {
		super("polished_netherrack", MOD_ID, Material.ROCK, Variants.class);
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
