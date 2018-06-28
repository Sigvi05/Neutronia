package net.hdt.neutronia.world.dimensions.new_nether.biome;

import com.google.common.collect.ImmutableList;
import net.hdt.neutronia.Main;
import net.hdt.neutronia.api.config.IConfig;
import net.hdt.neutronia.api.world.biome.IBiomeWrapper;
import net.hdt.neutronia.config.Config;
import net.hdt.neutronia.util.helpers.ConfigHelper;
import net.hdt.neutronia.util.helpers.FileHelper;
import net.hdt.neutronia.world.dimensions.base.biome.BiomeWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Loader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@SuppressWarnings("ConstantConditions")
public class NetherBiomeManager
{
    private static final List<Biome> BIOMES = new ArrayList<>();
    private static final Map<Biome, IBiomeWrapper> BIOME_WRAPPERS = new HashMap<>();
    private static final Map<Biome, IConfig> BIOME_CONFIGS = new HashMap<>();

    public static void preInit()
    {
        FileHelper.copyDirectoryToDirectory(new File(Main.class.getResource("/assets/neutronia/biome_configs").getFile()), new File(Main.CONFIG_DIRECTORY, "Neutronia/biomes"));
    }

    public static void setupDefaultBiomes()
    {
        Main.LOGGER.info("Setting up default biomes.");
        parseBiomeConfigs(new File(Main.CONFIG_DIRECTORY, "Neutronia/Biomes/minecraft"));
        parseBiomeConfigs(new File(Main.CONFIG_DIRECTORY, "Neutronia/Biomes/neutronia"));
    }

    public static void setupCompatibleBiomes(MinecraftServer server)
    {
        World world = server.getEntityWorld();

        if(Loader.isModLoaded("biomesoplenty"))
        {
            WorldType worldType = world.getWorldType();

            if(worldType.getName().equalsIgnoreCase("BIOMESOP") || worldType.getName().equalsIgnoreCase("lostcities_bop"))
            {
                Main.LOGGER.info("Setting up Biomes O' Plenty biomes.");
                parseBiomeConfigs(new File(Main.CONFIG_DIRECTORY, "NetherEx/Biomes/biomesoplenty"));
            }
        }
    }

    public static void setupCustomBiomes()
    {
        Main.LOGGER.info("Setting up custom biomes.");
        parseBiomeConfigs(new File(Main.CONFIG_DIRECTORY, "Neutronia/Biomes/custom"));
    }

    private static void parseBiomeConfigs(File directory)
    {
        if(!directory.exists())
        {
            directory.mkdirs();
        }

        try
        {
            Iterator<Path> pathIter = Files.walk(directory.toPath()).iterator();

            while(pathIter.hasNext())
            {
                Path configPath = pathIter.next();
                File configFile = configPath.toFile();

                if(FileHelper.getFileExtension(configFile).equals("json"))
                {
                    wrapBiome(new Config(configFile), configFile);
                }
                else if(!configFile.isDirectory())
                {
                    Main.LOGGER.warn("Skipping file located at, {}, as it is not a json file.", configPath.toString());
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void wrapBiome(IConfig config, File configFile)
    {
        IBiomeWrapper wrapper = new BiomeWrapper(config);
        Biome biome = wrapper.getBiome();

        if(biome != null)
        {
            BIOMES.add(biome);
            BIOME_WRAPPERS.put(biome, wrapper);
            BIOME_CONFIGS.put(biome, config);
            ConfigHelper.saveConfig(config, configFile);
        }
    }

    public static void clearBiomes()
    {
        BIOMES.clear();
        BIOME_WRAPPERS.clear();
        BIOME_CONFIGS.clear();
    }

    public static List<Biome> getBiomes()
    {
        return ImmutableList.copyOf(BIOMES);
    }

    public static IBiomeWrapper getBiomeWrapper(Biome key)
    {
        return BIOME_WRAPPERS.get(key);
    }

    public static IConfig getBiomeConfig(Biome key)
    {
        return BIOME_CONFIGS.get(key);
    }
}