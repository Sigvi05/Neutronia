package net.hdt.neutronia.modules.building.blocks.slab;

import net.hdt.neutronia.blocks.overworld.BlockOverworldSlabBase;
import net.hdt.neutronia.modules.building.blocks.BlockBark;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.interf.IRecipeGrouped;

public class BlockBarkSlab extends BlockOverworldSlabBase implements IRecipeGrouped {

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
