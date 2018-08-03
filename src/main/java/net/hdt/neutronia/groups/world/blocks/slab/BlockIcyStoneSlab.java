package net.hdt.neutronia.groups.world.blocks.slab;

import net.hdt.neutronia.base.blocks.BlockNeutroniaSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockIcyStoneSlab extends BlockNeutroniaSlab {

	public BlockIcyStoneSlab(boolean doubleSlab) {
		super("icy_stone", Material.ROCK, doubleSlab);
		setHardness(1.5F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

}
