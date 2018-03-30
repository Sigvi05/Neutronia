package net.thegaminghuskymc.mcaddon.items.base.tools;

import net.minecraft.item.ItemSword;
import net.thegaminghuskymc.huskylib2.items.ItemModSword;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BaseSword extends ItemSword {

    public BaseSword(String name, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }

}
