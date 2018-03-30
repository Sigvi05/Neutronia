package net.thegaminghuskymc.mcaddon.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;
import net.thegaminghuskymc.mcaddon.util.Reference;
import net.thegaminghuskymc.mcaddon.items.base.tools.BaseSword;

public class ItemAncientSword extends ItemSword {

    public static Item.ToolMaterial ancientToolMaterial = EnumHelper.addToolMaterial("ANCIENT", 1, 131, 8.0F, 3.5F, 22);


    public ItemAncientSword()
    {
        super(ancientToolMaterial);
        setUnlocalizedName("ancient_sword");
        setRegistryName("ancient_sword");
    }
}