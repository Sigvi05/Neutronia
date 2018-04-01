// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Util.java

package net.thegaminghuskymc.mcaddon.util;

import java.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class Util
{

    public Util()
    {
    }

    public static List getTileEntitiesWithin(World world, Class teClass, int x1, int y1, int z1, int x2, int y2, int z2)
    {
        List tiles = new ArrayList();
        for(int i = x1; i <= x2; i++)
        {
            for(int j = y1; j <= y2; j++)
            {
                for(int k = z1; k <= z2; k++)
                {
                    BlockPos p = new BlockPos(i, j, k);
                    Chunk c = world.getChunkFromBlockCoords(p);
                    if(!c.isLoaded())
                        continue;
                    net.minecraft.tileentity.TileEntity t = world.getChunkFromBlockCoords(p).getTileEntity(p, Chunk.EnumCreateEntityType.CHECK);
                    if(t != null && teClass.isInstance(t))
                        tiles.add(t);
                }

            }

        }

        return tiles;
    }

    public static String lowercase(String s)
    {
        String f = "";
        for(int i = 0; i < s.length(); i++)
        {
            String c = s.substring(i, i + 1);
            if(c.toUpperCase().compareTo(c) == 0)
            {
                if(i > 0)
                    f = (new StringBuilder()).append(f).append("_").toString();
                f = (new StringBuilder()).append(f).append(c.toLowerCase()).toString();
            } else
            {
                f = (new StringBuilder()).append(f).append(c).toString();
            }
        }

        return f;
    }

    public static int intColor(int r, int g, int b)
    {
        return 0xff000000 + r * 0x10000 + g * 256 + b;
    }

    public static String getLowercaseClassName(Class c)
    {
        String nameParts[] = c.getTypeName().split("\\.");
        String className = nameParts[nameParts.length - 1];
        return lowercase(className);
    }

    public static Random rand = new Random();

}
