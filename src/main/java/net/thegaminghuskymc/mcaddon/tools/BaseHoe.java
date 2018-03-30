package net.thegaminghuskymc.mcaddon.tools;

import net.minecraft.item.ItemHoe;

public class BaseHoe extends ItemHoe
{

    public BaseHoe(String name, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
