package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeBasalt;

import java.util.Objects;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

//@Mod.EventBusSubscriber(modid = MOD_ID)
//@GameRegistry.ObjectHolder(MOD_ID)
public class BiomeInit  {

    public static final Biome BASALT = null;

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event)
    {
        event.getRegistry().register(new BiomeBasalt().setRegistryName(MOD_ID, "basalt"));
    }

    public static void postInit()
    {
        BiomeDictionary.addTypes(Objects.requireNonNull(BASALT), BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.DRY);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BASALT, 1));
        BiomeManager.addSpawnBiome(BASALT);

        System.out.println("Basalt biome: " + BASALT);
    }
}