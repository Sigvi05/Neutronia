// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EntityAtmosAnimal.java

package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityAtmosAnimal extends EntityAnimal implements IAnimals {

    public EntityAtmosAnimal(World par1World) {
        super(par1World);
    }


    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

}
