package net.thegaminghuskymc.mcaddon.util.handlers;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

/**
 * Remaps this mod's {@link Block}s and {@link Item}s after registry names have been changed.
 * <p>
 * Written by Choonster here:
 * https://github.com/Choonster-Minecraft-Mods/TestMod3/blob/2cb7b67adf7ab41e066c3308ac898224b2891752/src/main/java/choonster/testmod3/remap/Remapper.java
 *
 * @author Choonster
 */
public class RemapHandler<T extends IForgeRegistryEntry<T>>
{
    private static final Map<String, String> customNames = ImmutableMap.<String, String>builder()
            .build();

    private final List<Predicate<RegistryEvent.MissingMappings.Mapping<T>>> remappingFunctions = ImmutableList.of(this::remapRegistryName);

    private static final Logger LOGGER = LogManager.getLogger("NetherEx|RemapHandler");

    public void remapAll(List<RegistryEvent.MissingMappings.Mapping<T>> missingMappings)
    {
        LOGGER.info("Fix Missing Mappings started.");

        for(RegistryEvent.MissingMappings.Mapping<T> missingMapping : missingMappings)
        {
            LOGGER.info("Trying to remap %s", missingMapping.key);

            boolean remapped = remappingFunctions.stream().anyMatch(mappingPredicate -> mappingPredicate.test(missingMapping));

            if(!remapped)
            {
                LOGGER.info("Couldn't remap %s", missingMapping.key);
            }
        }

        LOGGER.info("Fix Missing Mappings completed.");
    }

    private boolean attemptRemap(RegistryEvent.MissingMappings.Mapping<T> missingMapping, ResourceLocation registryName)
    {
        IForgeRegistry<T> registry = missingMapping.registry;

        T value = registry.getValue(registryName);

        if(registry.containsKey(registryName) && value != null)
        {
            LOGGER.info("Remapped %s %s to %s", registry.getRegistrySuperType().getSimpleName(), missingMapping.key, registryName);
            missingMapping.remap(value);
            return true;
        }

        return false;
    }

    private boolean remapRegistryName(RegistryEvent.MissingMappings.Mapping<T> missingMapping)
    {
        final String missingPath = missingMapping.key.getResourcePath();

        if(!customNames.containsKey(missingPath))
        {
            return false;
        }

        String newPath = customNames.get(missingPath);
        ResourceLocation newRegistryName = new ResourceLocation(missingMapping.key.getResourceDomain(), newPath);
        return attemptRemap(missingMapping, newRegistryName);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    private static class EventHandler
    {
        private static final RemapHandler<Block> blockRemapper = new RemapHandler<>();
        private static final RemapHandler<Item> itemRemapper = new RemapHandler<>();

        @SubscribeEvent
        public static void missingBlockMappings(RegistryEvent.MissingMappings<Block> event)
        {
            blockRemapper.remapAll(event.getMappings());
        }

        @SubscribeEvent
        public static void missingItemMappings(RegistryEvent.MissingMappings<Item> event)
        {
            itemRemapper.remapAll(event.getMappings());
        }
    }
}