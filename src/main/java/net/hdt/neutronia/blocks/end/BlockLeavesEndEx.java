/*
package net.hdt.neutronia.blocks.end;

import eex.init.EndExBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public abstract class BlockLeavesEndEx extends BlockEndEx implements IShearable
{
    public static final PropertyBool DECAYABLE = PropertyBool.create("decayable");
    public static final PropertyBool CHECK_DECAY = PropertyBool.create("check_decay");
    private int[] surroundings;

    public BlockLeavesEndEx(String name, Material material)
    {
        super(name, material);

        setTickRandomly(true);
        setCreativeTab(CreativeTabs.DECORATIONS);
        setHardness(0.2F);
        setLightOpacity(1);
        setSoundType(SoundType.PLANT);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return Blocks.LEAVES.getBlockLayer();
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return Blocks.LEAVES.shouldSideBeRendered(state, world, pos, side);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World world, BlockPos pos, Random rand)
    {
        if(world.isRainingAt(pos.up()) && !world.getBlockState(pos.down()).isTopSolid() && rand.nextInt(15) == 1)
        {
            double posX = (double) ((float) pos.getX() + rand.nextFloat());
            double posY = (double) pos.getY() - 0.05D;
            double posZ = (double) ((float) pos.getZ() + rand.nextFloat());
            world.spawnParticle(EnumParticleTypes.DRIP_WATER, posX, posY, posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return Blocks.LEAVES.isOpaqueCube(state);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if(!world.isRemote)
        {
            if((state.getValue(CHECK_DECAY) && state.getValue(DECAYABLE)))
            {
                int k = pos.getX();
                int l = pos.getY();
                int i1 = pos.getZ();

                if(surroundings == null)
                {
                    surroundings = new int[32768];
                }

                if(world.isAreaLoaded(new BlockPos(k - 5, l - 5, i1 - 5), new BlockPos(k + 5, l + 5, i1 + 5)))
                {
                    BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

                    for(int i2 = -4; i2 <= 4; ++i2)
                    {
                        for(int j2 = -4; j2 <= 4; ++j2)
                        {
                            for(int k2 = -4; k2 <= 4; ++k2)
                            {
                                IBlockState testState = world.getBlockState(mutableBlockPos.setPos(k + i2, l + j2, i1 + k2));
                                Block testBlock = testState.getBlock();

                                if(!testBlock.canSustainLeaves(testState, world, mutableBlockPos.setPos(k + i2, l + j2, i1 + k2)))
                                {
                                    if(testBlock.isLeaves(testState, world, mutableBlockPos.setPos(k + i2, l + j2, i1 + k2)))
                                    {
                                        surroundings[(i2 + 16) * 1024 + (j2 + 16) * 32 + k2 + 16] = -2;
                                    }
                                    else
                                    {
                                        surroundings[(i2 + 16) * 1024 + (j2 + 16) * 32 + k2 + 16] = -1;
                                    }
                                }
                                else
                                {
                                    surroundings[(i2 + 16) * 1024 + (j2 + 16) * 32 + k2 + 16] = 0;
                                }
                            }
                        }
                    }

                    for(int i3 = 1; i3 <= 4; ++i3)
                    {
                        for(int j3 = -4; j3 <= 4; ++j3)
                        {
                            for(int k3 = -4; k3 <= 4; ++k3)
                            {
                                for(int l3 = -4; l3 <= 4; ++l3)
                                {
                                    if(surroundings[(j3 + 16) * 1024 + (k3 + 16) * 32 + l3 + 16] == i3 - 1)
                                    {
                                        if(surroundings[(j3 + 16 - 1) * 1024 + (k3 + 16) * 32 + l3 + 16] == -2)
                                        {
                                            surroundings[(j3 + 16 - 1) * 1024 + (k3 + 16) * 32 + l3 + 16] = i3;
                                        }

                                        if(surroundings[(j3 + 16 + 1) * 1024 + (k3 + 16) * 32 + l3 + 16] == -2)
                                        {
                                            surroundings[(j3 + 16 + 1) * 1024 + (k3 + 16) * 32 + l3 + 16] = i3;
                                        }

                                        if(surroundings[(j3 + 16) * 1024 + (k3 + 16 - 1) * 32 + l3 + 16] == -2)
                                        {
                                            surroundings[(j3 + 16) * 1024 + (k3 + 16 - 1) * 32 + l3 + 16] = i3;
                                        }

                                        if(surroundings[(j3 + 16) * 1024 + (k3 + 16 + 1) * 32 + l3 + 16] == -2)
                                        {
                                            surroundings[(j3 + 16) * 1024 + (k3 + 16 + 1) * 32 + l3 + 16] = i3;
                                        }

                                        if(surroundings[(j3 + 16) * 1024 + (k3 + 16) * 32 + (l3 + 16 - 1)] == -2)
                                        {
                                            surroundings[(j3 + 16) * 1024 + (k3 + 16) * 32 + (l3 + 16 - 1)] = i3;
                                        }

                                        if(surroundings[(j3 + 16) * 1024 + (k3 + 16) * 32 + l3 + 16 + 1] == -2)
                                        {
                                            surroundings[(j3 + 16) * 1024 + (k3 + 16) * 32 + l3 + 16 + 1] = i3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                int l2 = surroundings[16912];

                if(l2 >= 0)
                {
                    world.setBlockState(pos, state.withProperty(CHECK_DECAY, false), 4);
                }
                else
                {
                    destroy(world, pos);
                }
            }
        }
    }

    @Override
    public int quantityDropped(Random random)
    {
        return random.nextInt(20) == 0 ? 1 : 0;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(EndExBlocks.END_SAPLINGS);
    }

    @Override
    public void dropBlockAsItemWithChance(World world, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(world, pos, state, chance, fortune);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        int k = pos.getX();
        int l = pos.getY();
        int i1 = pos.getZ();

        if(world.isAreaLoaded(new BlockPos(k - 2, l - 2, i1 - 2), new BlockPos(k + 2, l + 2, i1 + 2)))
        {
            for(int j1 = -1; j1 <= 1; ++j1)
            {
                for(int k1 = -1; k1 <= 1; ++k1)
                {
                    for(int l1 = -1; l1 <= 1; ++l1)
                    {
                        BlockPos newPos = pos.add(j1, k1, l1);
                        IBlockState checkState = world.getBlockState(newPos);

                        if(checkState.getBlock().isLeaves(checkState, world, newPos))
                        {
                            checkState.getBlock().beginLeavesDecay(checkState, world, newPos);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean causesSuffocation(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean
    isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
    {
        return true;
    }

    @Override
    public boolean
    isLeaves(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return true;
    }

    @Override
    public void beginLeavesDecay(IBlockState state, World world, BlockPos pos)
    {
        if(!state.getValue(CHECK_DECAY))
        {
            world.setBlockState(pos, state.withProperty(CHECK_DECAY, true), 4);
        }
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        Random rand = world instanceof World ? ((World) world).rand : new Random();
        int chance = getSaplingDropChance(state);

        if(fortune > 0)
        {
            chance -= 2 << fortune;

            if(chance < 10)
            {
                chance = 10;
            }
        }
        if(rand.nextInt(chance) == 0)
        {

            ItemStack drop = new ItemStack(getItemDropped(state, rand, fortune), 1, damageDropped(state));
            if(!drop.isEmpty())
            {
                drops.add(drop);
            }
        }

        chance = 200;

        if(fortune > 0)
        {
            chance -= 10 << fortune;
            if(chance < 40) chance = 40;
        }

        captureDrops(true);

        if(world instanceof World)
        {
            dropApple((World) world, pos, state, chance);
        }

        drops.addAll(captureDrops(false));
    }

    public abstract BlockEndLog.EnumType getWoodType(int meta);

    protected void dropApple(World world, BlockPos pos, IBlockState state, int chance)
    {
    }

    protected int getSaplingDropChance(IBlockState state)
    {
        return 20;
    }

    private void destroy(World world, BlockPos pos)
    {
        dropBlockAsItem(world, pos, world.getBlockState(pos), 0);
        world.setBlockToAir(pos);
    }
}
*/
