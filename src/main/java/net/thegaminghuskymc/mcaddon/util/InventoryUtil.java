// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InventoryUtil.java

package net.thegaminghuskymc.mcaddon.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.oredict.OreDictionary;

// Referenced classes of package elucent.elulib.util:
//            OreStack

public class InventoryUtil
{

    public InventoryUtil()
    {
    }

    public static int attemptInsert(ItemStack stack, IItemHandler inventory, boolean simulate)
    {
        int count = stack.getCount();
        ItemStack toInsert = stack.copy();
        for(int i = 0; i < inventory.getSlots() && !toInsert.isEmpty(); i++)
        {
            ItemStack s = inventory.insertItem(i, toInsert.copy(), simulate);
            toInsert.setCount(s.getCount());
        }

        return count - toInsert.getCount();
    }

    public static int attemptInsert(ItemStack stack, IItemHandler inventory, boolean simulate, int startSlot, int endSlot)
    {
        int count = stack.getCount();
        ItemStack toInsert = stack.copy();
        for(int i = startSlot; i < endSlot && !toInsert.isEmpty(); i++)
        {
            ItemStack s = inventory.insertItem(i, toInsert.copy(), simulate);
            toInsert.setCount(s.getCount());
        }

        return count - toInsert.getCount();
    }

    public static boolean stackMatches(ItemStack stack, Object recipeInput)
    {
        if(recipeInput instanceof ItemStack)
        {
            if(!ItemStack.areItemsEqual(stack, (ItemStack)recipeInput))
                return false;
        } else
        if(recipeInput instanceof OreStack)
        {
            int id = OreDictionary.getOreID(((OreStack)recipeInput).oreId);
            int ids[] = OreDictionary.getOreIDs(stack);
            boolean hasMatch = false;
            int ai[] = ids;
            int i = ai.length;
            for(int k = 0; k < i; k++)
            {
                int pid = ai[k];
                if(pid == id)
                    hasMatch = true;
            }

            if(!hasMatch)
                return hasMatch;
        } else
        if(recipeInput instanceof String)
        {
            int id = OreDictionary.getOreID((String)recipeInput);
            int ids[] = OreDictionary.getOreIDs(stack);
            boolean hasMatch = false;
            int ai1[] = ids;
            int j = ai1.length;
            for(int l = 0; l < j; l++)
            {
                int pid = ai1[l];
                if(pid == id)
                    hasMatch = true;
            }

            if(!hasMatch)
                return hasMatch;
        }
        return true;
    }
}
