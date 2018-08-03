package net.hdt.neutronia.groups.dimensions.features;

import net.hdt.neutronia.base.groups.Feature;
import net.hdt.neutronia.groups.dimensions.world.providers.MoonWorldProvider;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class MoonDimension extends Feature {

    public static final DimensionType MOON = DimensionType.register("Moon", "_moon", 2, MoonWorldProvider.class, false);

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        DimensionManager.registerDimension(2, MOON);
    }

}
