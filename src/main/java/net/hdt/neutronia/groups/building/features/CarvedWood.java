package net.hdt.neutronia.groups.building.features;

import net.hdt.huskylib2.block.BlockMod;
import net.hdt.huskylib2.recipe.RecipeHandler;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.groups.building.blocks.BlockCarvedWood;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CarvedWood extends Component {

	public static BlockMod carvedWood;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		carvedWood = new BlockCarvedWood();

		for(int i = 0; i < 6; i++)
			RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(carvedWood, 2, i),
					"WW", "WW",
					'W', ProxyRegistry.newStack(Blocks.WOODEN_SLAB, 1, i));
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

}
