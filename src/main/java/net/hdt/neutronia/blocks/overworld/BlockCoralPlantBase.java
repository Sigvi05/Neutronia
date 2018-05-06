package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.blocks.base.BlockModBush;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class BlockCoralPlantBase extends BlockModBush {

    public BlockCoralPlantBase(String name) {
        super(Material.WATER, name, Reference.MOD_ID);
        this.setCreativeTab(Main.OVERWORLD_EXPANSION_TAB);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, 15));
    }

    @Override
    public IProperty[] getIgnoredProperties() {
        return new IProperty[]{LEVEL};
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

    public int getMetaFromState(IBlockState state) {
        return state.getValue(LEVEL);
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LEVEL);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        Block block = worldIn.getBlockState(new BlockPos(pos.add(0, -1, 0))).getBlock();
        return (block == Blocks.DIRT || block == Blocks.SAND || block == Blocks.SPONGE || block == Blocks.STONE || block == Blocks.CLAY || block == Blocks.GRAVEL || block == Blocks.GRASS) && worldIn.getBlockState(new BlockPos(pos.add(0, 2, 0))).getBlock() != Blocks.AIR;
    }

    public boolean canBlockStay(IBlockAccess worldIn, BlockPos pos, IBlockState state) {
        Block block = worldIn.getBlockState(new BlockPos(pos.add(0, -1, 0))).getBlock();
        return (block == Blocks.DIRT || block == Blocks.SAND || block == Blocks.SPONGE || block == Blocks.STONE || block == Blocks.CLAY || block == Blocks.GRAVEL || block == Blocks.GRASS) && worldIn.getBlockState(new BlockPos(pos.add(0, 2, 0))).getBlock() != Blocks.AIR;
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        Block ground = worldIn.getBlockState(pos.add(0, -1, 0)).getBlock();
        return ground == Blocks.SAND || ground == Blocks.GRASS || ground == Blocks.DIRT || ground == Blocks.GRAVEL && worldIn.getBlockState(pos.add(0, 2, 0)).getBlock() != Blocks.AIR;
    }

    public boolean isReplaceable(IBlockAccess access, BlockPos pos) {
        return access.getBlockState(pos).getBlock() == Blocks.WATER && canBlockStay(access, pos, getDefaultState()) && access.getBlockState(pos.add(0, 1, 0)).getBlock() != Blocks.AIR;
    }

    protected boolean canSustainBush(IBlockState state) {
        Block ground = state.getBlock();
        return ground == Blocks.SAND || ground == Blocks.GRASS || ground == Blocks.DIRT || ground == Blocks.GRAVEL;
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        checkAndDropBlock(worldIn, pos, state);
        super.onBlockAdded(worldIn, pos, state);
    }

    public boolean isReplaceable(World worldIn, BlockPos pos) {
        return false;
    }

}
