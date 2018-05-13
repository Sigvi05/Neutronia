package net.hdt.neutronia.modules.building.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockSturdyStone extends BlockMod implements IModBlock {

    public BlockSturdyStone() {
        super(Material.ROCK, MOD_ID, "sturdy_stone");
        setHardness(4.0F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public EnumPushReaction getMobilityFlag(IBlockState state) {
        return EnumPushReaction.BLOCK;
    }

}
