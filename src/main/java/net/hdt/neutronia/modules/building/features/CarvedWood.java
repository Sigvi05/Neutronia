package net.hdt.neutronia.modules.building.features;

import net.hdt.huskylib2.block.BlockMod;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.building.blocks.BlockCarvedWood;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CarvedWood extends Feature {

	public static BlockMod carvedWood;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		carvedWood = new BlockCarvedWood();

		/*for(int i = 0; i < 6; i++)
			RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(carvedWood, 2, i),
					"WW", "WW",
					'W', ProxyRegistry.newStack(Blocks.WOODEN_SLAB, 1, i));*/
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

}
