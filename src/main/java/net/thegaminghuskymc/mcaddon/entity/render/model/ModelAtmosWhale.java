/*
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModelAtmosWhale.java

package net.thegaminghuskymc.mcaddon.entity.render.model;

import axa;
import ayf;
import ke;
import lq;
import md;

public class ModelAtmosWhale extends axa
{

    public ModelAtmosWhale()
    {
        t = 64;
        u = 32;
        Body1 = new ayf(this, 0, 0);
        Body1.a(-3.5F, -2.5F, -7F, 7, 7, 14);
        Body1.a(0.0F, 19F, -4F);
        Body1.b(64, 32);
        Body1.i = true;
        setRotation(Body1, 0.0F, 0.0F, 0.0F);
        Body2 = new ayf(this, 28, 0);
        Body2.a(-2.5F, -2.5F, 0.0F, 5, 5, 9);
        Body2.a(0.0F, 20F, 3F);
        Body2.b(64, 32);
        Body2.i = true;
        setRotation(Body2, 0.0F, 0.0F, 0.0F);
        Tail1 = new ayf(this, 0, 21);
        Tail1.a(-2.5F, -1F, 8F, 5, 2, 6);
        Tail1.a(0.0F, 20F, 3F);
        Tail1.b(64, 32);
        Tail1.i = true;
        setRotation(Tail1, 0.0F, 0.0F, 0.0F);
        Tail2 = new ayf(this, 18, 21);
        Tail2.a(-5F, 0.0F, 13F, 3, 1, 5);
        Tail2.a(0.0F, 20F, 3F);
        Tail2.b(64, 32);
        Tail2.i = true;
        setRotation(Tail2, 0.0F, 0.3316126F, 0.0F);
        Tail3 = new ayf(this, 18, 21);
        Tail3.a(2.0F, 0.0F, 13F, 3, 1, 5);
        Tail3.a(0.0F, 20F, 3F);
        Tail3.b(64, 32);
        Tail3.i = true;
        setRotation(Tail3, 0.0F, -0.3316126F, 0.0F);
        Fin1 = new ayf(this, 35, 21);
        Fin1.a(0.0F, 1.0F, 0.0F, 2, 1, 5);
        Fin1.a(3F, 20F, 0.0F);
        Fin1.b(64, 32);
        Fin1.i = true;
        setRotation(Fin1, 0.0F, 0.4363323F, 0.0F);
        Fin2 = new ayf(this, 35, 21);
        Fin2.a(-2F, 0.0F, 0.0F, 2, 1, 5);
        Fin2.a(-3F, 20F, 0.0F);
        Fin2.b(64, 32);
        Fin2.i = true;
        setRotation(Fin2, 0.0F, -0.4363323F, 0.0F);
    }

    public void a(lq entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.a(entity, f, f1, f2, f3, f4, f5);
        a(f, f1, f2, f3, f4, f5, entity);
        Body1.a(f5);
        Body2.a(f5);
        Tail1.a(f5);
        Tail2.a(f5);
        Tail3.a(f5);
        Fin1.a(f5);
        Fin2.a(f5);
    }

    public void a(md entityliving, float par2, float par3, float par4)
    {
        float f1 = (0.5F + Math.max(par3, par4 - 1.0F)) * 0.25F;
        float f2 = par2 * 0.3F;
        Body2.f = ke.a(f2 - 0.375F) * f1;
        Tail1.f = ke.a(f2 - 0.525F) * f1;
        Tail2.f = ke.a(f2 - 0.675F) * f1;
        Tail3.f = ke.a(f2 - 0.825F) * f1;
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

    ayf Body1;
    ayf Body2;
    ayf Tail1;
    ayf Tail2;
    ayf Tail3;
    ayf Fin1;
    ayf Fin2;
}
*/
