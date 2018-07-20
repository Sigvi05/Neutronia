package net.hdt.neutronia.items.base.armors;

import net.hdt.neutronia.items.ItemModArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import static net.hdt.neutronia.base.util.Reference.MOD_ID;

public class ArmorBase extends ItemModArmor {

    private boolean hasColor, hasOverlay;

    public ArmorBase(String name, boolean hasColor, boolean hasOverlay, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(name, MOD_ID, materialIn, renderIndexIn, equipmentSlotIn);
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
