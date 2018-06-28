package net.hdt.neutronia.items;

import net.hdt.huskylib2.items.blocks.ItemModBlock;
import net.hdt.neutronia.util.WearableColourUtils;
import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemBlockColoredName extends ItemModBlock {

    private EnumDyeColor dyeColor;

    public ItemBlockColoredName(Block block, ResourceLocation name, EnumDyeColor dyeColor) {
        super(block, name);
        this.dyeColor = dyeColor;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return WearableColourUtils.getClosest(dyeColor.getColorValue()) + super.getItemStackDisplayName(stack);
    }

}
