package net.thegaminghuskymc.mcaddon.world.gen;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.thegaminghuskymc.mcaddon.world.gen.generators.WorldGenStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WorldGenCustomStructures implements IWorldGenerator {
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

	public WorldGenCustomStructures() {
		super();
	}

	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
			case 1:
				break;
			case 0:
                generateCoral(CORAL_PINK, world, random, chunkX, chunkZ, 20);
                generateCoral(CORAL_YELLOW, world, random, chunkX, chunkZ, 20);
                generateCoral(CORAL_PURPLE, world, random, chunkX, chunkZ, 20);
                generateCoral(CORAL_BLUE, world, random, chunkX, chunkZ, 20);
                generateCoral(CORAL_RED, world, random, chunkX, chunkZ, 20);
				break;
			case -1:
                break;
		}
	}

	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) {
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
				}
			}
		}
	}

    private void generateCoral(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance) {

        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = calculateGenerationHeight(world, x, z, Blocks.GRAVEL);
        BlockPos pos = new BlockPos(x,y,z);

        Biome biome = world.provider.getBiomeForCoords(pos);

        if(world.getWorldType() != WorldType.FLAT)
        {
            if(biome == Biomes.DEEP_OCEAN || biome == Biomes.OCEAN || biome == Biomes.FROZEN_OCEAN)
            {
                if(random.nextInt(chance) == 0)
                {
                    if(y + 19 < world.getSeaLevel()) {
                        generator.generate(world, random, pos);
                    }
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

    public static int getGroundFromAbove(World world, int x, int z)
    {
        int y = 255;
        boolean foundGround = false;
        while(!foundGround && y-- >= 31)
        {
            Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround =  blockAt == Blocks.WATER||blockAt == Blocks.FLOWING_WATER||blockAt == Blocks.GRASS || blockAt == Blocks.SAND || blockAt == Blocks.SNOW || blockAt == Blocks.SNOW_LAYER || blockAt == Blocks.GLASS||blockAt == Blocks.MYCELIUM;
        }

        return y;
    }
    public static int getLakeFromAbove(World world, int x, int z)
    {
        int y = 255;
        boolean foundGround = false;
        while(!foundGround && y-- >= 31)
        {
            Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround =  blockAt == Blocks.WATER||blockAt == Blocks.FLOWING_WATER;
        }

        return y;
    }

    public static boolean canSpawnHere(Template template, World world, BlockPos posAboveGround)
    {
        int zwidth = template.getSize().getZ();
        int xwidth = template.getSize().getX();

        // check all the corners to see which ones are replaceable
        boolean corner1 = isCornerValid(world, posAboveGround);
        boolean corner2 = isCornerValid(world, posAboveGround.add(xwidth, 0, zwidth));

        // if Y > 20 and all corners pass the test, it's okay to spawn the structure
        return posAboveGround.getY() > 31 && corner1 && corner2;
    }

    public static boolean isCornerValid(World world, BlockPos pos)
    {
        int variation = 3;
        int highestBlock = getGroundFromAbove(world, pos.getX(), pos.getZ());

        if (highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation)
            return true;

        return false;
    }

}