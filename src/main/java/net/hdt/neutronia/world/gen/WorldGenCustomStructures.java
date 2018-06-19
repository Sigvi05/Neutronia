package net.hdt.neutronia.world.gen;

import net.hdt.neutronia.world.gen.features.TFGenGroveRuins;
import net.hdt.neutronia.world.gen.features.chagarothlair;
import net.hdt.neutronia.world.gen.generators.WorldGenStructure;
import net.hdt.neutronia.world.utils.WorldGenUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.*;

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

    public static final WorldGenStructure SNOW_SMALL_1 = new WorldGenStructure("ttb/structure_snow_small1");
    public static final WorldGenStructure SNOW_SMALL_2 = new WorldGenStructure("ttb/structure_snow_small2");
    public static final WorldGenStructure SNOW_SMALL_3 = new WorldGenStructure("ttb/structure_snow_small3");
    public static final WorldGenStructure SNOW_SPIKES = new WorldGenStructure("ttb/structure_snow_spikes");
    public static final WorldGenStructure SNOW_TOWER = new WorldGenStructure("ttb/structure_snow_tower");

    public static final WorldGenStructure CRUST1 = new WorldGenStructure("ocean_structures/corals/crust1");
    public static final WorldGenStructure CRUST2 = new WorldGenStructure("ocean_structures/corals/crust2");
    public static final WorldGenStructure CRUST3 = new WorldGenStructure("ocean_structures/corals/crust3");
    public static final WorldGenStructure CRUST4 = new WorldGenStructure("ocean_structures/corals/crust4");
    public static final WorldGenStructure CRUST5 = new WorldGenStructure("ocean_structures/corals/crust5");

    public static final WorldGenStructure SPHINX_FRONT = new WorldGenStructure("large_sphinx_front");
    public static final WorldGenStructure SPHINX_BACK = new WorldGenStructure("large_sphinx_ass");

    public static final WorldGenStructure TEST = new WorldGenStructure("dungeon_0");

    public static final TFGenGroveRuins ruins = new TFGenGroveRuins();

    public static final chagarothlair idk = new chagarothlair();

    public WorldGenCustomStructures() {
        super();
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 1:
                break;
            case 0:
                generateStructure(SNOW_SMALL_1, world, random, chunkX, chunkZ, random.nextInt(10), Blocks.GRASS.getDefaultState().withProperty(BlockGrass.SNOWY, true).getBlock(), Biomes.ICE_PLAINS, Biomes.ICE_MOUNTAINS);
                generateStructure(SNOW_SMALL_2, world, random, chunkX, chunkZ, random.nextInt(10), Blocks.GRASS.getDefaultState().withProperty(BlockGrass.SNOWY, true).getBlock(), Biomes.ICE_PLAINS, Biomes.ICE_MOUNTAINS);
                generateStructure(SNOW_SMALL_3, world, random, chunkX, chunkZ, random.nextInt(10), Blocks.GRASS.getDefaultState().withProperty(BlockGrass.SNOWY, true).getBlock(), Biomes.ICE_PLAINS, Biomes.ICE_MOUNTAINS);
                generateStructure(SNOW_SPIKES, world, random, chunkX, chunkZ, random.nextInt(10), Blocks.GRASS.getDefaultState().withProperty(BlockGrass.SNOWY, true).getBlock(), Biomes.ICE_PLAINS, Biomes.ICE_MOUNTAINS);
                generateStructure(SNOW_TOWER, world, random, chunkX, chunkZ, random.nextInt(10), Blocks.GRASS.getDefaultState().withProperty(BlockGrass.SNOWY, true).getBlock(), Biomes.ICE_PLAINS, Biomes.ICE_MOUNTAINS);
//                generateCoral(CORAL_PINK, world, random, chunkX, chunkZ, random.nextInt(50));
//                generateCoral(CORAL_YELLOW, world, random, chunkX, chunkZ, random.nextInt(50));
//                generateCoral(CORAL_PURPLE, world, random, chunkX, chunkZ, random.nextInt(50));
//                generateCoral(CORAL_BLUE, world, random, chunkX, chunkZ, random.nextInt(50));
//                generateCoral(CORAL_RED, world, random, chunkX, chunkZ, random.nextInt(50));

//                generateStructure(SPHINX_FRONT, world, random, chunkX, chunkZ, random.nextInt(20), Blocks.SAND, Biomes.DESERT, Biomes.DESERT_HILLS);
//                generateStructure(SPHINX_BACK, world, random, chunkX, chunkZ, random.nextInt(20), Blocks.SAND, Biomes.DESERT, Biomes.DESERT_HILLS);

                generateStructure(TEST, world, random, chunkX, chunkZ, 2, Blocks.GRASS, Biomes.PLAINS, Biomes.JUNGLE, Biomes.FOREST, Biomes.HELL, Biomes.MESA_ROCK);

                generateStructure(ruins, world, random, chunkX, chunkZ, random.nextInt(5), Blocks.GRASS, Biomes.DEFAULT);

                generateStructure(idk, world, random, chunkX, chunkZ, 100, Blocks.GRASS, Biomes.PLAINS, Biomes.JUNGLE, Biomes.FOREST, Biomes.HELL, Biomes.MESA_ROCK);

                break;
            case -1:
                break;
        }
    }

    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Biome... classes) {
        Set<Biome> biomeSet = new HashSet<>(classes);

        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x,y,z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if(world.getWorldType() != WorldType.FLAT)
        {
            if (!biomeSet.contains(biome)) {
                return;
            }
            if(random.nextInt(chance) == 0)
            {
                generator.generate(world, random, pos);
                System.out.print("This is a thing" + random.nextInt(chance));
            }
        }
    }

    private void generateUndergroundStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, int structureHeight, Block topBlock, Biome... classes) {
        ArrayList<Biome> classesList = new ArrayList<>(Arrays.asList(classes));

        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = WorldGenUtils.calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if (world.getWorldType() != WorldType.FLAT) {
            if (classesList.contains(biome)) {
                for (int rnd = 0; rnd < chance; rnd++) {
                    if (y + structureHeight < world.getHeight()) {
                        generator.generate(world, random, pos);
                    }
                }
            }
        }
    }

    private void generateCoral(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance) {
        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = WorldGenUtils.calculateGenerationHeight(world, x, z, Blocks.GRAVEL);
        BlockPos pos = new BlockPos(x, y, z);

        Biome biome = world.provider.getBiomeForCoords(pos);

        if (world.getWorldType() != WorldType.FLAT) {
            if (biome == Biomes.DEEP_OCEAN || biome == Biomes.OCEAN || biome == Biomes.FROZEN_OCEAN) {
                for (int rnd = 0; rnd < chance; rnd++) {
                    if (y + 19 < world.getSeaLevel()) {
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

}