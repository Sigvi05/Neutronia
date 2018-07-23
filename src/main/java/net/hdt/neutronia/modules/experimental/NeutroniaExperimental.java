package net.hdt.neutronia.modules.experimental;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.experimental.features.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class NeutroniaExperimental extends Module {

	@Override
	public void addFeatures() {
		registerFeature(new BiggerCaves(), false);
		registerFeature(new ColoredLights(), false);
	}

	@Override
	public String getModuleDescription() {
		return "Experimental Features. All features in this module are disabled by default. Use at your own risk.";
	}
	
	@Override
	public ItemStack getIconStack() {
		return new ItemStack(Blocks.TNT);
	}

}
