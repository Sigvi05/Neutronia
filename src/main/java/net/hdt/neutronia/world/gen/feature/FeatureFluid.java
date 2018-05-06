package net.hdt.neutronia.world.gen.feature;

import net.hdt.neutronia.api.config.IConfig;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class FeatureFluid extends Feature {
    private IBlockState blockToSpawn;
    private IBlockState blockToTarget;
    private boolean hidden;

    public FeatureFluid(IConfig config) {
        super(config);
        blockToSpawn = config.getBlock("blockToSpawn", Blocks.BARRIER.getDefaultState());
        blockToTarget = config.getBlock("blockToTarget", Blocks.BARRIER.getDefaultState());
        hidden = config.getBoolean("hidden", true);
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        if (blockToSpawn.getBlock() == Blocks.BARRIER || blockToTarget.getBlock() == Blocks.BARRIER) {
            return false;
        }

        if (world.getBlockState(pos.up()) != blockToTarget) {
            return false;
        } else if (!world.isAirBlock(pos) && world.getBlockState(pos) != blockToTarget) {
            return false;
        } else {
            int i = 0;

            if (world.getBlockState(pos.west()) == blockToTarget) {
                i++;
            }

            if (world.getBlockState(pos.east()) == blockToTarget) {
                i++;
            }

            if (world.getBlockState(pos.north()) == blockToTarget) {
                i++;
            }

            if (world.getBlockState(pos.south()) == blockToTarget) {
                i++;
            }

            if (world.getBlockState(pos.down()) == blockToTarget) {
                i++;
            }

            int j = 0;

            if (world.isAirBlock(pos.west())) {
                j++;
            }

            if (world.isAirBlock(pos.east())) {
                j++;
            }

            if (world.isAirBlock(pos.north())) {
                j++;
            }

            if (world.isAirBlock(pos.south())) {
                j++;
            }

            if (world.isAirBlock(pos.down())) {
                j++;
            }

            if (!hidden && i == 4 && j == 1 || i == 5) {
                world.setBlockState(pos, blockToSpawn, 2);
                world.immediateBlockTick(pos, blockToSpawn, rand);
            }

            return true;
        }
    }
}
