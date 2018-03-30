package net.thegaminghuskymc.mcaddon.tools;

import net.minecraft.item.ItemPickaxe;

public class BasePickaxe extends ItemPickaxe
{

    public BasePickaxe(String name, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
