package net.hdt.neutronia.modules.building.blocks;

import net.hdt.neutronia.blocks.overworld.BlockOverworldBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

public class BlockCharredNetherBricks extends BlockOverworldBase implements IModBlock {

    public BlockCharredNetherBricks() {
        super(Material.ROCK, "charred_nether_bricks");
        setHardness(2.0F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }


}
