package net.thegaminghuskymc.mcaddon.world.biome;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeHellDecorator;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class BiomeBasalt extends Biome  {

    public BiomeBasalt()  {
        super(new BiomeProperties("Basalt").setBaseHeight(1.0F).setHeightVariation(0.3F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled().setWaterColor(Color.GREEN.getRGB()));

        topBlock = Objects.requireNonNull(Block.getBlockFromName("hmca:raw_basalt")).getDefaultState();
        fillerBlock = Objects.requireNonNull(Block.getBlockFromName("hmca:raw_basalt")).getDefaultState();

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();

        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();

        this.decorator = new BiomeHellDecorator();

    }

    public void decorate(World worldIn, Random rand, BlockPos pos) {
        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.GRASS))
            for (int i3 = 0; i3 < this.decorator.grassPerChunk; ++i3)
            {
                int j7 = rand.nextInt(16) + 8;
                int i11 = rand.nextInt(16) + 8;
                int k14 = worldIn.getHeight(this.decorator.chunkPos.add(j7, 0, i11)).getY() * 2;

                if (k14 > 0)
                {
                    int l17 = rand.nextInt(k14);
                    getRandomWorldGenForGrass(rand).generate(worldIn, rand, this.decorator.chunkPos.add(j7, l17, i11));
                }
            }
    }

    public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {
        return null;
    }

}