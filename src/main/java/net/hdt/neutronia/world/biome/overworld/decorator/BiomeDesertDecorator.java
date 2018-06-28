package net.hdt.neutronia.world.biome.overworld.decorator;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class BiomeDesertDecorator extends BiomeDecorator {

    private Block topBlock, fillerBlock;

    public BiomeDesertDecorator(Block topBlock, Block fillerBlock) {
        this.topBlock = topBlock;
        this.fillerBlock = fillerBlock;
    }

    @Override
    public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
        if(decorating) {
            System.out.println("Overriding Biome Decoration");
            this.dirtGen = new WorldGenMinable(fillerBlock.getDefaultState(), this.chunkProviderSettings.dirtSize);
            this.gravelOreGen = new WorldGenMinable(fillerBlock.getDefaultState(), this.chunkProviderSettings.gravelSize);
            this.graniteGen = new WorldGenMinable(fillerBlock.getDefaultState(), this.chunkProviderSettings.graniteSize);
            this.dioriteGen = new WorldGenMinable(fillerBlock.getDefaultState(), this.chunkProviderSettings.dioriteSize);
            this.andesiteGen = new WorldGenMinable(fillerBlock.getDefaultState(), this.chunkProviderSettings.andesiteSize);
            this.coalGen = new WorldGenMinable(fillerBlock.getDefaultState(), this.chunkProviderSettings.coalSize);
            this.ironGen = new WorldGenMinable(fillerBlock.getDefaultState(), this.chunkProviderSettings.ironSize);
            this.goldGen = new WorldGenMinable(fillerBlock.getDefaultState(), this.chunkProviderSettings.goldSize);
            this.redstoneGen = new WorldGenMinable(fillerBlock.getDefaultState(), this.chunkProviderSettings.redstoneSize);
            this.diamondGen = new WorldGenMinable(fillerBlock.getDefaultState(), this.chunkProviderSettings.diamondSize);
            this.lapisGen = new WorldGenMinable(fillerBlock.getDefaultState(), this.chunkProviderSettings.lapisSize);
            System.out.println("Done Overriding Biome Decoration");
        }
    }

    @Override
    protected void genDecorations(Biome biomeIn, World worldIn, Random random) {

    }

}
