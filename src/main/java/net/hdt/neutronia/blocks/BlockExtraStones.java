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

public class BlockExtraStones extends BlockMod {


    public static final PropertyEnum<BlockExtraStones.EnumType> VARIANT = PropertyEnum.create("variant", BlockExtraStones.EnumType.class);


    public BlockExtraStones(String name) {
        super(Material.ROCK, MOD_ID, name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockExtraStones.EnumType.GRANITE_COBBLESTONE));
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
            case MARBLE:
                return 11;
            case LIMESTONE:
                return 7;
            case SANDSTONE:
                return 15;
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
        return this.getDefaultState().withProperty(VARIANT, BlockExtraStones.EnumType.byMetadata(meta));
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
        if(tab != this.getCreativeTabToDisplayOn()) {
            for (BlockExtraStones.EnumType blockstone$enumtype : BlockExtraStones.EnumType.values()) {
                list.add(new ItemStack(this, 1, blockstone$enumtype.getMetadata()));
            }
        }
    }

    public enum EnumType implements IStringSerializable {
        GRANITE_COBBLESTONE(0, MapColor.DIRT, "granite_cobblestone"),
        GRANITE_BRICKS(1, MapColor.DIRT, "granite_bricks"),
        DIORITE_COBBLESTONE(2, MapColor.QUARTZ, "diorite_cobblestone"),
        DIORITE_BRICKS(3, MapColor.QUARTZ, "diorite_bricks"),
        ANDESITE_COBBLESTONE(4, MapColor.STONE, "andesite_cobblestone"),
        ANDESITE_BRICKS(5, MapColor.STONE, "andesite_bricks"),
        LIMESTONE(6, MapColor.STONE, "limestone"),
        LIMESTONE_COBBLESTONE(7, MapColor.STONE, "limestone_cobblestone"),
        LIMESTONE_BRICKS(8, MapColor.STONE, "limestone_bricks"),
        LIMESTONE_SMOOTH(9, MapColor.STONE, "limestone_smooth"),
        MARBLE(10, MapColor.QUARTZ, "marble"),
        MARBLE_COBBLESTONE(11, MapColor.QUARTZ, "marble_cobblestone"),
        MARBLE_BRICKS(12, MapColor.QUARTZ, "marble_bricks"),
        MARBLE_SMOOTH(13, MapColor.QUARTZ, "marble_smooth"),
        SANDSTONE(14, MapColor.SAND, "sandstone"),
        SANDSTONE_COBBLESTONE(15, MapColor.SAND, "sandstone_cobblestone");

        /**
         * Array of the Block's BlockStates
         */
        private static final BlockExtraStones.EnumType[] META = new BlockExtraStones.EnumType[values().length];

        static {
            for (BlockExtraStones.EnumType blockstone$enumtype : values()) {
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
        public static BlockExtraStones.EnumType byMetadata(int meta) {
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