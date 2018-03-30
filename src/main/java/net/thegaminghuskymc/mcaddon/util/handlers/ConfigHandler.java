package net.thegaminghuskymc.mcaddon.util.handlers;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

@Config.LangKey("config.hmca:title")
@Config(modid = MOD_ID, name = "Husky's Minecraft Additions/hmca", category = "hmca")
public class ConfigHandler
{
    @Config.Name("client")
    @Config.LangKey("config.hmca:client")
    public static Client client = new Client();

    @Config.Name("dimension")
    @Config.LangKey("config.hmca:dimension")
    public static Dimension dimension = new Dimension();

    @Config.Name("block")
    @Config.LangKey("config.hmca:block")
    public static Block block = new Block();

    @Config.Name("potion_effect")
    @Config.LangKey("config.hmca:potionEffect")
    public static PotionEffect potionEffect = new PotionEffect();

    @Config.Name("entity")
    @Config.LangKey("config.hmca:entity")
    public static Entity entity = new Entity();

    @Config.Name("biome")
    @Config.LangKey("config.hmca:biome")
    public static Biome biome = new Biome();

    private static final Logger LOGGER = LogManager.getLogger("NetherEx|ConfigHandler");

    public static class Client
    {
        @Config.Name("visual")
        @Config.LangKey("config.hmca:client.visual")
        public Visual visual = new Visual();

        public class Visual
        {
            @Config.LangKey("config.hmca:client.visual.disableNetherFog")
            public boolean disableNetherFog = true;
        }
    }

    public static class Dimension
    {
        @Config.Name("nether")
        @Config.LangKey("config.hmca:dimension.nether")
        public Nether nether = new Nether();

        public class Nether
        {
            @Config.LangKey("config.hmca:dimension.nether.generateSoulSand")
            public boolean generateSoulSand = false;

            @Config.LangKey("config.hmca:dimension.nether.generateGravel")
            public boolean generateGravel = false;

            @Config.LangKey("config.hmca:dimension.nether.isLavaInfinite")
            public boolean isLavaInfinite = false;
        }
    }

    public static class Block
    {
        @Config.Name("nether_portal")
        @Config.LangKey("config.hmca:block.netherPortal")
        public NetherPortal netherPortal = new NetherPortal();

        @Config.Name("netherrack")
        @Config.LangKey("config.hmca:block.netherrack")
        public Netherrack netherrack = new Netherrack();

        @Config.Name("soul_sand")
        @Config.LangKey("config.hmca:block.soulSand")
        public SoulSand soulSand = new SoulSand();

        @Config.Name("magma")
        @Config.LangKey("config.hmca:block.magma")
        public Magma magma = new Magma();

        @Config.Name("rime")
        @Config.LangKey("config.hmca:block.rime")
        public Rime rime = new Rime();

        @Config.Name("thornstalk")
        @Config.LangKey("config.hmca:block.thornstalk")
        public Thornstalk thornstalk = new Thornstalk();

        @Config.Name("hyphae")
        @Config.LangKey("config.hmca:block.hyphae")
        public Hyphae hyphae = new Hyphae();

        public class NetherPortal
        {
            @Config.LangKey("config.hmca:block.netherrack.allowPigmanSpawning")
            public boolean allowPigmanSpawning = true;

            @Config.RangeInt(min = 4, max = 2048)
            @Config.LangKey("config.hmca:block.netherrack.pigmanSpawnRarity")
            @Config.Comment({"The higher the number, the rarer it is for Pigman to spawn", "The lower the number, the more common it is for Pigman to spawn"})
            public int pigmanSpawnRarity = 2000;
        }

        public class Netherrack
        {
            @Config.LangKey("config.hmca:block.netherrack.allowAllShovelsToFlatten")
            public boolean allowAllShovelsToFlatten = false;
        }

        public class SoulSand
        {
            @Config.LangKey("config.hmca:block.soulSand.doesNetherwartUseNewGrowthSystem")
            public boolean doesNetherwartUseNewGrowthSystem = true;

            @Config.LangKey("config.hmca:block.soulSand.allowAllHoesToTill")
            public boolean allowAllHoesToTill = false;

            @Config.LangKey("config.hmca:block.soulSand.doesRequireIchor")
            public boolean doesRequireIchor = true;
        }

        public class Magma
        {
            @Config.LangKey("config.hmca:block.magma.turnIntoLava")
            public boolean turnIntoLava = false;
        }

