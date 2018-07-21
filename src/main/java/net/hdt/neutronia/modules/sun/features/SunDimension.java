package net.hdt.neutronia.modules.sun.features;

import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.sun.world.SunWorldProvider;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class SunDimension extends Feature {

    public static final DimensionType SUN = DimensionType.register("Sun", "_sun", 4, SunWorldProvider.class, false);

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        DimensionManager.registerDimension(4, SUN);
    }

}
