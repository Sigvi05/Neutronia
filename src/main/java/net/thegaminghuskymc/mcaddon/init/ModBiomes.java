package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeBasalt;

import static net.minecraftforge.common.BiomeDictionary.Type.*;
import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

@SuppressWarnings("WeakerAccess")
//@GameRegistry.ObjectHolder(MOD_ID)
public class ModBiomes {

	public static final BiomeBasalt DESERT_TEST = null;

//	@Mod.EventBusSubscriber(modid = MOD_ID)
	public static class RegistrationHandler {

		/**
		 * Register this mod's {@link Biome}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
			final IForgeRegistry<Biome> registry = event.getRegistry();

			registerBiome(registry, new BiomeBasalt(), "desert_test", BiomeManager.BiomeType.DESERT, 3, MAGICAL, DEAD, DRY, SPOOKY);
		}

		private static <T extends Biome> void registerBiome(final IForgeRegistry<Biome> registry, final T biome, final String biomeName, final BiomeManager.BiomeType biomeType, final int weight, final BiomeDictionary.Type... types) {
			registry.register(biome.setRegistryName(MOD_ID, biomeName));
			BiomeDictionary.addTypes(biome, types);
			BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weight));
			System.out.print(String.format("%s is now registered! With Biome Types %s", biomeName, biomeType.name()));
		}
	}
}