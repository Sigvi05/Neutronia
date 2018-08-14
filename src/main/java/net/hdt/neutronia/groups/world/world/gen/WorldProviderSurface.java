package net.hdt.neutronia.groups.world.world.gen;

import net.minecraft.world.gen.ChunkGeneratorHell;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderSurface extends net.minecraft.world.WorldProviderSurface {

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorHell(this.world, this.world.getWorldInfo().isMapFeaturesEnabled(), this.world.getSeed());
    }

}