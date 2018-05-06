package net.hdt.neutronia.world.biome.overworld;

import net.hdt.neutronia.init.HMBlocks;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomeBlackDesert extends Biome {

    public BiomeBlackDesert() {
        super((new BiomeProperties("Black Desert")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled());
        this.decorator.generateFalls = false;
        this.decorator.treesPerChunk = -999;
        this.decorator.flowersPerChunk = -999;
        this.decorator.grassPerChunk = 4;
        this.decorator.reedsPerChunk = 2;
        this.decorator.cactiPerChunk = 1;

        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));

        this.spawnableMonsterList.removeIf(biome$spawnlistentry -> biome$spawnlistentry.entityClass == EntityZombie.class || biome$spawnlistentry.entityClass == EntityZombieVillager.class);

        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombie.class, 19, 4, 4));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 1, 1, 1));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityHusk.class, 80, 4, 4));
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        if (noiseVal > 1.9D) {
            this.topBlock = Blocks.GRAVEL.getDefaultState();
            this.fillerBlock = Blocks.GRAVEL.getDefaultState();
        } else {
            this.topBlock = HMBlocks.coloredSand[EnumDyeColor.BLACK.getMetadata()].getDefaultState();
            this.fillerBlock = HMBlocks.coloredSand[EnumDyeColor.BLACK.getMetadata()].getDefaultState();
        }

        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

}
