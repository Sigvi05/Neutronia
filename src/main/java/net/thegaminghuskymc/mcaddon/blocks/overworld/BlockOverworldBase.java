package net.thegaminghuskymc.mcaddon.blocks.overworld;

import net.minecraft.block.material.Material;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BlockOverworldBase extends BlockMod {

    public BlockOverworldBase(Material material, String name) {
        super(material, MOD_ID, name);
        setCreativeTab(HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
    }

}
