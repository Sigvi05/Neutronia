/*
package net.hdt.neutronia.blocks.end;

import eex.init.EndExPlantTypes;
import eex.world.gen.feature.WorldGenEndpalm;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.EnumPlantType;

import java.util.Random;

public class BlockEndSaplings extends BlockBushEndEx implements IGrowable
{
    public static final PropertyEnum<BlockEndLog.EnumType> TYPE = PropertyEnum.create("type", BlockEndLog.EnumType.class);
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

    public BlockEndSaplings()
    {
        super("end_saplings", Material.PLANTS);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return SAPLING_AABB;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if(!world.isRemote)
        {
            super.updateTick(world, pos, state, rand);

            if(world.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                grow(world, pos, state, rand);
            }
        }
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        for(BlockEndLog.EnumType type : BlockEndLog.EnumType.values())
        {
            list.add(new ItemStack(this, 1, type.ordinal()));
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
    {
        return EndExPlantTypes.END;
    }

    @Override
    public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state)
    {
        return (double) world.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World world, Random rand, BlockPos pos, IBlockState state)
    {
        grow(world, pos, state, rand);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(TYPE).ordinal();
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(TYPE, BlockEndLog.EnumType.fromMeta(meta & 7)).withProperty(STAGE, (meta & 8) >> 3);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | (state.getValue(TYPE)).ordinal();
        i = i | (state.getValue(STAGE)) << 3;
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, TYPE, STAGE);
    }

    public void grow(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if(state.getValue(STAGE) == 0)
        {
            world.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            generateTree(world, pos, state, rand);
        }
    }

    public void generateTree(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if(!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, rand, pos)) return;
        WorldGenerator treeGenerator = rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
        int posX = 0;
        int posZ = 0;
        boolean flag = false;

        switch(state.getValue(TYPE))
        {
            case ENDPALM:
                treeGenerator = new WorldGenEndpalm(2, 32);
                break;
        }

        IBlockState stateAir = Blocks.AIR.getDefaultState();

        if(flag)
        {
            world.setBlockState(pos.add(posX, 0, posZ), stateAir, 4);
            world.setBlockState(pos.add(posX + 1, 0, posZ), stateAir, 4);
            world.setBlockState(pos.add(posX, 0, posZ + 1), stateAir, 4);
            world.setBlockState(pos.add(posX + 1, 0, posZ + 1), stateAir, 4);
        }
        else
        {
            world.setBlockState(pos, stateAir, 4);
        }

        if(!treeGenerator.generate(world, rand, pos.add(posX, 0, posZ)))
        {
            if(flag)
            {
                world.setBlockState(pos.add(posX, 0, posZ), state, 4);
                world.setBlockState(pos.add(posX + 1, 0, posZ), state, 4);
                world.setBlockState(pos.add(posX, 0, posZ + 1), state, 4);
                world.setBlockState(pos.add(posX + 1, 0, posZ + 1), state, 4);
            }
            else
            {
                world.setBlockState(pos, state, 4);
            }
        }
    }
}
*/
