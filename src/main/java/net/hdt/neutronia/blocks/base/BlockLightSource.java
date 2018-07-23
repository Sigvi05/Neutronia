package net.hdt.neutronia.blocks.base;

import net.hdt.huskylib2.block.BlockMod;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.material.Material;

public class BlockLightSource extends BlockMod implements INeutroniaBlock {

    public BlockLightSource(String name) {
        super(name, Material.ROCK);
        this.setTickRandomly(true);
        setLightLevel(1.0F);
    }

}