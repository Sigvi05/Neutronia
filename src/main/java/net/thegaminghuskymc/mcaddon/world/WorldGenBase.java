package net.thegaminghuskymc.mcaddon.world;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.thegaminghuskymc.mcaddon.util.NoiseGenUtil;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class WorldGenBase implements IWorldGenerator {
    public float spawnChance = 0.0F;
    public Set<Block> spawnable = new HashSet<>();

    public WorldGenBase(float chance) {
        this.spawnChance = chance;
    }

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        Random rand = NoiseGenUtil.getRandom(new int[]{chunkX, chunkZ, this.getClass().getTypeName().hashCode()});
        if (rand.nextFloat() < this.spawnChance) {
            this.generateStruct(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }

    }

    public void generateStruct(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGen, IChunkProvider chunkProv) {
    }
}
