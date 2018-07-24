package net.hdt.neutronia.events.handlers;

import net.hdt.neutronia.commands.CommandFindBiome;
import net.hdt.neutronia.commands.CommandStructureCapture;
import net.hdt.neutronia.commands.CommandTeleportToDimension;
import net.hdt.neutronia.events.ILifeCycleHandler;
import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.init.NItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.*;

public class EventHandlers implements ILifeCycleHandler {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(NBlocks.class);
        MinecraftForge.EVENT_BUS.register(NItems.class);
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
        event.registerServerCommand(new CommandFindBiome());
        event.registerServerCommand(new CommandTeleportToDimension());
        event.registerServerCommand(new CommandStructureCapture());
    }

}
