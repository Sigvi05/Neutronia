package net.thegaminghuskymc.mcaddon.world.gen.layer;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.IntCache;
import net.thegaminghuskymc.mcaddon.world.biome.NetherBiomeManager;

public class GenLayerNetherBiome extends GenLayerNether
{
    public GenLayerNetherBiome(long seed)
    {
        super(seed);
    }

    @Override
    public int[] getInts(int areaX, int areaZ, int areaWidth, int areaHeight)
    {
        int[] outputs = IntCache.getIntCache(areaWidth * areaHeight);

        for(int z = 0; z < areaHeight; z++)
        {
            for(int x = 0; x < areaWidth; x++)
            {
                initChunkSeed(x + areaX, z + areaZ);
                outputs[x + z * areaWidth] = Biome.getIdForBiome(NetherBiomeManager.getRandomBiome(NetherBiomeManager.getAllBiomeEntries(), this));
            }
        }

        return outputs;
    }
}