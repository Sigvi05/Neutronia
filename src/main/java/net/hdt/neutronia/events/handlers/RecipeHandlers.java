package net.hdt.neutronia.events.handlers;

import net.hdt.neutronia.events.ILifeCycleHandler;
import net.hdt.neutronia.init.NVanillaOverrides;
import net.minecraftforge.fml.common.event.*;

public class RecipeHandlers implements ILifeCycleHandler {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        NVanillaOverrides.overrideRecipes();
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void loadComplete(FMLLoadCompleteEvent event) {

    }

    @Override
    public void serverInit(FMLServerStartingEvent event) {

    }

}
