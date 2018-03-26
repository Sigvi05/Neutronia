package net.thegaminghuskymc.mcaddon.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.thegaminghuskymc.huskylib2.lib.blocks.BlockMod;

public class BlockWorkignUnderWater extends BlockMod {

    private PropertyBool WATERLOGGED = PropertyBool.create("waterlogged");

    public BlockWorkignUnderWater(String modid, String name) {
        super(Material.WATER, modid, name);
    }

}
