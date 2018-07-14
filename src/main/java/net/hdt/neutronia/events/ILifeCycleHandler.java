package net.hdt.neutronia.events;

import net.minecraftforge.fml.common.event.*;

public interface ILifeCycleHandler {

	public void preInit(FMLPreInitializationEvent event);

	public void init(FMLInitializationEvent event);

	public void postInit(FMLPostInitializationEvent event);

	public void loadComplete(FMLLoadCompleteEvent event);

	public void serverInit(FMLServerStartingEvent event);

}
