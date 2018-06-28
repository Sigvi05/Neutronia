package net.hdt.neutronia.world.dimensions.base.gen.feature;

import net.hdt.neutronia.api.config.IConfig;
import net.hdt.neutronia.util.NumberHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public abstract class Feature extends WorldGenerator implements IFeature
{
    protected int genAttempts;
    protected float genProbability;
    protected boolean randomizeGenAttempts;
    protected int minHeight;
    protected int maxHeight;

    public Feature(IConfig config)
    {
        genAttempts = config.getInt("genAttempts", 4);
        genProbability = config.getFloat("genProbability", 1.0F);
        randomizeGenAttempts = config.getBoolean("randomizeGenAttempts", false);
        minHeight = config.getInt("minHeight", 16);
        maxHeight = config.getInt("maxHeight", 112);
    }

    public Feature(int genAttemptsIn, float genProbabilityIn, boolean randomizeGenAttemptsIn, int minHeightIn, int maxHeightIn)
    {
        genAttempts = genAttemptsIn;
        genProbability = genProbabilityIn;
        randomizeGenAttempts = randomizeGenAttemptsIn;
        minHeight = minHeightIn;
        maxHeight = maxHeightIn;
    }

    @Override
    public abstract boolean generate(World world, Random rand, BlockPos pos);

    @Override
    public int getGenAttempts()
    {
        return genAttempts;
    }

    @Override
    public int getGenAttempts(Random rand)
    {
        int attempts = genAttempts;

        if(genProbability > 0.0F && genProbability < 1.0F && rand.nextFloat() > genProbability)
        {
            attempts = 0;
        }
        if(randomizeGenAttempts)
        {
            attempts = NumberHelper.getNumberInRange(1, attempts, rand);
        }

        return attempts;
    }

    @Override
    public float getGenProbability()
    {
        return genProbability;
    }

    @Override
    public boolean randomizeGenAttempts()
    {
        return randomizeGenAttempts;
    }

    @Override
    public int getMinHeight()
    {
        return minHeight;
    }

    @Override
    public int getMaxHeight()
    {
        return maxHeight;
    }
}