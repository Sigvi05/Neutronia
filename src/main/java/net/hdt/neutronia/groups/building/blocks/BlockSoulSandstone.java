package net.hdt.neutronia.groups.building.blocks;

import net.hdt.huskylib2.block.BlockMetaVariants;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSoulSandstone extends BlockMetaVariants implements INeutroniaBlock {

    public BlockSoulSandstone() {
        super("soul_sandstone", Material.ROCK, Variants.class);
        setHardness(1F);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public enum Variants implements EnumBase {
        SOUL_SANDSTONE,
        CHISELED_SOUL_SANDSTONE,
        SMOOTH_SOUL_SANDSTONE
    }

}
