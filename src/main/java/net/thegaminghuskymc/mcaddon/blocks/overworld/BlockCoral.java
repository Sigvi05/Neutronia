package net.thegaminghuskymc.mcaddon.blocks.overworld;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;
import net.thegaminghuskymc.mcaddon.init.MCAddonBlocks;
import net.thegaminghuskymc.mcaddon.properties.EnumCoralColor;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

public class BlockCoral extends BlockMod {

    private final EnumCoralColor color;

    public BlockCoral(EnumCoralColor colorIn, String name) {
        super(Material.CORAL, MOD_ID, colorIn + "_" + name);
        this.color = colorIn;
        this.setCreativeTab(HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
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

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

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
