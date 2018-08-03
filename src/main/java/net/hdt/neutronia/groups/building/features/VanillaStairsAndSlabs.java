package net.hdt.neutronia.groups.building.features;

import net.hdt.huskylib2.block.BlockModSlab;
import net.hdt.huskylib2.block.BlockModStairs;
import net.hdt.neutronia.base.blocks.BlockNeutroniaStairs;
import net.hdt.neutronia.base.groups.Feature;
import net.hdt.neutronia.base.groups.GlobalConfig;
import net.hdt.neutronia.groups.building.blocks.slab.BlockVanillaSlab;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class VanillaStairsAndSlabs extends Feature {

	boolean stone, granite, diorite, andesite, endBricks, prismarine, prismarineBricks, darkPrismarine, redNetherBricks;

	@Override
	public void setupConfig() {
		stone = loadPropBool("Stone", "", true);
		granite = loadPropBool("Granite", "", true);
		diorite = loadPropBool("Diorite", "", true);
		andesite = loadPropBool("Andesite", "", true);
		endBricks = loadPropBool("End Bricks", "", true);
		prismarine = loadPropBool("Prismarine", "", true);
		prismarineBricks = loadPropBool("Prismarine Bricks", "", true);
		darkPrismarine = loadPropBool("Dark Prismarine", "", true);
		redNetherBricks = loadPropBool("Red Nether Brick", "", true);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		if(!GlobalConfig.enableVariants)
			return;
		
		add("stone", Blocks.STONE, 0, false, true, stone);
		add("stone_granite", Blocks.STONE, 1, granite);
		add("stone_diorite", Blocks.STONE, 3, diorite);
		add("stone_andesite", Blocks.STONE, 5, andesite);
		add("end_bricks", Blocks.END_BRICKS, 0, endBricks);
		add("prismarine", Blocks.PRISMARINE, 0, prismarine);
		add("prismarine_bricks", Blocks.PRISMARINE, 1, prismarineBricks);
		add("prismarine_dark", Blocks.PRISMARINE, 2, darkPrismarine);
		add("red_nether_brick", Blocks.RED_NETHER_BRICK, 0, redNetherBricks);
	}

	public static void add(String name, Block block, int meta, boolean doit) {
		add(name, block, meta, true, true, doit);
	}

	public static void add(String name, Block block, int meta, boolean slab, boolean stairs, boolean doit) {
		if(!doit)
			return;

		IBlockState state = block.getStateFromMeta(meta);
		String stairsName = name + "_stairs";

		if(stairs)
			BlockModStairs.initStairs(block, meta, new BlockNeutroniaStairs(stairsName, state));
		if(slab)
			BlockModSlab.initSlab(block, meta, new BlockVanillaSlab(name, state, false), new BlockVanillaSlab(name, state, true));
	}

	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}
	
}

