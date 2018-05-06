package net.hdt.neutronia.world.utils;

import net.hdt.neutronia.util.handlers.DimensionConfig;
import net.hdt.neutronia.world.utils.handlers.BiomeTypeConfigHandler;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.config.Configuration;

import java.util.List;

public class StoneInfo {

    private static Configuration config;
    public final boolean enabled;
    public final int clusterSize, clusterRarity, upperBound, lowerBound;
    public final boolean clustersRarityPerChunk;
    public final DimensionConfig dims;
    public final List<BiomeDictionary.Type> allowedBiomes;

    public StoneInfo(String category, int clusterSize, int clusterRarity, int upperBound, int lowerBound, boolean enabled, String dimStr, BiomeDictionary.Type... biomes) {
        this.enabled = config.getBoolean("Enabled", category, true, "") && enabled;
        this.clusterSize = config.getInt("Cluster Radius", category, clusterSize, 0, Integer.MAX_VALUE, "");
        this.clusterRarity = config.getInt("Cluster Rarity", category, clusterRarity, 0, Integer.MAX_VALUE, "Out of how many chunks would one of these clusters generate");
        this.upperBound = config.getInt("Y Level Max", category, upperBound, 0, 255, "");
        this.lowerBound = config.getInt("Y Level Min", category, lowerBound, 0, 255, "");
        clustersRarityPerChunk = config.getBoolean("Invert Cluster Rarity", category, false, "Setting this to true will make the 'Cluster Rarity' feature be X per chunk rather than 1 per X chunks");

        dims = new DimensionConfig(category, dimStr);
        allowedBiomes = BiomeTypeConfigHandler.parseBiomeTypeArrayConfig("Allowed Biome Types", category, biomes);
    }
}