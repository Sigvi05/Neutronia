package net.thegaminghuskymc.mcaddon.blocks.nether;

import net.minecraft.block.state.IBlockState;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BlockNetherStairBase extends BlockModStairs {

    public BlockNetherStairBase(String name, IBlockState state) {
        super(name, state);
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
