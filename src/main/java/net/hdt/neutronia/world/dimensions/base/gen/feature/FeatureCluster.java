package net.hdt.neutronia.world.dimensions.base.gen.feature;

import net.hdt.neutronia.api.config.IConfig;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class FeatureCluster extends Feature
{
    private IBlockState blockToSpawn;
    private IBlockState blockToAttachTo;
    private EnumFacing direction;

    public FeatureCluster(IConfig config)
    {
        super(config);
        blockToSpawn = config.getBlock("blockToSpawn", Blocks.BARRIER.getDefaultState());
        blockToAttachTo = config.getBlock("blockToAttachTo", Blocks.BARRIER.getDefaultState());
        direction = config.getEnum("direction", EnumFacing.class, EnumFacing.DOWN);
    }

    public FeatureCluster(int genAttempts, float genProbability, boolean randomizeGenAttempts, int minHeight, int maxHeight, IBlockState blockToSpawnIn, IBlockState blockToAttachToIn, EnumFacing directionIn)
    {
        super(genAttempts, genProbability, randomizeGenAttempts, minHeight, maxHeight);
        blockToSpawn = blockToSpawnIn;
        blockToAttachTo = blockToAttachToIn;
        direction = directionIn;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        if(blockToSpawn.getBlock() == Blocks.BARRIER || blockToAttachTo.getBlock() == Blocks.BARRIER)
        {
            return false;
        }

        if(!world.isAirBlock(pos))
        {
            return false;
        }
        else if(world.getBlockState(pos.offset(direction.getOpposite())) != blockToAttachTo)
        {
            return false;
        }
        else
        {
            world.setBlockState(pos, blockToSpawn, 3);

            for(int i = 0; i < 1500; i++)
            {
                BlockPos newPos;

                switch(direction)
                {
                    default:
                    case DOWN:
                        newPos = pos.add(rand.nextInt(8) - rand.nextInt(8), -rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8));
                        break;
                    case UP:
                        newPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8));
                        break;
                    case NORTH:
                        newPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(8) - rand.nextInt(8), -rand.nextInt(12));
                        break;
                    case SOUTH:
                        newPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(8) - rand.nextInt(8), rand.nextInt(12));
                        break;
                    case WEST:
                        newPos = pos.add(-rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8), rand.nextInt(8) - rand.nextInt(8));
                        break;
                    case EAST:
                        newPos = pos.add(rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8), rand.nextInt(8) - rand.nextInt(8));
                        break;
                }

                if(world.isAirBlock(newPos))
                {
                    int j = 0;

                    for(EnumFacing facing : EnumFacing.values())
                    {
                        if(world.getBlockState(newPos.offset(facing)).getBlock() == blockToSpawn.getBlock())
                        {
                            j++;
                        }

                        if(j > 1)
                        {
                            break;
                        }
                    }

                    if(j == 1)
                    {
                        world.setBlockState(newPos, blockToSpawn, 3);
                    }
                }
            }

            return true;
        }
    }
}