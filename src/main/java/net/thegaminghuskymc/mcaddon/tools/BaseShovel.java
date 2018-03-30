package net.thegaminghuskymc.mcaddon.tools;

import net.minecraft.item.ItemSpade;

public class BaseShovel extends ItemSpade
{

    public BaseShovel(String name, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
