// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MathUtil.java

package net.thegaminghuskymc.mcaddon.util;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class MathUtil
{

    public MathUtil()
    {
    }

    public static double nclamp(double d, double n)
    {
        return d - Math.floor(d / n) * n;
    }

    public static Vec3d rotateX(Vec3d v, float angle)
    {
        return new Vec3d(v.x * (double)MathHelper.cos(angle) - v.y * (double)MathHelper.sin(angle), v.x * (double)MathHelper.sin(angle) + v.y * (double)MathHelper.cos(angle), v.z);
    }

    public static Vec3d rotateZ(Vec3d v, float angle)
    {
        return new Vec3d(v.x, v.y * (double)MathHelper.cos(angle) - v.z * (double)MathHelper.sin(angle), v.y * (double)MathHelper.sin(angle) + v.z * (double)MathHelper.cos(angle));
    }

    public static Vec3d rotateY(Vec3d v, float angle)
    {
        return new Vec3d(v.z * (double)MathHelper.cos(angle) - v.x * (double)MathHelper.sin(angle), v.y, v.z * (double)MathHelper.sin(angle) + v.x * (double)MathHelper.cos(angle));
    }
}
