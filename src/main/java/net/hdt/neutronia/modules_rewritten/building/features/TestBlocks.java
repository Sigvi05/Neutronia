package net.hdt.neutronia.modules_rewritten.building.features;

import net.hdt.neutronia.base.NeutroniaMain;
import net.hdt.neutronia.base.module_rewrite.Feature;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class TestBlocks extends Feature {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        NeutroniaMain.LOGGER.info("This is a message from the Test Block feature in the Test Building module");
    }
}
