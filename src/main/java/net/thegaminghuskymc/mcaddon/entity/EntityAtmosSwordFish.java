// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EntityAtmosSwordFish.java

package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

public class EntityAtmosSwordFish extends EntityAtmosWater {

    public EntityAtmosSwordFish(World world)
    {
        super(world);
        setSize(0.8F, 0.5F);
        setMaxHealth(20);
        setTamed(false);
        caught = false;
    }

    public EntityPlayer getClosestPlayer(double par1, double par3, double par5, double par7)
    {
        double d = -1D;
        EntityPlayer entityplayer = null;
        for(int i = 0; i < playerEntities.size(); i++)
        {
            EntityPlayer entityplayer1 = (EntityPlayer)playerEntities.get(i);
            double d1 = entityplayer1.getDistanceSq(par1, par3, par5);
            if((par7 < 0.0D || d1 < par7 * par7) && (d == -1D || d1 < d))
            {
                d = d1;
                entityplayer = entityplayer1;
            }
        }

        return entityplayer;
    }

    public EntityPlayer getClosestVulnerablePlayerToEntity(EntityPlayer par1Entity, double par2)
    {
        return getClosestPlayer(par1Entity.posX, par1Entity.posY, par1Entity.posZ, par2);
    }

    public boolean getIsTamed()
    {
        return isTamed;
    }

    public void setTamed(boolean flag)
    {
        isTamed = flag;
    }

    public boolean bj()
    {
        return !getIsTamed();
    }

    public boolean a(EntityPlayer entityplayer)
    {
        ItemStack itemstack = entityplayer.getActiveItemStack();
        if(itemstack != null && outOfWater != 0)
        {
            caught = true;
            itemstack.damageItem(4, entityplayer);
            return true;
        } else
        {
            return true;
        }
    }

    public void b(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setBoolean("Tamed", getIsTamed());
    }

    public void a(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        setTamed(nbttagcompound.getBoolean("Tamed"));
    }

    public List playerEntities;
    private boolean caught;
}
