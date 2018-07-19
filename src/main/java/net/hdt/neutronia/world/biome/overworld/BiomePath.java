package net.hdt.neutronia.world.biome.overworld;

import net.minecraft.world.biome.Biome;

public class BiomePath extends Biome
{
    public BiomePath(Biome.BiomeProperties properties)
    {
        super(properties);
        this.spawnableCreatureList.clear();
    }
}