        public class Rime
        {
            @Config.LangKey("config.hmca:block.rime.canFreezeWater")
            public boolean canFreezeWater = true;

            @Config.LangKey("config.hmca:block.rime.canFreezeLava")
            public boolean canFreezeLava = true;

            @Config.LangKey("config.hmca:block.rime.canFreezeMobs")
            public boolean canFreezeMobs = true;
        }

        public class Thornstalk
        {
            @Config.LangKey("config.hmca:block.thornstalk.canDestroyItems")
            public boolean canDestroyItems = false;

            @Config.LangKey("config.hmca:block.thornstalk.blacklist")
            @Config.Comment("Mobs the Thornstalk shouldn't hurt")
            public String[] blacklist = new String[]{
                    "minecraft:wither_skeleton",
                    "minecraft:zombie_pigman",
                    "hmca:monster_spinout"
            };
        }

        public class Hyphae
        {
            @Config.LangKey("config.hmca:block.hyphae.doesSpread")
            public boolean doesSpread = false;
        }
    }

    public static class PotionEffect
    {
        @Config.Name("freeze")
        @Config.LangKey("config.hmca:potionEffect.freeze")
        public Freeze freeze = new Freeze();

        @Config.Name("spore")
        @Config.LangKey("config.hmca:potionEffect.spore")
        public Spore spore = new Spore();

        @Config.Name("lost")
        @Config.LangKey("config.hmca:potionEffect.lost")
        public Lost lost = new Lost();

        public class Freeze
        {
            @Config.LangKey("config.hmca:potionEffect.freeze.chanceOfThawing")
            @Config.Comment({"The higher the number, the rarer it is to thaw", "The lower the number, the more common it is to thaw"})
            @Config.RangeInt(min = 1, max = 2048)
            public int chanceOfThawing = 1024;

            @Config.LangKey("config.hmca:potionEffect.freeze.blacklist")
            @Config.Comment("Mobs that shouldn't freeze")
            public String[] blacklist = new String[]{
                    "minecraft:blaze",
                    "minecraft:ghast",
                    "minecraft:wither_skeleton",
                    "minecraft:polar_bear",
                    "hmca:monster_wight",
                    "hmca:monster_ember",
                    "hmca:monster_spinout",
                    "hmca:monster_bone_spider",
                    "hmca:monster_brute"
            };
        }

        public class Spore
        {
            @Config.LangKey("config.hmca:potionEffect.spore.chanceOfSporeSpawning")
            @Config.Comment({"The higher the number, the rarer it is to spawn a Spore", "The lower the number, the more common it is to spawn a Spore"})
            @Config.RangeInt(min = 1, max = 256)
            public int chanceOfSporeSpawning = 128;

            @Config.LangKey("config.hmca:potionEffect.spore.blacklist")
            @Config.Comment("Mobs that shouldn't spawn Spores")
            public String[] blacklist = new String[]{
                    "hmca:monster_spore_creeper",
                    "hmca:monster_spore",
                    "hmca:neutral_mogus"
            };
        }

        public class Lost
        {
            @Config.LangKey("config.hmca:potionEffect.lost.chanceOfGhastlingSpawning")
            @Config.Comment({"The higher the number, the rarer it is to spawn a Ghastling", "The lower the number, the more common it is to spawn a Ghastling"})
            @Config.RangeInt(min = 1, max = 256)
            public int chanceOfGhastlingSpawning = 256;
        }
    }

    public static class Entity
    {
        @Config.Name("ember")
        @Config.LangKey("config.hmca:entity.ember")
        public Ember ember = new Ember();

        @Config.Name("nethermite")
        @Config.LangKey("config.hmca:entity.nethermite")
        public Nethermite nethermite = new Nethermite();

        @Config.Name("spinout")
        @Config.LangKey("config.hmca:entity.spinout")
        public Spinout spinout = new Spinout();

        @Config.Name("spore_creeper")
        @Config.LangKey("config.hmca:entity.sporeCreeper")
        public SporeCreeper sporeCreeper = new SporeCreeper();

        @Config.Name("spore")
        @Config.LangKey("config.hmca:entity.spore")
        public Spore spore = new Spore();

        @Config.Name("brute")
        @Config.LangKey("config.hmca:entity.brute")
        public Brute brute = new Brute();

