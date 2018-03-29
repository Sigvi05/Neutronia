package net.thegaminghuskymc.mcaddon.world.biome;

import net.minecraft.block.Block;

import java.util.Objects;

@SuppressWarnings("ConstantConditions")
public class BiomeBasaltNether extends BiomeNether {
    public BiomeBasaltNether() {
        super(new BiomeProperties("Basalt Nether").setTemperature(2.0F).setRainfall(0.0F).setRainDisabled(), "basalt_nether");

        topBlock = Objects.requireNonNull(Block.getBlockFromName("hmca:raw_basalt")).getDefaultState();
        fillerBlock = Objects.requireNonNull(Block.getBlockFromName("hmca:raw_basalt")).getDefaultState();
    }
}