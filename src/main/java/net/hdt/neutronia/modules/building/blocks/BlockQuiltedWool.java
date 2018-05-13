package net.hdt.neutronia.modules.building.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMetaVariants;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockQuiltedWool extends BlockMetaVariants implements IModBlock {

    public BlockQuiltedWool() {
        super("quilted_wool", MOD_ID, Material.CLOTH, Variants.class);
        setHardness(0.8F);
        setSoundType(SoundType.CLOTH);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public enum Variants implements EnumBase {
        WOOL_QUILTED_WHITE,
        WOOL_QUILTED_ORANGE,
        WOOL_QUILTED_MAGENTA,
        WOOL_QUILTED_LIGHT_BLUE,
        WOOL_QUILTED_YELLOW,
        WOOL_QUILTED_LIME,
        WOOL_QUILTED_PINK,
        WOOL_QUILTED_GRAY,
        WOOL_QUILTED_SILVER,
        WOOL_QUILTED_CYAN,
        WOOL_QUILTED_PURPLE,
        WOOL_QUILTED_BLUE,
        WOOL_QUILTED_BROWN,
        WOOL_QUILTED_GREEN,
        WOOL_QUILTED_RED,
        WOOL_QUILTED_BLACK
    }

}
