package net.hdt.neutronia.blocks.base;

import net.hdt.huskylib2.blocks.BlockMetaVariants;
import net.hdt.huskylib2.interf.IBlockColorProvider;
import net.hdt.huskylib2.interf.IModBlock;
import net.hdt.huskylib2.recipie.RecipeHandler;
import net.hdt.huskylib2.utils.ProxyRegistry;
import net.hdt.neutronia.items.ItemModBlockColoredSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.text.WordUtils;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class BlockModColoredSlab extends BlockSlab implements IModBlock, IBlockColorProvider {

    public static final PropertyEnum prop = PropertyEnum.create("prop", DummyEnum.class);
    public static HashMap<BlockModColoredSlab, BlockModColoredSlab> halfSlabs = new HashMap<>();
    public static HashMap<BlockModColoredSlab, BlockModColoredSlab> fullSlabs = new HashMap<>();
    static boolean tempDoubleSlab;
    private final String[] variants;
    private final String bareName, modid;
    boolean doubleSlab;
    public final EnumDyeColor color;

    public BlockModColoredSlab(String name, String modid, EnumDyeColor color, Material materialIn, boolean doubleSlab) {
        super(hacky(materialIn, doubleSlab));

        this.doubleSlab = doubleSlab;
        if (doubleSlab)
            name += "_double";

        variants = new String[]{name};
        bareName = name;
        this.modid = modid;
        this.color = color;

        setTranslationKey(name);
        if (!doubleSlab) {
            useNeighborBrightness = true;
            setDefaultState(blockState.getBaseState().withProperty(HALF, EnumBlockHalf.BOTTOM));
        }

        setCreativeTab(doubleSlab ? null : CreativeTabs.BUILDING_BLOCKS);
    }

    public static Material hacky(Material m, boolean doubleSlab) {
        tempDoubleSlab = doubleSlab;
        return m;
    }

    public static void initSlab(Block base, int meta, BlockModColoredSlab half, BlockModColoredSlab full) {
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

    @Override
    public String getTranslationKey(int meta) {
        return getTranslationKey();
    }

    @Override
    public BlockStateContainer createBlockState() {
        return tempDoubleSlab ? new BlockStateContainer(this, getVariantProp()) : new BlockStateContainer(this, HALF, getVariantProp());
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (doubleSlab)
            return getDefaultState();
        else return getDefaultState().withProperty(HALF, meta == 8 ? EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        if (doubleSlab)
            return 0;
        else return state.getValue(HALF) == EnumBlockHalf.TOP ? 8 : 0;
    }

    public BlockSlab getFullBlock() {
        return fullSlabs.get(this);
    }

    public BlockSlab getSingleBlock() {
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
        setRegistryName(modid, bareName);
        ProxyRegistry.register(this);
        if (!isDouble())
            ProxyRegistry.register(new ItemModBlockColoredSlab(this, new ResourceLocation(modid, bareName)));
    }

    @Override
    public String getBareName() {
        return bareName;
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

    @Override
    public IProperty[] getIgnoredProperties() {
        return doubleSlab ? new IProperty[]{prop, HALF} : new IProperty[]{prop};
    }

    @Override
    public boolean isDouble() {
        return doubleSlab;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        IBlockState state = getActualState(base_state, world, pos);
        if(base_state.getMaterial() == Material.GLASS) {
            return isDouble()
                    || (state.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP && side == EnumFacing.UP)
                    || (state.getValue(BlockSlab.HALF) == EnumBlockHalf.BOTTOM && side == EnumFacing.DOWN);
        } else {
            return false;
        }
    }

    @Override
    public IProperty<?> getVariantProp() {
        return prop;
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return prop;
    }

    @Override
    public Class getVariantEnum() {
        return DummyEnum.class;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return DummyEnum.BLARG;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        if(blockState.getMaterial() == Material.GLASS) {
            if (this.isDouble()) {
                return this.originalShouldSideBeRendered(blockState, blockAccess, pos, side);
            } else if (side != EnumFacing.UP && side != EnumFacing.DOWN && !super.shouldSideBeRendered(blockState, blockAccess, pos, side)) {
                return false;
            }
        }

        return this.originalShouldSideBeRendered(blockState, blockAccess, pos, side);
    }

    @SideOnly(Side.CLIENT)
    public boolean originalShouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        AxisAlignedBB axisalignedbb = blockState.getBoundingBox(blockAccess, pos);

        switch (side) {
            case DOWN:

                if (axisalignedbb.minY > 0.0D) {
                    return true;
                }

                break;
            case UP:

                if (axisalignedbb.maxY < 1.0D) {
                    return true;
                }

                break;
            case NORTH:

                if (axisalignedbb.minZ > 0.0D) {
                    return true;
                }

                break;
            case SOUTH:

                if (axisalignedbb.maxZ < 1.0D) {
                    return true;
                }

                break;
            case WEST:

                if (axisalignedbb.minX > 0.0D) {
                    return true;
                }

                break;
            case EAST:

                if (axisalignedbb.maxX < 1.0D) {
                    return true;
                }
        }

        IBlockState sideBlockState = blockAccess.getBlockState(pos.offset(side));

        Material material = sideBlockState.getMaterial();

        // Glass and other transparent materials force this side to be transparent.
        if (!material.isOpaque() && material != Material.AIR) {
            return false;
        }

        return !sideBlockState.doesSideBlockRendering(blockAccess, pos.offset(side), side.getOpposite());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }


    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        return true;
    }

    public static enum DummyEnum implements BlockMetaVariants.EnumBase {
        BLARG
    }

    private static TextFormatting getFromColor(EnumDyeColor color) {
        switch (color) {
            case ORANGE:
                return TextFormatting.GOLD;
            case MAGENTA:
                return TextFormatting.LIGHT_PURPLE;
            case LIGHT_BLUE:
                return TextFormatting.BLUE;
            case YELLOW:
                return TextFormatting.YELLOW;
            case LIME:
                return TextFormatting.GREEN;
            case PINK:
                return TextFormatting.LIGHT_PURPLE;
            case GRAY:
                return TextFormatting.DARK_GRAY;
            case SILVER:
                return TextFormatting.GRAY;
            case CYAN:
                return TextFormatting.DARK_AQUA;
            case PURPLE:
                return TextFormatting.DARK_PURPLE;
            case BLUE:
                return TextFormatting.DARK_BLUE;
            case BROWN:
                return TextFormatting.GOLD;
            case GREEN:
                return TextFormatting.DARK_GREEN;
            case RED:
                return TextFormatting.DARK_RED;
            case BLACK:
                return TextFormatting.BLACK;
            default:
                return TextFormatting.WHITE;
        }
    }

    @Override
    public String getModNamespace() {
        return modid;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!GuiScreen.isShiftKeyDown()) {
            tooltip.add("Hold " + TextFormatting.BOLD + getFromColor(color) + "SHIFT " + TextFormatting.GRAY + "for more information");
        } else {
            String colorName = color.getName().replace("_", " ");
            colorName = WordUtils.capitalize(colorName);
            tooltip.add("Color: " + TextFormatting.BOLD.toString() + getFromColor(color).toString() + colorName);
        }
    }

    @Override
    public IBlockColor getBlockColor() {
        return (state, worldIn, pos, tintIndex) -> EnumDyeColor.values()[tintIndex].getColorValue();
    }

    @Override
    public IItemColor getItemColor() {
        return (stack, tintIndex) -> EnumDyeColor.values()[tintIndex].getColorValue();
    }

}