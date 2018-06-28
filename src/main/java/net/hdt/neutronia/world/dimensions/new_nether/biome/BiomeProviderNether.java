package net.hdt.neutronia.world.dimensions.new_nether.biome;

import net.hdt.neutronia.world.dimensions.new_nether.gen.layer.GenLayerNetherEx;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class BiomeProviderNether extends BiomeProvider
{
    public BiomeProviderNether(World world)
    {
        super();

        GenLayer[] genLayers = GenLayerNetherEx.initializeAllBiomeGenerators(world.getSeed(), world.getWorldType());

        ReflectionHelper.setPrivateValue(BiomeProvider.class, this, genLayers[0], "field_76944_d", "genBiomes");
        ReflectionHelper.setPrivateValue(BiomeProvider.class, this, genLayers[1], "field_76945_e", "biomeIndexLayer");
    }
}