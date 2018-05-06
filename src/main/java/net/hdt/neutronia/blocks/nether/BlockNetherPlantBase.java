package net.hdt.neutronia.blocks.nether;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.blocks.base.BlockModBush;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNetherPlantBase extends BlockModBush {

    public BlockNetherPlantBase(String name) {
        super(Material.PLANTS, name, Reference.MOD_ID);
        this.setCreativeTab(Main.NETHER_EXPANSION_TAB);
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
