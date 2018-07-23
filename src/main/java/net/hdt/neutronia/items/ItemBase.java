package net.hdt.neutronia.items;

import net.hdt.huskylib2.item.ItemMod;
import net.hdt.neutronia.base.items.INeutroniaItem;
import net.minecraft.creativetab.CreativeTabs;

public class ItemBase extends ItemMod implements INeutroniaItem {

    public ItemBase(String name, CreativeTabs creativeTabs) {
        super(name);
        setCreativeTab(creativeTabs);
    }

}
