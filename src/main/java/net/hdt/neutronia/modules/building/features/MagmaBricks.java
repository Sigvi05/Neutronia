package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockMagmaBricks;
import net.hdt.neutronia.modules.building.blocks.slab.BlockMagmaBricksSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockMagmaBricksStairs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;

public class MagmaBricks extends Feature {

    public static Block magma_bricks;

    boolean enableStairsAndSlabs;

    @Override
    public void setupConfig() {
        enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        magma_bricks = new BlockMagmaBricks();

        if (enableStairsAndSlabs) {
            BlockModStairs.initStairs(magma_bricks, 0, new BlockMagmaBricksStairs());
            BlockModSlab.initSlab(magma_bricks, 0, new BlockMagmaBricksSlab(false), new BlockMagmaBricksSlab(true));
        }
		
		/*RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(magma_bricks, 4),
				ProxyRegistry.newStack(Blocks.STONEBRICK), ProxyRegistry.newStack(Blocks.STONEBRICK), ProxyRegistry.newStack(Blocks.MAGMA), ProxyRegistry.newStack(Blocks.MAGMA));*/
    }

}
