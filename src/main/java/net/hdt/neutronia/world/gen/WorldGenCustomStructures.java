package net.hdt.neutronia.world.gen;

import net.hdt.neutronia.world.gen.generators.WorldGenStructure;
import net.hdt.neutronia.world.gen.structure.WorldGenCivilizationRuins;
import net.hdt.neutronia.world.utils.WorldGenUtils;
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
import net.minecraftforge.fml.common.IWorldGenerator;

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

    public static final WorldGenStructure CRUST1 = new WorldGenStructure("ocean_structures/corals/crust1");
    public static final WorldGenStructure CRUST2 = new WorldGenStructure("ocean_structures/corals/crust2");
    public static final WorldGenStructure CRUST3 = new WorldGenStructure("ocean_structures/corals/crust3");
    public static final WorldGenStructure CRUST4 = new WorldGenStructure("ocean_structures/corals/crust4");
    public static final WorldGenStructure CRUST5 = new WorldGenStructure("ocean_structures/corals/crust5");

    public static final WorldGenStructure SPHINX_FRONT = new WorldGenStructure("large_sphinx_front");
    public static final WorldGenStructure SPHINX_BACK = new WorldGenStructure("large_sphinx_ass");

    public static final WorldGenerator ruins = new WorldGenCivilizationRuins();

    public WorldGenCustomStructures() {
        super();
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 1:
                break;
            case 0:
//                generateCoral(CORAL_PINK, world, random, chunkX, chunkZ, 5);
//                generateCoral(CORAL_YELLOW, world, random, chunkX, chunkZ, 8);
//                generateCoral(CORAL_PURPLE, world, random, chunkX, chunkZ, 2);
//                generateCoral(CORAL_BLUE, world, random, chunkX, chunkZ, 10);
//                generateCoral(CORAL_RED, world, random, chunkX, chunkZ, 7);

//                generateCoral(CRUST1, world, random, chunkX, chunkZ, 5);
//                generateCoral(CRUST2, world, random, chunkX, chunkZ, 8);
//                generateCoral(CRUST3, world, random, chunkX, chunkZ, 2);
//                generateCoral(CRUST4, world, random, chunkX, chunkZ, 10);
//                generateCoral(CRUST5, world, random, chunkX, chunkZ, 7);

//                generateStructure(SPHINX_FRONT, world, random, chunkX, chunkZ, 10, Blocks.SAND, Biomes.DESERT, Biomes.DESERT_HILLS);
//                generateStructure(SPHINX_BACK, world, random, chunkX, chunkZ, 10, Blocks.SAND, Biomes.DESERT, Biomes.DESERT_HILLS);

                generateStructure(ruins, world, random, chunkX, chunkZ, 10, Blocks.GRASS);

                break;
            case -1:
                break;
        }
    }

    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Biome... classes) {
        ArrayList<Biome> classesList = new ArrayList<>(Arrays.asList(classes));

        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = WorldGenUtils.calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if (world.getWorldType() != WorldType.FLAT) {
            if (classesList.contains(biome)) {
                if (random.nextInt(chance) == 0) {
                    generator.generate(world, random, pos);
                }
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
                if (random.nextInt(chance) == 0) {
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
                if (random.nextInt(chance) == 0) {
                    if (y + 19 < world.getSeaLevel()) {
                        generator.generate(world, random, pos);
                    }
                }
            }
        }
    }

}