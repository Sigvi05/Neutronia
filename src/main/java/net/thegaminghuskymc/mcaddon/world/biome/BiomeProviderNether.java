package net.thegaminghuskymc.mcaddon.world.biome;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.thegaminghuskymc.mcaddon.world.gen.layer.GenLayerNether;

import java.lang.reflect.Field;

public class BiomeProviderNether extends BiomeProvider {
    private static final Field FIELD_GEN_BIOMES = ReflectionHelper.findField(BiomeProvider.class, "field_76944_d", "genBiomes");
    private static final Field FIELD_BIOME_INDEX_LAYER = ReflectionHelper.findField(BiomeProvider.class, "field_76945_e", "biomeIndexLayer");

    public BiomeProviderNether(World world) {
        super();

        GenLayer[] genLayers = GenLayerNether.initializeAllBiomeGenerators(world.getSeed(), world.getWorldType());

        try {
            FIELD_GEN_BIOMES.set(this, genLayers[0]);
            FIELD_BIOME_INDEX_LAYER.set(this, genLayers[1]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}