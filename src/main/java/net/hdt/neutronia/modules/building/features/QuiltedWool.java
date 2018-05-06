package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockQuiltedWool;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.module.Feature;

public class QuiltedWool extends Feature {

    public static Block quilted_wool;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        quilted_wool = new BlockQuiltedWool();
		
		/*for(int i = 0; i < 16; i++)
			RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(quilted_wool, 3, i),
					" S ", "WWW", " S ",
					'S', ProxyRegistry.newStack(Items.STRING),
					'W', ProxyRegistry.newStack(Blocks.WOOL, 1, i));*/
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }


}
