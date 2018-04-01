// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EntityAtmosLavaMob.java

package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.world.World;

// Referenced classes of package atmosmobs:
//            EntityAtmosWaterMob

public class EntityAtmosLavaMob extends EntityAtmosWaterMob {

    public EntityAtmosLavaMob(World world) {
        super(world);
        chosenway = false;
    }

    public int aT()
    {
        return maxHealth;
    }

    public boolean H()
    {
        return false;
    }

    public boolean bc()
    {
        return true;
    }

    private int maxHealth;
    public boolean diving;
    public boolean rising;
    private int divingCount;
    public boolean isTamed;
    private boolean chosenway;
    private double chosenwayX;
    private double chosenwayZ;
}
