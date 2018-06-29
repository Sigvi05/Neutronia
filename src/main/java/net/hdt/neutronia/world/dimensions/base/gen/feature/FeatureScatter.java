package net.hdt.neutronia.world.dimensions.base.gen.feature;

import net.hdt.neutronia.api.config.IConfig;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class FeatureScatter extends Feature
{
    private IBlockState blockToSpawn;
    private IBlockState blockToTarget;
    private Placement placement;

    public FeatureScatter(IConfig config)
    {
        super(config);
        blockToSpawn = config.getBlock("blockToSpawn", Blocks.BARRIER.getDefaultState());
        blockToTarget = config.getBlock("blockToTarget", Blocks.BARRIER.getDefaultState());
        placement = config.getEnum("placement", Placement.class, Placement.ON_GROUND);
    }

    public FeatureScatter(int genAttempts, float genProbability, boolean randomizeGenAttempts, int minHeight, int maxHeight, IBlockState blockToSpawnIn, IBlockState blockToTargetIn, Placement placementIn)
    {
        super(genAttempts, genProbability, randomizeGenAttempts, minHeight, maxHeight);
        blockToSpawn = blockToSpawnIn;
        blockToTarget = blockToTargetIn;
        placement = placementIn;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        if(blockToSpawn.getBlock() == Blocks.BARRIER || blockToTarget.getBlock() == Blocks.BARRIER)
        {
            return false;
        }

        for(int i = 0; i < 64; ++i)
        {
            BlockPos newPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if(world.isAirBlock(newPos) && world.getBlockState(newPos.down()) == blockToTarget)
            {
                if(blockToSpawn instanceof BlockBush)
                {
                    if(((BlockBush) blockToSpawn).canBlockStay(world, placement.offsetPos(pos), blockToSpawn))
                    {
                        world.setBlockState(placement.offsetPos(newPos), blockToSpawn, 2);
                    }
                }
                else
                {
                    world.setBlockState(placement.offsetPos(newPos), blockToSpawn, 2);
                }
            }
        }

        return true;
    }

    public enum Placement
    {
        ON_GROUND(null),
        IN_GROUND(EnumFacing.DOWN);

        EnumFacing offset;

        Placement(EnumFacing offsetIn)
        {
            offset = offsetIn;
        }

        public BlockPos offsetPos(BlockPos pos)
        {
            if(offset != null)
            {
                return pos.offset(offset);
            }
            else
            {
                return pos;
            }
        }
    }
}