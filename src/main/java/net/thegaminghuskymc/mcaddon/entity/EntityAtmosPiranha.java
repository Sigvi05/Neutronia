// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EntityAtmosPiranha.java

package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.world.World;

// Referenced classes of package atmosmobs.watercreatures:
//            EntityAtmosStarFish

public class EntityAtmosPiranha extends EntityAtmosWater
{

    public EntityAtmosPiranha(World world)
    {
        super(world);
        setSize(0.5F, 0.8F);
        setMaxHealth(10);
        caught = false;
    }

    private boolean caught;
}
