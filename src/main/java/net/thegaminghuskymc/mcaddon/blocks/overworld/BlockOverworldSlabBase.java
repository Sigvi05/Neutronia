package net.thegaminghuskymc.mcaddon.blocks.overworld;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

public class BlockOverworldSlabBase extends BlockModSlab {

    public BlockOverworldSlabBase(String name, boolean isDouble) {
        super(name, Material.ROCK, isDouble);
        setCreativeTab(HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
    }

    @Override
    public String getModNamespace() {
        return MOD_ID;
    }

    @Override
    public String getPrefix() {
        return MOD_ID;
    }
}
