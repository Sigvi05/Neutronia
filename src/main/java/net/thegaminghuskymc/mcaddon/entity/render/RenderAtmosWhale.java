/*
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RenderAtmosWhale.java

package net.thegaminghuskymc.mcaddon.entity.render;

import axa;
import bcj;
import md;
import net.thegaminghuskymc.mcaddon.entity.EntityAtmosWhale;
import org.lwjgl.opengl.GL11;

// Referenced classes of package atmosmobs.watercreatures:
//            EntityAtmosWhale

public class RenderAtmosWhale extends bcj
{

    public RenderAtmosWhale(axa par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderWhale(EntityAtmosWhale par1EntityWhale, double par2, double par4, double par6,
                            float par8, float par9)
    {
        super.a(par1EntityWhale, par2, par4, par6, par8, par9);
    }

    public void a(md par1EntityLiving, double par2, double par4, double par6, 
            float par8, float par9)
    {
        renderWhale((EntityAtmosWhale)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    protected void scaleWhale(EntityAtmosWhale par1EntityWhale, float par2)
    {
        float f = par1EntityWhale.whaleScaleAmount();
        GL11.glScalef(f, f, f);
    }

    protected void a(md par1EntityLiving, float par2)
    {
        scaleWhale((EntityAtmosWhale)par1EntityLiving, par2);
    }
}
*/
