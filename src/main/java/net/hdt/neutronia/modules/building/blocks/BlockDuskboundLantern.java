package net.hdt.neutronia.modules.building.blocks;

import net.hdt.neutronia.blocks.overworld.BlockOverworldBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

public class BlockDuskboundLantern extends BlockOverworldBase implements IModBlock {

    public BlockDuskboundLantern() {
        super(Material.ROCK, "duskbound_lantern");
        setLightLevel(1.0F);
        setHardness(1.5F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

}
