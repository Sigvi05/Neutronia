package net.hdt.neutronia.world.dimensions.test_dimension;

import net.hdt.neutronia.init.NBiomes;
import net.hdt.neutronia.world.dimensions.test_dimension.gen.ChunkGeneratorOverworld;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderTest extends WorldProvider {

    DimensionType type = DimensionType.register("Test", "_test", 2, WorldProviderTest.class, false);

    @Override
    protected void init() {
        super.init();
        biomeProvider = new BiomeProviderSingle(NBiomes.BASALT);
    }

    @Override
    public DimensionType getDimensionType() {
        return type;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorOverworld(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), world.getWorldInfo().getGeneratorOptions());
    }

    @Override
    public boolean canRespawnHere() {
        return true;
    }

    @Override
    public boolean isSurfaceWorld() {
        return true;
    }

}
