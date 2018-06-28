package net.hdt.neutronia.world.dimensions.new_nether.gen.layer;

import net.hdt.neutronia.api.config.IConfig;
import net.hdt.neutronia.world.dimensions.new_nether.biome.NetherBiomeManager;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GenLayerNetherBiome extends GenLayerNetherEx
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
                outputs[x + z * areaWidth] = Biome.getIdForBiome(getRandomBiome());
            }
        }

        return outputs;
    }

    private Biome getRandomBiome(List<Supplier<Biome>> biomes) {
        return biomes.get(nextInt(biomes.size())).get();
    }

    public Biome getRandomBiome()
    {
        List<BiomeManager.BiomeEntry> biomeEntryList = new ArrayList<>();

        for(Biome biome : NetherBiomeManager.getBiomes())
        {
            IConfig config = NetherBiomeManager.getBiomeConfig(biome);

            if(config != null)
            {
                biomeEntryList.add(new BiomeManager.BiomeEntry(biome, config.getInt("weight", 10)));
            }
        }

        return biomeEntryList.get(4).biome;
    }
}