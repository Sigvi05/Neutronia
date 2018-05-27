package net.hdt.neutronia.blocks.overworld;

import net.hdt.huskylib2.blocks.BlockModSlab;
import net.hdt.huskylib2.interf.IModBlock;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOverworldSlabBase extends BlockModSlab implements IModBlock {

    public BlockOverworldSlabBase(String name, Material material, boolean isDouble, CreativeTabs tab) {
        super(name, Reference.MOD_ID, material, isDouble);
        setCreativeTab(isDouble ? null : tab);
    }

}
