package net.hdt.neutronia.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;
import net.thegaminghuskymc.huskylib2.items.blocks.ItemModBlockSlab;
import net.thegaminghuskymc.huskylib2.recipie.RecipeHandler;
import net.thegaminghuskymc.huskylib2.utils.ProxyRegistry;

import java.util.HashMap;
import java.util.Random;

public class BlockVerticalSlab extends Block implements IModBlock {

    public static final PropertyEnum<BlockSlab.EnumBlockHalf> HALF = PropertyEnum.create("half", BlockSlab.EnumBlockHalf.class);
    public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    protected static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.5D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.5D);
    protected static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.5D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    public static HashMap<BlockVerticalSlab, BlockVerticalSlab> halfSlabs = new HashMap<>();
    public static HashMap<BlockVerticalSlab, BlockVerticalSlab> fullSlabs = new HashMap<>();
    static boolean tempDoubleSlab;
    private final String[] variants;
    private final String bareName, modid;
    boolean doubleSlab;

    public BlockVerticalSlab(String name, String modid, Material materialIn, boolean doubleSlab) {
        super(hacky(materialIn, doubleSlab));
        this.doubleSlab = doubleSlab;
        if (doubleSlab)
            name += "_double";

        variants = new String[]{name};
        bareName = name;
        this.modid = modid;

        setUnlocalizedName(name);
        if (!doubleSlab) {
            useNeighborBrightness = true;
            setDefaultState(blockState.getBaseState().withProperty(PROPERTYFACING, EnumFacing.NORTH).withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM));
        }
    }

    public static Material hacky(Material m, boolean doubleSlab) {
        tempDoubleSlab = doubleSlab;
        return m;
    }

    public static void initSlab(Block base, int meta, BlockVerticalSlab half, BlockVerticalSlab full) {
        fullSlabs.put(half, full);
        fullSlabs.put(full, full);
        halfSlabs.put(half, half);
        halfSlabs.put(full, half);

        half.register();
        full.register();

        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(half, 6),
                "BBB",
                'B', ProxyRegistry.newStack(base, 1, meta));
    }

    protected boolean canSilkHarvest() {
        return false;
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (isDouble())
            return FULL_BLOCK_AABB;
        if (state.getValue(PROPERTYFACING) == EnumFacing.NORTH)
            return AABB_NORTH;
        if (state.getValue(PROPERTYFACING) == EnumFacing.SOUTH)
            return AABB_SOUTH;
        if (state.getValue(PROPERTYFACING) == EnumFacing.EAST)
            return AABB_EAST;
        if (state.getValue(PROPERTYFACING) == EnumFacing.WEST)
            return AABB_WEST;
        else
            return FULL_BLOCK_AABB;
    }

    public boolean isTopSolid(IBlockState state) {
        return isDouble();
    }

    public boolean isOpaqueCube(IBlockState state) {
        return isDouble();
    }

    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        if (ForgeModContainer.disableStairSlabCulling)
            return super.doesSideBlockRendering(state, world, pos, face);
        if (state.isOpaqueCube()) {
            return true;
        } else {
            EnumFacing facing = state.getValue(PROPERTYFACING);
            return facing == EnumFacing.NORTH && face == EnumFacing.SOUTH || facing == EnumFacing.SOUTH && face == EnumFacing.NORTH || facing == EnumFacing.EAST && face == EnumFacing.WEST || facing == EnumFacing.WEST && face == EnumFacing.EAST;
        }
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
                                            EntityLivingBase placer) {
        if (placer.getHorizontalFacing() == EnumFacing.NORTH) {
            if (facing == EnumFacing.SOUTH)
                return getDefaultState().withProperty(PROPERTYFACING, facing);
            if ((double) hitZ < 0.5D && !isDouble())
                return getDefaultState().withProperty(PROPERTYFACING, EnumFacing.SOUTH);
            else
                return getDefaultState().withProperty(PROPERTYFACING, EnumFacing.NORTH);
        }
        if (placer.getHorizontalFacing() == EnumFacing.SOUTH) {
            if (facing == EnumFacing.NORTH)
                return getDefaultState().withProperty(PROPERTYFACING, facing);
            if ((double) hitZ < 0.5D || isDouble())
                return getDefaultState().withProperty(PROPERTYFACING, EnumFacing.SOUTH);
            else
                return getDefaultState().withProperty(PROPERTYFACING, EnumFacing.NORTH);
        }
        if (placer.getHorizontalFacing() == EnumFacing.EAST) {
            if (facing == EnumFacing.WEST)
                return getDefaultState().withProperty(PROPERTYFACING, facing);
            if ((double) hitX < 0.5D || isDouble())
                return getDefaultState().withProperty(PROPERTYFACING, EnumFacing.EAST);
            else
                return getDefaultState().withProperty(PROPERTYFACING, EnumFacing.WEST);
        }
        if (placer.getHorizontalFacing() == EnumFacing.WEST) {
            if (facing == EnumFacing.EAST)
                return getDefaultState().withProperty(PROPERTYFACING, facing);
            if ((double) hitX < 0.5D && !isDouble())
                return getDefaultState().withProperty(PROPERTYFACING, EnumFacing.EAST);
            else
                return getDefaultState().withProperty(PROPERTYFACING, EnumFacing.WEST);
        } else {
            return getDefaultState().withProperty(PROPERTYFACING, EnumFacing.NORTH);
        }
    }

    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(PROPERTYFACING, rot.rotate(state.getValue(PROPERTYFACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(PROPERTYFACING)));
    }

    public int quantityDropped(Random random) {
        return isDouble() ? 2 : 1;
    }

    public boolean isFullCube(IBlockState state) {
        return isDouble();
    }

    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        if (isDouble())
            return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
        else
            return true;
    }

    @Override
    public BlockStateContainer createBlockState() {
        return tempDoubleSlab ? new BlockStateContainer(this, PROPERTYFACING, getVariantProp()) : new BlockStateContainer(this, PROPERTYFACING, getVariantProp());
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    public BlockVerticalSlab getFullBlock() {
        return fullSlabs.get(this);
    }

    public BlockVerticalSlab getSingleBlock() {
        return halfSlabs.get(this);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(getSingleBlock());
    }

    @Override
    public Item getItemDropped(IBlockState p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(getSingleBlock());
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return super.quantityDropped(state, fortune, random);
    }

    public void register() {
        setRegistryName(getPrefix(), bareName);
        ProxyRegistry.register(this);
        if (!isDouble())
            ProxyRegistry.register(new ItemModBlockSlab(this, new ResourceLocation(getPrefix(), bareName)));
    }

    @Override
    public String getBareName() {
        return bareName;
    }

    @Override
    public IProperty getVariantProp() {
        return null;
    }

    @Override
    public IProperty[] getIgnoredProperties() {
        return new IProperty[0];
    }

    @Override
    public String[] getVariants() {
        return variants;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }

    public boolean isDouble() {
        return doubleSlab;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return isDouble();
    }

    @Override
    public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        IBlockState state = getActualState(base_state, world, pos);
        return isDouble()
                || (state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP && side == EnumFacing.UP)
                || (state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM && side == EnumFacing.DOWN);
    }

    @Override
    public String getPrefix() {
        return this.modid;
    }

    @Override
    public String getModNamespace() {
        return this.modid;
    }

    @Override
    public Class getVariantEnum() {
        return null;
    }
}