        @Config.Name("ghast_queen")
        @Config.LangKey("config.hmca:entity.ghastQueen")
        public GhastQueen ghastQueen = new GhastQueen();

        public class Ember
        {
            @Config.LangKey("config.hmca:entity.ember.chanceOfSettingPlayerOnFire")
            @Config.Comment({"The higher the number, the rarer it is to set a player on fire", "The lower the number, the more common it is to set a player on fire"})
            @Config.RangeInt(min = 1, max = 256)
            public int chanceOfSettingPlayerOnFire = 1;
        }

        public class Nethermite
        {
            @Config.LangKey("config.hmca:entity.nethermite.chanceOfSpawning")
            @Config.Comment({"The higher the number, the rarer it is for a Nethermite to spawn", "The lower the number, the more common it is for a Nethermite to spawn"})
            @Config.RangeInt(min = 1, max = 256)
            public int chanceOfSpawning = 64;

            @Config.LangKey("config.hmca:entity.nethermite.whitelist")
            @Config.Comment("Blocks the Nethermite should spawn from")
            public String[] whitelist = new String[]{
                    "minecraft:quartz_ore",
                    "hmca:ore_quartz",
                    "hmca:ore_amethyst",
                    "hmca:ore_rime",
                    "tconstruct:ore",
                    "nethermetals:nether_coal_ore",
                    "nethermetals:nether_redstone_ore",
                    "nethermetals:nether_diamond_ore",
                    "nethermetals:nether_emerald_ore",
                    "nethermetals:nether_gold_ore",
                    "nethermetals:nether_iron_ore",
                    "nethermetals:nether_lapis_ore",
                    "nethermetals:nether_antimony_ore",
                    "nethermetals:nether_bismuth_ore",
                    "nethermetals:nether_copper_ore",
                    "nethermetals:nether_lead_ore",
                    "nethermetals:nether_mercury_ore",
                    "nethermetals:nether_nickel_ore",
                    "nethermetals:nether_platnium_ore",
                    "nethermetals:nether_silver_ore",
                    "nethermetals:nether_tin_ore",
                    "nethermetals:nether_zinc_ore",
                    "nethermetals:nether_aluminum_ore",
                    "nethermetals:nether_cadmium_ore",
                    "nethermetals:nether_chromium_ore",
                    "nethermetals:nether_iridium_ore",
                    "nethermetals:nether_magnesium_ore",
                    "nethermetals:nether_magnanese_ore",
                    "nethermetals:nether_osmium_ore",
                    "nethermetals:nether_plutonium_ore",
                    "nethermetals:nether_rutile_ore",
                    "nethermetals:nether_tantalum_ore",
                    "nethermetals:nether_titanium_ore",
                    "nethermetals:nether_tungsten_ore",
                    "nethermetals:nether_uramium_ore",
                    "nethermetals:nether_zirconium_ore"
            };
        }

        public class Spinout
        {
            @Config.LangKey("config.hmca:entity.spinout.spinTime")
            @Config.Comment({"The lower the number, the less time a Spinout spins", "The higher the number, the more time a Spinout spins"})
            @Config.RangeInt(min = 1, max = 512)
            public int spinTime = 6;

            @Config.LangKey("config.hmca:entity.spinout.spinCooldown")
            @Config.Comment({"The lower the number, the less time a Spinout goes without spinning", "The higher the number, the more time a Spinout goes without spinning"})
            @Config.RangeInt(min = 1, max = 512)
            public int spinCooldown = 2;
        }

        public class SporeCreeper
        {
            @Config.LangKey("config.hmca:entity.sporeCreeper.chanceOfSporeSpawning")
            @Config.Comment({"The higher the number, the rarer it is for s Spore Creeper to spawn a Spore on death", "The lower the number, the more common it is for a Spore Creeper to spawn a Spore on death"})
            @Config.RangeInt(min = 1, max = 256)
            public int chanceOfSporeSpawning = 12;
        }

        public class Spore
        {
            @Config.LangKey("config.hmca:entity.spore.growthTime")
            @Config.Comment({"The lower the number, the less it takes a Spore to grow", "The higher the number, the more time it takes for a Spore to grow"})
            @Config.RangeInt(min = 1, max = 512)
            public int growthTime = 60;

