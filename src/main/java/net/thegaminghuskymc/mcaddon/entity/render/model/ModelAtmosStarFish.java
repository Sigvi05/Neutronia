/*
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModelAtmosStarFish.java

package net.thegaminghuskymc.mcaddon.entity.render.model;

import axa;
import ayf;
import ke;
import lq;
import md;

public class ModelAtmosStarFish extends axa
{

    public ModelAtmosStarFish()
    {
        t = 64;
        u = 32;
        Side1 = new ayf(this, 0, 0);
        Side1.a(-0.5F, -0.5F, -0.5F, 1, 1, 4);
        Side1.a(0.0F, 23F, 0.0F);
        Side1.b(64, 32);
        Side1.i = true;
        setRotation(Side1, -0.1396263F, 0.0F, 0.0F);
        Side2 = new ayf(this, 0, 0);
        Side2.a(-0.5F, -0.5F, -0.5F, 1, 1, 4);
        Side2.a(0.0F, 23F, 0.0F);
        Side2.b(64, 32);
        Side2.i = true;
        setRotation(Side2, -0.1396263F, 0.9599311F, 0.0F);
        Side3 = new ayf(this, 0, 0);
        Side3.a(-0.5F, -0.5F, -0.5F, 1, 1, 4);
        Side3.a(0.0F, 23F, 0.0F);
        Side3.b(64, 32);
        Side3.i = true;
        setRotation(Side3, -0.1396263F, -0.9599311F, 0.0F);
        Side4 = new ayf(this, 0, 0);
        Side4.a(-0.5F, -0.5F, -0.5F, 1, 1, 4);
        Side4.a(0.0F, 23F, 0.0F);
        Side4.b(64, 32);
        Side4.i = true;
        setRotation(Side4, -0.1396263F, 2.268928F, 0.0F);
        Side5 = new ayf(this, 0, 0);
        Side5.a(-0.5F, -0.5F, -0.5F, 1, 1, 4);
        Side5.a(0.0F, 23F, 0.0F);
        Side5.b(64, 32);
        Side5.i = true;
        setRotation(Side5, -0.1396263F, -2.268928F, 0.0F);
    }

    public void a(md entityliving, float f, float f1, float f2)
    {
        Side1.f = ke.b(f1 * 0.6662F * 2.0F + 0.0F) * 0.2F * f2;
        Side2.f = ke.b(f1 * 0.6662F * 2.0F + 0.0F) * 0.2F * f2;
        Side3.f = ke.b(f1 * 0.6662F * 2.0F + 0.0F) * 0.2F * f2;
        Side4.f = ke.b(f1 * 0.6662F * 2.0F + 0.0F) * 0.2F * f2;
        Side5.f = ke.b(f1 * 0.6662F * 2.0F + 0.0F) * 0.2F * f2;
    }

    public void a(lq entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.a(entity, f, f1, f2, f3, f4, f5);
        a(f, f1, f2, f3, f4, f5, entity);
        Side1.a(f5);
        Side2.a(f5);
        Side3.a(f5);
        Side4.a(f5);
        Side5.a(f5);
    }

    private void setRotation(ayf model, float x, float y, float z)
    {
        model.f = x;
        model.g = y;
        model.h = z;
    }

    public void a(float f, float f1, float f2, float f3, float f4, float f5, lq entity)
    {
        super.a(f, f1, f2, f3, f4, f5, entity);
    }

    ayf Side1;
    ayf Side2;
    ayf Side3;
    ayf Side4;
    ayf Side5;
}
*/
