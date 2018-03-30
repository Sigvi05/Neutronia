package net.thegaminghuskymc.mcaddon.items;

import net.minecraft.creativetab.CreativeTabs;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

public class ItemFood extends ItemModFood {

    public ItemFood(String name, CreativeTabs creativeTabs) {
        super(MOD_ID, name, creativeTabs, 1, false);
    }

}
