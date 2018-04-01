// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RenderAtmosAngler.java

package net.thegaminghuskymc.mcaddon.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.mcaddon.entity.EntityAtmosAngler;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelAtmosAngler;
import net.thegaminghuskymc.mcaddon.util.Reference;

import javax.annotation.Nullable;

// Referenced classes of package atmosmobs.watercreatures:
//            ModelAtmosAngler, EntityAtmosAngler

public class RenderAtmosAngler extends RenderLiving<EntityAtmosAngler> {

    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/ocean_creatures/angler.png");

    public RenderAtmosAngler(RenderManager manager)
    {
        super(manager, new ModelAtmosAngler(), 1.0F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAtmosAngler entity) {
        return SCORP_TEXTURE;
    }

    /*public void renderAngler(EntityAtmosAngler entityAngler, double d, double d1, double d2,
                             float f, float f1)
    {
        super.renderModel(entityAngler, d, d1, d2, f, f1);
    }

    public void a(md entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderAngler((EntityAtmosAngler)entityliving, d, d1, d2, f, f1);
    }

    public void a(lq entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderAngler((EntityAtmosAngler)entity, d, d1, d2, f, f1);
    }

    protected void preRenderScale(md entityliving, float f)
    {
        EntityAtmosAngler entityAngler = (EntityAtmosAngler)entityliving;
        if(entityAngler.isDiving())
            isDescending(entityliving);
        if(entityAngler.isRising())
            isAscending(entityliving);
    }

    protected void a(md entityliving, float f)
    {
        preRenderScale((EntityAtmosAngler)entityliving, f);
    }

    protected int setAnglerEyeBrightness(EntityAtmosAngler par1EntityAngler, int par2, float par3)
    {
        if(par2 != 0)
        {
            return -1;
        } else
        {
            a("/atmosmobs/seacreatures/angler_light.png");
            float f = 1.0F;
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            int i = 61680;
            int j = i % 0x10000;
            int k = i / 0x10000;
            bfe.a(bfe.b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
            return 1;
        }
    }

    protected void isDescending(md entityliving)
    {
        GL11.glRotatef(-45F, -1F, 0.0F, 0.0F);
    }

    protected void isAscending(md entityliving)
    {
        GL11.glRotatef(-315F, -1F, 0.0F, 0.0F);
    }

    protected int a(md par1EntityLiving, int par2, float par3)
    {
        return setAnglerEyeBrightness((EntityAtmosAngler)par1EntityLiving, par2, par3);
    }*/
}
