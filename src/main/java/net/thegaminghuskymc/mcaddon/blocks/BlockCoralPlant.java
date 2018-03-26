package net.thegaminghuskymc.mcaddon.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.mcaddon.properties.EnumCoralColor;

import static net.minecraft.block.BlockLiquid.LEVEL;
import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

public class BlockCoralPlant extends BlockModBush {

    private final EnumCoralColor color;
    private static final PropertyEnum<EnumFacing> FACING = BlockHorizontal.FACING;

    public BlockCoralPlant(EnumCoralColor colorIn, String name) {
        super(Material.WATER, colorIn + "_" + name, MOD_ID);
        this.color = colorIn;
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(LEVEL, 15));
        StateMap.Builder builder = new StateMap.Builder();
        ModelLoader.setCustomStateMapper(this, builder.ignore(LEVEL).build());
    }

    @SideOnly(Side.CLIENT)
    public static EnumCoralColor getColorFromItem(Item itemIn) {
        return getColorFromBlock(Block.getBlockFromItem(itemIn));
    }

    @SideOnly(Side.CLIENT)
    private static EnumCoralColor getColorFromBlock(Block blockIn) {
        return blockIn instanceof BlockCoralPlant ? ((BlockCoralPlant) blockIn).getColor() : EnumCoralColor.BLUE;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    private EnumCoralColor getColor() {
        return this.color;
    }

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        state = worldIn.getBlockState(pos.down());
        Block block = state.getBlock();
        if (worldIn.getBlockState(pos.up()).getMaterial() != Material.WATER) return false;
        return block.canSustainPlant(state, worldIn, pos.down(), EnumFacing.UP, this);
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        IBlockState state = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand);
        return state.withProperty(FACING, placer.getHorizontalFacing());
    }

    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return canBlockStay(Minecraft.getMinecraft().world, pos, this.getDefaultState());
    }

    public int getMetaFromState(IBlockState state) {
        return (state.getValue(FACING)).getHorizontalIndex() & state.getValue(LEVEL);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, LEVEL);
    }

}
