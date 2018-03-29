package net.thegaminghuskymc.mcaddon.blocks.nether;

import net.minecraft.block.material.Material;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BlockNetherBase extends BlockMod {

    public BlockNetherBase(Material material, String name) {
        super(material, MOD_ID, name);
        setCreativeTab(HuskysMinecraftAdditions.NETHER_EXPANSION_TAB);
    }

}
