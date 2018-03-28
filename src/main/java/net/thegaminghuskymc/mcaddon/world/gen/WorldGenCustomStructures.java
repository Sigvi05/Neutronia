package net.thegaminghuskymc.mcaddon.world.gen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeJungle;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeBasalt;
import net.thegaminghuskymc.mcaddon.world.gen.generators.WorldGenStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WorldGenCustomStructures implements IWorldGenerator
{
	public static final WorldGenStructure LIVING_CORAL_REEF = new WorldGenStructure("living_coral_reef");
	public static final WorldGenStructure DEAD_CORAL_REEF = new WorldGenStructure("dead_coral_reef");
	public static final WorldGenStructure VOLCANO = new WorldGenStructure("volcano");
	public static final WorldGenStructure DESERT_HOUSE_1 = new WorldGenStructure("desert_house_1");
	public static final WorldGenStructure DESERT_HOUSE_2 = new WorldGenStructure("desert_house_2");
	public static final WorldGenStructure JUNGLE_VILLAGER_TOTEM = new WorldGenStructure("jungle_villager_totem");

    public static final WorldGenStructure CORAL_PINK = new WorldGenStructure("coral_pink");
    public static final WorldGenStructure CORAL_YELLOW = new WorldGenStructure("coral_yellow");
    public static final WorldGenStructure CORAL_PURPLE = new WorldGenStructure("coral_purple");
    public static final WorldGenStructure CORAL_BLUE = new WorldGenStructure("coral_blue");
    public static final WorldGenStructure CORAL_RED = new WorldGenStructure("coral_red");
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
		case 2:
			
			break;
			
		case 1:
			
			break;
			
		case 0:
			
			generateStructure(VOLCANO, world, random, chunkX, chunkZ, 20, Block.getBlockFromName("hmca:raw_basalt"), BiomeBasalt.class);
//            generateStructure(LIVING_CORAL_REEF, world, random, chunkX, chunkZ, 100, Blocks.GRAVEL, BiomeOcean.class);
//            generateStructure(DEAD_CORAL_REEF, world, random, chunkX, chunkZ, 200, Blocks.GRAVEL, BiomeOcean.class);

            generateStructure(DESERT_HOUSE_1, world, random, chunkX, chunkZ, 20, Blocks.SAND, BiomeDesert.class);
            generateStructure(DESERT_HOUSE_2, world, random, chunkX, chunkZ, 20, Blocks.SAND, BiomeDesert.class);
            generateStructure(JUNGLE_VILLAGER_TOTEM, world, random, chunkX, chunkZ, 30, Blocks.GRASS, BiomeJungle.class);

            generateStructure(CORAL_PINK, world, random, chunkX, chunkZ, 10, Blocks.GRAVEL, BiomeOcean.class);
            generateStructure(CORAL_YELLOW, world, random, chunkX, chunkZ, 10, Blocks.GRAVEL, BiomeOcean.class);
            generateStructure(CORAL_PURPLE, world, random, chunkX, chunkZ, 10, Blocks.GRAVEL, BiomeOcean.class);
            generateStructure(CORAL_BLUE, world, random, chunkX, chunkZ, 10, Blocks.GRAVEL, BiomeOcean.class);
            generateStructure(CORAL_RED, world, random, chunkX, chunkZ, 10, Blocks.GRAVEL, BiomeOcean.class);
			
			break;
			
		case -1:
			
		}
	}
	
	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + random.nextInt(15);
		int z = (chunkZ * 16) + random.nextInt(15);
		int y = calculateGenerationHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x,y,z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(random.nextInt(chance) == 0)
				{
					generator.generate(world, random, pos);
					System.out.print("Generating structure");
				}
			}
		}
	}

	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
	{
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0)
		{
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = block == topBlock;
		}
		
		return y;
	}
}