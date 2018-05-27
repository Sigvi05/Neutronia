package net.hdt.neutronia.proxy;

import net.hdt.neutronia.init.NBiomes;
import net.hdt.neutronia.init.NRecipes;
import net.hdt.neutronia.module.ModModules;
import net.hdt.neutronia.module.ModuleHandler;
import net.hdt.neutronia.tileentity.TileCustomChest;
import net.hdt.neutronia.tileentity.TileEntityFloorTile;
import net.hdt.neutronia.tileentity.TileEntityNeonLight;
import net.hdt.neutronia.world.events.WorldGenEvents;
import net.hdt.neutronia.world.gen.OreGen;
import net.hdt.neutronia.world.gen.WorldGenCustomStructures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        ModModules.registerModules();
        ModuleHandler.INSTANCE.handlePreInit(event);
        ModuleHandler.INSTANCE.handlePostPreInit(event);
    }

    public void init(FMLInitializationEvent event) {
        NBiomes.registerBiomes();
        NRecipes.register();
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
        MinecraftForge.TERRAIN_GEN_BUS.register(WorldGenEvents.class);
        GameRegistry.registerTileEntity(TileCustomChest.class, "neutronia:custom_chest");
        GameRegistry.registerTileEntity(TileEntityFloorTile.class, "neutronia:floor_tile");
//        GameRegistry.registerTileEntity(TileEntityPotteryClayMachine.class, "neutronia:pottery_clay_machine");
        GameRegistry.registerTileEntity(TileEntityNeonLight.class, "neutronia:neon_lights");
        ModuleHandler.INSTANCE.handleInit(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
        ModuleHandler.INSTANCE.handlePostInit(event);
    }

    public void addResourceOverride(String space, String dir, String file, String ext) {

    }

}
