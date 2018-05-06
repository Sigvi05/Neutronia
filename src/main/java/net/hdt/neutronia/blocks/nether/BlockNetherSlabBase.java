package net.hdt.neutronia.blocks.nether;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;

public class BlockNetherSlabBase extends BlockModSlab {

    public BlockNetherSlabBase(String name, boolean isDouble) {
        super(name, Reference.MOD_ID, Material.ROCK, isDouble);
        setCreativeTab(Main.NETHER_EXPANSION_TAB);
    }

    @Override
    public String getModNamespace() {
        return Reference.MOD_ID;
    }

    @Override
    public String getPrefix() {
        return Reference.MOD_ID;
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return HALF;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return null;
    }
}
