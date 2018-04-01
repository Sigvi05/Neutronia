/*
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModelAtmosPiranha.java

package net.thegaminghuskymc.mcaddon.entity.render.model;

import axa;
import ayf;
import ke;
import lq;
import md;

public class ModelAtmosPiranha extends axa
{

    public ModelAtmosPiranha()
    {
        t = 64;
        u = 32;
        Body = new ayf(this, 0, 11);
        Body.a(-1F, -3F, -7F, 2, 2, 7);
        Body.a(0.0F, 18F, 0.0F);
        Body.b(64, 32);
        Body.i = true;
        setRotation(Body, 0.0F, 0.0F, 0.0F);
        Body2 = new ayf(this, 0, 20);
        Body2.a(-1F, -1F, -6F, 2, 1, 8);
        Body2.a(0.0F, 18F, -1F);
        Body2.b(64, 32);
        Body2.i = true;
        setRotation(Body2, 0.0F, 0.0F, 0.0F);
        Fin1 = new ayf(this, 0, 0);
        Fin1.a(-0.5F, -3F, 0.0F, 1, 3, 1);
        Fin1.a(0.0F, 17F, 0.0F);
        Fin1.b(64, 32);
        Fin1.i = true;
        setRotation(Fin1, -0.6632251F, 0.0F, 0.0F);
        Fin2 = new ayf(this, 0, 0);
        Fin2.a(-0.5F, 0.0F, 0.0F, 1, 3, 1);
        Fin2.a(0.0F, 17F, 0.0F);
        Fin2.b(64, 32);
        Fin2.i = true;
        setRotation(Fin2, -0.6632251F, 0.0F, 0.0F);
        Beak = new ayf(this, 0, 5);
        Beak.a(-1F, 0.0F, -4F, 3, 2, 4);
        Beak.a(-0.5F, 17F, -4F);
        Beak.b(64, 32);
        Beak.i = true;
        setRotation(Beak, 0.2268928F, 0.0F, 0.0F);
        Teeth = new ayf(this, 14, 0);
        Teeth.a(-1F, -1F, -4F, 3, 1, 4);
        Teeth.a(-0.5F, 17F, -4F);
        Teeth.b(64, 32);
        Teeth.i = true;
        setRotation(Teeth, 0.2268928F, 0.0F, 0.0F);
        Fin3 = new ayf(this, 4, 0);
        Fin3.a(0.0F, -2F, 0.0F, 1, 4, 1);
        Fin3.a(-0.5F, 18F, -2F);
        Fin3.b(64, 32);
        Fin3.i = true;
        setRotation(Fin3, -1.570796F, 0.0F, 0.0F);
        Fin4 = new ayf(this, 8, 0);
        Fin4.a(0.0F, -1F, -2F, 1, 2, 2);
        Fin4.a(-0.5F, 16F, -1F);
        Fin4.b(64, 32);
        Fin4.i = true;
        setRotation(Fin4, -1.797689F, 0.0F, 0.0F);
    }

    public void a(lq entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.a(entity, f, f1, f2, f3, f4, f5);
        a(f, f1, f2, f3, f4, f5, entity);
        Body.a(f5);
        Body2.a(f5);
        Fin1.a(f5);
        Fin2.a(f5);
        Beak.a(f5);
        Teeth.a(f5);
        Fin3.a(f5);
        Fin4.a(f5);
    }

    public void a(md entityliving, float f, float f1, float f2)
    {
        Beak.f = ke.b(f1 * 0.6662F * 2.0F + 0.0F) * 0.6F * f2;
        Teeth.f = ke.b(f1 * 0.6662F * 2.0F + 0.0F) * 0.6F * f2;
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
        Fin1.g = -ke.b(f3 * 0.6662F * 2.0F + 0.0F) * 0.6F * f1;
        Fin2.g = -ke.b(f3 * 0.6662F * 2.0F + 0.0F) * 0.6F * f1 + 3.141593F;
    }

    ayf Body;
    ayf Body2;
    ayf Fin1;
    ayf Fin2;
    ayf Beak;
    ayf Teeth;
    ayf Fin3;
    ayf Fin4;
}
*/
