package net.hdt.neutronia.world.gen;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.hdt.neutronia.world.gen.feature.EnhancedGenerator;
import net.minecraft.world.biome.Biome;

import java.util.List;
import java.util.Map;

public enum GenerationStage {
    PRE_POPULATE,
    POPULATE,
    POST_POPULATE,
    PRE_DECORATE,
    DECORATE,
    POST_DECORATE,
    PRE_ORE,
    ORE,
    POST_ORE,
    LAVA_FALL,
    FIRE,
    GLOWSTONE,
    MUSHROOM,
    QUARTZ,
    MAGMA,
    LAVA_TRAP;

    private final Map<Biome, List<EnhancedGenerator>> biomeGenerators = Maps.newHashMap();

    public static GenerationStage getFromString(String string) {
        if (!Strings.isNullOrEmpty(string)) {
            for (GenerationStage generationStage : values()) {
                if (generationStage.name().replace("_", "").equalsIgnoreCase(string)) {
                    return generationStage;
                }
            }
        }

        return POST_DECORATE;
    }

    public void addGenerator(Biome biome, EnhancedGenerator feature) {
        biomeGenerators.computeIfAbsent(biome, k -> Lists.newArrayList()).add(feature);
    }

    public void clearGeneratorList(Biome biome) {
        biomeGenerators.remove(biome);
    }

    public Map<Biome, List<EnhancedGenerator>> getBiomeGeneratorMap() {
        return ImmutableMap.copyOf(biomeGenerators);
    }

}
