package net.thegaminghuskymc.mcaddon.world.gen.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.thegaminghuskymc.mcaddon.util.BlockUtil;
import net.thegaminghuskymc.mcaddon.world.biome.NetherBiome;

import java.util.Random;

public class FeatureFluid extends Feature
{
    private final IBlockState blockToSpawn;
    private final IBlockState targetBlock;
    private final boolean hidden;

    public FeatureFluid(Biome biome, NetherBiome.BiomeFeature feature)
    {
        super(biome, feature);

        blockToSpawn = BlockUtil.getBlock(feature.getBlockToSpawn(), "minecraft:air");
        targetBlock = BlockUtil.getBlock(feature.getTargetBlock(), "minecraft:air");
        hidden = feature.isHidden();
    }

    @Override
    public boolean generate(World world, BlockPos pos, Random rand)
    {
        if(world.getBlockState(pos.up()) != targetBlock)
        {
            return false;
        }
        else if(!world.isAirBlock(pos) && world.getBlockState(pos) != targetBlock)
        {
            return false;
        }
        else
        {
            int i = 0;

            if(world.getBlockState(pos.west()) == targetBlock)
            {
                ++i;
            }

            if(world.getBlockState(pos.east()) == targetBlock)
            {
                ++i;
            }

            if(world.getBlockState(pos.north()) == targetBlock)
            {
                ++i;
            }

            if(world.getBlockState(pos.south()) == targetBlock)
            {
                ++i;
            }

            if(world.getBlockState(pos.down()) == targetBlock)
            {
                ++i;
            }

            int j = 0;

            if(world.isAirBlock(pos.west()))
            {
                ++j;
            }

            if(world.isAirBlock(pos.east()))
            {
                ++j;
            }

            if(world.isAirBlock(pos.north()))
            {
                ++j;
            }

            if(world.isAirBlock(pos.south()))
            {
                ++j;
            }

            if(world.isAirBlock(pos.down()))
            {
                ++j;
            }

            if(!hidden && i == 4 && j == 1 || i == 5)
            {
                IBlockState state = blockToSpawn;
                world.setBlockState(pos, state, 2);
                world.immediateBlockTick(pos, state, rand);
            }

            return true;
        }
    }

    @Override
    public boolean canGenerate()
    {
        return !(blockToSpawn == Blocks.AIR.getDefaultState() || targetBlock == Blocks.AIR.getDefaultState());
    }

    @Override
    public FeatureType getType()
    {
        return FeatureType.FLUID;
    }
}