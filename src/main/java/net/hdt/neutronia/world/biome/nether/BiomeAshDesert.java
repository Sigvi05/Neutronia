package net.hdt.neutronia.world.biome.nether;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.world.dimensions.base.biome.BiomeLibEx;
import net.minecraft.init.Blocks;

public class BiomeAshDesert extends BiomeLibEx {

    public BiomeAshDesert() {
        super(Main.instance, new BiomeProperties("Ash Desert").setTemperature(2.0F).setRainfall(0.0F).setRainDisabled(), "ash_desert");
        topBlock = NBlocks.netherBlocks[0].getDefaultState();
        fillerBlock = Blocks.NETHERRACK.getDefaultState();
    }

}
