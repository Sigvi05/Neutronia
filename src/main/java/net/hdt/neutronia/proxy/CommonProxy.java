package net.hdt.neutronia.proxy;

import net.hdt.neutronia.init.NBiomes;
import net.hdt.neutronia.init.NOreDict;
import net.hdt.neutronia.init.NRecipes;
import net.hdt.neutronia.module.ModModules;
import net.hdt.neutronia.module.ModuleHandler;
import net.hdt.neutronia.tileentity.TileCustomChest;
import net.hdt.neutronia.tileentity.TileEntityCraftingTable;
import net.hdt.neutronia.tileentity.TileEntityFloorTile;
import net.hdt.neutronia.world.events.WorldGenEvents;
import net.hdt.neutronia.world.gen.OreGen;
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
        NOreDict.register();
        NRecipes.register();
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        MinecraftForge.TERRAIN_GEN_BUS.register(WorldGenEvents.class);
        GameRegistry.registerTileEntity(TileCustomChest.class, "neutronia:custom_chest");
        GameRegistry.registerTileEntity(TileEntityFloorTile.class, "neutronia:floor_tile");
        GameRegistry.registerTileEntity(TileEntityCraftingTable.class, "minecraft:workbench");
        ModuleHandler.INSTANCE.handleInit(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
        ModuleHandler.INSTANCE.handlePostInit(event);
    }

    public void addResourceOverride(String space, String dir, String file, String ext) {

    }

}
