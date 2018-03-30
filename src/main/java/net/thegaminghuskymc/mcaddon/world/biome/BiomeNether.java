package net.thegaminghuskymc.mcaddon.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public abstract class BiomeNether extends Biome {
    public BiomeNether(BiomeProperties properties, String name) {
        super(properties);

        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCaveCreatureList.clear();

        setRegistryName(MOD_ID, name);
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new BiomeDecoratorNether();
    }
}