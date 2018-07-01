package net.hdt.neutronia.init;

import net.hdt.neutronia.world.dimensions.mars.MarsWorldProvider;
import net.hdt.neutronia.world.dimensions.moon.MoonWorldProvider;
import net.hdt.neutronia.world.dimensions.sun.SunWorldProvider;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class NDimension {

    public static final DimensionType MOON = DimensionType.register("Moon", "_moon", 2, MoonWorldProvider.class, false);
    public static final DimensionType MARS = DimensionType.register("Mars", "_mars", 3, MarsWorldProvider.class, false);
    public static final DimensionType SUN = DimensionType.register("Sun", "_sun", 4, SunWorldProvider.class, false);

    public static void registerDimensions()
    {
        DimensionManager.registerDimension(2, MOON);
        DimensionManager.registerDimension(3, MARS);
        DimensionManager.registerDimension(4, SUN);
    }

}