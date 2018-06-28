package net.hdt.neutronia.items;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.util.WearableColourUtils;
import net.minecraft.item.ItemStack;

public class ItemPhantomMembrane extends ItemBase {

    public ItemPhantomMembrane() {
        super("phantom_membrane", Main.ITEM_EXPANSION_TAB);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return WearableColourUtils.getClosest(0xd8cda9) + super.getItemStackDisplayName(stack);
    }
}
