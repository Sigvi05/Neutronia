package net.thegaminghuskymc.mcaddon.world;

import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.mcaddon.util.handlers.ConfigHandler;
import net.thegaminghuskymc.mcaddon.world.biome.BiomeProviderNether;
import net.thegaminghuskymc.mcaddon.world.gen.ChunkGeneratorNether;

public class WorldProviderNether extends WorldProviderHell
{
    @Override
    public void init()
    {
        biomeProvider = new BiomeProviderNether(world);
        doesWaterVaporize = true;
        nether = true;
    }

    @Override
    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkGeneratorNether(world);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int chunkX, int chunkZ)
    {
        return !ConfigHandler.client.visual.disableNetherFog;
    }
}