package net.hdt.neutronia.util.handlers;

import net.hdt.neutronia.util.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Config.LangKey("config.neutronia:title")
@Config(modid = Reference.MOD_ID, name = "Neutronia/neutronia", category = "neutronia")
public class ConfigHandlerOld {
    private static final Logger LOGGER = LogManager.getLogger("Neutronia|ConfigHandlerOld");
    @Config.Name("client")
    @Config.LangKey("config.neutronia:client")
    public static Client client = new Client();
    @Config.Name("dimension")
    @Config.LangKey("config.neutronia:dimension")
    public static Dimension dimension = new Dimension();
    @Config.Name("animation.animations.blocks")
    @Config.LangKey("config.neutronia:animation.animations.blocks")
    public static Block block = new Block();
    @Config.Name("biome")
    @Config.LangKey("config.neutronia:biome")
    public static Biome biome = new Biome();

    public static class Client {
        @Config.Name("visual")
        @Config.LangKey("config.neutronia:client.visual")
        public Visual visual = new Visual();

        public class Visual {
            @Config.LangKey("config.neutronia:client.visual.disableNetherFog")
            public boolean disableNetherFog = true;
        }
    }

    public static class Dimension {
        @Config.Name("nether")
        @Config.LangKey("config.neutronia:dimension.nether")
        public Nether nether = new Nether();

        public class Nether {
            @Config.LangKey("config.neutronia:dimension.nether.generateSoulSand")
            public boolean generateSoulSand = false;

            @Config.LangKey("config.neutronia:dimension.nether.generateGravel")
            public boolean generateGravel = false;

            @Config.LangKey("config.neutronia:dimension.nether.isLavaInfinite")
            public boolean isLavaInfinite = false;
        }
    }

    public static class Block {

        @Config.Name("netherrack")
        @Config.LangKey("config.neutronia:animation.animations.blocks.netherrack")
        public Netherrack netherrack = new Netherrack();

        @Config.Name("magma")
        @Config.LangKey("config.neutronia:animation.animations.blocks.magma")
        public Magma magma = new Magma();

        public class Netherrack {
            @Config.LangKey("config.neutronia:animation.animations.blocks.netherrack.allowAllShovelsToFlatten")
            public boolean allowAllShovelsToFlatten = false;
        }

        public class Magma {
            @Config.LangKey("config.neutronia:animation.animations.blocks.magma.turnIntoLava")
            public boolean turnIntoLava = false;
        }
    }

    public static class Biome {
        @Config.Name("hell")
        @Config.LangKey("config.neutronia:biome.hell")
        public Hell hell = new Hell();

        public class Hell {
        }
    }

    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    public static class ConfigSyncHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(Reference.MOD_ID)) {
                ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
                LOGGER.info("Configuration has been saved.");
            }
        }
    }
}