package net.thegaminghuskymc.mcaddon.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

@SuppressWarnings("ConstantConditions")
public class BiomeHell extends BiomeNether {
    public BiomeHell() {
        super(new Biome.BiomeProperties("Hell").setTemperature(2.0F).setRainfall(0.0F).setRainDisabled(), "hell");

        topBlock = Blocks.NETHERRACK.getDefaultState();
        fillerBlock = Blocks.NETHERRACK.getDefaultState();
    }
}