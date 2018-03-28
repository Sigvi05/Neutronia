package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeBasalt;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

public class BiomeInit {

    public static final Biome BASALT = new BiomeBasalt();

    public static void registerBiomes()
    {
        initBiome(BASALT, "Basalt", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DEAD);
    }

    private static Biome initBiome(Biome biome, String name, BiomeManager.BiomeType biomeType, BiomeDictionary.Type... types)
    {
        biome.setRegistryName(MOD_ID, name);
        ForgeRegistries.BIOMES.register(biome);
        System.out.println(String.format("Biome: %s is now registered", name));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);
        System.out.println(String.format("Biome: %s is now added to the spawn biome's", name));
        return biome;
    }

}