package net.hdt.neutronia.world.biome.nether;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.world.dimensions.base.biome.BiomeLibEx;
import net.minecraft.init.Blocks;

public class BiomeMagmaLands extends BiomeLibEx {

    public BiomeMagmaLands() {
        super(Main.instance, new BiomeProperties("Magma Lands").setTemperature(1.8F).setRainfall(0.0F).setRainDisabled(), "magma_lands");
        topBlock = Blocks.OBSIDIAN.getDefaultState();
        fillerBlock = Blocks.NETHERRACK.getDefaultState();
    }

}
