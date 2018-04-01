// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GenerationNode.java

package net.thegaminghuskymc.mcaddon.world;

import java.util.Map;

import elucent.elulib.world.IGeneratable;
import elucent.elulib.world.StructureRegistry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// Referenced classes of package elucent.elulib.world:
//            StructureRegistry, IGeneratable

public class GenerationNode
{

    public GenerationNode(NBTTagCompound tag)
    {
        structure = "";
        rotation = Rotation.NONE;
        mirror = Mirror.NONE;
        pos = new BlockPos(-1, -1, -1);
        replaceWithAir = false;
        isAlive = true;
        readFromNBT(tag);
    }

    public GenerationNode(BlockPos pos, String structure, Rotation rotation, Mirror mirror, boolean replaceWithAir)
    {
        this.structure = "";
        this.rotation = Rotation.NONE;
        this.mirror = Mirror.NONE;
        this.pos = new BlockPos(-1, -1, -1);
        this.replaceWithAir = false;
        isAlive = true;
        this.pos = pos;
        this.structure = structure;
        this.rotation = rotation;
        this.mirror = mirror;
        this.replaceWithAir = replaceWithAir;
    }

    public void update(World world)
    {
        if(structure.length() > 0)
        {
            elucent.elulib.world.IGeneratable data = (IGeneratable)StructureRegistry.structures.get(structure);
            if(data != null)
            {
                data.calcDimensions();
                if(world.isAreaLoaded(new BlockPos(pos.getX() - 8, pos.getY(), pos.getZ() - 8), new BlockPos(pos.getX() + data.getWidth() + 8, pos.getY(), pos.getZ() + data.getLength() + 8)))
                {
                    data.generateIn(world, pos.getX(), pos.getY(), pos.getZ(), rotation, mirror, replaceWithAir);
                    isAlive = false;
                }
            } else
            {
                isAlive = false;
            }
        }
    }

    protected void readFromNBT(NBTTagCompound compound)
    {
        structure = compound.getString("structure");
        rotation = Rotation.values()[compound.getInteger("rotation")];
        mirror = Mirror.values()[compound.getInteger("mirror")];
        replaceWithAir = compound.getBoolean("replaceWithAir");
        pos = NBTUtil.getPosFromTag(compound.getCompoundTag("pos"));
    }

    public NBTTagCompound writeToNBT()
    {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setTag("pos", NBTUtil.createPosTag(pos));
        compound.setString("structure", structure);
        compound.setInteger("rotation", rotation.ordinal());
        compound.setInteger("mirror", mirror.ordinal());
        compound.setBoolean("replaceWithAir", replaceWithAir);
        return compound;
    }

    String structure;
    Rotation rotation;
    Mirror mirror;
    public BlockPos pos;
    boolean replaceWithAir;
    public boolean isAlive;
}
