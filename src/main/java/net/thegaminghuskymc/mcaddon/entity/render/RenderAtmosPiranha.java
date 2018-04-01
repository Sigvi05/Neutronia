// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RenderAtmosPiranha.java

package net.thegaminghuskymc.mcaddon.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.mcaddon.entity.EntityAtmosPiranha;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelCod;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

// Referenced classes of package atmosmobs.watercreatures:
//            EntityAtmosPiranha

public class RenderAtmosPiranha extends RenderLiving<EntityAtmosPiranha>
{

    public RenderAtmosPiranha(RenderManager manager)
    {
        super(manager, new ModelCod(), 0.5f);
    }

    public void renderPiranha(EntityAtmosPiranha entityPiranha, double d, double d1, double d2,
                              float f, float f1)
    {
        super.renderMultipass(entityPiranha, d, d1, d2, f, f1);
    }

    public void a(EntityLiving entityliving, double d, double d1, double d2,
                  float f, float f1)
    {
        renderPiranha((EntityAtmosPiranha)entityliving, d, d1, d2, f, f1);
    }

    public void a(Entity entity, double d, double d1, double d2,
            float f, float f1)
    {
        renderPiranha((EntityAtmosPiranha)entity, d, d1, d2, f, f1);
    }

    protected void preRenderScale(Entity entityliving, float f)
    {
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        EntityAtmosPiranha entityPiranha = (EntityAtmosPiranha)entityliving;
        if(entityPiranha.isDiving())
            isDescending(entityliving);
        if(entityPiranha.isRising())
            isAscending(entityliving);
    }

    protected void a(Entity entityliving, float f)
    {
        preRenderScale((EntityAtmosPiranha)entityliving, f);
    }

    protected void isAscending(Entity entityliving)
    {
        GL11.glRotatef(-45F, -1F, 0.0F, 0.0F);
    }

    protected void isDescending(Entity entityliving)
    {
        GL11.glRotatef(45F, -1F, 0.0F, 0.0F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAtmosPiranha entity) {
        return null;
    }
}
