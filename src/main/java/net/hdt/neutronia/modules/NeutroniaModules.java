package net.hdt.neutronia.modules;

import net.hdt.neutronia.modules.building.NeutroniaBuilding;
import net.hdt.neutronia.modules.client.NeutroniaClient;
import net.hdt.neutronia.modules.colorful_armor_points.NeutroniaColorfulArmorPoints;
import net.hdt.neutronia.modules.decoration.NeutroniaDecoration;
import net.hdt.neutronia.modules.management.NeutroniaManagement;
import net.hdt.neutronia.modules.mars.NeutroniaMars;
import net.hdt.neutronia.modules.moon.NeutroniaMoon;
import net.hdt.neutronia.modules.sun.NeutroniaSun;
import net.hdt.neutronia.modules.tweaks.NeutroniaTweaks;
import net.hdt.neutronia.modules.vanity.NeutroniaVanity;
import net.hdt.neutronia.modules.world.NeutroniaWorld;

import static net.hdt.neutronia.base.module.ModuleLoader.*;

public class NeutroniaModules {

    public static void registerModules() {
        registerModule(NeutroniaBuilding.class);
        registerModule(NeutroniaTweaks.class);
        registerModule(NeutroniaMoon.class);
        registerModule(NeutroniaMars.class);
        registerModule(NeutroniaColorfulArmorPoints.class);
        registerModule(NeutroniaSun.class);
        registerModule(NeutroniaWorld.class);
        registerModule(NeutroniaDecoration.class);
        registerModule(NeutroniaManagement.class);
        registerModule(NeutroniaVanity.class);
        registerModule(NeutroniaClient.class);
    }

}
