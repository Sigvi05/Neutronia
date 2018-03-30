package net.thegaminghuskymc.mcaddon.items.base.tools;

import net.minecraft.item.ItemHoe;
import net.thegaminghuskymc.mcaddon.items.ItemModHoe;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BaseHoe extends ItemHoe {

    public BaseHoe(String name, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
