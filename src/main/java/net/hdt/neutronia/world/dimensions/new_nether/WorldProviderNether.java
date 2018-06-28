package net.hdt.neutronia.world.dimensions.new_nether;

import net.hdt.neutronia.world.dimensions.new_nether.biome.BiomeProviderNether;
import net.hdt.neutronia.world.dimensions.new_nether.gen.ChunkGeneratorNether;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderNether extends WorldProviderHell
{
    @Override
    public void init()
    {
        super.init();
        biomeProvider = new BiomeProviderNether(world);
    }

    @Override
    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkGeneratorNether(world);
    }

    /*@Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int chunkX, int chunkZ)
    {
        return !ConfigHandler.clientConfig.visual.disableNetherFog;
    }*/
}