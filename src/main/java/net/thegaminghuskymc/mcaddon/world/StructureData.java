// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StructureData.java

package net.thegaminghuskymc.mcaddon.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package elucent.elulib.world:
//            IGeneratable

public class StructureData
    implements IGeneratable
{

    public StructureData()
    {
        data = new HashMap();
        blocks = new HashMap();
        width = 0;
        height = 0;
        length = 0;
    }

    public void addBlock(String string, IBlockState state)
    {
        blocks.put(string, state);
    }

    public void addLayer(String layer[], int y)
    {
        for(int i = 0; i < layer.length; i++)
        {
            for(int j = 0; j < layer[i].length(); j++)
                data.put(new Vec3i(i, y, j), layer[i].substring(j, j + 1));

        }

    }

    public void calcDimensions()
    {
        int minX = 0;
        int minY = 0;
        int minZ = 0;
        int maxX = 0;
        int maxY = 0;
        int maxZ = 0;
        Iterator iterator = data.keySet().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            Vec3i v = (Vec3i)iterator.next();
            if(v.getX() < minX)
                minX = v.getX();
            if(v.getY() < minY)
                minY = v.getY();
            if(v.getZ() < minZ)
                minZ = v.getZ();
            if(v.getX() > maxX)
                maxX = v.getX();
            if(v.getY() > maxY)
                maxY = v.getY();
            if(v.getY() > maxZ)
                maxZ = v.getZ();
        } while(true);
        width = maxX - minX;
        height = maxY - minY;
        length = maxZ - minZ;
    }

    public int getWidth()
    {
        return width;
    }

    public int getLength()
    {
        return length;
    }

    public void generateIn(World world, int x, int y, int z, Rotation rotation, Mirror doMirror, boolean replaceWithAir)
    {
        calcDimensions();
        Iterator iterator = data.entrySet().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            Map.Entry e = (Map.Entry)iterator.next();
            Vec3i v = (Vec3i)e.getKey();
            String b = (String)e.getValue();
            if(rotation == Rotation.CLOCKWISE_180)
                placeBlock(world, new BlockPos(x + v.getX(), y + v.getY(), (z - v.getZ()) + length), (IBlockState)blocks.get(b), rotation, doMirror, replaceWithAir);
            if(rotation == Rotation.COUNTERCLOCKWISE_90)
                placeBlock(world, new BlockPos(x + v.getZ(), y + v.getY(), z + v.getX()), (IBlockState)blocks.get(b), rotation, doMirror, replaceWithAir);
            if(rotation == Rotation.NONE)
                placeBlock(world, new BlockPos((x - v.getX()) + width, y + v.getY(), z + v.getZ()), (IBlockState)blocks.get(b), rotation, doMirror, replaceWithAir);
            if(rotation == Rotation.CLOCKWISE_90)
                placeBlock(world, new BlockPos((x - v.getZ()) + length, y + v.getY(), (z - v.getX()) + width), (IBlockState)blocks.get(b), rotation, doMirror, replaceWithAir);
        } while(true);
    }

    public void placeBlock(World world, BlockPos pos, IBlockState state, Rotation rotation, Mirror mirror, boolean replaceWithAir)
    {
        if(state.getBlock() != Blocks.AIR || state.getBlock() == Blocks.AIR && replaceWithAir)
            world.setBlockState(pos, state.withRotation(rotation).withMirror(mirror));
    }

    public Map data;
    public Map blocks;
    int width;
    int height;
    int length;
}
