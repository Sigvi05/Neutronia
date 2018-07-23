package net.hdt.neutronia.blocks.overworld;

import net.hdt.huskylib2.block.BlockFacing;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.material.Material;

public class BlockOverworldFacing extends BlockFacing implements INeutroniaBlock {

    public BlockOverworldFacing(Material materialIn, String name, String... variants) {
        super(name, materialIn, variants);
    }

}
