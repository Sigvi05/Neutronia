package net.hdt.neutronia.modules.building.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMetaVariants;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockVerticalPlanks extends BlockMetaVariants implements IModBlock {

    public BlockVerticalPlanks() {
        super("vertical_planks", MOD_ID, Material.WOOD, Variants.class);
        setHardness(2.0F);
        setResistance(5.0F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public enum Variants implements BlockMetaVariants.EnumBase {
        VERTICAL_OAK_PLANKS,
        VERTICAL_SPRUCE_PLANKS,
        VERTICAL_BIRCH_PLANKS,
        VERTICAL_JUNGLE_PLANKS,
        VERTICAL_ACACIA_PLANKS,
        VERTICAL_DARK_OAK_PLANKS
    }

}
