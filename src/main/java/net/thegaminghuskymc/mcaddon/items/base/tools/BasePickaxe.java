package net.thegaminghuskymc.mcaddon.items.base.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.thegaminghuskymc.huskylib2.items.ItemModPickaxe;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BasePickaxe extends ItemPickaxe {

    public BasePickaxe(String name, Item.ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
