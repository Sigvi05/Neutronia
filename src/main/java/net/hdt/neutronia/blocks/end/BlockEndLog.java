/*
package net.hdt.neutronia.blocks.end;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class BlockEndLog extends BlockLogEndEx
{
    public static final PropertyEnum<EnumType> TYPE = PropertyEnum.create("type", EnumType.class, type -> type.ordinal() < 4);

    public BlockEndLog()
    {
        super("end_log", Material.WOOD);
        setDefaultState(blockState.getBaseState().withProperty(AXIS, EnumAxis.Y));
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        for(EnumType type : EnumType.values())
        {
            list.add(new ItemStack(this, 1, type.ordinal()));
        }
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(TYPE).ordinal();
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, state.getValue(TYPE).ordinal());
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = getDefaultState().withProperty(TYPE, EnumType.fromMeta((meta & 3) % 4));

        switch(meta & 12)
        {
            case 0:
                state = state.withProperty(AXIS, EnumAxis.Y);
                break;
            case 4:
                state = state.withProperty(AXIS, EnumAxis.X);
                break;
            case 8:
                state = state.withProperty(AXIS, EnumAxis.Z);
                break;
            default:
                state = state.withProperty(AXIS, EnumAxis.NONE);
        }

        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | state.getValue(TYPE).ordinal();

        switch(state.getValue(AXIS))
        {
            case X:
                i |= 4;
                break;
            case Z:
                i |= 8;
                break;
            case NONE:
                i |= 12;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, TYPE, AXIS);
    }

    public enum EnumType implements IStringSerializable
    {
        ENDPALM;

        @Override
        public String getName()
        {
            return toString().toLowerCase();
        }

        public static EnumType fromMeta(int meta)
        {
            if(meta < 0 || meta >= values().length)
            {
                meta = 0;
            }

            return values()[meta];
        }
    }
}
*/
