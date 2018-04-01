/*
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RenderAtmosSwordFish.java

package net.thegaminghuskymc.mcaddon.entity.render;

import axa;
import bcj;
import lq;
import md;
import net.thegaminghuskymc.mcaddon.entity.EntityAtmosSwordFish;
import org.lwjgl.opengl.GL11;

// Referenced classes of package atmosmobs.watercreatures:
//            EntityAtmosSwordFish

public class RenderAtmosSwordFish extends bcj
{

    public RenderAtmosSwordFish(axa modelbase, float f)
    {
        super(modelbase, f);
    }

    public void renderSwordFish(EntityAtmosSwordFish entitySwordFish, double d, double d1, double d2,
                                float f, float f1)
    {
        super.a(entitySwordFish, d, d1, d2, f, f1);
    }

    public void a(md entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderSwordFish((EntityAtmosSwordFish)entityliving, d, d1, d2, f, f1);
    }

    public void a(lq entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderSwordFish((EntityAtmosSwordFish)entity, d, d1, d2, f, f1);
    }

    protected void preRenderScale(md entityliving, float f)
    {
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        EntityAtmosSwordFish entitySwordFish = (EntityAtmosSwordFish)entityliving;
        if(entitySwordFish.isDiving())
            isDescending(entityliving);
        if(entitySwordFish.isRising())
            isAscending(entityliving);
    }

    protected void a(md entityliving, float f)
    {
        preRenderScale((EntityAtmosSwordFish)entityliving, f);
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
