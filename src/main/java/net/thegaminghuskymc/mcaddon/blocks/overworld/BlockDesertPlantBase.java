package net.thegaminghuskymc.mcaddon.blocks.overworld;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;
import net.thegaminghuskymc.mcaddon.blocks.BlockModBush;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BlockDesertPlantBase extends BlockModBush {

    public BlockDesertPlantBase(String name) {
        super(Material.PLANTS, name, MOD_ID);
        this.setCreativeTab(HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

}
