package net.hdt.neutronia.modules.building.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMetaVariants;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockVerticalStainedPlanks extends BlockMetaVariants implements IModBlock {

    public BlockVerticalStainedPlanks() {
        super("vertical_stained_planks", MOD_ID, Material.WOOD, Variants.class);
        setHardness(2.0F);
        setResistance(5.0F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public enum Variants implements EnumBase {
        VERTICAL_STAINED_PLANKS_WHITE,
        VERTICAL_STAINED_PLANKS_ORANGE,
        VERTICAL_STAINED_PLANKS_MAGENTA,
        VERTICAL_STAINED_PLANKS_LIGHT_BLUE,
        VERTICAL_STAINED_PLANKS_YELLOW,
        VERTICAL_STAINED_PLANKS_LIME,
        VERTICAL_STAINED_PLANKS_PINK,
        VERTICAL_STAINED_PLANKS_GRAY,
        VERTICAL_STAINED_PLANKS_SILVER,
        VERTICAL_STAINED_PLANKS_CYAN,
        VERTICAL_STAINED_PLANKS_PURPLE,
        VERTICAL_STAINED_PLANKS_BLUE,
        VERTICAL_STAINED_PLANKS_BROWN,
        VERTICAL_STAINED_PLANKS_GREEN,
        VERTICAL_STAINED_PLANKS_RED,
        VERTICAL_STAINED_PLANKS_BLACK
    }

}
