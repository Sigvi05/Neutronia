package net.hdt.neutronia.modules.moon.features;

import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.moon.world.biomes.BiomeMoonMain;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static net.hdt.neutronia.base.util.Reference.MOD_ID;

public class MoonBiomes extends Feature {

    public static final Biome MOON_MAIN = new BiomeMoonMain();

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addBiome(MOON_MAIN, "moon_main");
    }

    private static void addBiome(Biome biome, String name) {
        biome.setRegistryName(MOD_ID, name);
        ForgeRegistries.BIOMES.register(biome);
        System.out.println(String.format("Moon Biome: %s is now registered", name));
    }

}
