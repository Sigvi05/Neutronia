package net.hdt.neutronia.proxy;

import net.hdt.neutronia.init.HMBiomes;
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
//        OreGenEvents events = new OreGenEvents(event);
//        MinecraftForge.ORE_GEN_BUS.register(events.getClass());
    }

    public void init(FMLInitializationEvent event) {
//        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        MinecraftForge.TERRAIN_GEN_BUS.register(WorldGenEvents.class);
//        GameRegistry.registerWorldGenerator(new WorldGenerationHandler(), 1);
        GameRegistry.registerTileEntity(TileCustomChest.class, "neutronia:custom_chest");
        GameRegistry.registerTileEntity(TileEntityFloorTile.class, "neutronia:floor_tile");
        GameRegistry.registerTileEntity(TileEntityCraftingTable.class, "minecraft:workbench");
        HMBiomes.registerBiomes();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void addResourceOverride(String space, String dir, String file, String ext) {

    }

}
