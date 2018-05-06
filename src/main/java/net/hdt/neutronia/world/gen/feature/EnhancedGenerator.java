package net.hdt.neutronia.world.gen.feature;

import com.google.common.base.Strings;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public abstract class EnhancedGenerator extends WorldGenerator {
    private final int generationAttempts;
    private final float generationProbability;
    private final int minHeight;
    private final int maxHeight;

    protected EnhancedGenerator(int generationAttemptsIn, float generationProbabilityIn, int minHeightIn, int maxHeightIn) {
        generationAttempts = generationAttemptsIn;
        generationProbability = generationProbabilityIn;
        minHeight = minHeightIn;
        maxHeight = maxHeightIn;
    }

    public static EnhancedGenerator deserialize(JsonObject config) {
        GeneratorType generatorType = GeneratorType.getFromString(JsonUtils.getString(config, "generator", ""));

        switch (generatorType) {
            case FLUID:
                return EnhancedGeneratorFluid.INSTANCE.deserializeConfig(config);
            case SCATTER:
                return EnhancedGeneratorScatter.INSTANCE.deserializeConfig(config);
            case CLUSTER:
                return EnhancedGeneratorCluster.INSTANCE.deserializeConfig(config);
            case ORE:
                return EnhancedGeneratorOre.INSTANCE.deserializeConfig(config);
            case POOL:
                return EnhancedGeneratorPool.INSTANCE.deserializeConfig(config);
            case UNKNOWN:
            default:
                return null;
        }
    }

    public abstract EnhancedGenerator deserializeConfig(JsonObject config);

    @Override
    public abstract boolean generate(World world, Random rand, BlockPos pos);

    public int getGenerationAttempts() {
        return generationAttempts;
    }

    public int getGenAttempts(Random rand) {
        int attempts = getGenerationAttempts();
        float probability = getGenerationProbability();

        if (probability > 0.0F && probability < 1.0F && rand.nextFloat() > probability) {
            attempts = 0;
        }
        if (attempts < 0) {
            attempts = rand.nextInt(MathHelper.abs(attempts)) + 1;
        }

        return attempts;
    }

    public float getGenerationProbability() {
        return generationProbability;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    private enum GeneratorType {
        STRUCTURE,
        FLUID,
        SCATTER,
        CLUSTER,
        ORE,
        POOL,
        THORNSTALK,
        ENOKI,
        UNKNOWN;

        public static GeneratorType getFromString(String string) {
            if (!Strings.isNullOrEmpty(string)) {
                for (GeneratorType generatorType : values()) {
                    if (generatorType.name().equalsIgnoreCase(string)) {
                        return generatorType;
                    }
                }
            }

            return UNKNOWN;
        }

    }
}