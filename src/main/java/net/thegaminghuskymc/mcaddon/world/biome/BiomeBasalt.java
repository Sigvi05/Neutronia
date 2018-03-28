package net.thegaminghuskymc.mcaddon.world.biome;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenFossils;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class BiomeBasalt extends Biome  {

    public BiomeBasalt()  {
        super(new BiomeProperties("Basalt").setBaseHeight(1.0F).setHeightVariation(0.3F).setRainDisabled().setTemperature(1.0F).setWaterColor(Color.RED.getRGB()));
        this.decorator.treesPerChunk = -999;


        topBlock = Objects.requireNonNull(Block.getBlockFromName("hmca:raw_basalt")).getDefaultState();
        fillerBlock = Objects.requireNonNull(Block.getBlockFromName("hmca:raw_basalt")).getDefaultState();

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
    }

    public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        super.decorate(worldIn, rand, pos);

        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FOSSIL))
            if (rand.nextInt(64) == 0)
            {
                (new WorldGenFossils()).generate(worldIn, rand, pos);
            }
    }

}