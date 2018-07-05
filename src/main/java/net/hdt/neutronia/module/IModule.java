package net.hdt.neutronia.module;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IModule {

    String getName();

    boolean isEnabled();

    void handlePreInit(FMLPreInitializationEvent event);

    @SideOnly(Side.CLIENT)
    void handlePreInitClient(FMLPreInitializationEvent event);

    void handlePostPreInit(FMLPreInitializationEvent event);

    @SideOnly(Side.CLIENT)
    void handlePostPreInitClient(FMLPreInitializationEvent event);

    void handleInit(FMLInitializationEvent event);

    @SideOnly(Side.CLIENT)
    void handleInitClient(FMLInitializationEvent event);

    void handlePostInit(FMLPostInitializationEvent event);

    @SideOnly(Side.CLIENT)
    void handlePostInitClient(FMLPostInitializationEvent event);

}