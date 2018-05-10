package net.hdt.neutronia.init;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderSurface;

public class NDimension {

    public static void registerDimensions() {
        createDimension("test", "_test", 2, WorldProviderSurface.class, false);
    }

    public static void createDimension(String name, String suffix, int ID, Class<? extends WorldProvider> provider, boolean keepLoaded) {
        DimensionType type = DimensionType.register(name, suffix, ID, provider, keepLoaded);
        type.createDimension();
    }

}