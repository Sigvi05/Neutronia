package net.thegaminghuskymc.mcaddon.tools;

import net.minecraft.item.ItemSword;

public class BaseSword extends ItemSword
{

    public BaseSword(String name, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
