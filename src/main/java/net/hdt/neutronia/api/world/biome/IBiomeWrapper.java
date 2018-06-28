package net.hdt.neutronia.api.world.biome;

import net.hdt.neutronia.world.dimensions.base.gen.GenerationStage;
import net.hdt.neutronia.world.dimensions.base.gen.feature.IFeature;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;

import java.util.List;

public interface IBiomeWrapper
{
    Biome getBiome();

    IBlockState getBlock(String key, IBlockState fallbackValue);

    IBlockState getBlock(String key);

    List<IBlockState> getBlocks();

    List<IFeature> getFeatures(GenerationStage generationStage);

    List<Biome.SpawnListEntry> getSpawnableMobs(EnumCreatureType creatureType);

    boolean isEnabled();

    boolean shouldGenDefaultFeatures();
}