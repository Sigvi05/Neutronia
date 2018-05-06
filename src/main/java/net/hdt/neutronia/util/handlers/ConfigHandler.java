/*
 * NetherEx
 * Copyright (c) 2016-2018 by MineEx
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.hdt.neutronia.util.handlers;

import net.hdt.neutronia.Main;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.hdt.neutronia.util.Reference.MOD_ID;

@Config.LangKey("config." + MOD_ID + ":title")
@Config(modid = MOD_ID, name = "Neutronia/" + MOD_ID, category = "neutronia")
public class ConfigHandler {

    @Config.Name("client")
    @Config.LangKey("config." + MOD_ID + ":client")
    public static ClientConfig clientConfig = new ClientConfig();

    @Config.Name("compatibility")
    @Config.LangKey("config." + MOD_ID + ":compatibility")
    public static CompatibilityConfig compatibilityConfig = new CompatibilityConfig();

    @Config.Name("dimension")
    @Config.LangKey("config." + MOD_ID + ":dimension")
    public static DimensionConfig dimensionConfig = new DimensionConfig();

    @Config.Name("block")
    @Config.LangKey("config." + MOD_ID + ":block")
    public static BlockConfig blockConfig = new BlockConfig();

    @Config.Name("biome")
    @Config.LangKey("config." + MOD_ID + ":biome")
    public static BiomeConfig biomeConfig = new BiomeConfig();

    public static class ClientConfig {
        @Config.Name("visual")
        @Config.LangKey("config." + MOD_ID + ":client.visual")
        public Visual visual = new Visual();

        public class Visual {
            @Config.LangKey("config." + MOD_ID + ":client.visual.disableNetherFog")
            public boolean disableNetherFog = true;
        }
    }

    public static class CompatibilityConfig {
        @Config.Name("biomesoplenty")
        @Config.LangKey("config." + MOD_ID + ":compatibility.biomesoplenty")
        public BiomesOPlenty biomesOPlenty = new BiomesOPlenty();

        public class BiomesOPlenty {
            @Config.LangKey("config." + MOD_ID + ":compatibility.biomesoplenty.enableCompat")
            public boolean enableCompat = true;
        }
    }

    public static class DimensionConfig {
        @Config.Name("nether")
        @Config.LangKey("config." + MOD_ID + ":dimension.nether")
        public Nether nether = new Nether();

        public class Nether {
            @Config.LangKey("config." + MOD_ID + ":dimension.nether.generateSoulSand")
            public boolean generateSoulSand = false;

            @Config.LangKey("config." + MOD_ID + ":dimension.nether.generateGravel")
            public boolean generateGravel = false;

            @Config.LangKey("config." + MOD_ID + ":dimension.nether.isLavaInfinite")
            public boolean isLavaInfinite = false;
        }
    }

    public static class BlockConfig {
        @Config.Name("nether_portal")
        @Config.LangKey("config." + MOD_ID + ":block.netherPortal")
        public NetherPortal netherPortal = new NetherPortal();

        @Config.Name("netherrack")
        @Config.LangKey("config." + MOD_ID + ":block.netherrack")
        public Netherrack netherrack = new Netherrack();

        @Config.Name("soul_sand")
        @Config.LangKey("config." + MOD_ID + ":block.soulSand")
        public SoulSand soulSand = new SoulSand();

        @Config.Name("magma")
        @Config.LangKey("config." + MOD_ID + ":block.magma")
        public Magma magma = new Magma();

        public class NetherPortal {
            @Config.LangKey("config." + MOD_ID + ":block.netherPortal.allowPigmanSpawning")
            public boolean allowPigmanSpawning = true;

            @Config.RangeInt(min = 4, max = 2048)
            @Config.LangKey("config." + MOD_ID + ":block.netherPortal.pigmanSpawnRarity")
            @Config.Comment({"The higher the number, the rarer it is for Pigman to spawn", "The lower the number, the more common it is for Pigman to spawn"})
            public int pigmanSpawnRarity = 2000;
        }

        public class Netherrack {
            @Config.LangKey("config." + MOD_ID + ":block.netherrack.allowAllShovelsToFlatten")
            public boolean allowAllShovelsToFlatten = false;
        }

        public class SoulSand {
            @Config.LangKey("config." + MOD_ID + ":block.soulSand.doesNetherwartUseNewGrowthSystem")
            public boolean doesNetherwartUseNewGrowthSystem = true;

            @Config.LangKey("config." + MOD_ID + ":block.soulSand.allowAllHoesToTill")
            public boolean allowAllHoesToTill = false;

            @Config.LangKey("config." + MOD_ID + ":block.soulSand.doesRequireIchor")
            public boolean doesRequireIchor = true;
        }

        public class Magma {
            @Config.LangKey("config." + MOD_ID + ":block.magma.turnIntoLava")
            public boolean turnIntoLava = false;
        }
    }

    public static class BiomeConfig {
        @Config.Name("hell")
        @Config.LangKey("config." + MOD_ID + ":biome.hell")
        public Hell hell = new Hell();

        @Config.Name("soulsand_desert")
        @Config.LangKey("config." + MOD_ID + ":biome.soulsandDesert")
        public SoulsandDesert soulsandDesert = new SoulsandDesert();

        @Config.Name("thorny_forest")
        @Config.LangKey("config." + MOD_ID + ":biome.thornyForest")
        public ThornyForest thornyForest = new ThornyForest();

        @Config.Name("glowing_mushroom_forest")
        @Config.LangKey("config." + MOD_ID + ":biome.glowingMushroomForest")
        public GlowingMushroomForest glowingMushroomForest = new GlowingMushroomForest();

        public class Hell {
        }

        public class SoulsandDesert {
        }

        public class ThornyForest {
        }

        public class GlowingMushroomForest {
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class ConfigSyncHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(MOD_ID)) {
                ConfigManager.sync(MOD_ID, Config.Type.INSTANCE);
                Main.LOGGER.info("Configuration has been saved.");
            }
        }
    }
}