package net.thegaminghuskymc.mcaddon.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib2.lib.blocks.BlockMod;
import net.thegaminghuskymc.mcaddon.properties.EnumCoralColor;

import static net.minecraft.block.BlockLiquid.LEVEL;
import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

public class BlockCoral extends BlockMod {

    private final EnumCoralColor color;

    public BlockCoral(EnumCoralColor colorIn, String name) {
        super(Material.CORAL, MOD_ID, colorIn + "_" + name);
        this.color = colorIn;
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public String getPrefix() {
        return MOD_ID;
    }

    @Override
    public String getModNamespace() {
        return MOD_ID;
    }

    @SideOnly(Side.CLIENT)
    public static EnumCoralColor getColorFromItem(Item itemIn) {
        return getColorFromBlock(Block.getBlockFromItem(itemIn));
    }

    @SideOnly(Side.CLIENT)
    private static EnumCoralColor getColorFromBlock(Block blockIn) {
        return blockIn instanceof BlockCoral ? ((BlockCoral) blockIn).getColor() : EnumCoralColor.BLUE;
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

    @SideOnly(Side.CLIENT)
    public EnumCoralColor getColor() {
        return this.color;
    }
}
