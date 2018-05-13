/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [20/03/2016, 22:49:30 (GMT)]
 */
package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockThatch;
import net.hdt.neutronia.modules.building.blocks.slab.BlockThatchSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockThatchStairs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;

public class Thatch extends Feature {

    public static Block thatch;
    public static float fallDamageMultiplier;
    boolean enableStairsAndSlabs;

    @Override
    public void setupConfig() {
        enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
        fallDamageMultiplier = (float) loadPropDouble("Fall damage multiplier", "", 0.5);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        thatch = new BlockThatch();

        if (enableStairsAndSlabs) {
            BlockModStairs.initStairs(thatch, 0, new BlockThatchStairs());
            BlockModSlab.initSlab(thatch, 0, new BlockThatchSlab(false), new BlockThatchSlab(true));
        }

		/*RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(thatch),
				"WW", "WW",
				'W', ProxyRegistry.newStack(Items.WHEAT));
		RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(Items.WHEAT, 4), ProxyRegistry.newStack(thatch));*/
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
