package net.hdt.neutronia.base.util;

import net.hdt.neutronia.init.NCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static net.hdt.neutronia.base.util.Reference.MOD_ID;

public class InitUtil {
    public static void setup(Item item, String name) {
        item.setRegistryName(new ResourceLocation(MOD_ID, name));
        item.setTranslationKey(MOD_ID + "." + name);
        item.setCreativeTab(NCreativeTabs.ITEM_EXPANSION_TAB);
    }

    public static void setup(Block block, String name) {
        block.setRegistryName(new ResourceLocation(MOD_ID, name));
        block.setTranslationKey(MOD_ID + "." + name);
        block.setCreativeTab(NCreativeTabs.OVERWORLD_EXPANSION_TAB);
    }
}
