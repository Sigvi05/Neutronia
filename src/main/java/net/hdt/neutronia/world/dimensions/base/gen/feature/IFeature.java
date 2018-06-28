package net.hdt.neutronia.world.dimensions.base.gen.feature;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public interface IFeature
{
    boolean generate(World world, Random rand, BlockPos pos);

    int getGenAttempts();

    int getGenAttempts(Random rand);

    float getGenProbability();

    boolean randomizeGenAttempts();

    int getMinHeight();

    int getMaxHeight();
}