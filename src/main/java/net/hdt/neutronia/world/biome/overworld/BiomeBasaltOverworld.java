package net.hdt.neutronia.world.biome.overworld;

import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.world.biome.overworld.decorator.BiomeDesertDecorator;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeBasaltOverworld extends Biome {

    public BiomeBasaltOverworld() {
        super(new BiomeProperties("Basalt").setBaseHeight(1.0F).setHeightVariation(0.3F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled());

        topBlock = NBlocks.newStoneVariants[2].getDefaultState();
        fillerBlock = NBlocks.newStoneVariants[6].getDefaultState();

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new BiomeDesertDecorator(topBlock.getBlock(), fillerBlock.getBlock());
    }

}