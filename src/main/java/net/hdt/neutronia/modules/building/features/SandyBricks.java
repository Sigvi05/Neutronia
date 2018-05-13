/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [20/03/2016, 22:44:08 (GMT)]
 */
package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockSandyBricks;
import net.hdt.neutronia.modules.building.blocks.slab.BlockSandyBricksSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockSandyBricksStairs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;

public class SandyBricks extends Feature {

    public static Block sandy_bricks;

    boolean enableStairsAndSlabs;
    boolean enableWalls;

    @Override
    public void setupConfig() {
        enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
        enableWalls = loadPropBool("Enable walls", "", true) && GlobalConfig.enableVariants;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        sandy_bricks = new BlockSandyBricks();

        if (enableStairsAndSlabs) {
            BlockModStairs.initStairs(sandy_bricks, 0, new BlockSandyBricksStairs());
            BlockModSlab.initSlab(sandy_bricks, 0, new BlockSandyBricksSlab(false), new BlockSandyBricksSlab(true));
        }
        VanillaWalls.add("sandy_bricks", sandy_bricks, 0, enableWalls);

//		RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(sandy_bricks), ProxyRegistry.newStack(Blocks.BRICK_BLOCK), ProxyRegistry.newStack(Blocks.SAND));
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
