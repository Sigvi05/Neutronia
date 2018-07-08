package net.hdt.neutronia.modules.test.world;

import net.hdt.neutronia.init.NBiomes;
import net.hdt.neutronia.init.NDimension;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TestWorldProvider extends WorldProvider {

    @Override
    protected void init() {
        super.init();
        biomeProvider = new BiomeProviderSingle(NBiomes.DEEP_WARM_OCEAN);
    }

    @Override
    public DimensionType getDimensionType() {
        return NDimension.TEST;
    }

    @Override
    public String getSaveFolder() {
        return "TEST";
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

}