package net.hdt.neutronia.items;

import net.hdt.huskylib2.items.blocks.ItemModBlock;
import net.hdt.neutronia.properties.EnumCoralColor;
import net.hdt.neutronia.util.WearableColourUtils;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemBlockCoralColoredName extends ItemModBlock {

    private EnumCoralColor dyeColor;

    public ItemBlockCoralColoredName(Block block, ResourceLocation name, EnumCoralColor dyeColor) {
        super(block, name);
        this.dyeColor = dyeColor;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return WearableColourUtils.getClosest(dyeColor.getColorValue()) + super.getItemStackDisplayName(stack);
    }

}
