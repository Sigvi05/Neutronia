/*
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RenderAtmosColourfulFish.java

package net.thegaminghuskymc.mcaddon.entity.render;

import axa;
import bcj;
import lq;
import md;
import net.thegaminghuskymc.mcaddon.entity.EntityAtmosColourfulFish;
import org.lwjgl.opengl.GL11;

// Referenced classes of package atmosmobs.watercreatures:
//            EntityAtmosColourfulFish

public class RenderAtmosColourfulFish extends bcj
{

    public RenderAtmosColourfulFish(axa modelbase, float f)
    {
        super(modelbase, f);
    }

    public void renderColourfulFish(EntityAtmosColourfulFish entityColourfulFish, double d, double d1, double d2,
                                    float f, float f1)
    {
        super.a(entityColourfulFish, d, d1, d2, f, f1);
    }

    public void a(md entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderColourfulFish((EntityAtmosColourfulFish)entityliving, d, d1, d2, f, f1);
    }

    public void a(lq entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderColourfulFish((EntityAtmosColourfulFish)entity, d, d1, d2, f, f1);
    }

    protected void preRenderScale(md entityliving, float f)
    {
        EntityAtmosColourfulFish entityColourfulFish = (EntityAtmosColourfulFish)entityliving;
        if(entityColourfulFish.isDiving())
            isDescending(entityliving);
        if(entityColourfulFish.isRising())
            isAscending(entityliving);
    }

    protected void a(md entityliving, float f)
    {
        preRenderScale((EntityAtmosColourfulFish)entityliving, f);
    }

    protected void isAscending(md entityliving)
    {
        GL11.glRotatef(-45F, -1F, 0.0F, 0.0F);
    }

    protected void isDescending(md entityliving)
    {
        GL11.glRotatef(45F, -1F, 0.0F, 0.0F);
    }
}
*/
