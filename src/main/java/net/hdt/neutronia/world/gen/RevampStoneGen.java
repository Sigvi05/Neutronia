package net.hdt.neutronia.world.gen;

import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.properties.EnumNewStoneVariants;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class RevampStoneGen {

	boolean outputCSV;

	int defSize = 14;
	int defRarity = 15;
	int defUpper = 80;
	int defLower = 20;

	public StoneInfo graniteInfo = loadStoneInfo("granite", defSize, defRarity, defUpper, defLower, true, Type.MOUNTAIN, Type.HILLS),
			dioriteInfo = loadStoneInfo("diorite", defSize, defRarity, defUpper, defLower, true, Type.SANDY, Type.SAVANNA, Type.WASTELAND, Type.MUSHROOM),
			andesiteInfo = loadStoneInfo("andesite", defSize, defRarity, defUpper, defLower, true, Type.FOREST),
			marbleInfo = loadStoneInfo("marble", defSize, defRarity, defUpper, defLower, true, Type.FOREST, Type.OCEAN, Type.MAGICAL),
			limestoneInfo = loadStoneInfo("limestone", defSize, defRarity, defUpper, defLower, true, Type.MAGICAL, Type.OCEAN, Type.WASTELAND),
			basaltInfo = loadStoneInfo("basalt", defSize, defRarity, defUpper, defLower, true, Type.HOT, Type.MAGICAL, Type.NETHER, Type.SPOOKY, Type.DEAD);
	private static List<StoneInfoBasedGenerator> generators;
	
	public StoneInfo loadStoneInfo(String name, int clusterSize, int clusterRarity, int upperBound, int lowerBound, boolean enabled, BiomeDictionary.Type... biomes) {
		return loadStoneInfo("worldgen", name, clusterSize, clusterRarity, upperBound, lowerBound, enabled, "0", biomes);
	}

	public static StoneInfo loadStoneInfo(String configCategory, String name, int clusterSize, int clusterRarity, int upperBound, int lowerBound, boolean enabled, String dims, BiomeDictionary.Type... biomes) {
		String category = configCategory + "." + name;
		StoneInfo info = new StoneInfo(category, clusterSize, clusterRarity, upperBound, lowerBound, enabled, dims, biomes);
		return info;
	}

	public void preInit(FMLPreInitializationEvent event) {
		IBlockState graniteState = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE);
		IBlockState dioriteState = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE);
		IBlockState andesiteState = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE);
		IBlockState marbleState = NBlocks.newStoneVariants[EnumNewStoneVariants.MARBLE.getMetadata()].getDefaultState();
		IBlockState limestoneState = NBlocks.newStoneVariants[EnumNewStoneVariants.LIMESTONE.getMetadata()].getDefaultState();
		IBlockState basaltState = NBlocks.newStoneVariants[EnumNewStoneVariants.BASALT.getMetadata()].getDefaultState();

		generators = new ArrayList<>();
		
		generators.add(new StoneInfoBasedGenerator(() -> graniteInfo, graniteState, "granite"));
		generators.add(new StoneInfoBasedGenerator(() -> dioriteInfo, dioriteState, "diorite"));
		generators.add(new StoneInfoBasedGenerator(() -> andesiteInfo, andesiteState, "andesite"));
		generators.add(new StoneInfoBasedGenerator(() -> marbleInfo, marbleState, "marble"));
		generators.add(new StoneInfoBasedGenerator(() -> limestoneInfo, limestoneState, "limestone"));
		generators.add(new StoneInfoBasedGenerator(() -> basaltInfo, basaltState, "basalt"));
		
		if(outputCSV)
			BiomeTypeConfigHandler.debugStoneGeneration(generators);
	}

	@SubscribeEvent
	public void onOreGenerate(OreGenEvent.GenerateMinable event) {
		switch(event.getType()) {
		case GRANITE:
			if(graniteInfo.enabled)
				event.setResult(Result.DENY);
			break;
		case DIORITE:
			if(dioriteInfo.enabled)
				event.setResult(Result.DENY);
			break;
		case ANDESITE:
			if(andesiteInfo.enabled)
				event.setResult(Result.DENY);
			
			generateNewStones(event);
			break;
		default: return;
		}
	}

	private void generateNewStones(OreGenEvent.GenerateMinable event) {
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		Chunk chunk = world.getChunkFromBlockCoords(pos);
		
		for(StoneInfoBasedGenerator gen : generators)
			gen.generate(chunk.x, chunk.z, world);
	}

}
