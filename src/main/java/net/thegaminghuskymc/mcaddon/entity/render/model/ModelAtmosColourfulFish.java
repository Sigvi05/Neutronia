/*
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModelAtmosColourfulFish.java

package net.thegaminghuskymc.mcaddon.entity.render.model;

import axa;
import ayf;
import ke;
import lq;

public class ModelAtmosColourfulFish extends axa
{

    public ModelAtmosColourfulFish()
    {
        t = 64;
        u = 32;
        Body = new ayf(this, 0, 6);
        Body.a(-0.5F, -2F, -2.5F, 1, 4, 5);
        Body.a(0.0F, 21F, 0.0F);
        Body.b(64, 32);
        Body.i = true;
        setRotation(Body, 0.0F, 0.0F, 0.0F);
        Fin1 = new ayf(this, 0, 19);
        Fin1.a(0.0F, 0.0F, 0.0F, 1, 2, 2);
        Fin1.a(0.0F, 21F, 2.0F);
        Fin1.b(64, 32);
        Fin1.i = true;
        setRotation(Fin1, 0.7853982F, 0.0F, 0.0F);
        Fin2 = new ayf(this, 8, 15);
        Fin2.a(0.0F, 0.0F, 0.0F, 1, 1, 4);
        Fin2.a(0.0F, 18F, -2F);
        Fin2.b(64, 32);
        Fin2.i = true;
        setRotation(Fin2, -0.1745329F, 0.0F, 0.0F);
        Fin3 = new ayf(this, 0, 15);
        Fin3.a(0.0F, 0.0F, 0.0F, 1, 1, 3);
        Fin3.a(0.0F, 23F, -1F);
        Fin3.b(64, 32);
        Fin3.i = true;
        setRotation(Fin3, 0.296706F, 0.0F, 0.0F);
        Head = new ayf(this, 0, 2);
        Head.a(-0.5F, 0.0F, 0.0F, 1, 2, 2);
        Head.a(0.0F, 21F, -1F);
        Head.b(64, 32);
        Head.i = true;
        setRotation(Head, -2.356194F, 0.0F, 0.0F);
        Fin4 = new ayf(this, 6, 0);
        Fin4.a(0.0F, 0.0F, 0.0F, 2, 1, 1);
        Fin4.a(0.0F, 22F, -2F);
        Fin4.b(64, 32);
        Fin4.i = true;
        setRotation(Fin4, 0.0F, 0.0F, 0.3839724F);
        Fin5 = new ayf(this, 0, 0);
        Fin5.a(-2F, 0.0F, 0.0F, 2, 1, 1);
        Fin5.a(0.0F, 22F, -2F);
        Fin5.b(64, 32);
        Fin5.i = true;
        setRotation(Fin5, 0.0F, 0.0F, -0.3839724F);
    }

    public void a(lq entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.a(entity, f, f1, f2, f3, f4, f5);
        a(f, f1, f2, f3, f4, f5, entity);
        Body.a(f5);
        Fin1.a(f5);
        Fin2.a(f5);
        Fin3.a(f5);
        Head.a(f5);
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
        Fin1.g = -ke.b(f3 * 0.6662F * 2.0F + 0.0F) * 0.6F * f1;
    }

    ayf Body;
    ayf Fin1;
    ayf Fin2;
    ayf Fin3;
    ayf Head;
    ayf Fin4;
    ayf Fin5;
}
*/
