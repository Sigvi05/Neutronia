package net.hdt.neutronia.modules.moon.world.biomes;

import net.hdt.neutronia.world.biome.overworld.decorator.BiomeDesertDecorator;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeMoonMain extends Biome {

    public BiomeMoonMain() {
        super(new BiomeProperties("Moon NeutroniaMain").setBaseHeight(1.0F).setHeightVariation(0.1F).setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());

        topBlock = Blocks.END_STONE.getDefaultState();
        fillerBlock = Blocks.END_STONE.getDefaultState();

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
