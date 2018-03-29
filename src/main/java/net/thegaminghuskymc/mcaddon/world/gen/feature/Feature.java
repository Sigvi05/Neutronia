package net.thegaminghuskymc.mcaddon.world.gen.feature;

import com.google.common.base.Strings;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.thegaminghuskymc.mcaddon.world.biome.NetherBiome;

import java.util.Random;

public abstract class Feature
{
    private final Biome biome;
    private final int rarity;
    private final int minHeight;
    private final int maxHeight;
    private final boolean randomRarity;
    private final boolean superRare;

    public Feature(Biome biomeIn, NetherBiome.BiomeFeature feature)
    {
        biome = biomeIn;
        rarity = feature.getRarity() <= 0 ? 10 : feature.getRarity();
        minHeight = feature.getMinHeight() <= 0 || feature.getMinHeight() >= 128 ? 4 : feature.getMinHeight();
        maxHeight = feature.getMaxHeight() >= 120 || feature.getMaxHeight() <= 0 ? 108 : feature.getMaxHeight();
        randomRarity = feature.useRandomRarity();
        superRare = feature.isSuperRare();
    }

    public abstract boolean generate(World world, BlockPos pos, Random rand);

    public abstract boolean canGenerate();

    public abstract FeatureType getType();

    public Biome getBiome()
    {
        return biome;
    }

    public int getRarity()
    {
        return rarity;
    }

    public int getMinHeight()
    {
        return minHeight;
    }

    public int getMaxHeight()
    {
        return maxHeight;
    }

    public boolean useRandomRarity()
    {
        return randomRarity;
    }

    public boolean isSuperRare()
    {
        return superRare;
    }

    public enum FeatureType
    {
        SCATTERED,
        CLUMPED,
        ORE,
        FLUID,
        POOL,
        STRUCTURE,
        UNKNOWN;

        public static FeatureType getFromString(String string)
        {
            if(!Strings.isNullOrEmpty(string))
            {
                for(FeatureType type : values())
                {
                    if(type.name().equalsIgnoreCase(string))
                    {
                        return type;
                    }
                }
            }

            return UNKNOWN;
        }
    }
}