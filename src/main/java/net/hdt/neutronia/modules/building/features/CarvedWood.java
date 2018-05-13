/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [30/03/2016, 18:42:41 (GMT)]
 */
package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockCarvedWood;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.huskylib2.module.Feature;

public class CarvedWood extends Feature {

    public static BlockMod carvedWood;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        carvedWood = new BlockCarvedWood();

		/*for(int i = 0; i < 6; i++)
			RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(carvedWood, 2, i),
					"WW", "WW",
					'W', ProxyRegistry.newStack(Blocks.WOODEN_SLAB, 1, i));*/
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
