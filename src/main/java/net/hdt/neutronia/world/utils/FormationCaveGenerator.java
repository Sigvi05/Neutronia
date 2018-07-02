package net.hdt.neutronia.world.utils;

import net.hdt.neutronia.init.NBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FormationCaveGenerator implements IWorldGenerator {

    public FormationCaveGenerator() {

    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int x = chunkX * 16 + random.nextInt(16);
        int z = chunkZ * 16 + random.nextInt(16);

        for (int i = 15; i < 50; i++) {
            BlockPos pos = new BlockPos(x, i, z);
            BlockPos belowPos = pos.down();
            IBlockState state = world.getBlockState(pos);
            IBlockState stateBelow = world.getBlockState(belowPos);
            if (state.getBlock().isAir(state, world, pos) && stateBelow.getBlock() == Blocks.STONE) {
                makeFormationCaveAt(world, pos, random);
                return;
            }
        }
    }

    public void makeFormationCaveAt(World world, BlockPos source, Random rand) {
        double expandX = (rand.nextDouble() - 0.5) * 2;
        double expandY = (rand.nextDouble() - 0.5) * 0.1F;
        double expandZ = (rand.nextDouble() - 0.5) * 2;

        double curveAngle = rand.nextDouble() * Math.PI * 2;
        double curveRatio = rand.nextDouble() * 0.25 + 0.1;
        double curveX = Math.cos(curveAngle) * curveRatio;
        double curveY = (rand.nextFloat() - 0.5F) * 0.05F;
        double curveZ = Math.sin(curveAngle) * curveRatio;

        BlockPos hollowingCenter = source;
        Vec3d expansion = new Vec3d(expandX, expandY, expandZ).normalize();
        Vec3d curvature = new Vec3d(curveX, curveY, curveZ);

        int color1 = rand.nextInt(5);
        int color2;
        do {
            color2 = rand.nextInt(5);
        } while (color2 == color1);

        IBlockState crystal1 = NBlocks.brainCoral[color1].getDefaultState();
        IBlockState crystal2 = NBlocks.brainCoral[color2].getDefaultState();

        int length = 12 + rand.nextInt(10);
        int size = 4 + rand.nextInt(3);
        for (int i = 0; i < length; i++) {
            hollowOut(world, hollowingCenter, rand, size, crystal1, crystal2);

            BlockPos currentCenter = hollowingCenter;
            hollowingCenter = currentCenter.add(expansion.x * size * 0.5, expansion.y * size * 0.5, expansion.z * size * 0.5);

            if (hollowingCenter.getY() < 10) {
                expansion = new Vec3d(expansion.x, -expansion.y, expansion.z);
                curvature = new Vec3d(curvature.x, -curvature.y, curvature.z);
                currentCenter = hollowingCenter.add(expansion.x * size * 0.5, expansion.y * size * 0.5, expansion.z * size * 0.5);
            }

            expansion = expansion.add(curvature).normalize();
        }
    }

    private void hollowOut(World world, BlockPos source, Random rand, int width, IBlockState block1, IBlockState block2) {
        List<BlockPos> blocks = new ArrayList<>();

        int max = width * width;
        for (int i = -width; i <= width; i++)
            for (int j = -width; j <= width; j++)
                for (int k = -width; k <= width; k++) {
                    BlockPos pos = source.add(i, j, k);
                    int dist = i * i + j * j + k * k;

                    if (dist < max) {
                        IBlockState state = world.getBlockState(pos);
                        Block block = state.getBlock();

                        if (block.getBlockHardness(state, world, pos) != -1)
                            world.setBlockToAir(pos);
                    } else if (dist - 1 < max)
                        blocks.add(pos);
                }

        for (BlockPos pos : blocks) {
            if (rand.nextInt(3) == 0)
                makeFormation(world, pos, rand, rand.nextBoolean() ? block1 : block2);
            else if (rand.nextInt(2) == 0) {
                IBlockState stateAt = world.getBlockState(pos);
                Block blockAt = stateAt.getBlock();
                if (blockAt.isAir(stateAt, world, pos) || blockAt == block1.getBlock() || blockAt == block2.getBlock() || blockAt.getBlockHardness(stateAt, world, pos) == -1)
                    continue;

                IBlockState oreState = Blocks.GOLD_ORE.getDefaultState();
                if (rand.nextInt(3) == 0) {
                    if (rand.nextInt(3) == 0)
                        oreState = Blocks.DIAMOND_ORE.getDefaultState();
                    else oreState = Blocks.EMERALD_ORE.getDefaultState();
                }

                world.setBlockState(pos, oreState);
            }
        }

    }

    private void makeFormation(World world, BlockPos source, Random rand, IBlockState formationBlock) {
        boolean up = rand.nextBoolean();
        EnumFacing shift = up ? EnumFacing.UP : EnumFacing.DOWN;

        BlockPos startPos = source;
        IBlockState state = world.getBlockState(startPos);
        if (state.getBlock() == formationBlock.getBlock())
            return;

        int tests = 0;

        while (state.getBlock().isAir(state, world, startPos)) {
            startPos = startPos.offset(shift.getOpposite());
            state = world.getBlockState(startPos);

            tests++;
            if (tests >= 10)
                return;
        }

        int size = 3 + rand.nextInt(4);

        BlockPos pos = startPos;
        for (int i = 0; i < size; i++) {
            IBlockState stateAt = world.getBlockState(pos);
            Block block = stateAt.getBlock();
            if (block.getBlockHardness(stateAt, world, pos) == -1)
                break;

            world.setBlockState(pos, formationBlock);
            pos = pos.offset(shift);
        }
    }

}