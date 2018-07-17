package net.hdt.neutronia.world.gen;

import com.google.common.collect.Lists;
import net.hdt.neutronia.init.NBiomes;
import net.hdt.neutronia.world.gen.generators.WorldGenStructure;
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

import java.util.*;

public class WorldGenCustomStructures implements IWorldGenerator {

    private static final WorldGenStructure CORALS = new WorldGenStructure(Lists.newArrayList("ocean_structures/coral_1", "ocean_structures/coral_2", "ocean_structures/coral_3", "ocean_structures/coral_4", "ocean_structures/coral_5", "ocean_structures/coral_blue", "ocean_structures/coral_pink", "ocean_structures/coral_purple", "ocean_structures/coral_yellow", "ocean_structures/coral_red"));

    /**TODO: Add Mini Castle, More Village Stuff, Spider Nests, Endermite Nests, Guardian Ruins, Mesa Temple, Mesa Village, Desert Labyrinth, Actual Pyramids,
    **/
    public WorldGenCustomStructures() {
        super();
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 5:
                generateCoral(CORALS, world, random, chunkX, chunkZ, 10);
                break;
            case 0:
                generateStructure(CORALS, world, random, chunkX, chunkZ, 10, Blocks.GRAVEL, NBiomes.DEEP_WARM_OCEAN, NBiomes.WARM_OCEAN);
                break;
        }
    }

    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Biome... classes) {
        Set<Biome> biomeSet = new HashSet<>();
        Collections.addAll(biomeSet, classes);

        int x = (chunkX * 16) + random.nextInt(16);
        int z = (chunkZ * 16) + random.nextInt(16);
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x,y,z);

        Biome biome = world.getBiome(pos);

        if(world.getWorldType() != WorldType.FLAT)
        {
            if (!biomeSet.contains(biome)) {
                return;
            }
            if(random.nextInt(chance) == 0)
            {
                generator.generate(world, random, pos);
//                System.out.print(String.format("This structure has a %d percent of spawning" + "\n", random.nextInt(chance)));
            }
        }
    }

    private void generateUndergroundStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, int structureHeight, Block topBlock, Biome... classes) {
        Set<Biome> biomeSet = new HashSet<>();
        Collections.addAll(biomeSet, classes);

        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = WorldGenUtils.calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);

        Biome biome = world.getBiome(pos);

        if (world.getWorldType() != WorldType.FLAT) {
            if (!biomeSet.contains(biome)) {
                return;
            }
            if(random.nextInt(chance) == 0)
            {
                if (y + structureHeight < world.getHeight()) {
                    generator.generate(world, random, pos);
                }
            }
        }
    }

    private void generateCoral(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance) {
        int x = (chunkX * 16) + random.nextInt(16);
        int z = (chunkZ * 16) + random.nextInt(16);
        int y = WorldGenUtils.calculateGenerationHeight(world, x, z, Blocks.GRAVEL);
        BlockPos pos = new BlockPos(x, y, z);

        Biome biome = world.getBiome(pos);

        if (world.getWorldType() != WorldType.FLAT) {
            if (biome == Biomes.DEEP_OCEAN || biome == Biomes.OCEAN || biome == Biomes.FROZEN_OCEAN || biome == NBiomes.DEEP_WARM_OCEAN || biome == NBiomes.WARM_OCEAN) {
                if (random.nextInt(chance) == 0) {
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