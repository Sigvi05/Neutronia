package net.hdt.neutronia.base.blocks;

import net.hdt.huskylib2.interf.IModBlock;
import net.hdt.neutronia.base.lib.LibMisc;

public interface INeutroniaBlock extends IModBlock {

	@Override
	default String getModNamespace() {
		return LibMisc.MOD_ID;
	}
	
}
