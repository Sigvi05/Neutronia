package net.hdt.neutronia.base.blocks;

import net.hdt.huskylib2.blocks.BlockModDust;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public abstract class BlockNeutroniaDust extends BlockModDust implements INeutroniaBlock  {

	public BlockNeutroniaDust(String name) {
		super(MOD_ID, name);
	}

}
