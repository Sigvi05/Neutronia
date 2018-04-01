// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EntityAtmosStarFish.java

package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.world.World;

// Referenced classes of package atmosmobs.watercreatures:
//            EntityAtmosSeaTurtle, EntityAtmosSwordFish, EntityAtmosReefManta, EntityAtmosColourfulFish, 
//            EntityAtmosMcFish, EntityAtmosPiranha, EntityAtmosBlowfish, EntityAtmosAngler

public class EntityAtmosStarFish extends EntityAtmosCreature
{

    public EntityAtmosStarFish(World world)
    {
        super(world);
        setSize(0.3F, 0.3F);
        caught = false;
        fish1 = false;
        fish2 = false;
        fish3 = false;
        fish4 = false;
        fish5 = false;
        fish6 = false;
        fish7 = false;
        fish8 = false;
    }

    public boolean isTamed;
    public boolean caught;
    public boolean fish1;
    public boolean fish2;
    public boolean fish3;
    public boolean fish4;
    public boolean fish5;
    public boolean fish6;
    public boolean fish7;
    public boolean fish8;
}
