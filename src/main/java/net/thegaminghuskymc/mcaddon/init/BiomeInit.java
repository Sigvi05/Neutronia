package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeBasaltOverworld;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeBlackDesert;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeRedDesert;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeSuperDeepOcean;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BiomeInit {

    public static final Biome BASALT = new BiomeBasaltOverworld();
    public static final Biome RED_DESERT = new BiomeRedDesert();
    public static final Biome BLACK_DESERT = new BiomeBlackDesert();
    public static final Biome SUPER_DEEP_OCEAN = new BiomeSuperDeepOcean();

    public static void registerBiomes()
    {
        initBiome(BASALT, "basalt", 3, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DEAD);
        initBiome(RED_DESERT, "red_desert", 20, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY);
        initBiome(BLACK_DESERT, "black_desert", 10, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY);
        initBiome(SUPER_DEEP_OCEAN, "super_deep_ocean", 20, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.WATER, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WET);
    }

    private static Biome initBiome(Biome biome, String name, int weight, BiomeManager.BiomeType biomeType, BiomeDictionary.Type... types) {
        biome.setRegistryName(MOD_ID, name);
        ForgeRegistries.BIOMES.register(biome);
        System.out.println(String.format("Biome: %s is now registered", name));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weight));
        BiomeManager.addSpawnBiome(biome);
        System.out.println(String.format("Biome: %s is now added to the spawn biome's", name));
        return biome;
    }

}