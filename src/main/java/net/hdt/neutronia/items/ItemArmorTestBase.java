package net.hdt.neutronia.items;

import net.hdt.neutronia.base.items.INeutroniaItem;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class ItemArmorTestBase extends ItemModArmor implements INeutroniaItem {

    private boolean hasOverlay, hasColor;

    public ItemArmorTestBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(name, materialIn, renderIndexIn, equipmentSlotIn);
    }

    @Override
    public boolean hasOverlay(ItemStack stack) {
        return isHasOverlay();
    }

    @Override
    public boolean hasColor(ItemStack stack) {
        return isHasColor();
    }

    public void setHasColor(boolean hasColor) {
        this.hasColor = hasColor;
    }

    public void setHasOverlay(boolean hasOverlay) {
        this.hasOverlay = hasOverlay;
    }

    public boolean isHasOverlay() {
        return hasOverlay;
    }

    public boolean isHasColor() {
        return hasColor;
    }

}
