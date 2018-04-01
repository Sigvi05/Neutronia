// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FluidTextureUtil.java

package net.thegaminghuskymc.mcaddon.util;

import com.google.common.collect.Maps;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.util.Iterator;
import java.util.Map;

public class FluidTextureUtil
{

    public FluidTextureUtil()
    {
    }

    public static void initTextures(TextureMap map)
    {
        Iterator iterator = FluidRegistry.getRegisteredFluids().values().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            Fluid fluid = (Fluid)iterator.next();
            if(fluid.getStill() != null)
            {
                String still = fluid.getStill().toString();
                TextureAtlasSprite sprite;
                if(map.getTextureExtry(still) != null)
                    sprite = map.getTextureExtry(still);
                else
                    sprite = map.registerSprite(fluid.getStill());
                stillTextures.put(fluid, sprite);
            }
        } while(true);
    }

    public static Map stillTextures = Maps.newHashMap();

}
