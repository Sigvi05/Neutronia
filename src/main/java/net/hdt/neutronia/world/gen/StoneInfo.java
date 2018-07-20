package net.hdt.neutronia.world.gen;

import net.hdt.huskylib2.module.ModuleLoader;
import net.hdt.neutronia.base.util.handlers.DimensionConfig;
import net.minecraftforge.common.BiomeDictionary;

import java.util.List;

public class StoneInfo {

		public final boolean enabled;
		public final int clusterSize, clusterRarity, upperBound, lowerBound;
		public final boolean clustersRarityPerChunk;
		
		public final DimensionConfig dims;
		public final List<BiomeDictionary.Type> allowedBiomes;

		public StoneInfo(String category, int clusterSize, int clusterRarity, int upperBound, int lowerBound, boolean enabled, String dimStr, BiomeDictionary.Type... biomes) {
			this.enabled = ModuleLoader.config.getBoolean("Enabled", category, true, "") && enabled;
			this.clusterSize = ModuleLoader.config.getInt("Cluster Radius", category, clusterSize, 0, Integer.MAX_VALUE, "");
			this.clusterRarity = ModuleLoader.config.getInt("Cluster Rarity", category, clusterRarity, 0, Integer.MAX_VALUE, "Out of how many chunks would one of these clusters generate");
			this.upperBound = ModuleLoader.config.getInt("Y Level Max", category, upperBound, 0, 255, "");
			this.lowerBound = ModuleLoader.config.getInt("Y Level Min", category, lowerBound, 0, 255, "");
			clustersRarityPerChunk = ModuleLoader.config.getBoolean("Invert Cluster Rarity", category, false, "Setting this to true will make the 'Cluster Rarity' feature be X per chunk rather than 1 per X chunks");
			
			dims = new DimensionConfig(category, dimStr);
			allowedBiomes = BiomeTypeConfigHandler.parseBiomeTypeArrayConfig("Allowed Biome Types", category, biomes);
		}
}