package net.hdt.neutronia.module;

import net.hdt.neutronia.module.thaumcraft.ModuleThaumcraft;

public class ModModules {

    public static void registerModules() {
        ModuleHandler.INSTANCE.registerModule("thaumcraft", ModuleThaumcraft.class);
    }

}