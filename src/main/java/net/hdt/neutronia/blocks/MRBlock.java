package net.hdt.neutronia.blocks;

import net.hdt.huskylib2.block.BlockMod;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MRBlock extends BlockMod implements INeutroniaBlock {

    protected String name;

    public MRBlock(Material material, String name, CreativeTabs creativetab, float hardness, float resistance) {
        super(name, material);
        setCreativeTab(creativetab);
        setHardness(hardness);
        setResistance(resistance);
    }

    public void slipperiness(float x)
    {
        this.slipperiness = x;
    }
}
