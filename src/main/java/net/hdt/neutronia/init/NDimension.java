package net.hdt.neutronia.init;

import net.hdt.neutronia.world.dimensions.test.TestWorldProvider;
import net.hdt.neutronia.world.dimensions.test_dimension.WorldProviderTest;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class NDimension {

    public static final DimensionType TEST = DimensionType.register("Test", "_test", 2, WorldProviderTest.class, false);
    public static final DimensionType MOON = DimensionType.register("Moon", "_moon", 3, TestWorldProvider.class, false);
    public static final DimensionType TEST3 = DimensionType.register("Test 3", "_test3", 4, WorldProviderTest.class, false);

    public static void registerDimensions()
    {
        DimensionManager.registerDimension(2, TEST);
        DimensionManager.registerDimension(3, MOON);
        DimensionManager.registerDimension(4, TEST3);
    }

}