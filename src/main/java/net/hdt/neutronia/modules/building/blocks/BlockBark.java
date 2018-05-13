package net.hdt.neutronia.modules.building.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMetaVariants;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockBark extends BlockMetaVariants implements IModBlock {

    public BlockBark() {
        super("bark", MOD_ID, Material.WOOD, Variants.class);
        setHardness(2.0F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public enum Variants implements BlockMetaVariants.EnumBase {
        BARK_OAK,
        BARK_SPRUCE,
        BARK_BIRCH,
        BARK_JUNGLE,
        BARK_ACACIA,
        BARK_DARK_OAK
    }

}
