package net.hdt.neutronia.util.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.hdt.neutronia.Main;
import net.hdt.neutronia.api.config.IConfig;
import net.hdt.neutronia.config.Config;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ConfigHelper
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static void saveConfig(IConfig config, File configFile)
    {
        if(configFile != null)
        {
            if(configFile.getPath().startsWith("~"))
            {
                configFile = new File(configFile.getPath().replace("~", Main.CONFIG_DIRECTORY.getPath()));
            }

            String jsonString = GSON.toJson(config.serialize());

            try
            {
                FileUtils.write(configFile, jsonString, Charset.defaultCharset());
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static List<IConfig> getFileConfigs(File directory)
    {
        List<IConfig> configs = new ArrayList<>();

        if(directory.exists())
        {
            for(File file : FileUtils.listFilesAndDirs(directory, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE))
            {
                if(FileHelper.getFileExtension(file).equals("json"))
                {
                    configs.add(new Config(file));
                }
            }
        }

        return configs;
    }

    public static boolean isString(JsonElement element)
    {
        return isPrimitive(element) && element.getAsJsonPrimitive().isString();
    }

    public static boolean isInt(JsonElement element)
    {
        return isPrimitive(element) && element.getAsJsonPrimitive().isNumber();
    }

    public static boolean isFloat(JsonElement element)
    {
        return isPrimitive(element) && element.getAsJsonPrimitive().isNumber();
    }

    public static boolean isBoolean(JsonElement element)
    {
        return isPrimitive(element) && element.getAsJsonPrimitive().isBoolean();
    }

    public static boolean isPrimitive(JsonElement element)
    {
        return !isNull(element) && element.isJsonPrimitive();
    }

    public static boolean isObject(JsonElement element)
    {
        return !isNull(element) && element.isJsonObject();
    }

    public static boolean isArray(JsonElement element)
    {
        return !isNull(element) && element.isJsonArray();
    }

    public static boolean isNull(JsonElement element)
    {
        return element == null || element.isJsonNull();
    }
}