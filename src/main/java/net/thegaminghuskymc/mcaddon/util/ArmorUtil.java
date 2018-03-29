package net.thegaminghuskymc.mcaddon.util;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ArmorUtil
{
    public static boolean isWearingFullArmorSet(EntityPlayer player, ItemArmor.ArmorMaterial material)
    {
        Iterable<ItemStack> armor = player.getArmorInventoryList();
        List<ItemArmor.ArmorMaterial> armorMaterials = Lists.newArrayList();

        for(ItemStack testStack : armor)
        {
            if(testStack == ItemStack.EMPTY || !(testStack.getItem() instanceof ItemArmor))
            {
                return false;
            }

            armorMaterials.add(((ItemArmor) testStack.getItem()).getArmorMaterial());
        }

        for(ItemArmor.ArmorMaterial testMaterial : armorMaterials)
        {
            if(testMaterial != material)
            {
                return false;
            }
        }

        return true;
    }

}