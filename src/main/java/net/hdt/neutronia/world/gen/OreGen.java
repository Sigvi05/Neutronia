package net.hdt.neutronia.world.gen;

import net.hdt.neutronia.init.NBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreGen implements IWorldGenerator {

    // World Generators
    private WorldGenerator marble;
    private WorldGenerator basalt;
    private WorldGenerator limestone;
    private WorldGenerator meteorite;
    private WorldGenerator fieryStone;
    private WorldGenerator volcanicGlowRock;
    private WorldGenerator volcanicRock;

    public OreGen() {
        marble = new WorldGenMinable(NBlocks.newStoneVariants[13].getDefaultState(), 18);
        basalt = new WorldGenMinable(NBlocks.newStoneVariants[6].getDefaultState(), 30);
        limestone = new WorldGenMinable(NBlocks.newStoneVariants[20].getDefaultState(), 18);
        meteorite = new WorldGenMinable(NBlocks.newStoneVariants[27].getDefaultState(), 18);
        fieryStone = new WorldGenMinable(NBlocks.netherBlocks[0].getDefaultState(), 6);
        volcanicGlowRock = new WorldGenMinable(NBlocks.netherBlocks[1].getDefaultState(), 12);
        volcanicRock = new WorldGenMinable(NBlocks.netherBlocks[1].getDefaultState(), 12);
    }

    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z,
                              int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == -1) {
            this.runGenerator(basalt, world, random, chunkX, chunkZ, 1, 0, 128);
            this.runGenerator(fieryStone, world, random, chunkX, chunkZ, 1, 0, 128);
            this.runGenerator(volcanicGlowRock, world, random, chunkX, chunkZ, 1, 0, 128);
            this.runGenerator(volcanicRock, world, random, chunkX, chunkZ, 1, 0, 128);
        }
        if (world.provider.getDimension() == 0) {
            this.runGenerator(marble, world, random, chunkX, chunkZ, 1, 0, 128);
            this.runGenerator(meteorite, world, random, chunkX, chunkZ, 1, 0, 128);
            this.runGenerator(limestone, world, random, chunkX, chunkZ, 1, 0, 128);
        }
    }

}
