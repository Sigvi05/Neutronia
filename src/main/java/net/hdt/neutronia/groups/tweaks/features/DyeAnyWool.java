package net.hdt.neutronia.groups.tweaks.features;

import net.hdt.huskylib2.recipe.RecipeHandler;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.base.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

public class DyeAnyWool extends Component {

	boolean add8WoolRecipe;

	@Override
	public void setupConfig() {
		add8WoolRecipe = loadPropBool("Add 8 Dyed Wool Recipe", "", true);
	}

	@Override
	public void postPreInit(FMLPreInitializationEvent event) {
		for(int i = 0; i < 16; i++) {
			String dye = LibMisc.OREDICT_DYES.get(15 - i);

			addRecipe(Blocks.WOOL, i, dye);
		}
	}

	private void addRecipe(Block block, int meta, String dye) {
		ItemStack in = ProxyRegistry.newStack(block, 1, OreDictionary.WILDCARD_VALUE);
		RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(block, 1, meta), in, dye);

		if(add8WoolRecipe)
			RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(block, 8, meta), 
					dye, in, in, in, in, in, in, in, in);
	}

}