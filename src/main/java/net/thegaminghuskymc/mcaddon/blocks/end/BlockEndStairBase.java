package net.thegaminghuskymc.mcaddon.blocks.end;

import net.minecraft.block.state.IBlockState;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

public class BlockEndStairBase extends BlockModStairs {

    public BlockEndStairBase(String name, IBlockState state) {
        super(name, state);
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