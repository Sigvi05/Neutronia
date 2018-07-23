package net.hdt.neutronia.blocks.base;

import net.hdt.huskylib2.block.BlockMod;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

public abstract class BlockHorizontal extends BlockMod {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    protected BlockHorizontal(Material material, String name) {
        super(name, material);
    }

}