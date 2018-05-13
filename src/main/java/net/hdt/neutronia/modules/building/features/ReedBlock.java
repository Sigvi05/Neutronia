/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [20/03/2016, 23:37:35 (GMT)]
 */
package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockReed;
import net.hdt.neutronia.modules.building.blocks.slab.BlockReedSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockReedStairs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;

public class ReedBlock extends Feature {

    public static Block reed_block;

    boolean enableStairsAndSlabs;
    boolean enableWalls;

    @Override
    public void setupConfig() {
        enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
        enableWalls = loadPropBool("Enable walls", "", true) && GlobalConfig.enableVariants;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        reed_block = new BlockReed();

        if (enableStairsAndSlabs) {
            BlockModStairs.initStairs(reed_block, 0, new BlockReedStairs());
            BlockModSlab.initSlab(reed_block, 0, new BlockReedSlab(false), new BlockReedSlab(true));
        }
        VanillaWalls.add("reed_block", reed_block, 0, enableWalls);

		/*RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(reed_block),
				"RRR", "RRR", "RRR",
				'R', ProxyRegistry.newStack(Items.REEDS));
		RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(Items.REEDS, 9), ProxyRegistry.newStack(reed_block));*/
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
