package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.blocks.base.BlockModBush;
import net.hdt.neutronia.init.NCreativeTabs;
import net.hdt.neutronia.base.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class BlockWaterPlantBase extends BlockModBush {

    private static final PropertyEnum<EnumFacing> FACING = BlockHorizontal.FACING;

    public BlockWaterPlantBase(String name) {
        super(Material.WATER, name, Reference.MOD_ID);
        this.setCreativeTab(NCreativeTabs.OCEAN_EXPANSION_TAB);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(LEVEL, 15));
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

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        switch (face) {
            case DOWN:
                return false;
            case UP:
                return isWater(world, pos.add(0, 1, 0));
            case NORTH:
                return isWater(world, pos.add(0, 0, -1));
            case SOUTH:
                return isWater(world, pos.add(0, 0, 1));
            case EAST:
                return isWater(world, pos.add(1, 0, 0));
            case WEST:
                return isWater(world, pos.add(-1, 0, 0));
        }
        return false;
    }

    private boolean isWater(IBlockAccess world, BlockPos pos) {
        return world.getBlockState(pos).getMaterial() == Material.WATER;
    }

    @Override
    public boolean isTranslucent(IBlockState state) {
        return true;
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        IBlockState state = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand);
        return state.withProperty(FACING, placer.getHorizontalFacing());
    }

    public int getMetaFromState(IBlockState state) {
        return (state.getValue(FACING)).getHorizontalIndex() & state.getValue(LEVEL);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta));
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, LEVEL);
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
