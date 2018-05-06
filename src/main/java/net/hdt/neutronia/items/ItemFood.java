package net.hdt.neutronia.items;

import net.hdt.neutronia.util.Reference;
import net.minecraft.creativetab.CreativeTabs;

public class ItemFood extends ItemModFood {

    public ItemFood(String name, CreativeTabs creativeTabs, int amount, boolean isWolfFood) {
        super(Reference.MOD_ID, name, creativeTabs, amount, isWolfFood);
    }

    public ItemFood(String name, CreativeTabs creativeTabs, int amount, float saturation, boolean isWolfFood) {
        super(Reference.MOD_ID, name, creativeTabs, amount, saturation, isWolfFood);
    }

}
