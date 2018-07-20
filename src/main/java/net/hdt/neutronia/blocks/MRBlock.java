package net.hdt.neutronia.blocks;

import net.hdt.huskylib2.blocks.BlockMod;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import static net.hdt.neutronia.base.util.Reference.MOD_ID;

public class MRBlock extends BlockMod {

    protected String name;

    public MRBlock(Material material, String name, CreativeTabs creativetab, float hardness, float resistance) {
        super(material, MOD_ID, name);
        setCreativeTab(creativetab);
        setHardness(hardness);
        setResistance(resistance);
    }

    public void slipperiness(float x)
    {
        this.slipperiness = x;
    }
}
