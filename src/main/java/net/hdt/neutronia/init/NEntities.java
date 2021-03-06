package net.hdt.neutronia.init;

import net.hdt.neutronia.entity.*;
import net.hdt.neutronia.util.handlers.RenderHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.*;
import net.minecraftforge.fml.relauncher.Side;

import static net.hdt.neutronia.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class NEntities {

    private static int entityID = 0;

    @SubscribeEvent
    public static void entityRegistering(RegistryEvent.Register<EntityEntry> event) {
        final EntityEntry[] entries = {
                createBuilder("mummy").entity(EntityMummy.class).tracker(80, 3, true).egg(0xC9CE92, 0x444444).build(),
                createBuilder("mummy_villager").entity(EntityMummyVillager.class).tracker(80, 3, true).egg(0xC9CE92, 0x442f00).build(),
                createBuilder("scorpion").entity(EntityScorp.class).tracker(30, 3, true).egg(0x65401, 0x6201209).build(),
                createBuilder("phantom").entity(EntityPhantom.class).tracker(80, 3, true).egg(0x2d3f56, 0x958c79).build(),
                createBuilder("red_phantom").entity(EntityBloodPhantom.class).tracker(80, 3, true).egg(0x4A2929, 0x799591).build(),
                createBuilder("ender_phantom").entity(EntityEnderPhantom.class).tracker(80, 3, true).egg(0x352D56, 0x8C9579).build(),
                createBuilder("shadow_phantom").entity(EntityShadowPhantom.class).tracker(80, 3, true).egg(0x101010, 0x101010).build(),
                createBuilder("inferno").entity(EntityInferno.class).tracker(80, 3, true).egg(0x211114, 0xd17800).build(),
//                createBuilder("ravenous_killer_squid").entity(EntityMonsterOfTheOceanDepths.class).tracker(80, 3, true).egg(0x03002e, 0x060081).build(),
//                createBuilder("turtle").entity(EntitySeaTurtle.class).tracker(80, 3, true).egg(0xFFFFFF, 0x13232B).build(),
                createBuilder("drowned").entity(EntityDrowned.class).tracker(80, 3, true).egg(0x86e2ca, 0x617d51).build(),
                createBuilder("drowned_scuba_villager").entity(EntityDrownedScubaVillager.class).tracker(80, 3, true).egg(0x000000, 0x44E4FF).build(),
                createBuilder("scuba_villager").entity(EntityScubaVillager.class).tracker(80, 3, true).egg(0x000000, 0xC3B99D).build(),
                createBuilder("sanddiver_aquatic").entity(EntitySandDiverAquatic.class).tracker(80, 3, true).egg(0x000000, 0x44E4FF).build(),
                createBuilder("albadon").entity(EntityAlbadon.class).tracker(80, 3, true).egg(0x000000, 0x44E4FF).build(),
                createBuilder("axolotl").entity(EntityAxolotl.class).tracker(80, 3, true).egg(0x000000, 0x44E4FF).build(),
                createBuilder("bird").entity(EntityBird.class).tracker(80, 3, true).egg(0x000000, 0x44E4FF).build(),
                createBuilder("fox").entity(EntityFox.class).tracker(80, 3, true).egg(0x000000, 0x44E4FF).build(),
                createBuilder("arctic_wolf").entity(EntityArcticWolf.class).tracker(80, 3, true).egg(0x000000, 0x44E4FF).build(),
//                createBuilder("gulper").entity(EntityGreatHunger.class).tracker(80, 3, true).egg(0x876949, 0xce9252).build(),
                createBuilder("mushroom_shroom_glutton").entity(EntityMushroomShroomGlutton.class).tracker(80, 3, true).egg(0x000000, 0x44E4FF).build(),
                createBuilder("well_wisher").entity(EntityWellWisher.class).tracker(80, 3, true).egg(0x000000, 0x44E4FF).build(),
                createBuilder("ol_diggy").entity(EntityOlDiggy.class).tracker(80, 3, true).egg(0x000000, 0x44E4FF).build(),
                createBuilder("sea_swallowed_captain").entity(EntitySeaSwallowedCaptain.class).tracker(80, 3, true).egg(0x000000, 0x44E4FF).build(),
                createBuilder("anchored").entity(EntityAnchored.class).tracker(80, 3, true).egg(0x13271d, 0x88baad).build(),
                createBuilder("forsaken_diver").entity(EntityForsakenDiver.class).tracker(80, 3, true).egg(0x13271d, 0x88baad).build(),
                createBuilder("lost_miner").entity(EntityLostMiner.class).tracker(80, 3, true).egg(0x13271d, 0x88baad).build(),
                createBuilder("pharaoh_golem").entity(EntityPharaohGolem.class).tracker(80, 3, true).egg(0x13271d, 0x88baad).build(),
                createBuilder("yeti_golem").entity(EntityYetiGolem.class).tracker(80, 3, true).egg(0x13271d, 0x88baad).build(),
                createBuilder("firefly").entity(EntityFirefly.class).tracker(64, 20, true).egg(0,0).build(),
//                createBuilder("clay_golem").entity(EntityClayGolem.class).tracker(80, 3, true).egg(0x13271d, 0x88baad).build(),
//                createBuilder("diamond_golem").entity(EntityDiamondGolem.class).tracker(80, 3, true).egg(0x13271d, 0x88baad).build(),
//                createBuilder("gold_golem").entity(EntityGoldGolem.class).tracker(80, 3, true).egg(0x13271d, 0x88baad).build(),
//                createBuilder("wood_golem").entity(EntityWoodGolem.class).tracker(80, 3, true).egg(0x13271d, 0x88baad).build(),
                createBuilder("steampunk_golem").entity(EntitySteampunkGolem.class).tracker(80, 3, true).egg(0x13271d, 0x88baad).build()
        };
        event.getRegistry().registerAll(entries);
        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            RenderHandler.registerEntityRenders();
        }
        addSpawns();

        /*TODO: Add Great White Shark, Hammerhead Shark, Piranha, Angler Fish, Dragon Shark, Hare, Rabbit, Gecko, Desert Gecko,
                 Clay Golem, Moss Golem, Manta ray, Octopus, Seablob, Necromancer(illager type) */
    }

    @SubscribeEvent
    public static void registerNewVillagerProffesions(RegistryEvent.Register<VillagerRegistry.VillagerProfession> event) {
        /*event.getRegistry().registerAll(
                new VillagerRegistry.VillagerProfession(MOD_ID + ":necro", MOD_ID + ":textures/entities/villagers/professions/necro", MOD_ID + ":textures/entities/villagers/professions/zombie/necro"),
                new VillagerRegistry.VillagerProfession(MOD_ID + ":adventurer", MOD_ID + ":textures/entities/villagers/professions/adventurer", MOD_ID + ":textures/entities/villagers/professions/zombie/adventurer"),
                new VillagerRegistry.VillagerProfession(MOD_ID + ":miner", MOD_ID + ":textures/entities/villagers/professions/miner", MOD_ID + ":textures/entities/villagers/professions/zombie/miner"),
                new VillagerRegistry.VillagerProfession(MOD_ID + ":scuba_diver", MOD_ID + ":textures/entities/villagers/professions/scuba_diver", MOD_ID + ":textures/entities/villagers/professions/zombie/scuba_diver"),
                new VillagerRegistry.VillagerProfession(MOD_ID + ":drowned_scuba_diver", MOD_ID + ":textures/entities/villagers/professions/drowned_scuba_diver", MOD_ID + ":textures/entities/villagers/professions/zombie/drowned_scuba_diver"));*/
    }

    private static void addSpawns() {
        EntityRegistry.addSpawn(EntityMummy.class, 10, 1, 3, EnumCreatureType.MONSTER, Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.MUTATED_DESERT, Biomes.BEACH);
//        EntityRegistry.addSpawn(EntityPharaohGolem.class, 3, 1, 2, EnumCreatureType.CREATURE, Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.MUTATED_DESERT, Biomes.BEACH);
//        EntityRegistry.addSpawn(EntityScorp.class, 9, 2, 8, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.SANDY));

        EntityRegistry.addSpawn(EntityDrowned.class, 14, 2, 4, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.OCEAN));
        EntityRegistry.addSpawn(EntityAnchored.class, 5, 1, 3, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.OCEAN));
        EntityRegistry.addSpawn(EntityForsakenDiver.class, 60, 1, 2, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.OCEAN));

        EntityRegistry.addSpawn(EntityInferno.class, 9, 2, 8, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.NETHER));

        EntityRegistry.addSpawn(EntityScubaVillager.class, 10, 1, 3, EnumCreatureType.AMBIENT, Biomes.BEACH, Biomes.STONE_BEACH);
//        EntityRegistry.addSpawn(EntityGreatHunger.class, 9, 2, 8, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.SANDY));
//        EntityRegistry.addSpawn(EntitySeaTurtle.class, 9, 2, 8, EnumCreatureType.MONSTER, getBiomes(BiomeDictionary.Type.BEACH));
//        EntityRegistry.addSpawn(EntityMonsterOfTheOceanDepths.class, 10, 1, 3, EnumCreatureType.WATER_CREATURE, getBiomes(BiomeDictionary.Type.OCEAN));
    }

    private static <E extends Entity> EntityEntryBuilder<E> createBuilder(final String name) {
        final EntityEntryBuilder<E> builder = EntityEntryBuilder.create();
        final ResourceLocation registryName = new ResourceLocation(MOD_ID, name);
        return builder.id(registryName, entityID++).name(registryName.toString());
    }

    private static Biome[] getBiomes(final BiomeDictionary.Type type) {
        return BiomeDictionary.getBiomes(type).toArray(new Biome[0]);
    }

}
