package net.hdt.neutronia.blocks;

import net.hdt.neutronia.blocks.base.BlockModPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MRPillar extends BlockModPillar {

    public MRPillar(Material material, String name, CreativeTabs creativetab, float hardnesss, float resistance) {
        super(name, material);
        setCreativeTab(creativetab);
        setHardness(hardnesss);
        setSoundType(SoundType.STONE);
        setResistance(resistance);
    }

}