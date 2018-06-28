package net.hdt.neutronia.blocks.base;

import net.hdt.neutronia.blocks.overworld.BlockOverworldBase;
import net.hdt.neutronia.items.ItemBlockColoredName;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class BlockColoredName extends BlockOverworldBase {

    private EnumDyeColor dyeColor;

    public BlockColoredName(Material material, String name, EnumDyeColor dyeColor) {
        super(material, name);
        this.dyeColor = dyeColor;
    }

    @Override
    protected ItemBlock createItemBlock(ResourceLocation res) {
        return new ItemBlockColoredName(this, getRegistryName(), dyeColor);
    }

}
