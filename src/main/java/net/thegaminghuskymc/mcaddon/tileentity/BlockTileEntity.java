package net.thegaminghuskymc.mcaddon.tileentity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumBlockRenderType;
import net.thegaminghuskymc.huskylib2.blocks.BlockModContainer;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

/**
 * A simple base class for Animated(or not Blocks (with a TileEntity) made on CraftStudio
 * */
public abstract class BlockTileEntity<T extends BaseTileEntity> extends BlockModContainer {

    public BlockTileEntity(final String name, final Material material) {
        super(material, MOD_ID, name);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }

    /**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     */
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
    
    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}