package net.thegaminghuskymc.mcaddon.blocks.nether;

import net.minecraft.block.material.Material;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BlockNetherSlabBase extends BlockModSlab {

    public BlockNetherSlabBase(String name, boolean isDouble) {
        super(name, MOD_ID, Material.ROCK, isDouble);
        setCreativeTab(HuskysMinecraftAdditions.NETHER_EXPANSION_TAB);
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
