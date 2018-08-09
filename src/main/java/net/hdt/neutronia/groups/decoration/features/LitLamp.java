package net.hdt.neutronia.groups.decoration.features;

import net.hdt.huskylib2.recipe.RecipeHandler;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.groups.decoration.blocks.BlockLitLamp;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class LitLamp extends Component {

	public static Block lit_lamp;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		lit_lamp = new BlockLitLamp();

		RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(lit_lamp), ProxyRegistry.newStack(Blocks.REDSTONE_LAMP), ProxyRegistry.newStack(Blocks.REDSTONE_TORCH));
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

}
