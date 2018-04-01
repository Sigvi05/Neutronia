// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EntityAtmosWater.java

package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.world.World;

// Referenced classes of package atmosmobs:
//            EntityAtmosWaterMob

public class EntityAtmosWater extends EntityAtmosWaterMob {

    public EntityAtmosWater(World world) {
        super(world);
        outOfWater = 0;
    }

    public boolean bj()
    {
        return false;
    }

    public float b(float f, float f1, float f2)
    {
        float f3 = f1;
        for(f3 = f1 - f; f3 < -180F; f3 += 360F);
        for(; f3 >= 180F; f3 -= 360F);
        if(f3 > f2)
            f3 = f2;
        if(f3 < -f2)
            f3 = -f2;
        return f + f3;
    }

    protected void a(int i, int j, int k, int l)
    {
    }

    protected void a(float f1)
    {
    }

    public boolean isRising()
    {
        return rising && outOfWater == 0;
    }

    public int aT()
    {
        return maxHealth;
    }

    public void setMaxHealth(int i)
    {
        maxHealth = i;
    }

    protected String ba()
    {
        return null;
    }

    protected String aZ()
    {
        return null;
    }

    protected String aY()
    {
        return null;
    }

    protected float aX()
    {
        return 0.4F;
    }

    public boolean gettingOutOfWater()
    {
        int i = (int)posX;
        int j = (int)posY;
        int k = (int)posZ;
        int l = 1;
        return false;
    }

    protected String getUpsetSound()
    {
        return null;
    }

    public double speed()
    {
        return 1.5D;
    }

    public boolean H()
    {
        return false;
    }

    public boolean bc()
    {
        return true;
    }

    public boolean isDiving()
    {
        return diving && outOfWater == 0;
    }

    public void setDiving(boolean par1)
    {
        if(par1)
            diving = true;
        else
            diving = false;
    }

    protected void bi()
    {
    }

    public int outOfWater;
    private int maxHealth;
    public boolean rising;
    private boolean diving;
    private int divingCount;
    public boolean isTamed;
    private boolean Jump;
}
