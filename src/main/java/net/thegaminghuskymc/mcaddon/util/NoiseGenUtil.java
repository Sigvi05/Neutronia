// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NoiseGenUtil.java

package net.thegaminghuskymc.mcaddon.util;

import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class NoiseGenUtil
{

    public NoiseGenUtil()
    {
    }

    public static float getNoise(long seed, int x, int y)
    {
        random.setSeed(simple_hash(new int[] {
            (int)seed, (int)(seed << 32), (int)Math.signum(y) * 512 + 512, (int)Math.signum(x) * 512 + 512, x, y
        }, 5));
        return random.nextFloat();
    }

    public static Random getRandom(int args[])
    {
        return new Random(simple_hash(args, args.length));
    }

    public static long getSeed(int seed, int x, int y)
    {
        return (long)simple_hash(new int[] {
            seed, (int)Math.signum(y) * 512 + 512, (int)Math.signum(x) * 512 + 512, x, y
        }, 5);
    }

    public static int simple_hash(int is[], int count)
    {
        int hash = 0x4c856cf;
        for(int i = 0; i < count; i++)
            hash = hash << 4 ^ hash >> 28 ^ (is[i] * 5449) % 0x1fe5b;

        return hash % 0x47d67ab;
    }

    public static float get2DNoise(long seed, int x, int z)
    {
        return (float)Math.pow((80F * getOctave(seed, x, z, 112) + 20F * getOctave(seed, x, z, 68) + 6F * getOctave(seed, x, z, 34) + 4F * getOctave(seed, x, z, 21) + 2.0F * getOctave(seed, x, z, 11) + 1.0F * getOctave(seed, x, z, 4)) / 93F, 1.6000000238418579D);
    }

    public static float fastSin(float x)
    {
        if((double)x < -3.1415926500000002D)
            x = (float)((double)x + 6.2831853100000004D);
        else
        if((double)x > 3.1415926500000002D)
            x = (float)((double)x - 6.2831853100000004D);
        if(x < 0.0F)
            return (float)(1.2732395400000001D * (double)x + 0.40528473500000001D * (double)x * (double)x);
        else
            return (float)(1.2732395400000001D * (double)x - 0.40528473500000001D * (double)x * (double)x);
    }

    public static float fastCos(float x)
    {
        if((double)x < -3.1415926500000002D)
            x = (float)((double)x + 6.2831853100000004D);
        else
        if((double)x > 3.1415926500000002D)
            x = (float)((double)x - 6.2831853100000004D);
        x = (float)((double)x + 1.5707963199999999D);
        if((double)x > 3.1415926500000002D)
            x = (float)((double)x - 6.2831853100000004D);
        if(x < 0.0F)
            return (float)(1.2732395400000001D * (double)x + 0.40528473500000001D * (double)x * (double)x);
        else
            return (float)(1.2732395400000001D * (double)x - 0.40528473500000001D * (double)x * (double)x);
    }

    public static float interpolate(float s, float e, float t)
    {
        float t2 = (1.0F - fastCos(t * 3.141593F)) / 2.0F;
        return s * (1.0F - t2) + e * t2;
    }

    public static float interpolate(float s, float e, float t, float phase, float mult)
    {
        float t2 = 1.0F - MathHelper.cos(mult * (t * 3.141593F + phase)) / 2.0F;
        float coeff = (0.5F - Math.abs(0.5F - t)) / 0.5F;
        float t3 = t * (1.0F - coeff) + t2 * coeff;
        return s * (1.0F - t3) + e * t3;
    }

    public static float lerp(float s, float e, float t)
    {
        return s * (1.0F - t) + e * t;
    }

    public static float bilinear(float ul, float ur, float dr, float dl, float t1, float t2)
    {
        return interpolate(interpolate(ul, ur, t1), interpolate(dl, dr, t1), t2);
    }

    public static float getOctave(long seed, int x, int y, int dimen)
    {
        return bilinear(getNoise(seed, (int)Math.floor((float)x / (float)dimen) * dimen, (int)Math.floor((float)y / (float)dimen) * dimen), getNoise(seed, (int)Math.floor((float)x / (float)dimen) * dimen + dimen, (int)Math.floor((float)y / (float)dimen) * dimen), getNoise(seed, (int)Math.floor((float)x / (float)dimen) * dimen + dimen, (int)Math.floor((float)y / (float)dimen) * dimen + dimen), getNoise(seed, (int)Math.floor((float)x / (float)dimen) * dimen, (int)Math.floor((float)y / (float)dimen) * dimen + dimen), Math.abs((float)((double)x - Math.floor((float)x / (float)dimen) * (double)dimen) / (float)dimen), Math.abs((float)((double)y - Math.floor((float)y / (float)dimen) * (double)dimen) / (float)dimen));
    }

    static Random random = new Random();

}
