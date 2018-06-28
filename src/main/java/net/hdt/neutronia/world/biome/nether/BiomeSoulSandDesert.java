package net.hdt.neutronia.world.biome.nether;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.world.dimensions.base.biome.BiomeLibEx;
import net.minecraft.init.Blocks;

public class BiomeSoulSandDesert extends BiomeLibEx {

    public BiomeSoulSandDesert() {
        super(Main.instance, new BiomeProperties("Soul Sand Desert").setTemperature(2.0F).setRainfall(0.0F).setRainDisabled(), "soul_sand_desert");
        topBlock = Blocks.SOUL_SAND.getDefaultState();
        fillerBlock = Blocks.SOUL_SAND.getDefaultState();
    }

}
