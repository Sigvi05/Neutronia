package net.hdt.neutronia.items.base.armors;

import net.hdt.neutronia.base.items.INeutroniaItem;
import net.hdt.neutronia.items.ItemModArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class ArmorBase extends ItemModArmor implements INeutroniaItem {

    private boolean hasColor, hasOverlay;

    public ArmorBase(String name, boolean hasColor, boolean hasOverlay, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(name, materialIn, renderIndexIn, equipmentSlotIn);
        this.hasColor = hasColor;
        this.hasOverlay = hasOverlay;
        setCreativeTab(CreativeTabs.COMBAT);
    }

    @Override
    public boolean hasColor(ItemStack stack) {
        return hasColor;
    }

    @Override
    public boolean hasOverlay(ItemStack stack) {
        return hasOverlay;
    }

}
