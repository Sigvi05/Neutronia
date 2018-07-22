package net.hdt.neutronia.modules.world.features;

import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.world.blocks.corals.BlockSeaPickle;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class SeaPickles extends Feature {

    public static BlockSeaPickle SEA_PICKLE;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        SEA_PICKLE = new BlockSeaPickle();
    }

}
