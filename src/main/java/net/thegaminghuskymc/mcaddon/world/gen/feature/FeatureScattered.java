package net.thegaminghuskymc.mcaddon.world.gen.feature;

import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.thegaminghuskymc.mcaddon.util.BlockUtil;
import net.thegaminghuskymc.mcaddon.world.biome.NetherBiome;

import java.util.Random;

public class FeatureScattered extends Feature
{
    private final IBlockState blockToSpawn;
    private final IBlockState targetBlock;

    public FeatureScattered(Biome biome, NetherBiome.BiomeFeature feature)
    {
        super(biome, feature);

        blockToSpawn = BlockUtil.getBlock(feature.getBlockToSpawn(), "minecraft:air");
        targetBlock = BlockUtil.getBlock(feature.getTargetBlock(), "minecraft:air");
    }

    @Override
    public boolean generate(World world, BlockPos pos, Random rand)
    {
        for(int i = 0; i < 64; ++i)
        {
            BlockPos newPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if(world.isAirBlock(newPos) && world.getBlockState(newPos.down()) == targetBlock)
            {
                if(blockToSpawn instanceof BlockBush)
                {
                    if(((BlockBush) blockToSpawn).canBlockStay(world, newPos, ((BlockBush) blockToSpawn).getDefaultState()))
                    {
                        world.setBlockState(newPos, blockToSpawn, 2);
                    }
                }
                else
                {
                    world.setBlockState(newPos, blockToSpawn, 2);
                }
            }
        }

        return true;
    }

    @Override
    public boolean canGenerate()
    {
        return !(blockToSpawn == Blocks.AIR.getDefaultState() || targetBlock == Blocks.AIR.getDefaultState());
    }

    @Override
    public FeatureType getType()
    {
        return FeatureType.SCATTERED;
    }
}