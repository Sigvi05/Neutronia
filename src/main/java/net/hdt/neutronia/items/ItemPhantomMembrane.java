package net.hdt.neutronia.items;

import net.hdt.neutronia.init.NCreativeTabs;
import net.hdt.neutronia.base.util.ColorUtils;
import net.minecraft.item.ItemStack;

public class ItemPhantomMembrane extends ItemBase {

    public ItemPhantomMembrane() {
        super("phantom_membrane", NCreativeTabs.ITEM_EXPANSION_TAB);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return ColorUtils.getClosest(0xd8cda9) + super.getItemStackDisplayName(stack);
    }
}
