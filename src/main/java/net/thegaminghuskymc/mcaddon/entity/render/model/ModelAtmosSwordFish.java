/*
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModelAtmosSwordFish.java

package net.thegaminghuskymc.mcaddon.entity.render.model;

import axa;
import ayf;
import ke;
import lq;

public class ModelAtmosSwordFish extends axa
{

    public ModelAtmosSwordFish()
    {
        t = 64;
        u = 32;
        Body1 = new ayf(this, 0, 18);
        Body1.a(-1F, -3F, -7F, 2, 4, 10);
        Body1.a(0.0F, 19F, 0.0F);
        Body1.b(64, 32);
        Body1.i = true;
        setRotation(Body1, 0.0F, 0.0F, 0.0F);
        Fin1 = new ayf(this, 0, 20);
        Fin1.a(-0.5F, -4F, 0.0F, 1, 4, 2);
        Fin1.a(0.0F, 16F, -6F);
        Fin1.b(64, 32);
        Fin1.i = true;
        setRotation(Fin1, -0.5759587F, 0.0F, 0.0F);
        Head1 = new ayf(this, 0, 11);
        Head1.a(-1F, -3F, -4F, 2, 3, 4);
        Head1.a(0.0F, 19F, -6F);
        Head1.b(64, 32);
        Head1.i = true;
        setRotation(Head1, 0.2268928F, 0.0F, 0.0F);
        Head2 = new ayf(this, 12, 0);
        Head2.a(-0.5F, 0.0F, -8F, 1, 1, 8);
        Head2.a(0.0F, 18F, -10F);
        Head2.b(64, 32);
        Head2.i = true;
        setRotation(Head2, 0.0F, 0.0F, 0.0F);
        Fin2 = new ayf(this, 12, 11);
        Fin2.a(-0.5F, -6F, 1.0F, 1, 5, 2);
        Fin2.a(0.0F, 18F, 3F);
        Fin2.b(64, 32);
        Fin2.i = true;
        setRotation(Fin2, -0.5585054F, 0.0F, 0.0F);
        Fin3 = new ayf(this, 18, 11);
        Fin3.a(-0.5F, 1.0F, 1.0F, 1, 5, 2);
        Fin3.a(0.0F, 18F, 3F);
        Fin3.b(64, 32);
        Fin3.i = true;
        setRotation(Fin3, 0.5585054F, 0.0F, -0.0174533F);
        Body2 = new ayf(this, 0, 5);
        Body2.a(-1F, -1.5F, 0.0F, 2, 3, 3);
        Body2.a(0.0F, 18F, 3F);
        Body2.b(64, 32);
        Body2.i = true;
        setRotation(Body2, 0.0F, 0.0F, 0.0F);
        Fin4 = new ayf(this, 10, 0);
        Fin4.a(0.0F, 0.0F, 0.0F, 1, 1, 4);
        Fin4.a(0.5F, 19F, -6F);
        Fin4.b(64, 32);
        Fin4.i = true;
        setRotation(Fin4, 0.0F, 0.4014257F, 0.0F);
        Fin5 = new ayf(this, 0, 0);
        Fin5.a(-1F, 0.0F, 0.0F, 1, 1, 4);
        Fin5.a(-0.5F, 19F, -6F);
        Fin5.b(64, 32);
        Fin5.i = true;
        setRotation(Fin5, 0.0F, -0.4014257F, 0.0F);
    }

    public void a(lq entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.a(entity, f, f1, f2, f3, f4, f5);
        a(f, f1, f2, f3, f4, f5, entity);
        Body1.a(f5);
        Fin1.a(f5);
        Head1.a(f5);
        Head2.a(f5);
        Fin2.a(f5);
        Fin3.a(f5);
        Body2.a(f5);
        Fin4.a(f5);
        Fin5.a(f5);
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
        Fin2.g = -ke.b(f3 * 0.6662F * 2.0F + 1.0F) * 0.9F * f1;
        Fin3.g = -ke.b(f3 * 0.6662F * 2.0F + 1.0F) * 0.9F * f1;
        Body2.g = -ke.b(f3 * 0.6662F * 2.0F + 1.0F) * 0.9F * f1;
    }

    ayf Body1;
    ayf Fin1;
    ayf Head1;
    ayf Head2;
    ayf Fin2;
    ayf Fin3;
    ayf Body2;
    ayf Fin4;
    ayf Fin5;
}
*/
