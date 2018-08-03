package net.hdt.neutronia.groups.world.features;

import net.hdt.neutronia.base.groups.Feature;
import net.hdt.neutronia.groups.world.blocks.corals.BlockSeaPickle;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class SeaPickles extends Feature {

    public static BlockSeaPickle SEA_PICKLE;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        SEA_PICKLE = new BlockSeaPickle();
    }

}
