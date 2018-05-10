package net.hdt.neutronia.init;

import net.hdt.neutronia.world.biome.overworld.BiomeBasaltOverworld;
import net.hdt.neutronia.world.biome.overworld.BiomeBlackDesert;
import net.hdt.neutronia.world.biome.overworld.BiomeFrozenMesa;
import net.hdt.neutronia.world.biome.overworld.BiomeRedDesert;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class NBiomes {

    public static final Biome BASALT = new BiomeBasaltOverworld();
    public static final Biome RED_DESERT = new BiomeRedDesert();
    public static final Biome BLACK_DESERT = new BiomeBlackDesert();
    public static final Biome MESA = new BiomeFrozenMesa(false, false, (new Biome.BiomeProperties("Frozen Mesa")).setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());
    public static final Biome MESA_ROCK = new BiomeFrozenMesa(false, true, (new Biome.BiomeProperties("Frozen Mesa Plateau F")).setBaseHeight(1.5F).setHeightVariation(0.025F).setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());
    public static final Biome MESA_CLEAR_ROCK = new BiomeFrozenMesa(false, false, (new Biome.BiomeProperties("Frozen Mesa Plateau")).setBaseHeight(1.5F).setHeightVariation(0.025F).setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());
    public static final Biome MUTATED_MESA = new BiomeFrozenMesa(false, true, (new Biome.BiomeProperties("Frozen Mesa (Bryce)")).setBaseBiome("frozen_mesa").setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());
    public static final Biome MUTATED_MESA_ROCK = new BiomeFrozenMesa(false, true, (new Biome.BiomeProperties("Frozen Mesa Plateau F M")).setBaseBiome("frozen_mesa_rock").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());
    public static final Biome MUTATED_MESA_CLEAR_ROCK = new BiomeFrozenMesa(false, false, (new Biome.BiomeProperties("Frozen Mesa Plateau F M")).setBaseBiome("frozen_mesa_clear_rock").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());

    public static void registerBiomes() {
        initBiome(BASALT, "basalt", 3, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DEAD);
        initBiome(RED_DESERT, "red_desert", 20, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY);
        initBiome(BLACK_DESERT, "black_desert", 10, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY);

        initBiome(MESA, "frozen_mesa", 1, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
        initBiome(MESA_ROCK, "frozen_mesa_rock", 1, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
        initBiome(MESA_CLEAR_ROCK, "frozen_mesa_clear_rock", 1, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
        initBiome(MUTATED_MESA, "frozen_mutated_mesa", 60, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
        initBiome(MUTATED_MESA_ROCK, "frozen_mutated_mesa_rock", 90, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
        initBiome(MUTATED_MESA_CLEAR_ROCK, "frozen_mutated_mesa_clear_rock", 114, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
    }

    private static Biome initBiome(Biome biome, String name, int weight, BiomeManager.BiomeType biomeType, BiomeDictionary.Type... types) {
        biome.setRegistryName(MOD_ID, name);
        ForgeRegistries.BIOMES.register(biome);
        System.out.println(String.format("Biome: %s is now registered", name));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weight));
        BiomeManager.addSpawnBiome(biome);
        /*if (biome.isMutation())
        {
            Biome.MUTATION_TO_BASE_ID_MAP.put(biome, Biome.getIdForBiome(Objects.requireNonNull(Biome.REGISTRY.getObject(new ResourceLocation(biome.getBiomeName())))));
        }*/
        System.out.println(String.format("Biome: %s is now added to the spawn biome's", name));
        return biome;
    }

}