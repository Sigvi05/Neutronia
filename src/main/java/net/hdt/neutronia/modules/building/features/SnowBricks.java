/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [18/04/2016, 22:43:48 (GMT)]
 */
package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockSnowBricks;
import net.hdt.neutronia.modules.building.blocks.slab.BlockSnowBricksSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockSnowBricksStairs;
import net.hdt.neutronia.modules.building.blocks.wall.BlockSnowBricksWall;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;

public class SnowBricks extends Feature {

    public static Block snow_bricks;

    boolean enableStairsAndSlabs;
    boolean enableWalls;

    @Override
    public void setupConfig() {
        enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
        enableWalls = loadPropBool("Enable walls", "", true) && GlobalConfig.enableVariants;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        snow_bricks = new BlockSnowBricks();

        if (enableStairsAndSlabs) {
            BlockModStairs.initStairs(snow_bricks, 0, new BlockSnowBricksStairs());
            BlockModSlab.initSlab(snow_bricks, 0, new BlockSnowBricksSlab(false), new BlockSnowBricksSlab(true));
        }
        VanillaWalls.add("snow_bricks", snow_bricks, 0, enableWalls, (name, state) -> new BlockSnowBricksWall(name, state));

		/*RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(snow_bricks, 4),
				"SS", "SS",
				'S', ProxyRegistry.newStack(Blocks.SNOW));*/
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
