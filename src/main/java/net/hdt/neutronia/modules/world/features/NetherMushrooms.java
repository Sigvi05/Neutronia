package net.hdt.neutronia.modules.world.features;

import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.world.world.NetherMushroomGenerator;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NetherMushrooms extends Feature {

    @Override
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new NetherMushroomGenerator(), 10);
    }

}
