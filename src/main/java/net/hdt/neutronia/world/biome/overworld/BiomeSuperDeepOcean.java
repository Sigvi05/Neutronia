package net.hdt.neutronia.world.biome.overworld;

import net.minecraft.world.biome.Biome;

public class BiomeSuperDeepOcean extends Biome {

    public BiomeSuperDeepOcean() {
        super(new Biome.BiomeProperties("Super Deep Ocean").setBaseHeight(-4.0F).setHeightVariation(0.8F).setBaseBiome("ocean"));
    }

    public Biome.TempCategory getTempCategory() {
        return Biome.TempCategory.OCEAN;
    }

}
