package net.thegaminghuskymc.mcaddon.world.biome;

import net.minecraft.world.biome.Biome;

public class BiomeSuperDeepOcean extends Biome {

    public BiomeSuperDeepOcean() {
        super(new Biome.BiomeProperties("Super Deep Ocean").setBaseHeight(-5.0F).setHeightVariation(0.4F).setBaseBiome("ocean"));
    }

    public Biome.TempCategory getTempCategory()
    {
        return Biome.TempCategory.OCEAN;
    }

}
