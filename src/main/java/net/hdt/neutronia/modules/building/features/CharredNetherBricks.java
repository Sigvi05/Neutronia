package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockCharredNetherBricks;
import net.hdt.neutronia.modules.building.blocks.slab.BlockCharredNetherBrickSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockCharredNetherBrickStairs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;

public class CharredNetherBricks extends Feature {

    public static Block charred_nether_bricks;

    boolean enableStairsAndSlabs;

    @Override
    public void setupConfig() {
        enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        charred_nether_bricks = new BlockCharredNetherBricks();

//		RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(charred_nether_bricks, 3), ProxyRegistry.newStack(Blocks.NETHER_BRICK), ProxyRegistry.newStack(Blocks.NETHER_BRICK), ProxyRegistry.newStack(Blocks.NETHER_BRICK), ProxyRegistry.newStack(Items.FIRE_CHARGE));

        if (enableStairsAndSlabs) {
            BlockModStairs.initStairs(charred_nether_bricks, 0, new BlockCharredNetherBrickStairs());
            BlockModSlab.initSlab(charred_nether_bricks, 0, new BlockCharredNetherBrickSlab(false), new BlockCharredNetherBrickSlab(true));
        }
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
