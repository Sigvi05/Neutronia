package net.hdt.neutronia.blocks.base;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.hdt.huskylib2.blocks.BlockMod;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public abstract class BlockDirectional extends BlockMod {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    protected BlockDirectional(Material materialIn, String name) {
        super(materialIn, MOD_ID, name);
    }
}