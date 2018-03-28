package net.thegaminghuskymc.mcaddon.world.biome;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeHellDecorator;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

@Mod.EventBusSubscriber
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
        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.CUSTOM))
            if (rand.nextInt(10) == 0)
            {
                (new WorldGenLiquids(Blocks.FLOWING_LAVA)).generate(worldIn, rand, pos);
            }
    }

}