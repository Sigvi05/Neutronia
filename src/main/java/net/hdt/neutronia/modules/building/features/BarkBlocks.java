package net.hdt.neutronia.modules.building.features;

import net.hdt.huskylib2.block.BlockMod;
import net.hdt.huskylib2.block.BlockModSlab;
import net.hdt.huskylib2.block.BlockModStairs;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.base.module.GlobalConfig;
import net.hdt.neutronia.modules.building.blocks.BlockBark;
import net.hdt.neutronia.modules.building.blocks.slab.BlockBarkSlab;
import net.hdt.neutronia.modules.building.blocks.stair.BlockBarkStairs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BarkBlocks extends Feature {

	public static BlockMod bark;

	private boolean enableWalls, enableStairsAndSlabs, use2x2;

	@Override
	public void setupConfig() {
		enableWalls = loadPropBool("Enable walls", "", true) && GlobalConfig.enableVariants;
		enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
		use2x2 = loadPropBool("Use 2x2 Recipe", "Set this to true to use a 2x2 recipe instead of 3x3.", false);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		bark = new BlockBark();

		/*for(int i = 0; i < 6; i++) {
			ItemStack log = ProxyRegistry.newStack(i > 3 ? Blocks.LOG2 : Blocks.LOG, 1, i % 4);

			if(!use2x2)
				RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(bark, 9, i),
						"WWW", "WWW", "WWW",
						'W', log);
			else RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(bark, 4, i),
					"WW", "WW",
					'W', log);
			RecipeHandler.addShapelessOreDictRecipe(log, ProxyRegistry.newStack(bark, 1, i));
		}*/

		for(BlockBark.Variants variant : BlockBark.Variants.values()) {
			bark.getDefaultState().withProperty(bark.getVariantProp(), variant);
			String name = variant.getName();
			VanillaWalls.add(name, bark, variant.ordinal(), enableWalls);
			
			if(enableStairsAndSlabs) {
				BlockModStairs.initStairs(bark, variant.ordinal(), new BlockBarkStairs(variant));
				BlockModSlab.initSlab(bark, variant.ordinal(), new BlockBarkSlab(variant, false), new BlockBarkSlab(variant, true));
			}
		}
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

}
