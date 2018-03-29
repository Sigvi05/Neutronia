package net.thegaminghuskymc.mcaddon.world.gen.layer;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.*;

public abstract class GenLayerNether extends GenLayer
{
    public GenLayerNether(long seed)
    {
        super(seed);
    }

    public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType type)
    {
        int biomeSize = type == WorldType.LARGE_BIOMES ? 6 : 4;
        biomeSize = getModdedBiomeSize(type, biomeSize);

        GenLayer genLayer = new GenLayerNetherBiome(1L);
        genLayer = new GenLayerFuzzyZoom(1000L, genLayer);
        genLayer = GenLayerZoom.magnify(1000L, genLayer, biomeSize);
        genLayer = new GenLayerSmooth(1000L, genLayer);
        GenLayer genLayerVoronoiZoom = new GenLayerVoronoiZoom(10L, genLayer);

        genLayer.initWorldGenSeed(seed);
        genLayerVoronoiZoom.initWorldGenSeed(seed);

        return new GenLayer[]{genLayer, genLayerVoronoiZoom};
    }

    @Override
    public abstract int[] getInts(int areaX, int areaZ, int areaWidth, int areaHeight);

    @Override
    public int nextInt(int i)
    {
        return super.nextInt(i);
    }
}