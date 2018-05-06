package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockSturdyStone;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.module.Feature;

public class SturdyStone extends Feature {

    public static Block sturdy_stone;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        sturdy_stone = new BlockSturdyStone();

		/*RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(sturdy_stone, 4),
				"SCS", "C C", "SCS",
				'S', "stone",
				'C', "cobblestone");
		RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(sturdy_stone, 4), 
				"CSC", "S S", "CSC",
				'S', "stone",
				'C', "cobblestone");*/
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
