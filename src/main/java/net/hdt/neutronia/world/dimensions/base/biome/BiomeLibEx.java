package net.hdt.neutronia.world.dimensions.base.biome;

import net.hdt.neutronia.api.IModData;
import net.minecraft.world.biome.Biome;

public class BiomeLibEx extends Biome
{
    public BiomeLibEx(IModData data, BiomeProperties properties, String name)
    {
        super(properties);
        setRegistryName(data.getModId() + ":" + name);
        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCaveCreatureList.clear();
    }
}