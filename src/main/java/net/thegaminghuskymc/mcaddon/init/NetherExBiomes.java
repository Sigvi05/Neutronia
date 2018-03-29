package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.mcaddon.world.WorldProviderNether;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeBasaltNether;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeHell;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraftforge.common.BiomeDictionary.Type.*;
import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

@SuppressWarnings("ConstantConditions")
@GameRegistry.ObjectHolder(MOD_ID)
public class NetherExBiomes  {

    @GameRegistry.ObjectHolder("hell")
    public static final BiomeHell HELL = null;

    @GameRegistry.ObjectHolder("basalt_nether")
    public static final BiomeBasaltNether BASALT = null;

    private static final Logger LOGGER = LogManager.getLogger("Husky's Minecraft Additions | Biomes");

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class EventHandler
    {
        @SubscribeEvent
        public static void onRegisterBiomes(RegistryEvent.Register<Biome> event)
        {
            LOGGER.info("Biome registration started.");

            event.getRegistry().registerAll(
                    new BiomeHell(),
                    new BiomeBasaltNether()
            );

            LOGGER.info("Biome registration completed.");
        }
    }

    public static void init()
    {
        BiomeDictionary.addTypes(HELL, NETHER, HOT, DRY);
        BiomeDictionary.addTypes(BASALT, NETHER, HOT, SPOOKY, MAGICAL, WASTELAND);
    }

    public static void postInit()
    {
        DimensionManager.unregisterDimension(-1);
        DimensionType nether = DimensionType.register("Nether", "_nether", -1, WorldProviderNether.class, false);
        DimensionManager.registerDimension(-1, nether);

        LOGGER.info("The Nether has been overridden.");
    }
}