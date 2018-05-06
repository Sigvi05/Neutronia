package net.hdt.neutronia.modules.building.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMetaVariants;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockCarvedWood extends BlockMetaVariants implements IModBlock {

    public BlockCarvedWood() {
        super("carved_wood", MOD_ID, Material.WOOD, Variants.class);
        setHardness(2.0F);
        setResistance(5.0F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public enum Variants implements BlockMetaVariants.EnumBase {
        CARVED_OAK_WOOD,
        CARVED_SPRUCE_WOOD,
        CARVED_BIRCH_WOOD,
        CARVED_JUNGLE_WOOD,
        CARVED_ACACIA_WOOD,
        CARVED_DARK_OAK_WOOD
    }

}
