package net.thegaminghuskymc.mcaddon.items;

import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.items.ItemMod;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

public class ItemBase extends ItemMod {

    public ItemBase(String name, CreativeTabs creativeTabs) {
        super(name, MOD_ID);
        setCreativeTab(creativeTabs);
    }

}
