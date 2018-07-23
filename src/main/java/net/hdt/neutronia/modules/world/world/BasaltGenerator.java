package net.hdt.neutronia.modules.world.world;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.hdt.neutronia.base.handler.DimensionConfig;
import net.hdt.neutronia.modules.world.features.Basalt;
import net.hdt.neutronia.modules.world.features.RevampStoneGen.StoneInfo;

public class BasaltGenerator extends StoneInfoBasedGenerator implements IWorldGenerator {

	public BasaltGenerator(Supplier<StoneInfo> infoSupplier) {
		super(infoSupplier, Basalt.basalt.getDefaultState(), "basalt");
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		generate(chunkX, chunkZ, world);
	}
	
	@Override
	public boolean canPlaceBlock(World world, BlockPos pos) {
		Block block = world.getBlockState(pos).getBlock(); 
		return block == Blocks.STONE || block == Blocks.NETHERRACK;
	}

}
