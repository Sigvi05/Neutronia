/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [24/03/2016, 15:24:42 (GMT)]
 */
package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockBark;
import net.hdt.neutronia.modules.building.blocks.slab.BlockBarkSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockBarkStairs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;

public class BarkBlocks extends Feature {

    public static BlockMod bark;

    boolean enableWalls, enableStairsAndSlabs, use2x2;

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

        for (BlockBark.Variants variant : BlockBark.Variants.class.getEnumConstants()) {
            bark.getDefaultState().withProperty(bark.getVariantProp(), variant);
            String name = variant.getName();
//			VanillaWalls.add(name, bark, variant.ordinal(), enableWalls);

            if (enableStairsAndSlabs) {
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
