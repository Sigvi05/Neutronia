package net.hdt.neutronia;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static net.hdt.neutronia.util.Reference.MOD_ID;

/**
 * Remaps this mod's {@link Block}s and {@link Item}s after registry names have been changed.
 *
 * @author Choonster
 */
final class Remapper<T extends IForgeRegistryEntry<T>> {

	private static final Marker MARKER = MarkerManager.getMarker("Remapper").addParents(Logger.MOD_MARKER);

	/**
	 * A list of remapping functions that return {@code true} if they took an action for the {@link Mapping<T>}.
	 */
	private final List<Predicate<Mapping<T>>> remappingFunctions = ImmutableList.of(this::remapCustomName);

	private Remapper() {
	}

	/**
	 * Remap this mod's missing mappings.
	 *
	 * @param missingMappings This mod's missing mappings
	 */
	private void remapAll(final List<Mapping<T>> missingMappings) {
		for (final Mapping<T> missingMapping : missingMappings) { // For each missing mapping,
			Logger.info(MARKER, "Trying to remap %s", missingMapping.key);

			// Try to apply all remapping functions until one performs an action.
			final boolean remapped = remappingFunctions.stream().anyMatch(mappingPredicate -> mappingPredicate.test(missingMapping));

			if (!remapped) {
				Logger.info(MARKER, "Couldn't remap %s", missingMapping.key);
			}
		}
	}

	/**
	 * Try to remap {@code missingMapping} to the value of {@code registryName}.
	 *
	 * @param missingMapping The missing mapping
	 * @param registryName   The registry name to remap to
	 * @return True if the remapping was successful
	 */
	private boolean tryRemap(final Mapping<T> missingMapping, final ResourceLocation registryName) {
		final IForgeRegistry<T> registry = missingMapping.registry;
		final T value = registry.getValue(registryName);
		if (registry.containsKey(registryName) && value != null) {
			Logger.info(MARKER, "Remapped %s %s to %s", registry.getRegistrySuperType().getSimpleName(), missingMapping.key, registryName);
			missingMapping.remap(value);
			return true;
		}

		return false;
	}

	/**
	 * Custom names to remap. Keys are the old names, values are the new names.
	 */
	private static final Map<String, String> customNames;

	static {
		customNames = ImmutableMap.<String, String>builder()
                .put("blue_coral", "tube_coral")
                .put("pink_coral", "brain_coral")
                .put("purple_coral", "bubble_coral")
                .put("red_coral", "fire_coral")
                .put("yellow_coral", "horn_coral")
                .put("blue_dead_coral", "dead_tube_coral")
                .put("pink_dead_coral", "dead_brain_coral")
                .put("purple_dead_coral", "dead_bubble_coral")
                .put("red_dead_coral", "dead_fire_coral")
                .put("yellow_dead_coral", "dead_horn_coral")

                .put("blue_brain_coral", "tube_coral")
                .put("pink_brain_coral", "brain_coral")
                .put("purple_brain_coral", "bubble_coral")
                .put("red_brain_coral", "fire_coral")
                .put("yellow_brain_coral", "horn_coral")
                .put("blue_dead_brain_coral", "dead_tube_coral")
                .put("pink_dead_brain_coral", "dead_brain_coral")
                .put("purple_dead_brain_coral", "dead_bubble_coral")
                .put("red_dead_brain_coral", "dead_fire_coral")
                .put("yellow_dead_brain_coral", "dead_horn_coral")

                .put("blue_coral_fan", "tube_coral_fan")
                .put("pink_coral_fan", "brain_coral_fan")
                .put("purple_coral_fan", "bubble_coral_fan")
                .put("red_coral_fan", "fire_coral_fan")
                .put("yellow_coral_fan", "horn_coral_fan")
                .put("blue_dead_coral_fan", "dead_tube_coral_fan")
                .put("pink_dead_coral_fan", "dead_brain_coral_fan")
                .put("purple_dead_coral_fan", "dead_bubble_coral_fan")
                .put("red_dead_coral_fan", "dead_fire_coral_fan")
                .put("yellow_dead_coral_fan", "dead_horn_coral_fan")
                .build();
	}

	/**
	 * Remap names to those specified in {@link #customNames}.
	 *
	 * @param missingMapping The missing mapping
	 * @return True if the missing mapping was remapped
	 */
	private boolean remapCustomName(final Mapping<T> missingMapping) {
		final String missingPath = missingMapping.key.getPath();

		if (!customNames.containsKey(missingPath)) return false;

		final String newPath = customNames.get(missingPath);
		final ResourceLocation newRegistryName = new ResourceLocation(missingMapping.key.getPath(), newPath);

		return tryRemap(missingMapping, newRegistryName);
	}

	@Mod.EventBusSubscriber(modid = MOD_ID)
	@SuppressWarnings("unused")
	private static class EventHandler {
		private static final Remapper<Block> blockRemapper = new Remapper<>();
		private static final Remapper<Item> itemRemapper = new Remapper<>();

		@SubscribeEvent
		public static void missingBlockMappings(final RegistryEvent.MissingMappings<Block> event) {
			blockRemapper.remapAll(event.getMappings());
		}

		@SubscribeEvent
		public static void missingItemMappings(final RegistryEvent.MissingMappings<Item> event) {
			itemRemapper.remapAll(event.getMappings());
		}
	}
}