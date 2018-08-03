package net.hdt.neutronia.groups.world.features;

import net.hdt.neutronia.base.groups.Feature;
import net.hdt.neutronia.groups.world.world.NetherMushroomGenerator;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NetherMushrooms extends Feature {

    @Override
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new NetherMushroomGenerator(), 10);
    }

}
