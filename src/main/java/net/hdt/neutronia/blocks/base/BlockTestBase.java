package net.hdt.neutronia.blocks.base;

import net.hdt.huskylib2.block.BlockMod;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.material.Material;

public class BlockTestBase extends BlockMod implements INeutroniaBlock {

    public BlockTestBase(String name, String textureName) {
        super(name, Material.ROCK, textureName);
    }

}
