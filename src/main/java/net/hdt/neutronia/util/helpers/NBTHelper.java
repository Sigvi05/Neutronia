package net.hdt.neutronia.util.helpers;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper
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