package net.hdt.neutronia.world.gen;

import net.hdt.neutronia.init.NBlocks;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class BasaltGenerator implements IWorldGenerator {

	int clusterCountOverworld, clusterCountNether;
	WorldGenMinable generatorOverworld;
	WorldGenMinable generatorNether;

	public BasaltGenerator(int clusterSizeOverworld, int clusterSizeNether, int clusterCountOverworld, int clusterCountNether) {
		this.clusterCountNether = clusterCountNether;
		this.clusterCountOverworld = clusterCountOverworld;

		generatorOverworld = new WorldGenMinable(NBlocks.newStoneVariants[3].getDefaultState(), clusterSizeOverworld);
		generatorNether = new WorldGenMinable(NBlocks.newStoneVariants[3].getDefaultState(), clusterSizeNether, BlockMatcher.forBlock(Blocks.NETHERRACK));
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		boolean isNether = world.provider.getDimensionType() == DimensionType.NETHER;

		for(int i = 0; i < (isNether ? clusterCountNether : clusterCountOverworld); i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = rand.nextInt(isNether ? 128 : 80);
			int z = chunkZ * 16 + rand.nextInt(16);

			if(isNether)
				generatorNether.generate(world, rand, new BlockPos(x, y, z));
			else generatorOverworld.generate(world, rand, new BlockPos(x, y, z));
		}
	}

}