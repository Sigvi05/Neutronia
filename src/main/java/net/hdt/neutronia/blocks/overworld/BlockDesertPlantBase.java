package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.blocks.base.BlockModBush;
import net.hdt.neutronia.init.NCreativeTabs;
import net.hdt.neutronia.base.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDesertPlantBase extends BlockModBush {

    public BlockDesertPlantBase(String name) {
        super(Material.PLANTS, name, Reference.MOD_ID);
        this.setCreativeTab(NCreativeTabs.OVERWORLD_EXPANSION_TAB);
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
