package net.hdt.neutronia.modules;

import net.hdt.neutronia.modules.building.NeutroniaBuilding;
import net.hdt.neutronia.modules.client.NeutroniaClient;
import net.hdt.neutronia.modules.decoration.NeutroniaDecoration;
import net.hdt.neutronia.modules.dimensions.NeutroniaDimensions;
import net.hdt.neutronia.modules.experimental.NeutroniaExperimental;
import net.hdt.neutronia.modules.management.NeutroniaManagement;
import net.hdt.neutronia.modules.tweaks.NeutroniaTweaks;
import net.hdt.neutronia.modules.vanity.NeutroniaVanity;
import net.hdt.neutronia.modules.world.NeutroniaWorld;

import static net.hdt.neutronia.base.module.ModuleLoader.registerModule;

public class NeutroniaModules {

    public static void registerModules() {
        registerModule(NeutroniaBuilding.class);
        registerModule(NeutroniaTweaks.class);
        registerModule(NeutroniaDimensions.class);
        registerModule(NeutroniaWorld.class);
        registerModule(NeutroniaDecoration.class);
        registerModule(NeutroniaManagement.class);
        registerModule(NeutroniaVanity.class);
        registerModule(NeutroniaClient.class);
        registerModule(NeutroniaExperimental.class);
    }

}
