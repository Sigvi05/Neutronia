package net.hdt.neutronia.groups.building.features;

import net.hdt.neutronia.base.NeutroniaMain;
import net.hdt.neutronia.base.groups.Feature;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class TestBlocks extends Feature {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        NeutroniaMain.LOGGER.info("This is a message from the Test Block feature in the Test Building group");
    }
}
