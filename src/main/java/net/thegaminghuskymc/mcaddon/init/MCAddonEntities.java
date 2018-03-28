package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.thegaminghuskymc.mcaddon.Reference;
import net.thegaminghuskymc.mcaddon.entity.EntityMummy;
import net.thegaminghuskymc.mcaddon.entity.EntityMummyVillager;
import net.thegaminghuskymc.mcaddon.util.handlers.RenderHandler;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class MCAddonEntities {

    @SubscribeEvent
    public static void RegisterEntitys(RegistryEvent.Register<EntityEntry> event) {
        final EntityEntry[] entries = {
            createBuilder("mummy").entity(EntityMummy.class).tracker(80, 3, true).egg(0xC9CE92, 0x444444).build(),
            createBuilder("mummy_villager").entity(EntityMummyVillager.class).tracker(80, 3, true).egg(0xC9CE92, 0x442f00).build()
        };
        event.getRegistry().registerAll(entries);
        RenderHandler.registerEntityRenders();
        addSpawns();
    }

    private static void addSpawns() {
        EntityRegistry.addSpawn(EntityMummy.class, 10, 1, 3, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.SANDY));
    }

    private static int entityID = 0;

    private static <E extends Entity> EntityEntryBuilder<E> createBuilder(final String name) {
        final EntityEntryBuilder<E> builder = EntityEntryBuilder.create();
        final ResourceLocation registryName = new ResourceLocation(Reference.MOD_ID, name);
        return builder.id(registryName, entityID++).name(registryName.toString());
    }

    private static Biome[] getBiomes(final BiomeDictionary.Type type) {
        return BiomeDictionary.getBiomes(type).toArray(new Biome[0]);
    }

    //for use later...
    private static void copySpawns(final Class<? extends EntityLiving> classToAdd, final EnumCreatureType creatureTypeToAdd, final Class<? extends EntityLiving> classToCopy, final EnumCreatureType creatureTypeToCopy) {
        for (final Biome biome : ForgeRegistries.BIOMES) {
            biome.getSpawnableList(creatureTypeToCopy).stream()
                    .filter(entry -> entry.entityClass == classToCopy)
                    .findFirst()
                    .ifPresent(spawnListEntry ->
                            biome.getSpawnableList(creatureTypeToAdd).add(new Biome.SpawnListEntry(classToAdd, spawnListEntry.itemWeight, spawnListEntry.minGroupCount, spawnListEntry.maxGroupCount))
                    );
        }
    }

}
