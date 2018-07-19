package net.hdt.neutronia.init;

import net.hdt.neutronia.CreativeTab;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NCreativeTabs {

    public static CreativeTab OVERWORLD_EXPANSION_TAB = new CreativeTab("Neutronia: Overworld", true);
    public static CreativeTab OCEAN_EXPANSION_TAB = new CreativeTab("Neutronia: Ocean", true);
    public static CreativeTab WOOD_EXPANSION_TAB = new CreativeTab("Neutronia: Wood", true);
    public static CreativeTab NETHER_EXPANSION_TAB = new CreativeTab("Neutronia: Nether", true);
    public static CreativeTab END_EXPANSION_TAB = new CreativeTab("Neutronia: End", false) {
        @Override
        public ItemStack getIcon() {
            return new ItemStack(Item.getItemFromBlock(Blocks.END_BRICKS));
        }
    };
    public static CreativeTab ITEM_EXPANSION_TAB = new CreativeTab("Neutronia: Items", true);

}
