package net.hdt.neutronia.groups.building.blocks.slab;

import net.hdt.huskylib2.interf.IRecipeGrouped;
import net.hdt.neutronia.base.blocks.BlockNeutroniaSlab;
import net.hdt.neutronia.groups.building.blocks.BlockBark;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBarkSlab extends BlockNeutroniaSlab implements IRecipeGrouped {

    public BlockBarkSlab(BlockBark.Variants variant, boolean doubleSlab) {
        super(variant.getName() + "_slab", Material.WOOD, doubleSlab);
        setHardness(2.0F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public String getRecipeGroup() {
        return "bark_slab";
    }

}
