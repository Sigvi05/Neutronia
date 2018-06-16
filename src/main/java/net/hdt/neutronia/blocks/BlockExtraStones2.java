package net.hdt.neutronia.blocks;

import net.hdt.huskylib2.blocks.BlockMod;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockExtraStones2 extends BlockMod {

    public static final PropertyEnum<BlockExtraStones2.EnumType> VARIANT = PropertyEnum.create("variant", BlockExtraStones2.EnumType.class);

    public BlockExtraStones2(String name) {
        super(Material.ROCK, MOD_ID, name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockExtraStones2.EnumType.SANDSTONE_BRICKS));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(1.8F);
        this.setResistance(10F);
    }

    @Nullable
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public int damageDropped(IBlockState state) {
        switch (state.getValue(VARIANT)) {
            case BASALT:
                return 3;
            case RED_SANDSTONE:
                return 7;
            default:
                return (state.getValue(VARIANT)).getMetadata();
        }
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, this.getMetaFromState(state));
    }


    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, BlockExtraStones2.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, VARIANT);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        if(tab != getCreativeTabToDisplayOn()) {
            for (BlockExtraStones2.EnumType blockstone$enumtype : BlockExtraStones2.EnumType.values()) {
                list.add(new ItemStack(this, 1, blockstone$enumtype.getMetadata()));
            }
        }
    }

    public enum EnumType implements IStringSerializable {
        SANDSTONE_BRICKS(0, MapColor.SAND, "sandstone_bricks"),
        SANDSTONE_SMOOTH(1, MapColor.SAND, "sandstone_smooth"),
        BASALT(2, MapColor.BLACK, "basalt"),
        BASALT_COBBLESTONE(3, MapColor.BLACK, "basalt_cobblestone"),
        BASALT_BRICKS(4, MapColor.BLACK, "basalt_bricks"),
        BASALT_SMOOTH(5, MapColor.BLACK, "basalt_smooth"),
        RED_SANDSTONE(6, MapColor.ADOBE, "red_sandstone"),
        RED_SANDSTONE_COBBLESTONE(7, MapColor.ADOBE, "red_sandstone_cobblestone"),
        RED_SANDSTONE_BRICKS(8, MapColor.ADOBE, "red_sandstone_bricks"),
        RED_SANDSTONE_SMOOTH(9, MapColor.ADOBE, "red_sandstone_smooth"),
        NETHERRACK_BRICKS(10, MapColor.NETHERRACK, "netherrack_bricks"),
        NETHERRACK_SMOOTH(11, MapColor.NETHERRACK, "netherrack_smooth"),
        STONE_SMOOTH(12, MapColor.STONE, "stone_smooth"),
        ENDSTONE_SMOOTH(13, MapColor.SAND, "endstone_smooth"),
        CONCRETE_WET(14, MapColor.STONE, "concrete_wet"),
        CONCRETE_DRY(15, MapColor.SAND, "concrete_dry");

        /**
         * Array of the Block's BlockStates
         */
        private static final BlockExtraStones2.EnumType[] META = new BlockExtraStones2.EnumType[values().length];

        static {
            for (BlockExtraStones2.EnumType blockstone$enumtype : values()) {
                META[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
            }
        }

        /**
         * The BlockState's metadata.
         */
        private final int meta;
        /**
         * The EnumType's name.
         */
        private final String name;
        private final String unlocalizedName;
        private final MapColor mapColor;

        EnumType(int i, MapColor color, String name) {
            this(i, color, name, name);
        }

        EnumType(int meta, MapColor color, String name, String name2) {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = name2;
            this.mapColor = color;
        }

        /**
         * Returns an EnumType for the BlockState from a metadata value.
         */
        public static BlockExtraStones2.EnumType byMetadata(int meta) {
            if (meta < 0 || meta >= META.length) {
                meta = 0;
            }

            return META[meta];
        }

        /**
         * Returns the EnumType's metadata value.
         */
        public int getMetadata() {
            return this.meta;
        }

        public MapColor getMapColor() {
            return this.mapColor;
        }

        public String toString() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }

    }
}