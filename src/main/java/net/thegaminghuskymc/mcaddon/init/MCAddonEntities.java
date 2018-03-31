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
import net.minecraftforge.fml.common.registry.*;
import net.thegaminghuskymc.mcaddon.entity.*;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.thegaminghuskymc.mcaddon.entity.EntityMummy;
import net.thegaminghuskymc.mcaddon.entity.EntityMummyVillager;
import net.thegaminghuskymc.mcaddon.entity.EntityScorp;
import net.thegaminghuskymc.mcaddon.util.handlers.RenderHandler;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MCAddonEntities {

    @SubscribeEvent
    public static void RegisterEntitys(RegistryEvent.Register<EntityEntry> event) {
        final EntityEntry[] entries = {
            createBuilder("mummy").entity(EntityMummy.class).tracker(80, 3, true).egg(0xC9CE92, 0x444444).build(),
            createBuilder("mummy_villager").entity(EntityMummyVillager.class).tracker(80, 3, true).egg(0xC9CE92, 0x442f00).build(),
            createBuilder("scorpion").entity(EntityScorp.class).tracker(30,3,true).egg(0x65401,0x6201209).build(),
            createBuilder("phantom").entity(EntityPhantom.class).tracker(80, 3, true).egg(0x2d3f56, 0x958c79).build(),
            createBuilder("red_phantom").entity(EntityRedPhantom.class).tracker(80, 3, true).egg(0x4A2929, 0x799591).build(),
            createBuilder("ender_phantom").entity(EntityEnderPhantom.class).tracker(80, 3, true).egg(0x352D56, 0x8C9579).build(),
            createBuilder("shadow_phantom").entity(EntityShadowPhantom.class).tracker(80, 3, true).egg(0x101010, 0x101010).build(),
            createBuilder("hovering_inferno").entity(EntityHoveringInferno.class).tracker(80, 3, true).egg(0x864500, 0xd36d00).build(),
            createBuilder("ravenous_killer_squid").entity(EntityMonsterOfTheOceanDepths.class).tracker(80, 3, true).egg(0x03002e, 0x060081).build(),
            createBuilder("turtle").entity(EntityMummyVillager.class).tracker(80, 3, true).egg(0xFFFFFF, 0x008d8d).build(),
            createBuilder("drowned").entity(EntityDrowned.class).tracker(80, 3, true).egg(0x86e2ca, 0x617d51).build(),
            createBuilder("scuba_divers").entity(EntityScubaDivers.class).tracker(80, 3, true).egg(0xC9CE92, 0x442f00).build(),
            createBuilder("drowned_villager").entity(EntityDrownedVillager.class).tracker(80, 3, true).egg(0xC9CE92, 0x442f00).build(),
            createBuilder("great_hunger").entity(EntityGreatHunger.class).tracker(80, 3, true).egg(0x876949, 0xce9252).build(),
            createBuilder("cod").entity(EntityCod.class).tracker(30, 3, true).egg(0xb89e70, 0x786749).build()
        };
        event.getRegistry().registerAll(entries);
        RenderHandler.registerEntityRenders();
        addSpawns();
    }

    @SubscribeEvent
    public static void registerNewVillagerProffesions(RegistryEvent.Register<VillagerRegistry.VillagerProfession> event) {
        event.getRegistry().register(new VillagerRegistry.VillagerProfession(new ResourceLocation(MOD_ID, "miner").toString(), new ResourceLocation(MOD_ID, "textures/entities/villagers/miner").toString(), new ResourceLocation(MOD_ID, "textures/entities/villagers/zombie/miner").toString()));
        event.getRegistry().register(new VillagerRegistry.VillagerProfession(new ResourceLocation(MOD_ID, "scuba_diver").toString(), new ResourceLocation(MOD_ID, "textures/entities/villagers/scuba_diver").toString(), new ResourceLocation(MOD_ID, "textures/entities/villagers/zombie/scuba_diver").toString()));
        event.getRegistry().register(new VillagerRegistry.VillagerProfession(new ResourceLocation(MOD_ID, "explorer").toString(), new ResourceLocation(MOD_ID, "textures/entities/villagers/explorer").toString(), new ResourceLocation(MOD_ID, "textures/entities/villagers/zombie/explorer").toString()));
        event.getRegistry().register(new VillagerRegistry.VillagerProfession(new ResourceLocation(MOD_ID, "magician").toString(), new ResourceLocation(MOD_ID, "textures/entities/villagers/magician").toString(), new ResourceLocation(MOD_ID, "textures/entities/villagers/zombie/magician").toString()));
        event.getRegistry().register(new VillagerRegistry.VillagerProfession(new ResourceLocation(MOD_ID, "guard").toString(), new ResourceLocation(MOD_ID, "textures/entities/villagers/guard").toString(), new ResourceLocation(MOD_ID, "textures/entities/villagers/zombie/guard").toString()));
    }

    private static void addSpawns() {
        EntityRegistry.addSpawn(EntityMummy.class, 10, 1, 3, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.SANDY));
        EntityRegistry.addSpawn(EntityScorp.class, 9,2,8, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.SANDY));
        EntityRegistry.addSpawn(EntityDrowned.class, 9,2,8, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.OCEAN));
        EntityRegistry.addSpawn(EntityHoveringInferno.class, 9,2,8, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.NETHER));
        EntityRegistry.addSpawn(EntityGreatHunger.class, 9,2,8, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.SANDY));
        EntityRegistry.addSpawn(EntityTurtle.class, 9,2,8, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.BEACH));
    }

    private static int entityID = 0;

    private static <E extends Entity> EntityEntryBuilder<E> createBuilder(final String name) {
        final EntityEntryBuilder<E> builder = EntityEntryBuilder.create();
        final ResourceLocation registryName = new ResourceLocation(MOD_ID, name);
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
