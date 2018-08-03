package net.hdt.neutronia.modules.management.features;

import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.base.module.ModuleLoader;

public class BetterCraftShifting extends Feature {

	public static int getInventoryBoundary(int curr) {
		if(!ModuleLoader.isFeatureEnabled(BetterCraftShifting.class))
			return curr;
		
		return curr == 37 ? 0 : 10;
	}
	
}
