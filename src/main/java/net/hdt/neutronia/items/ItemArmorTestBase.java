package net.hdt.neutronia.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class ItemArmorTestBase extends ItemModArmor {

    private boolean hasOverlay, hasColor;

    public ItemArmorTestBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(name, MOD_ID, materialIn, renderIndexIn, equipmentSlotIn);
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
