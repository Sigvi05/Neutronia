/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [30/06/2016, 14:52:57 (GMT)]
 */
package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockIronPlate;
import net.hdt.neutronia.modules.building.blocks.slab.BlockIronPlateSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockIronPlateStairs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;

public class IronPlates extends Feature {

    public static Block iron_plate;

    boolean enableStairsAndSlabs;

    @Override
    public void setupConfig() {
        enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        iron_plate = new BlockIronPlate();

        if (enableStairsAndSlabs) {
            BlockModStairs.initStairs(iron_plate, 0, new BlockIronPlateStairs());
            BlockModSlab.initSlab(iron_plate, 0, new BlockIronPlateSlab(false), new BlockIronPlateSlab(true));
        }

		/*RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(iron_plate, 24),
				"III", "I I", "III",
				'I', "ingotIron");
		
		RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(iron_plate, 24, 1),
				"III", "IBI", "III",
				'I', "ingotIron",
				'B', ProxyRegistry.newStack(Items.WATER_BUCKET));
		
		RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(iron_plate, 8, 1),
				"III", "IBI", "III",
				'I', ProxyRegistry.newStack(iron_plate),
				'B', ProxyRegistry.newStack(Items.WATER_BUCKET));*/
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
