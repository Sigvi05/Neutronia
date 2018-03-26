package net.thegaminghuskymc.mcaddon.items;

import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.items.ItemMod;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

public class ItemTest extends ItemMod {

    public ItemTest() {
        super("test", MOD_ID);
        setCreativeTab(CreativeTabs.FOOD);
    }

}
