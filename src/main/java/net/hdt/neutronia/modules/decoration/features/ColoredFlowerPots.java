package net.hdt.neutronia.modules.decoration.features;

import net.hdt.huskylib2.recipe.RecipeHandler;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.lib.LibMisc;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.decoration.blocks.BlockColoredFlowerPot;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ColoredFlowerPots extends Feature {

	public static BlockColoredFlowerPot[] pots;
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		pots = new BlockColoredFlowerPot[EnumDyeColor.values().length];
		for(int i = 0; i < pots.length; i++) {
			pots[i] = new BlockColoredFlowerPot(EnumDyeColor.byMetadata(i));
			RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(pots[i]), ProxyRegistry.newStack(Items.FLOWER_POT), LibMisc.OREDICT_DYES.get(15 - i));
		}
	}

}