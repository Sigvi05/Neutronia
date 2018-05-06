package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.blocks.overworld.BlockStainedPlanksSlab;
import net.hdt.neutronia.modules.building.blocks.BlockStainedPlanks;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockStainedPlanksStairs;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;
import net.thegaminghuskymc.huskylib2.utils.ProxyRegistry;

public class StainedPlanks extends Feature {

    public static BlockMod stained_planks;

    boolean enableStairsAndSlabs;

    @Override
    public void setupConfig() {
        enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        stained_planks = new BlockStainedPlanks();

        if (enableStairsAndSlabs) {
            for (BlockStainedPlanks.Variants variant : BlockStainedPlanks.Variants.class.getEnumConstants())
                BlockModStairs.initStairs(stained_planks, variant.ordinal(), new BlockStainedPlanksStairs(variant));
            for (BlockStainedPlanks.Variants variant : BlockStainedPlanks.Variants.class.getEnumConstants())
                BlockModSlab.initSlab(stained_planks, variant.ordinal(), new BlockStainedPlanksSlab(variant, false), new BlockStainedPlanksSlab(variant, true));
        }
		
		/*for(int i = 0; i < 16; i++) {
			RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(stained_planks, 8, i),
					"BBB", "BDB", "BBB",
					'B', "plankWood",
					'D', LibMisc.OREDICT_DYES.get(15 - i));
		}*/
    }

    @Override
    public void init(FMLInitializationEvent event) {
        OreDictionary.registerOre("plankWood", ProxyRegistry.newStack(stained_planks, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("plankStained", ProxyRegistry.newStack(stained_planks, 1, OreDictionary.WILDCARD_VALUE));
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
