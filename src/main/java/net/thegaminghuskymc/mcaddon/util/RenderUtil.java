// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RenderUtil.java

package net.thegaminghuskymc.mcaddon.util;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class RenderUtil
{

    public RenderUtil()
    {
    }

    public static void renderBeam(BufferBuilder buf, double x1, double y1, double z1, double x2, double y2, double z2, float r1, float g1, 
            float b1, float a1, float r2, float g2, float b2, float a2, double width)
    {
        float yaw = (float)Math.atan2(x2 - x1, z2 - z1);
        float pitch = (float)Math.atan2(y2 - y1, MathHelper.sqrt(Math.pow(x2 - x1, 2D) + Math.pow(z2 - z1, 2D)));
        double tX1 = width * (double)MathHelper.cos(yaw);
        double tY1 = 0.0D;
        double tZ1 = -width * (double)MathHelper.sin(yaw);
        double tX2 = width * (double)MathHelper.sin(yaw) * -(double)MathHelper.sin(pitch);
        double tY2 = width * (double)MathHelper.cos(pitch);
        double tZ2 = width * (double)MathHelper.cos(yaw) * -(double)MathHelper.sin(pitch);
        buf.pos(x1 - tX1, y1 - tY1, z1 - tZ1).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        buf.pos(x2 - tX1, y2 - tY1, z2 - tZ1).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x2 + tX1, y2 + tY1, z2 + tZ1).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x1 + tX1, y1 + tY1, z1 + tZ1).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        buf.pos(x1 - tX2, y1 - tY2, z1 - tZ2).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        buf.pos(x2 - tX2, y2 - tY2, z2 - tZ2).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x2 + tX2, y2 + tY2, z2 + tZ2).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x1 + tX2, y1 + tY2, z1 + tZ2).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
    }

    public static void renderBeam(BufferBuilder buf, double x1, double y1, double z1, double x2, double y2, double z2, float r1, float g1, 
            float b1, float a1, float r2, float g2, float b2, float a2, double width1, double width2, double angle)
    {
        float rads = (float)Math.toRadians(angle);
        double ac = MathHelper.cos(rads);
        double as = MathHelper.sin(rads);
        float yaw = (float)Math.atan2(x2 - x1, z2 - z1);
        float pitch = (float)Math.atan2(y2 - y1, MathHelper.sqrt(Math.pow(x2 - x1, 2D) + Math.pow(z2 - z1, 2D)));
        double tX1 = MathHelper.cos(yaw);
        double tY1 = 0.0D;
        double tZ1 = -(double)MathHelper.sin(yaw);
        double tX2 = (double)MathHelper.sin(yaw) * -(double)MathHelper.sin(pitch);
        double tY2 = MathHelper.cos(pitch);
        double tZ2 = (double)MathHelper.cos(yaw) * -(double)MathHelper.sin(pitch);
        double tXc1 = width1 * (tX1 * ac + tX2 * as);
        double tYc1 = width1 * (tY1 * ac + tY2 * as);
        double tZc1 = width1 * (tZ1 * ac + tZ2 * as);
        double tXs1 = width1 * (tX1 * -as + tX2 * ac);
        double tYs1 = width1 * (tY1 * -as + tY2 * ac);
        double tZs1 = width1 * (tZ1 * -as + tZ2 * ac);
        double tXc2 = width2 * (tX1 * ac + tX2 * as);
        double tYc2 = width2 * (tY1 * ac + tY2 * as);
        double tZc2 = width2 * (tZ1 * ac + tZ2 * as);
        double tXs2 = width2 * (tX1 * -as + tX2 * ac);
        double tYs2 = width2 * (tY1 * -as + tY2 * ac);
        double tZs2 = width2 * (tZ1 * -as + tZ2 * ac);
        buf.pos(x1 - tXs1, y1 - tYs1, z1 - tZs1).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        buf.pos(x2 - tXs2, y2 - tYs2, z2 - tZs2).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x2 + tXs2, y2 + tYs2, z2 + tZs2).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x1 + tXs1, y1 + tYs1, z1 + tZs1).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        buf.pos(x1 - tXc1, y1 - tYc1, z1 - tZc1).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        buf.pos(x2 - tXc2, y2 - tYc2, z2 - tZc2).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x2 + tXc2, y2 + tYc2, z2 + tZc2).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x1 + tXc1, y1 + tYc1, z1 + tZc1).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
    }

    public static void renderBeam(BufferBuilder buf, double x1, double y1, double z1, double x2, double y2, double z2, float r1, float g1, 
            float b1, float a1, float r2, float g2, float b2, float a2, double width, double angle)
    {
        float rads = (float)Math.toRadians(angle);
        double ac = MathHelper.cos(rads);
        double as = MathHelper.sin(rads);
        float yaw = (float)Math.atan2(x2 - x1, z2 - z1);
        float pitch = (float)Math.atan2(y2 - y1, MathHelper.sqrt(Math.pow(x2 - x1, 2D) + Math.pow(z2 - z1, 2D)));
        double tX1 = width * (double)MathHelper.cos(yaw);
        double tY1 = 0.0D;
        double tZ1 = -width * (double)MathHelper.sin(yaw);
        double tX2 = width * (double)MathHelper.sin(yaw) * -(double)MathHelper.sin(pitch);
        double tY2 = width * (double)MathHelper.cos(pitch);
        double tZ2 = width * (double)MathHelper.cos(yaw) * -(double)MathHelper.sin(pitch);
        double tXc = tX1 * ac + tX2 * as;
        double tYc = tY1 * ac + tY2 * as;
        double tZc = tZ1 * ac + tZ2 * as;
        double tXs = tX1 * -as + tX2 * ac;
        double tYs = tY1 * -as + tY2 * ac;
        double tZs = tZ1 * -as + tZ2 * ac;
        buf.pos(x1 - tXs, y1 - tYs, z1 - tZs).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        buf.pos(x2 - tXs, y2 - tYs, z2 - tZs).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x2 + tXs, y2 + tYs, z2 + tZs).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x1 + tXs, y1 + tYs, z1 + tZs).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        buf.pos(x1 - tXc, y1 - tYc, z1 - tZc).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        buf.pos(x2 - tXc, y2 - tYc, z2 - tZc).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x2 + tXc, y2 + tYc, z2 + tZc).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x1 + tXc, y1 + tYc, z1 + tZc).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
    }

    public static void renderBeamGui(BufferBuilder buf, double x1, double y1, double x2, double y2, float r1, float g1, float b1, float a1, float r2, float g2, 
            float b2, float a2, double width)
    {
        float yaw = (float)Math.atan2(y2 - y1, x2 - x1);
        double tX1 = -width * (double)MathHelper.sin(yaw);
        double tY1 = width * (double)MathHelper.cos(yaw);
        buf.pos(x1 - tX1, y1 - tY1, 0.0D).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        buf.pos(x2 - tX1, y2 - tY1, 0.0D).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x2 + tX1, y2 + tY1, 0.0D).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        buf.pos(x1 + tX1, y1 + tY1, 0.0D).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
    }

    public static void renderBeamSeriesGui(BufferBuilder buf, double x1, double y1, double x2, double y2, float r1, float g1, float b1, float a1, double width, 
            boolean horiz)
    {
        float yaw2 = (float)Math.atan2(y2 - y1, x2 - x1);
        double tX1 = width * (double)MathHelper.cos(yaw2);
        double tY1 = -width * (double)MathHelper.sin(yaw2);
        buf.pos(x1 - tX1, y1 - tY1, 0.0D).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        buf.pos(x1 + tX1, y1 + tY1, 0.0D).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
    }

    public static void renderBeamSeries(BufferBuilder buf, double x1, double y1, double z1, double x2, double y2, double z2, float r1, float g1, 
            float b1, float a1, double width, boolean horiz)
    {
        float yaw2 = (float)Math.atan2(x2 - x1, z2 - z1);
        float pitch2 = (float)Math.atan2(y2 - y1, MathHelper.sqrt(Math.pow(x2 - x1, 2D) + Math.pow(z2 - z1, 2D)));
        double tX1 = width * (double)MathHelper.cos(yaw2);
        double tY1 = 0.0D;
        double tZ1 = -width * (double)MathHelper.sin(yaw2);
        double tX2 = width * (double)MathHelper.sin(yaw2) * -(double)MathHelper.sin(pitch2);
        double tY2 = width * (double)MathHelper.cos(pitch2);
        double tZ2 = width * (double)MathHelper.cos(yaw2) * -(double)MathHelper.sin(pitch2);
        if(horiz)
        {
            buf.pos(x1 - tX1, y1 - tY1, z1 - tZ1).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
            buf.pos(x1 + tX1, y1 + tY1, z1 + tZ1).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        } else
        {
            buf.pos(x1 - tX2, y1 - tY2, z1 - tZ2).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
            buf.pos(x1 + tX2, y1 + tY2, z1 + tZ2).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        }
    }

    public static void renderSlash(BufferBuilder buf, double x0, double y0, double z0, float r, 
            float g, float b, float a, float radius, float width, float angleRange)
    {
        for(float i = -angleRange / 2.0F; i < angleRange / 2.0F; i += angleRange / 16F)
        {
            float coeff1 = 1.0F - Math.abs(i) / (angleRange / 2.0F);
            float coeff2 = 1.0F - Math.abs(i + angleRange / 16F) / (angleRange / 2.0F);
            double x1 = x0 + (double)radius * Math.sin(Math.toRadians(i));
            double z1 = z0 + (double)radius * Math.cos(Math.toRadians(i));
            double x2 = x0 + (double)(radius + 0.5F * coeff1 * width) * Math.sin(Math.toRadians(i));
            double z2 = z0 + (double)(radius + 0.5F * coeff1 * width) * Math.cos(Math.toRadians(i));
            double x3 = x0 + (double)(radius + 0.5F * coeff2 * width) * Math.sin(Math.toRadians(i + angleRange / 16F));
            double z3 = z0 + (double)(radius + 0.5F * coeff2 * width) * Math.cos(Math.toRadians(i + angleRange / 16F));
            double x4 = x0 + (double)radius * Math.sin(Math.toRadians(i + angleRange / 16F));
            double z4 = z0 + (double)radius * Math.cos(Math.toRadians(i + angleRange / 16F));
            buf.pos(x1, y0, z1 - (double)(radius / 2.0F)).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff1).endVertex();
            buf.pos(x2, y0, z2 - (double)(radius / 2.0F)).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff1).endVertex();
            buf.pos(x3, y0, z3 - (double)(radius / 2.0F)).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff2).endVertex();
            buf.pos(x4, y0, z4 - (double)(radius / 2.0F)).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff2).endVertex();
            x1 = x0 + (double)radius * Math.sin(Math.toRadians(i));
            z1 = z0 + (double)radius * Math.cos(Math.toRadians(i));
            x2 = x0 + (double)(radius - 0.5F * coeff1 * width) * Math.sin(Math.toRadians(i));
            z2 = z0 + (double)(radius - 0.5F * coeff1 * width) * Math.cos(Math.toRadians(i));
            x3 = x0 + (double)(radius - 0.5F * coeff2 * width) * Math.sin(Math.toRadians(i + angleRange / 16F));
            z3 = z0 + (double)(radius - 0.5F * coeff2 * width) * Math.cos(Math.toRadians(i + angleRange / 16F));
            x4 = x0 + (double)radius * Math.sin(Math.toRadians(i + angleRange / 16F));
            z4 = z0 + (double)radius * Math.cos(Math.toRadians(i + angleRange / 16F));
            buf.pos(x1, y0, z1 - (double)(radius / 2.0F)).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff1).endVertex();
            buf.pos(x2, y0, z2 - (double)(radius / 2.0F)).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff1).endVertex();
            buf.pos(x3, y0, z3 - (double)(radius / 2.0F)).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff2).endVertex();
            buf.pos(x4, y0, z4 - (double)(radius / 2.0F)).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff2).endVertex();
            buf.pos(x1, y0, z1 - (double)(radius / 2.0F)).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff1).endVertex();
            buf.pos(x2, y0, z2 - (double)(radius / 2.0F)).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff1).endVertex();
            buf.pos(x3, y0, z3 - (double)(radius / 2.0F)).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff2).endVertex();
            buf.pos(x4, y0, z4 - (double)(radius / 2.0F)).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff2).endVertex();
            x1 = x0 + (double)radius * Math.sin(Math.toRadians(i));
            z1 = z0 + (double)radius * Math.cos(Math.toRadians(i));
            x2 = x0 + (double)radius * Math.sin(Math.toRadians(i));
            z2 = z0 + (double)radius * Math.cos(Math.toRadians(i));
            x3 = x0 + (double)radius * Math.sin(Math.toRadians(i + angleRange / 16F));
            z3 = z0 + (double)radius * Math.cos(Math.toRadians(i + angleRange / 16F));
            x4 = x0 + (double)radius * Math.sin(Math.toRadians(i + angleRange / 16F));
            z4 = z0 + (double)radius * Math.cos(Math.toRadians(i + angleRange / 16F));
            buf.pos(x1, y0, z1 - (double)(radius / 2.0F)).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff1).endVertex();
            buf.pos(x2, y0 - (double)(width * 0.5F * coeff1), z2 - (double)(radius / 2.0F)).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff1).endVertex();
            buf.pos(x3, y0 - (double)(width * 0.5F * coeff2), z3 - (double)(radius / 2.0F)).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff2).endVertex();
            buf.pos(x4, y0, z4 - (double)(radius / 2.0F)).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff2).endVertex();
            buf.pos(x1, y0, z1 - (double)(radius / 2.0F)).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff1).endVertex();
            buf.pos(x2, y0 + (double)(width * 0.5F * coeff1), z2 - (double)(radius / 2.0F)).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff1).endVertex();
            buf.pos(x3, y0 + (double)(width * 0.5F * coeff2), z3 - (double)(radius / 2.0F)).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff2).endVertex();
            buf.pos(x4, y0, z4 - (double)(radius / 2.0F)).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r, g, b, a * coeff2).endVertex();
        }

    }

    public static void renderBeamSeries(BufferBuilder buf, double x0, double y0, double z0, double x1, double y1, double z1, double x2, 
            double y2, double z2, float r1, float g1, float b1, 
            float a1, float r2, float g2, float b2, float a2)
    {
        float yaw1 = (float)Math.atan2(x1 - x0, z1 - z0);
        float pitch1 = (float)Math.atan2(y1 - y0, MathHelper.sqrt(Math.pow(x1 - x0, 2D) + Math.pow(z1 - z0, 2D)));
        float yaw2 = (float)Math.atan2(x2 - x1, z2 - z1);
        float pitch2 = (float)Math.atan2(y2 - y1, MathHelper.sqrt(Math.pow(x2 - x1, 2D) + Math.pow(z2 - z1, 2D)));
        double iX1 = 0.20000000000000001D * (double)MathHelper.cos(yaw1);
        double iY1 = 0.0D;
        double iZ1 = -0.20000000000000001D * (double)MathHelper.sin(yaw1);
        double iX2 = 0.20000000000000001D * (double)MathHelper.sin(yaw1) * -(double)MathHelper.sin(pitch1);
        double iY2 = 0.20000000000000001D * (double)MathHelper.cos(pitch1);
        double iZ2 = 0.20000000000000001D * (double)MathHelper.cos(yaw1) * -(double)MathHelper.sin(pitch1);
        double tX1 = 0.20000000000000001D * (double)MathHelper.cos(yaw2);
        double tY1 = 0.0D;
        double tZ1 = -0.20000000000000001D * (double)MathHelper.sin(yaw2);
        double tX2 = 0.20000000000000001D * (double)MathHelper.sin(yaw2) * -(double)MathHelper.sin(pitch2);
        double tY2 = 0.20000000000000001D * (double)MathHelper.cos(pitch2);
        double tZ2 = 0.20000000000000001D * (double)MathHelper.cos(yaw2) * -(double)MathHelper.sin(pitch2);
        if(Math.signum(tX1) != Math.signum(iX1) || Math.signum(tY1) != Math.signum(iY1) || Math.signum(tZ1) != Math.signum(iZ1))
        {
            buf.pos(x2 - tX1, y2 - tY1, z2 - tZ1).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
            buf.pos(x1 + iX1, y1 + iY1, z1 + iZ1).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
            buf.pos(x1 - iX1, y1 - iY1, z1 - iZ1).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
            buf.pos(x2 + tX1, y2 + tY1, z2 + tZ1).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        } else
        {
            buf.pos(x1 - iX1, y1 - iY1, z1 - iZ1).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
            buf.pos(x2 - tX1, y2 - tY1, z2 - tZ1).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
            buf.pos(x2 + tX1, y2 + tY1, z2 + tZ1).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
            buf.pos(x1 + iX1, y1 + iY1, z1 + iZ1).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        }
        if(Math.signum(tX2) != Math.signum(iX2) || Math.signum(tY2) != Math.signum(iY2) || Math.signum(tZ2) != Math.signum(iZ2))
        {
            buf.pos(x2 - tX2, y2 - tY2, z2 - tZ2).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
            buf.pos(x1 + iX2, y1 + iY2, z1 + iZ2).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
            buf.pos(x1 - iX2, y1 - iY2, z1 - iZ2).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
            buf.pos(x2 + tX2, y2 + tY2, z2 + tZ2).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
        } else
        {
            buf.pos(x1 - iX2, y1 - iY2, z1 - iZ2).tex(0.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
            buf.pos(x2 - tX2, y2 - tY2, z2 - tZ2).tex(1.0D, 0.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
            buf.pos(x2 + tX2, y2 + tY2, z2 + tZ2).tex(1.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r2, g2, b2, a2).endVertex();
            buf.pos(x1 + iX2, y1 + iY2, z1 + iZ2).tex(0.0D, 1.0D).lightmap(maxLightX, maxLightY).color(r1, g1, b1, a1).endVertex();
        }
    }

    public static void drawTextRGBA(FontRenderer font, String s, int x, int y, int r, int g, int b, int a)
    {
        font.drawString(s, x, y, (a << 24) + (r << 16) + (g << 8) + b);
    }

    public static void renderStarBurst(BufferBuilder buf, double x, double y, double z, float r, 
            float g, float b, float a, double width, double radius)
    {
        for(double i = -1.5707963267948966D; i <= 1.5707963267948966D; i += 0.39269908169872414D)
        {
            for(double j = 0.0D; j < 6.2831853071795862D; j += 3.1415926535897931D * (0.75D * Math.abs(i / 1.5707963267948966D) + 0.25D))
            {
                double si = (double)((float)80F) * (0.375D + (0.77300000000000002D * j) / 6.2831853071795862D) * (0.25D + (1.2250000000000001D * i) / 3.1415926535897931D) * 3.1415926535897931D * 2D;
                double sj = (double)((float)57F) * (0.25D + (1.6299999999999999D * i) / 1.5707963267948966D) * (0.375D + (0.24099999999999999D * j) / 3.1415926535897931D) * 3.1415926535897931D * 2D;
                double dx = radius * Math.sin(sj) * Math.cos(si);
                double dy = radius * Math.sin(si);
                double dz = radius * Math.cos(sj) * Math.cos(si);
                renderBeam(buf, x + dx * 0.25D, y + dy * 0.25D, z + dz * 0.25D, x + dx * 0.375D, y + dy * 0.375D, z + dz * 0.375D, r, g, b, 0.0F, r, g, b, a, width);
                renderBeam(buf, x + dx * 0.375D, y + dy * 0.375D, z + dz * 0.375D, x + dx, y + dy, z + dz, r, g, b, a, r, g, b, 0.0F, width);
            }

        }

    }

    public static void renderBeamCircle(BufferBuilder buf, double x, double y, double z, float r, 
            float g, float b, float a, double width, double radius, 
            int steps, boolean horiz)
    {
        for(double i = 0.0D; i <= 6.2831853071795862D; i += 3.1415926535897931D * (2D / (double)steps))
        {
            double x1 = x + Math.sin(i) * radius;
            double z1 = z + Math.cos(i) * radius;
            double x2 = x + Math.sin(i + 3.1415926535897931D * (2D / (double)steps)) * radius;
            double z2 = z + Math.cos(i + 3.1415926535897931D * (2D / (double)steps)) * radius;
            renderBeamSeries(buf, x1, y, z1, x2, y, z2, r, g, b, a, width, horiz);
        }

    }

    public static void drawCrystal(BufferBuilder buf, float x, float y, float z, float r, float g, float b, float a, 
            float rotation, float hsize, float ysize, float minU, float minV, float maxU, float maxV)
    {
        float offX1 = hsize * 0.5F * (float)Math.sin(Math.toRadians(rotation));
        float offZ1 = hsize * 0.5F * (float)Math.cos(Math.toRadians(rotation));
        float offX2 = hsize * 0.5F * (float)Math.sin(Math.toRadians(rotation + 90F));
        float offZ2 = hsize * 0.5F * (float)Math.cos(Math.toRadians(rotation + 90F));
        float pos1X = x;
        double pos1Y = y - ysize * 0.5F;
        double pos1Z = z;
        double pos2X = x + offX1;
        double pos2Y = y;
        double pos2Z = z + offZ1;
        double pos3X = x + offX2;
        double pos3Y = y;
        double pos3Z = z + offZ2;
        double pos4X = x - offX1;
        double pos4Y = y;
        double pos4Z = z - offZ1;
        double pos5X = x - offX2;
        double pos5Y = y;
        double pos5Z = z - offZ2;
        double pos6X = x;
        double pos6Y = y + ysize * 0.5F;
        double pos6Z = z;
        Vec3d diff1 = new Vec3d(pos3X - (double)pos1X, pos3Y - pos1Y, pos3Z - pos1Z);
        Vec3d diff2 = new Vec3d(pos2X - (double)pos1X, pos2Y - pos1Y, pos2Z - pos1Z);
        Vec3d normal1 = (new Vec3d(diff1.y * diff2.z - diff1.z * diff2.y, diff1.x * diff2.z - diff1.z * diff2.x, diff1.x * diff2.y - diff1.y * diff2.x)).normalize().scale(-1D);
        Vec3d normal2 = (new Vec3d(normal1.z, -normal1.y, normal1.x)).scale(-1D);
        Vec3d normal3 = (new Vec3d(-normal1.x, -normal1.y, -normal1.z)).scale(-1D);
        Vec3d normal4 = (new Vec3d(-normal1.z, -normal1.y, -normal1.x)).scale(-1D);
        Vec3d normal5 = (new Vec3d(normal1.x, normal1.y, normal1.z)).scale(-1D);
        Vec3d normal6 = (new Vec3d(normal1.z, normal1.y, normal1.x)).scale(-1D);
        Vec3d normal7 = (new Vec3d(-normal1.x, normal1.y, -normal1.z)).scale(-1D);
        Vec3d normal8 = (new Vec3d(-normal1.z, normal1.y, -normal1.x)).scale(-1D);
        normal1 = (new Vec3d(normal1.x, -normal1.y, normal1.z)).scale(-1D);
        buf.pos(pos1X, pos1Y, pos1Z).tex((double)(minU + maxU) / 2D, maxV).color(r, g, b, a).normal((float)normal1.x, (float)normal1.y, (float)normal1.z).endVertex();
        buf.pos(pos2X, pos2Y, pos2Z).tex(minU, minV).color(r, g, b, a).normal((float)normal1.x, (float)normal1.y, (float)normal1.z).endVertex();
        buf.pos(pos3X, pos3Y, pos3Z).tex(maxU, minV).color(r, g, b, a).normal((float)normal1.x, (float)normal1.y, (float)normal1.z).endVertex();
        buf.pos(pos1X, pos1Y, pos1Z).tex((double)(minU + maxU) / 2D, maxV).color(r, g, b, a).normal((float)normal2.x, (float)normal2.y, (float)normal2.z).endVertex();
        buf.pos(pos3X, pos3Y, pos3Z).tex(minU, minV).color(r, g, b, a).normal((float)normal2.x, (float)normal2.y, (float)normal2.z).endVertex();
        buf.pos(pos4X, pos4Y, pos4Z).tex(maxU, minV).color(r, g, b, a).normal((float)normal2.x, (float)normal2.y, (float)normal2.z).endVertex();
        buf.pos(pos1X, pos1Y, pos1Z).tex((double)(minU + maxU) / 2D, maxV).color(r, g, b, a).normal((float)normal3.x, (float)normal3.y, (float)normal3.z).endVertex();
        buf.pos(pos4X, pos4Y, pos4Z).tex(minU, minV).color(r, g, b, a).normal((float)normal3.x, (float)normal3.y, (float)normal3.z).endVertex();
        buf.pos(pos5X, pos5Y, pos5Z).tex(maxU, minV).color(r, g, b, a).normal((float)normal3.x, (float)normal3.y, (float)normal3.z).endVertex();
        buf.pos(pos1X, pos1Y, pos1Z).tex((double)(minU + maxU) / 2D, maxV).color(r, g, b, a).normal((float)normal4.x, (float)normal4.y, (float)normal4.z).endVertex();
        buf.pos(pos5X, pos5Y, pos5Z).tex(minU, minV).color(r, g, b, a).normal((float)normal4.x, (float)normal4.y, (float)normal4.z).endVertex();
        buf.pos(pos2X, pos2Y, pos2Z).tex(maxU, minV).color(r, g, b, a).normal((float)normal4.x, (float)normal4.y, (float)normal4.z).endVertex();
        buf.pos(pos6X, pos6Y, pos6Z).tex((double)(minU + maxU) / 2D, minV).color(r, g, b, a).normal((float)normal5.x, (float)normal5.y, (float)normal5.z).endVertex();
        buf.pos(pos2X, pos2Y, pos2Z).tex(minU, maxV).color(r, g, b, a).normal((float)normal5.x, (float)normal5.y, (float)normal5.z).endVertex();
        buf.pos(pos3X, pos3Y, pos3Z).tex(maxU, maxV).color(r, g, b, a).normal((float)normal5.x, (float)normal5.y, (float)normal5.z).endVertex();
        buf.pos(pos6X, pos6Y, pos6Z).tex((double)(minU + maxU) / 2D, minV).color(r, g, b, a).normal((float)normal6.x, (float)normal6.y, (float)normal6.z).endVertex();
        buf.pos(pos3X, pos3Y, pos3Z).tex(minU, maxV).color(r, g, b, a).normal((float)normal6.x, (float)normal6.y, (float)normal6.z).endVertex();
        buf.pos(pos4X, pos4Y, pos4Z).tex(maxU, maxV).color(r, g, b, a).normal((float)normal6.x, (float)normal6.y, (float)normal6.z).endVertex();
        buf.pos(pos6X, pos6Y, pos6Z).tex((double)(minU + maxU) / 2D, minV).color(r, g, b, a).normal((float)normal7.x, (float)normal7.y, (float)normal7.z).endVertex();
        buf.pos(pos4X, pos4Y, pos4Z).tex(minU, maxV).color(r, g, b, a).normal((float)normal7.x, (float)normal7.y, (float)normal7.z).endVertex();
        buf.pos(pos5X, pos5Y, pos5Z).tex(maxU, maxV).color(r, g, b, a).normal((float)normal7.x, (float)normal7.y, (float)normal7.z).endVertex();
        buf.pos(pos6X, pos6Y, pos6Z).tex((double)(minU + maxU) / 2D, minV).color(r, g, b, a).normal((float)normal8.x, (float)normal8.y, (float)normal8.z).endVertex();
        buf.pos(pos5X, pos5Y, pos5Z).tex(minU, maxV).color(r, g, b, a).normal((float)normal8.x, (float)normal8.y, (float)normal8.z).endVertex();
        buf.pos(pos2X, pos2Y, pos2Z).tex(maxU, maxV).color(r, g, b, a).normal((float)normal8.x, (float)normal8.y, (float)normal8.z).endVertex();
    }

    public static void drawCrystal(BufferBuilder b, float x, float y, float z, float rotation, float hsize, float ysize, float minU, 
            float minV, float maxU, float maxV)
    {
        float offX1 = hsize * 0.5F * (float)Math.sin(Math.toRadians(rotation));
        float offZ1 = hsize * 0.5F * (float)Math.cos(Math.toRadians(rotation));
        float offX2 = hsize * 0.5F * (float)Math.sin(Math.toRadians(rotation + 90F));
        float offZ2 = hsize * 0.5F * (float)Math.cos(Math.toRadians(rotation + 90F));
        float pos1X = x;
        double pos1Y = y - ysize * 0.5F;
        double pos1Z = z;
        double pos2X = x + offX1;
        double pos2Y = y;
        double pos2Z = z + offZ1;
        double pos3X = x + offX2;
        double pos3Y = y;
        double pos3Z = z + offZ2;
        double pos4X = x - offX1;
        double pos4Y = y;
        double pos4Z = z - offZ1;
        double pos5X = x - offX2;
        double pos5Y = y;
        double pos5Z = z - offZ2;
        double pos6X = x;
        double pos6Y = y + ysize * 0.5F;
        double pos6Z = z;
        Vec3d diff1 = new Vec3d(pos3X - (double)pos1X, pos3Y - pos1Y, pos3Z - pos1Z);
        Vec3d diff2 = new Vec3d(pos2X - (double)pos1X, pos2Y - pos1Y, pos2Z - pos1Z);
        Vec3d normal1 = (new Vec3d(diff1.y * diff2.z - diff1.z * diff2.y, diff1.x * diff2.z - diff1.z * diff2.x, diff1.x * diff2.y - diff1.y * diff2.x)).normalize().scale(-1D);
        Vec3d normal2 = (new Vec3d(normal1.z, -normal1.y, normal1.x)).scale(-1D);
        Vec3d normal3 = (new Vec3d(-normal1.x, -normal1.y, -normal1.z)).scale(-1D);
        Vec3d normal4 = (new Vec3d(-normal1.z, -normal1.y, -normal1.x)).scale(-1D);
        Vec3d normal5 = (new Vec3d(normal1.x, normal1.y, normal1.z)).scale(-1D);
        Vec3d normal6 = (new Vec3d(normal1.z, normal1.y, normal1.x)).scale(-1D);
        Vec3d normal7 = (new Vec3d(-normal1.x, normal1.y, -normal1.z)).scale(-1D);
        Vec3d normal8 = (new Vec3d(-normal1.z, normal1.y, -normal1.x)).scale(-1D);
        normal1 = (new Vec3d(normal1.x, -normal1.y, normal1.z)).scale(-1D);
        b.pos(pos1X, pos1Y, pos1Z).tex((double)(minU + maxU) / 2D, maxV).color(255, 255, 255, 255).normal((float)normal1.x, (float)normal1.y, (float)normal1.z).endVertex();
        b.pos(pos2X, pos2Y, pos2Z).tex(minU, minV).color(255, 255, 255, 255).normal((float)normal1.x, (float)normal1.y, (float)normal1.z).endVertex();
        b.pos(pos3X, pos3Y, pos3Z).tex(maxU, minV).color(255, 255, 255, 255).normal((float)normal1.x, (float)normal1.y, (float)normal1.z).endVertex();
        b.pos(pos1X, pos1Y, pos1Z).tex((double)(minU + maxU) / 2D, maxV).color(255, 255, 255, 255).normal((float)normal2.x, (float)normal2.y, (float)normal2.z).endVertex();
        b.pos(pos3X, pos3Y, pos3Z).tex(minU, minV).color(255, 255, 255, 255).normal((float)normal2.x, (float)normal2.y, (float)normal2.z).endVertex();
        b.pos(pos4X, pos4Y, pos4Z).tex(maxU, minV).color(255, 255, 255, 255).normal((float)normal2.x, (float)normal2.y, (float)normal2.z).endVertex();
        b.pos(pos1X, pos1Y, pos1Z).tex((double)(minU + maxU) / 2D, maxV).color(255, 255, 255, 255).normal((float)normal3.x, (float)normal3.y, (float)normal3.z).endVertex();
        b.pos(pos4X, pos4Y, pos4Z).tex(minU, minV).color(255, 255, 255, 255).normal((float)normal3.x, (float)normal3.y, (float)normal3.z).endVertex();
        b.pos(pos5X, pos5Y, pos5Z).tex(maxU, minV).color(255, 255, 255, 255).normal((float)normal3.x, (float)normal3.y, (float)normal3.z).endVertex();
        b.pos(pos1X, pos1Y, pos1Z).tex((double)(minU + maxU) / 2D, maxV).color(255, 255, 255, 255).normal((float)normal4.x, (float)normal4.y, (float)normal4.z).endVertex();
        b.pos(pos5X, pos5Y, pos5Z).tex(minU, minV).color(255, 255, 255, 255).normal((float)normal4.x, (float)normal4.y, (float)normal4.z).endVertex();
        b.pos(pos2X, pos2Y, pos2Z).tex(maxU, minV).color(255, 255, 255, 255).normal((float)normal4.x, (float)normal4.y, (float)normal4.z).endVertex();
        b.pos(pos6X, pos6Y, pos6Z).tex((double)(minU + maxU) / 2D, minV).color(255, 255, 255, 255).normal((float)normal5.x, (float)normal5.y, (float)normal5.z).endVertex();
        b.pos(pos2X, pos2Y, pos2Z).tex(minU, maxV).color(255, 255, 255, 255).normal((float)normal5.x, (float)normal5.y, (float)normal5.z).endVertex();
        b.pos(pos3X, pos3Y, pos3Z).tex(maxU, maxV).color(255, 255, 255, 255).normal((float)normal5.x, (float)normal5.y, (float)normal5.z).endVertex();
        b.pos(pos6X, pos6Y, pos6Z).tex((double)(minU + maxU) / 2D, minV).color(255, 255, 255, 255).normal((float)normal6.x, (float)normal6.y, (float)normal6.z).endVertex();
        b.pos(pos3X, pos3Y, pos3Z).tex(minU, maxV).color(255, 255, 255, 255).normal((float)normal6.x, (float)normal6.y, (float)normal6.z).endVertex();
        b.pos(pos4X, pos4Y, pos4Z).tex(maxU, maxV).color(255, 255, 255, 255).normal((float)normal6.x, (float)normal6.y, (float)normal6.z).endVertex();
        b.pos(pos6X, pos6Y, pos6Z).tex((double)(minU + maxU) / 2D, minV).color(255, 255, 255, 255).normal((float)normal7.x, (float)normal7.y, (float)normal7.z).endVertex();
        b.pos(pos4X, pos4Y, pos4Z).tex(minU, maxV).color(255, 255, 255, 255).normal((float)normal7.x, (float)normal7.y, (float)normal7.z).endVertex();
        b.pos(pos5X, pos5Y, pos5Z).tex(maxU, maxV).color(255, 255, 255, 255).normal((float)normal7.x, (float)normal7.y, (float)normal7.z).endVertex();
        b.pos(pos6X, pos6Y, pos6Z).tex((double)(minU + maxU) / 2D, minV).color(255, 255, 255, 255).normal((float)normal8.x, (float)normal8.y, (float)normal8.z).endVertex();
        b.pos(pos5X, pos5Y, pos5Z).tex(minU, maxV).color(255, 255, 255, 255).normal((float)normal8.x, (float)normal8.y, (float)normal8.z).endVertex();
        b.pos(pos2X, pos2Y, pos2Z).tex(maxU, maxV).color(255, 255, 255, 255).normal((float)normal8.x, (float)normal8.y, (float)normal8.z).endVertex();
    }

    public static void setTransform(ItemCameraTransforms.TransformType t)
    {
        itemTransformType = t;
    }

    public static void setTransformGUI()
    {
        itemTransformType = ItemCameraTransforms.TransformType.GUI;
    }

    public static ResourceLocation beam_texture = new ResourceLocation("elulib:textures/effect/beam.png");
    public static ResourceLocation glow_texture = new ResourceLocation("elulib:textures/effect/glow.png");
    public static int maxLightX = 0xf000f0;
    public static int maxLightY = 0xf000f0;
    public static ItemCameraTransforms.TransformType itemTransformType;

    static 
    {
        itemTransformType = ItemCameraTransforms.TransformType.NONE;
    }
}
