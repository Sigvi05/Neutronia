// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EntityAtmosAngler.java

package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.world.World;

public class EntityAtmosAngler extends EntityWaterMob {

    public EntityAtmosAngler(World world) {
        super(world);
        setSize(0.5F, 0.5F);
        setHealth(25);
    }

    protected void initEntityAI()
    {
        super.initEntityAI();
    }

}
