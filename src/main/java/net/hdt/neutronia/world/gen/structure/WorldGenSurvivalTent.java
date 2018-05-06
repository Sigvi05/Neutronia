package net.hdt.neutronia.world.gen.structure;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenSurvivalTent extends WorldGenerator {
    public boolean generate(World world, Random random, BlockPos position) {
        position = position.down();

        int chest;
        for (chest = -3; chest < 3; ++chest) {
            world.setBlockState(position.add(-2, 0, chest), Blocks.DIRT.getDefaultState());
        }

        for (chest = -3; chest < 0; ++chest) {
            world.setBlockState(position.add(-1, 0, chest), Blocks.DIRT.getDefaultState());
        }

        world.setBlockState(position.west(1), Blocks.CHEST.getDefaultState());

        int zCoord;


        world.setBlockState(position.add(-1, 0, 1), Blocks.DIRT.getDefaultState());
        world.setBlockState(position.add(-1, 0, 2), Blocks.DIRT.getDefaultState());

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(0, 0, zCoord), Blocks.DIRT.getDefaultState());
            if (zCoord == -1 || zCoord == 0 || zCoord == 1) {
                world.setBlockState(position.add(0, 0, zCoord), Blocks.PLANKS.getDefaultState());
                if (zCoord == 0) {
                    world.setBlockState(position.add(0, -1, zCoord), Blocks.TNT.getDefaultState());
                }
            }
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(1, 0, zCoord), Blocks.DIRT.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(2, 0, zCoord), Blocks.DIRT.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(-2, 1, zCoord), Blocks.WOOL.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(-1, 1, zCoord), Blocks.AIR.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(0, 1, zCoord), Blocks.AIR.getDefaultState());
            if (zCoord == 0) {
                world.setBlockState(position.add(0, 1, zCoord), Blocks.WOODEN_PRESSURE_PLATE.getDefaultState());
            }
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(1, 1, zCoord), Blocks.AIR.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(2, 1, zCoord), Blocks.WOOL.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(-2, 2, zCoord), Blocks.AIR.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(-1, 2, zCoord), Blocks.WOOL.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(0, 2, zCoord), Blocks.AIR.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(1, 2, zCoord), Blocks.WOOL.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(2, 2, zCoord), Blocks.AIR.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(-1, 3, zCoord), Blocks.AIR.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(0, 3, zCoord), Blocks.WOOL.getDefaultState());
        }

        for (zCoord = -3; zCoord < 3; ++zCoord) {
            world.setBlockState(position.add(1, 3, zCoord), Blocks.AIR.getDefaultState());
        }

        return false;
    }
}