package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockPolishedNetherrack;
import net.hdt.neutronia.modules.building.blocks.slab.BlockPolishedNetherrackBricksSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockPolishedNetherrackBricksStairs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;

public class PolishedNetherrack extends Feature {

    public static BlockMod polished_netherrack;

    boolean enableStairsAndSlabs;
    boolean enableWalls;

    @Override
    public void setupConfig() {
        enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
        enableWalls = loadPropBool("Enable walls", "", true) && GlobalConfig.enableVariants;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        polished_netherrack = new BlockPolishedNetherrack();

        if (enableStairsAndSlabs) {
            BlockModStairs.initStairs(polished_netherrack, 1, new BlockPolishedNetherrackBricksStairs());
            BlockModSlab.initSlab(polished_netherrack, 1, new BlockPolishedNetherrackBricksSlab(false), new BlockPolishedNetherrackBricksSlab(true));
        }
        VanillaWalls.add("polished_netherrack_bricks", polished_netherrack, 1, enableWalls);

		/*RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(polished_netherrack),
				"RR", "RR",
				'R', ProxyRegistry.newStack(Blocks.NETHERRACK));
		RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(polished_netherrack, 4, 1),
				"RR", "RR",
				'R', ProxyRegistry.newStack(polished_netherrack));*/
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
