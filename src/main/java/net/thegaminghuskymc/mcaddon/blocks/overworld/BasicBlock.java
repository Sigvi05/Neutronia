package net.thegaminghuskymc.mcaddon.blocks.overworld;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block
{

    public BasicBlock(String name, Material material, float resistance, float hardness)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setResistance(resistance);
        setHardness(hardness);
    }
}
