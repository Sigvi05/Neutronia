package net.hdt.neutronia.groups.building.features;

import net.hdt.neutronia.base.Neutronia;
import net.hdt.neutronia.base.groups.Component;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class TestBlocks extends Component {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        Neutronia.LOGGER.info("This is a message from the Test Block feature in the Test Building group");
    }
}
