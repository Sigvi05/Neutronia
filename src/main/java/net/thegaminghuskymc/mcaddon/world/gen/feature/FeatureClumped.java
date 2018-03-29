package net.thegaminghuskymc.mcaddon.world.gen.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.thegaminghuskymc.mcaddon.util.BlockUtil;
import net.thegaminghuskymc.mcaddon.world.biome.NetherBiome;

import java.util.Random;

public class FeatureClumped extends Feature
{
    private final IBlockState blockToSpawn;

    public FeatureClumped(Biome biome, NetherBiome.BiomeFeature feature)
    {
        super(biome, feature);

        blockToSpawn = BlockUtil.getBlock(feature.getBlockToSpawn(), "minecraft:air");
    }

    @Override
    public boolean generate(World world, BlockPos pos, Random rand)
    {
        if(!world.isAirBlock(pos))
        {
            return false;
        }
        else if(!world.getBlockState(pos.up()).isSideSolid(world, pos.up(), EnumFacing.DOWN))
        {
            return false;
        }
        else
        {
            world.setBlockState(pos, blockToSpawn, 3);

            for(int i = 0; i < 1500; ++i)
            {
                BlockPos newPos = pos.add(rand.nextInt(8) - rand.nextInt(8), -rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8));

                if(world.isAirBlock(newPos))
                {
                    int j = 0;

                    for(EnumFacing enumfacing : EnumFacing.values())
                    {
                        if(world.getBlockState(newPos.offset(enumfacing)).getBlock() == blockToSpawn.getBlock())
                        {
                            ++j;
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

    @Override
    public boolean canGenerate()
    {
        return blockToSpawn != Blocks.AIR.getDefaultState();
    }

    @Override
    public FeatureType getType()
    {
        return FeatureType.CLUMPED;
    }
}