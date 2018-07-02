package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.blocks.base.BlockModBush;
import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.properties.EnumCoralColor;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockColoredWaterPlantBase extends BlockModBush {

    private static final PropertyEnum<EnumFacing> FACING = BlockHorizontal.FACING;
    private final EnumCoralColor color;
    protected static final AxisAlignedBB ALGAE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);

    public BlockColoredWaterPlantBase(EnumCoralColor coralColor, String name) {
        super(Material.PLANTS, coralColor + "_" + name, Reference.MOD_ID);
        this.color = coralColor;
        setTickRandomly(false);
        setSoundType(SoundType.PLANT);
        this.setCreativeTab(Main.OVERWORLD_EXPANSION_TAB);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.WATER || state.getMaterial() == Material.ICE;
    }

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        if (pos.getY() >= 0 && pos.getY() < 256) {
            IBlockState iblockstate = worldIn.getBlockState(pos.down());
            Material material = iblockstate.getMaterial();
            return material == Material.WATER && iblockstate.getValue(BlockLiquid.LEVEL) == 0 || material == Material.ICE;
        } else
            return false;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState state = worldIn.getBlockState(pos.down());
        return super.canPlaceBlockAt(worldIn, pos) && state.getBlock() == Blocks.WATER;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return ALGAE_AABB;
    }

    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

    @Override
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) {
        if (this == NBlocks.coralFan[getColor().getMetadata()] || this == NBlocks.deadCoralFan[getColor().getMetadata()]) {
            return side != EnumFacing.DOWN && side != EnumFacing.UP;
        } else {
            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    private EnumCoralColor getColor() {
        return this.color;
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        IBlockState state = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand);
        return state.withProperty(FACING, placer.getHorizontalFacing());
    }

    public int getMetaFromState(IBlockState state) {
        return (state.getValue(FACING)).getHorizontalIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

}