            @Config.LangKey("config.hmca:entity.spore.creeperSpawns")
            @Config.Comment({"The lower the number, the less Spore Creeper spawn from a Spore", "The higher the number, the more Spore Creeper spawn from a Spore"})
            @Config.RangeInt(min = 1, max = 256)
            public int creeperSpawns = 3;
        }

        public class Brute
        {
            @Config.LangKey("config.hmca:entity.brute.chargeCooldown")
            @Config.Comment({"The lower the number, the less cooldown the Brute has after charging", "The higher the number, the more cooldown the Brute has after charging"})
            @Config.RangeInt(min = 1, max = 512)
            public int chargeCooldown = 2;
        }

        public class GhastQueen
        {
            @Config.LangKey("config.hmca:entity.ghastQueen.ghastlingSpawnCooldown")
            @Config.Comment({"The lower the number, the less cooldown the Ghast Queen has after spawning Ghastlings", "The higher the number, the more cooldown the Ghast Queen has after spawning Ghastlings"})
            @Config.RangeInt(min = 1, max = 512)
            public int ghastlingSpawnCooldown = 10;

            @Config.LangKey("config.hmca:entity.ghastQueen.ghastlingSpawns")
            @Config.Comment({"The lower the number, the less Ghastling spawn", "The higher the number, the more Ghastling spawn"})
            @Config.RangeInt(min = 1, max = 256)
            public int ghastlingSpawns = 4;
        }
    }

    public static class Biome
    {
        @Config.Name("hell")
        @Config.LangKey("config.hmca:biome.hell")
        public Hell hell = new Hell();

        @Config.Name("ruthless_sands")
        @Config.LangKey("config.hmca:biome.ruthlessSands")
        public RuthlessSands ruthlessSands = new RuthlessSands();

        @Config.Name("fungi_forest")
        @Config.LangKey("config.hmca:biome.fungiForest")
        public FungiForest fungiForest = new FungiForest();

        @Config.Name("torrid_wasteland")
        @Config.LangKey("config.hmca:biome.torridWasteland")
        public TorridWasteland torridWasteland = new TorridWasteland();

        @Config.Name("arctic_abyss")
        @Config.LangKey("config.hmca:biome.arcticAbyss")
        public ArcticAbyss arcticAbyss = new ArcticAbyss();

        public class Hell
        {
        }

        public class RuthlessSands
        {
            @Config.LangKey("config.hmca:biome.ruthlessSands.generateThornstalk")
            public boolean generateThornstalk = true;

            @Config.LangKey("config.hmca:biome.ruthlessSands.thornstalkRarity")
            @Config.Comment({"The lower the number, the rarer Thornstalk is", "The higher the number, the more common Thornstalk is"})
            @Config.RangeInt(min = 1, max = 256)
            public int thornstalkRarity = 10;
        }

        public class FungiForest
        {
            @Config.LangKey("config.hmca:biome.fungiForest.generateElderMushrooms")
            public boolean generateElderMushrooms = true;

            @Config.LangKey("config.hmca:biome.fungiForest.generateEnokiMushrooms")
            public boolean generateEnokiMushrooms = true;

            @Config.LangKey("config.hmca:biome.fungiForest.elderMushroomRarity")
            @Config.Comment({"The lower the number, the rarer Elder Mushrooms are", "The higher the number, the more common Elder Mushrooms are"})
            @Config.RangeInt(min = 1, max = 256)
            public int elderMushroomRarity = 32;

            @Config.LangKey("config.hmca:biome.fungiForest.enokiMushroomRarity")
            @Config.Comment({"The lower the number, the rarer Enoki Mushrooms are", "The higher the number, the more common Enoki Mushrooms are"})
            @Config.RangeInt(min = 1, max = 256)
            public int enokiMushroomRarity = 4;
        }

        public class TorridWasteland
        {
        }

        public class ArcticAbyss
        {
            @Config.LangKey("config.hmca:biome.arcticAbyss.chanceOfFreezing")
            @Config.Comment({"The higher the number, the rarer it is for mobs to Freeze in the Arctic Abyss biome", "The lower the number, the more common it is for mobs to Freeze in the Arctic Abyss biome"})
            @Config.RangeInt(min = 1, max = 2048)
            public int chanceOfFreezing = 512;

        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class ConfigSyncHandler
    {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
        {
            if(event.getModID().equals(MOD_ID))
            {
                ConfigManager.sync(MOD_ID, Config.Type.INSTANCE);
                LOGGER.info("Configuration has been saved.");
            }
        }
    }
}