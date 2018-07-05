package net.hdt.neutronia.modules.moon.init;

import net.hdt.neutronia.modules.moon.world.biomes.BiomeMoonMain;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static net.hdt.neutronia.util.Reference.MOD_ID;
import static net.minecraftforge.common.BiomeDictionary.*;
import static net.minecraftforge.common.BiomeManager.*;

public class NMoonBiomes {

    public static final Biome MOON_MAIN = new BiomeMoonMain();

    public static void registerBiomes() {
        addBiome(MOON_MAIN, "moon_main", 90, BiomeType.ICY, Type.COLD, Type.DEAD, Type.MAGICAL, Type.END, Type.WASTELAND);
    }

    private static void addBiome(Biome biome, String name, int weight, BiomeType biomeType, Type... types) {
        biome.setRegistryName(MOD_ID, name);
        ForgeRegistries.BIOMES.register(biome);
        System.out.println(String.format("Moon Biome: %s is now registered", name));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeEntry(biome, weight));
        BiomeManager.addSpawnBiome(biome);
        BiomeManager.addStrongholdBiome(biome);
        BiomeManager.addVillageBiome(biome, true);
        System.out.println(String.format("Moon Biome: %s is now added to the spawn biome's", name));
        System.out.println(String.format("Moon Biome: %s has a %d chance to spawn", name, new BiomeEntry(biome, weight).itemWeight));
    }

}
