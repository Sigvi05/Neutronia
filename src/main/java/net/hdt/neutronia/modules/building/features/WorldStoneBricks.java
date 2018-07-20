package net.hdt.neutronia.modules.building.features;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.huskylib2.blocks.BlockModSlab;
import net.hdt.huskylib2.blocks.BlockModStairs;
import net.hdt.huskylib2.utils.ProxyRegistry;
import net.hdt.neutronia.base.handler.ModIntegrationHandler;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.base.module.GlobalConfig;
import net.hdt.neutronia.modules.building.blocks.BlockWorldStoneBricks;
import net.hdt.neutronia.modules.building.blocks.slab.BlockVanillaSlab;
import net.hdt.neutronia.modules.building.blocks.stair.BlockVanillaStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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

		if(enableStairsAndSlabs) {
			for(BlockWorldStoneBricks.Variants variant : BlockWorldStoneBricks.Variants.class.getEnumConstants()) {
				if(!variant.isEnabled())
					continue;

				IBlockState state = world_stone_bricks.getDefaultState().withProperty(world_stone_bricks.getVariantProp(), variant);
				String name = variant.getName() + "_stairs";
				BlockModStairs.initStairs(world_stone_bricks, variant.ordinal(), new BlockVanillaStairs(name, state));
			}

			for(BlockWorldStoneBricks.Variants variant : BlockWorldStoneBricks.Variants.class.getEnumConstants()) {
				if(!variant.isEnabled())
					continue;

				IBlockState state = world_stone_bricks.getDefaultState().withProperty(world_stone_bricks.getVariantProp(), variant);
				String name = variant.getName() + "_slab";
				BlockModSlab.initSlab(world_stone_bricks, variant.ordinal(), new BlockVanillaSlab(name , state, false), new BlockVanillaSlab(name, state, true));
			}
		}

		if(enableWalls)
		for(BlockWorldStoneBricks.Variants variant : BlockWorldStoneBricks.Variants.class.getEnumConstants()) {
			if(!variant.isEnabled())
				continue;

			world_stone_bricks.getDefaultState().withProperty(world_stone_bricks.getVariantProp(), variant);
			String name = variant.getName();
			VanillaWalls.add(name, world_stone_bricks, variant.ordinal(), true);
		}
	}

	@Override
	public void postPreInit(FMLPreInitializationEvent event) {		
		/*for(int i = 0; i < 3; i++)
			RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(world_stone_bricks, 4, i),
					"SS", "SS",
					'S', ProxyRegistry.newStack(Blocks.STONE, 1, i * 2 + 2));*/
	}

	@Override
	public void init(FMLInitializationEvent event) {
		ModIntegrationHandler.registerChiselVariant("granite", ProxyRegistry.newStack(world_stone_bricks, 1, 0));
		ModIntegrationHandler.registerChiselVariant("diorite", ProxyRegistry.newStack(world_stone_bricks, 1, 1));
		ModIntegrationHandler.registerChiselVariant("andesite", ProxyRegistry.newStack(world_stone_bricks, 1, 2));
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

}
