package net.hdt.neutronia.init;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.world.biome.nether.BiomeAshDesert;
import net.hdt.neutronia.world.biome.nether.BiomeMagmaLands;
import net.hdt.neutronia.world.biome.nether.BiomeSoulSandDesert;
import net.hdt.neutronia.world.dimensions.new_nether.WorldProviderNether;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static net.hdt.neutronia.util.Reference.MOD_ID;
import static net.minecraftforge.common.BiomeDictionary.Type.*;

@SuppressWarnings("ConstantConditions")
@GameRegistry.ObjectHolder(MOD_ID)
public class NNetherBiomes
{
    public static final BiomeAshDesert ASH_DESERT = null;
    public static final BiomeMagmaLands MAGMA_LANDS = null;
    public static final BiomeSoulSandDesert SOUL_SAND_DESERT = null;

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class EventHandler
    {
        @SubscribeEvent
        public static void onRegisterBiomes(RegistryEvent.Register<Biome> event)
        {
            Main.LOGGER.info("Biome registration started.");

            event.getRegistry().registerAll(
                    new BiomeAshDesert(),
                    new BiomeMagmaLands(),
                    new BiomeSoulSandDesert()
            );

            Main.LOGGER.info("Biome registration completed.");
        }
    }

    public static void init()
    {
        BiomeDictionary.addTypes(ASH_DESERT, NETHER, HOT, DRY, SANDY);
        BiomeDictionary.addTypes(MAGMA_LANDS, NETHER, HOT, DRY, BEACH);
        BiomeDictionary.addTypes(SOUL_SAND_DESERT, NETHER, HOT, DRY, DEAD, SANDY);
    }

    public static void postInit()
    {
        DimensionManager.unregisterDimension(-1);
        DimensionType nether = DimensionType.register("Nether", "_nether", -1, WorldProviderNether.class, false);
        DimensionManager.registerDimension(-1, nether);
        Main.LOGGER.info("The Nether has been overridden.");
    }
}