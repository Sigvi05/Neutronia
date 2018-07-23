package net.hdt.neutronia.modules.decoration.features;

import net.hdt.huskylib2.recipe.RecipeHandler;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.decoration.blocks.BlockNetherBrickFenceGate;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class NetherBrickFenceGate extends Feature {

	public static Block nether_brick_fence_gate;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		nether_brick_fence_gate = new BlockNetherBrickFenceGate();

		RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(nether_brick_fence_gate, 2),
				"NBN", "NBN",
				'N', ProxyRegistry.newStack(Blocks.NETHER_BRICK_FENCE),
				'B', ProxyRegistry.newStack(Blocks.NETHER_BRICK));
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

}