package net.hdt.neutronia.world.dimensions.base.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;

public abstract class GenLayerEx extends GenLayer
{
    public GenLayerEx(long seed)
    {
        super(seed);
    }

    @Override
    public abstract int[] getInts(int areaX, int areaZ, int areaWidth, int areaHeight);

    /*@Override
    public int nextInt(int i)
    {
        return super.nextInt(i);
    }*/
}