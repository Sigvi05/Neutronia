package net.hdt.neutronia.base.blocks;

import net.hdt.huskylib2.blocks.BlockModSlab;
import net.minecraft.block.material.Material;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class BlockNeutroniaSlab extends BlockModSlab implements INeutroniaBlock {

	public BlockNeutroniaSlab(String name, Material materialIn, boolean doubleSlab) {
		super(name, MOD_ID, materialIn, doubleSlab);
	}

}
