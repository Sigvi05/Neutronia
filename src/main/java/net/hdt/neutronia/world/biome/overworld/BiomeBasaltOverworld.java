package net.hdt.neutronia.world.biome.overworld;

import net.hdt.neutronia.init.HMBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public class BiomeBasaltOverworld extends Biome {

    public BiomeBasaltOverworld() {
        super(new BiomeProperties("Basalt").setBaseHeight(1.0F).setHeightVariation(0.3F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled());

        topBlock = HMBlocks.newStoneVariants[6].getDefaultState();
        fillerBlock = HMBlocks.newStoneVariants[6].getDefaultState();

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
    }

    public void decorate(World worldIn, Random rand, BlockPos pos) {

    }

}