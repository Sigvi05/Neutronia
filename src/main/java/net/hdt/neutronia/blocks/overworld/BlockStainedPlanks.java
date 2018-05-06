package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.util.Reference;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMetaVariants;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

public class BlockStainedPlanks extends BlockMetaVariants implements IModBlock {

    public BlockStainedPlanks() {
        super("dyed_planks", Reference.MOD_ID, Material.WOOD, Variants.class);
        setHardness(2.0F);
        setResistance(5.0F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public enum Variants implements EnumBase {
        STAINED_PLANKS_WHITE,
        STAINED_PLANKS_ORANGE,
        STAINED_PLANKS_MAGENTA,
        STAINED_PLANKS_LIGHT_BLUE,
        STAINED_PLANKS_YELLOW,
        STAINED_PLANKS_LIME,
        STAINED_PLANKS_PINK,
        STAINED_PLANKS_GRAY,
        STAINED_PLANKS_SILVER,
        STAINED_PLANKS_CYAN,
        STAINED_PLANKS_PURPLE,
        STAINED_PLANKS_BLUE,
        STAINED_PLANKS_BROWN,
        STAINED_PLANKS_GREEN,
        STAINED_PLANKS_RED,
        STAINED_PLANKS_BLACK
    }

}