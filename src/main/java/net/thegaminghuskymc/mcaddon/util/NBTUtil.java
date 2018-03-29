package net.thegaminghuskymc.mcaddon.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTUtil
{
    public static ItemStack setTag(ItemStack stack)
    {
        if(stack.getTagCompound() == null)
        {
            stack.setTagCompound(new NBTTagCompound());
        }

        return stack;
    }

    public static ItemStack setTag(ItemStack stack, NBTTagCompound compound)
    {
        if(stack.getTagCompound() == null)
        {
            stack.setTagCompound(compound);
        }
        else
        {
            stack.getTagCompound().merge(compound);
        }

        return stack;
    }
}