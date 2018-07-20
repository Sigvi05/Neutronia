package net.hdt.neutronia.init;

import net.hdt.neutronia.base.ModCreativeTab;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NCreativeTabs {

    public static ModCreativeTab OVERWORLD_EXPANSION_TAB = new ModCreativeTab("Neutronia: Overworld", true);
    public static ModCreativeTab OCEAN_EXPANSION_TAB = new ModCreativeTab("Neutronia: Ocean", true);
    public static ModCreativeTab WOOD_EXPANSION_TAB = new ModCreativeTab("Neutronia: Wood", true);
    public static ModCreativeTab NETHER_EXPANSION_TAB = new ModCreativeTab("Neutronia: Nether", true);
    public static ModCreativeTab END_EXPANSION_TAB = new ModCreativeTab("Neutronia: End", false) {
        @Override
        public ItemStack getIcon() {
            return new ItemStack(Item.getItemFromBlock(Blocks.END_BRICKS));
        }
    };
    public static ModCreativeTab ITEM_EXPANSION_TAB = new ModCreativeTab("Neutronia: Items", true);

}
