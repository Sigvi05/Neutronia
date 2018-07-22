package net.hdt.neutronia.modules.tweaks.features;

import net.hdt.neutronia.base.recipe.RecipeHandler;
import net.hdt.huskylib2.utils.ProxyRegistry;
import net.hdt.neutronia.base.module.Feature;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConvertClay extends Feature {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(Items.CLAY_BALL, 4), ProxyRegistry.newStack(Blocks.CLAY));
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

}