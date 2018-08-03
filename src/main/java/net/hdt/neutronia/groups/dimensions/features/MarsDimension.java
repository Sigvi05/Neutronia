package net.hdt.neutronia.groups.dimensions.features;

import net.hdt.neutronia.base.groups.Feature;
import net.hdt.neutronia.groups.dimensions.world.providers.MarsWorldProvider;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class MarsDimension extends Feature {

    public static final DimensionType MARS = DimensionType.register("Mars", "_mars", 3, MarsWorldProvider.class, false);

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        DimensionManager.registerDimension(3, MARS);
    }

}
