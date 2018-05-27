package net.hdt.neutronia.items;

import net.hdt.neutronia.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.hdt.huskylib2.items.ItemMod;

public class ItemBase extends ItemMod {

    public ItemBase(String name, CreativeTabs creativeTabs) {
        super(name, Reference.MOD_ID);
        setCreativeTab(creativeTabs);
    }

}
