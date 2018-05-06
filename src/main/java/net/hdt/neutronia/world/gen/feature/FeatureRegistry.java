package net.hdt.neutronia.world.gen.feature;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.api.config.IConfig;
import net.hdt.neutronia.api.world.gen.feature.IFeature;
import net.minecraft.util.ResourceLocation;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class FeatureRegistry {
    private static final Map<ResourceLocation, Class<? extends Feature>> FEATURES = new HashMap<>();

    static {
        registerFeature(new ResourceLocation(MOD_ID + ":scatter"), FeatureScatter.class);
        registerFeature(new ResourceLocation(MOD_ID + ":cluster"), FeatureCluster.class);
        registerFeature(new ResourceLocation(MOD_ID + ":fluid"), FeatureFluid.class);
        registerFeature(new ResourceLocation(MOD_ID + ":ore"), FeatureOre.class);
        registerFeature(new ResourceLocation(MOD_ID + ":pool"), FeaturePool.class);
        registerFeature(new ResourceLocation(MOD_ID + ":structure"), FeatureStructure.class);
    }

    public static void registerFeature(ResourceLocation name, Class<? extends Feature> cls) {
        if (!FEATURES.containsKey(name)) {
            FEATURES.put(name, cls);
        } else {
            Main.LOGGER.warn("A feature with the name, {}, is already registered!", name.toString());
        }
    }

    public static IFeature createFeature(ResourceLocation name, IConfig config) {
        if (FEATURES.containsKey(name)) {
            try {
                return FEATURES.get(name).getConstructor(IConfig.class).newInstance(config);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
