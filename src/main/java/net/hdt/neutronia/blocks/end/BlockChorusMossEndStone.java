/*
package net.hdt.neutronia.blocks.end;

import eex.handler.ConfigHandler;
import eex.init.EndExBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockChorusMossEndStone extends BlockEndEx
{
    public static final PropertyEnum<EnumType> TYPE = PropertyEnum.create("type", EnumType.class);

    public BlockChorusMossEndStone()
    {
        super("end_stone_chorus_moss", Material.ROCK);
        setHardness(3.0F);
        setResistance(15.0F);
        setTickRandomly(ConfigHandler.blockConfig.chorusMoss.doesSpread);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
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
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if(!world.isRemote)
        {
            IBlockState setState = getMetaFromState(state) == 0 ? Blocks.END_STONE.getDefaultState() : EndExBlocks.END_STONE.getDefaultState().withProperty(BlockEndStone.TYPE, BlockEndStone.EnumType.fromMeta(getMetaFromState(state) - 1));

            if(world.getLightFromNeighbors(pos.up()) < 4 && world.getBlockState(pos.up()).getLightOpacity(world, pos.up()) > 2)
            {
                world.setBlockState(pos, setState);
            }
            else
            {
                if(world.getLightFromNeighbors(pos.up()) >= 9)
                {
                    for(int i = 0; i < 4; ++i)
                    {
                        BlockPos newPos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if(newPos.getY() >= 0 && newPos.getY() < 256 && !world.isBlockLoaded(newPos))
                        {
                            return;
                        }

                        IBlockState checkState = world.getBlockState(newPos);

                        if(checkState.getBlock() == setState && world.getLightFromNeighbors(newPos.up()) >= 0)
                        {
                            world.setBlockState(newPos, getDefaultState().withProperty(TYPE, EnumType.fromMeta(getMetaFromState(state))));
                        }
                    }
                }
            }
        }
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(TYPE).ordinal();
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(TYPE, EnumType.fromMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(TYPE).ordinal();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, TYPE);
    }

    public enum EnumType implements IStringSerializable
    {
        NORMAL,
        HYDROUS,
        SALTY,
        STARRY,
        BARREN;

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
