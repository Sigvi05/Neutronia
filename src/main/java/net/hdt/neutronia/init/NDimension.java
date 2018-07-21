package net.hdt.neutronia.init;

import net.hdt.neutronia.modules.test.world.TestWorldProvider;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class NDimension {

    public static final DimensionType TEST = DimensionType.register("Test", "_test", 5, TestWorldProvider.class, false);

    public static void registerDimensions()
    {
        DimensionManager.registerDimension(5, TEST);
    }

}