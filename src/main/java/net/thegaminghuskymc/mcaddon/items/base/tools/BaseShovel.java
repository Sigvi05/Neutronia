package net.thegaminghuskymc.mcaddon.items.base.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.thegaminghuskymc.huskylib2.items.ItemModSpade;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BaseShovel extends ItemSpade {

    public BaseShovel(String name, Item.ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
