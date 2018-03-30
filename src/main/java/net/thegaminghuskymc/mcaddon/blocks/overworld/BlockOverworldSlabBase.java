package net.thegaminghuskymc.mcaddon.blocks.overworld;

import net.minecraft.block.material.Material;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BlockOverworldSlabBase extends BlockModSlab {

    public BlockOverworldSlabBase(String name, boolean isDouble) {
        super(name, MOD_ID, Material.ROCK, isDouble);
        setCreativeTab(HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
    }

}
