package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeBasalt;

public class BiomeInit
{
	public static final Biome BASALT = new BiomeBasalt();
	
	public static void registerBiomes()
	{
		initBiome(BASALT, "Basalt", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.DRY);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeManager.BiomeType biomeType, BiomeDictionary.Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Biome Registered");
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		System.out.println("Biome Added");
		return biome;
	}



}