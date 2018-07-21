package net.hdt.neutronia.world.biome.overworld;

import net.hdt.neutronia.init.NBlocks;
import net.minecraft.world.biome.Biome;

public class BiomeBasaltOverworld extends Biome {

    public BiomeBasaltOverworld() {
        super(new BiomeProperties("Basalt").setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled());

        topBlock = NBlocks.newStoneVariants[0].getDefaultState();
        fillerBlock = NBlocks.newStoneVariants[4].getDefaultState();

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
    }

}