package net.hdt.neutronia.api.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;

public interface IConfig {
    void parse(String jsonString);

    JsonElement compose();

    void add(String key, JsonElement element);

    void addFallback(String key, JsonElement element);

    void addSubConfig(String key, IConfig config);

    boolean has(String key);

    boolean hasFallback(String key);

    boolean hasSubConfig(String key);

    JsonElement get(String key);

    JsonElement getFallback(String key);

    Map<String, JsonElement> getElements();

    void remove(String key);

    String getString(String key, String fallbackValue);

    int getInt(String key, int fallbackValue);

    float getFloat(String key, float fallbackValue);

    boolean getBoolean(String key, boolean fallbackValue);

    <E extends Enum> E getEnum(String key, Class<? extends E> enumClass, E fallbackValue);

    ResourceLocation getResource(String key, ResourceLocation fallbackValue);

    IBlockState getBlock(String key, IBlockState fallbackValue);

    ItemStack getItem(String key, ItemStack fallbackValue);

    IConfig getSubConfig(String key, JsonObject defaultValue);

    String getString(String key);

    int getInt(String key);

    float getFloat(String key);

    boolean getBoolean(String key);

    <E extends Enum> E getEnum(String key, Class<? extends E> enumClass);

    ResourceLocation getResource(String key);

    IBlockState getBlock(String key);

    ItemStack getItem(String key);

    IConfig getSubConfig(String key);

    List<IConfig> getSubConfigs(String key, List<JsonObject> defaultValue);

    List<IConfig> getSubConfigs(String key);

    List<String> getStrings(String key, List<String> defaultValue);

    List<String> getStrings(String key);

}
