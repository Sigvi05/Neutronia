package net.hdt.neutronia.modules.mars.world;

import net.hdt.neutronia.init.NDimension;
import net.hdt.neutronia.modules.moon.init.NMoonBiomes;
import net.hdt.neutronia.modules.mars.world.gen.MarsChunkGenerator;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MarsWorldProvider extends WorldProvider {

    @Override
    protected void init() {
        super.init();
        biomeProvider = new BiomeProviderSingle(NMoonBiomes.MOON_MAIN);
    }

    @Override
    public DimensionType getDimensionType() {
        return NDimension.MOON;
    }

    @Override
    public String getSaveFolder() {
        return "MARS";
    }

    @Override
    public boolean canRespawnHere()
    {
        return false;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
        return 0.5F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float celestialAngle, float partialTicks)
    {
        return new Vec3d(0.2980392156862745D, 0.207843137254902D, 0.3372549019607843D);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z)
    {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1)
    {
        return 10.0F;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new MarsChunkGenerator(world);
    }

}