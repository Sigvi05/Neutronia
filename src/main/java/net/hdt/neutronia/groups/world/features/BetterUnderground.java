package net.hdt.neutronia.groups.world.features;

import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.groups.world.world.gen.WorldProviderSurface;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class BetterUnderground extends Component {

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        DimensionManager.unregisterDimension(0);
        DimensionType overworld = DimensionType.register("Overworld", "_overworld", 0, WorldProviderSurface.class, false);
        DimensionManager.registerDimension(0, overworld);
    }

}
