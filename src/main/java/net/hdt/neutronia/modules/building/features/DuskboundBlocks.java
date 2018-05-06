package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockDuskbound;
import net.hdt.neutronia.modules.building.blocks.BlockDuskboundLantern;
import net.hdt.neutronia.modules.building.blocks.slab.BlockDuskboundSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockDuskboundStairs;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;
import net.thegaminghuskymc.huskylib2.recipie.RecipeHandler;
import net.thegaminghuskymc.huskylib2.utils.ProxyRegistry;

public class DuskboundBlocks extends Feature {

    public static Block duskbound_block;
    public static Block duskbound_lantern;

    boolean enableStairsAndSlabs;
    boolean enableWalls;

    @Override
    public void setupConfig() {
        enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
        enableWalls = loadPropBool("Enable walls", "", true) && GlobalConfig.enableVariants;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        duskbound_block = new BlockDuskbound();
        duskbound_lantern = new BlockDuskboundLantern();

        if (enableStairsAndSlabs) {
            BlockModStairs.initStairs(duskbound_block, 0, new BlockDuskboundStairs());
            BlockModSlab.initSlab(duskbound_block, 0, new BlockDuskboundSlab(false), new BlockDuskboundSlab(true));
        }

        VanillaWalls.add("duskbound_block", duskbound_block, 0, enableWalls);

        RecipeHandler.addShapedRecipe(ProxyRegistry.newStack(duskbound_block, 16),
                "PPP", "POP", "PPP",
                'P', ProxyRegistry.newStack(Blocks.PURPUR_BLOCK),
                'O', ProxyRegistry.newStack(Blocks.OBSIDIAN));
		/*RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(duskbound_lantern, 4),
				"DDD", "DED", "DDD",
				'D', ProxyRegistry.newStack(duskbound_block),
				'E', ProxyRegistry.newStack(Items.ENDER_PEARL));*/
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
