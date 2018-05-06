package net.hdt.neutronia.modules.building.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMetaVariants;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockSoulSandstone extends BlockMetaVariants implements IModBlock {

    public BlockSoulSandstone() {
        super("soul_sandstone", MOD_ID, Material.ROCK, Variants.class);
        setHardness(1F);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public enum Variants implements EnumBase {
        SOUL_SANDSTONE,
        CHISELED_SOUL_SANDSTONE,
        SMOOTH_SOUL_SANDSTONE
    }

}
