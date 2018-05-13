/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [20/03/2016, 19:56:42 (GMT)]
 */
package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockWorldStoneBricks;
import net.hdt.neutronia.modules.building.blocks.slab.BlockVanillaSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockVanillaStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.compat.ModIntegrationHandler;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;
import net.thegaminghuskymc.huskylib2.utils.ProxyRegistry;

public class WorldStoneBricks extends Feature {

    public static BlockMod world_stone_bricks;

    boolean enableStairsAndSlabs;
    boolean enableWalls;

    @Override
    public void setupConfig() {
        enableStairsAndSlabs = loadPropBool("Enable stairs and slabs", "", true) && GlobalConfig.enableVariants;
        enableWalls = loadPropBool("Enable walls", "", true) && GlobalConfig.enableVariants;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        world_stone_bricks = new BlockWorldStoneBricks();

        if (enableStairsAndSlabs) {
            for (BlockWorldStoneBricks.Variants variant : BlockWorldStoneBricks.Variants.class.getEnumConstants()) {
                if (!variant.isEnabled())
                    continue;

                IBlockState state = world_stone_bricks.getDefaultState().withProperty(world_stone_bricks.getVariantProp(), variant);
                String name = variant.getName() + "_stairs";
                BlockModStairs.initStairs(world_stone_bricks, variant.ordinal(), new BlockVanillaStairs(name, state));
            }

            for (BlockWorldStoneBricks.Variants variant : BlockWorldStoneBricks.Variants.class.getEnumConstants()) {
                if (!variant.isEnabled())
                    continue;

                IBlockState state = world_stone_bricks.getDefaultState().withProperty(world_stone_bricks.getVariantProp(), variant);
                String name = variant.getName() + "_slab";
                BlockModSlab.initSlab(world_stone_bricks, variant.ordinal(), new BlockVanillaSlab(name, state, false), new BlockVanillaSlab(name, state, true));
            }
        }

        if (enableWalls)
            for (BlockWorldStoneBricks.Variants variant : BlockWorldStoneBricks.Variants.class.getEnumConstants()) {
                if (!variant.isEnabled())
                    continue;

                world_stone_bricks.getDefaultState().withProperty(world_stone_bricks.getVariantProp(), variant);
                String name = variant.getName();
//			VanillaWalls.add(name, world_stone_bricks, variant.ordinal(), true);
            }
    }

    @Override
    public void postPreInit(FMLPreInitializationEvent event) {
		/*for(int i = 0; i < 3; i++)
			RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(world_stone_bricks, 4, i),
					"SS", "SS",
					'S', ProxyRegistry.newStack(Blocks.STONE, 1, i * 2 + 2));*/

		/*if(BlockWorldStoneBricks.Variants.STONE_BASALT_BRICKS.isEnabled()) {
			RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(world_stone_bricks, 4, 3),
					"SS", "SS",
					'S', ProxyRegistry.newStack(Basalt.basalt, 1, 1));
		}
		
		if(BlockWorldStoneBricks.Variants.STONE_MARBLE_BRICKS.isEnabled()) {
			RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(world_stone_bricks, 4, 4),
					"SS", "SS",
					'S', ProxyRegistry.newStack(RevampStoneGen.marble, 1, 1));
		}
		
		if(BlockWorldStoneBricks.Variants.STONE_LIMESTONE_BRICKS.isEnabled()) {
			RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(world_stone_bricks, 4, 5),
					"SS", "SS",
					'S', ProxyRegistry.newStack(RevampStoneGen.limestone, 1, 1));
		}*/
    }

    @Override
    public void init(FMLInitializationEvent event) {
        ModIntegrationHandler.registerChiselVariant("granite", ProxyRegistry.newStack(world_stone_bricks, 1, 0));
        ModIntegrationHandler.registerChiselVariant("diorite", ProxyRegistry.newStack(world_stone_bricks, 1, 1));
        ModIntegrationHandler.registerChiselVariant("andesite", ProxyRegistry.newStack(world_stone_bricks, 1, 2));

		/*if(BlockWorldStoneBricks.Variants.STONE_BASALT_BRICKS.isEnabled()) {
			ModIntegrationHandler.registerChiselVariant("basalt", ProxyRegistry.newStack(world_stone_bricks, 1, 3));
		}

		if(BlockWorldStoneBricks.Variants.STONE_MARBLE_BRICKS.isEnabled()) {
			ModIntegrationHandler.registerChiselVariant("marble", ProxyRegistry.newStack(world_stone_bricks, 1, 4));
		}

		if(BlockWorldStoneBricks.Variants.STONE_LIMESTONE_BRICKS.isEnabled()) {
			ModIntegrationHandler.registerChiselVariant("limestone", ProxyRegistry.newStack(world_stone_bricks, 1, 5));
		}*/

    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
