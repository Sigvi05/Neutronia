// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EntityAtmosWhale.java

package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.world.World;

public class EntityAtmosWhale extends EntityAtmosWater {

    public EntityAtmosWhale(World world) {
        super(world);
        setSize(8F, 3F);
        setMaxHealth(100);
    }

    /*@Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvent.REGISTRY.getObject(new ResourceLocation("whale_ambient"));
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvent.REGISTRY.getObject(new ResourceLocation("whale_hurt"));
    }*/

}
