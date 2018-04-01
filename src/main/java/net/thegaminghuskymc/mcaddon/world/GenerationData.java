// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GenerationData.java

package net.thegaminghuskymc.mcaddon.world;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package elucent.hmca.world:
//            GenerationNode

public class GenerationData extends WorldSavedData
{

    public GenerationData(String name)
    {
        super(name);
        nodes = new HashSet();
    }

    public GenerationData()
    {
        super("hmca_generation_data");
        nodes = new HashSet();
    }

    public void addNode(GenerationNode node)
    {
        nodes.add(node);
        markDirty();
    }

    public void readFromNBT(NBTTagCompound nbt)
    {
        NBTTagList list = nbt.getTagList("gen_data_nodes", 10);
        for(int i = 0; i < list.tagCount(); i++)
            nodes.add(new GenerationNode(list.getCompoundTagAt(i)));

    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        NBTTagList list = new NBTTagList();
        GenerationNode g;
        for(Iterator iterator = nodes.iterator(); iterator.hasNext(); list.appendTag(g.writeToNBT()))
            g = (GenerationNode)iterator.next();

        compound.setTag("gen_data_nodes", list);
        return compound;
    }

    public static GenerationData get(World w)
    {
        MapStorage s = w.getPerWorldStorage();
        GenerationData d = (GenerationData)s.getOrLoadData(GenerationData.class, "hmca_generation_data");
        if(d == null)
        {
            d = new GenerationData();
            s.setData("hmca_generation_data", d);
        }
        return d;
    }

    public void update(World world)
    {
        Set toDelete = new HashSet();
        Iterator iterator = nodes.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            GenerationNode n = (GenerationNode)iterator.next();
            if(n != null)
                n.update(world);
            if(!n.isAlive || n == null)
                toDelete.add(n);
        } while(true);
        iterator = toDelete.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            GenerationNode n = (GenerationNode)iterator.next();
            if(nodes.contains(n))
                nodes.remove(n);
        } while(true);
        toDelete.clear();
    }

    public Set nodes;
}
