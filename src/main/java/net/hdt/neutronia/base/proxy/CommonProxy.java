package net.hdt.neutronia.base.proxy;

import net.hdt.neutronia.base.module.ModuleLoader;
import net.hdt.neutronia.base.network.MessageRegister;
import net.hdt.neutronia.blocks.overworld.BlockKelp;
import net.hdt.neutronia.init.NBiomes;
import net.hdt.neutronia.init.NDimension;
import net.hdt.neutronia.tileentity.TileCustomChest;
import net.hdt.neutronia.tileentity.TileEntityFloorTile;
import net.hdt.neutronia.tileentity.TileEntityNeonLight;
import net.hdt.neutronia.world.gen.OreGen;
import net.hdt.neutronia.world.gen.WorldGenCustomStructures;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        NBiomes.registerBiomes();
        NDimension.registerDimensions();
        ModuleLoader.preInit(event);
        MessageRegister.init();
    }

    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 1);
        GameRegistry.registerTileEntity(TileCustomChest.class, "neutronia:custom_chest");
        GameRegistry.registerTileEntity(TileEntityFloorTile.class, "neutronia:floor_tile");
        GameRegistry.registerTileEntity(TileEntityNeonLight.class, "neutronia:neon_lights");
        GameRegistry.registerTileEntity(BlockKelp.TileKelp.class, "neutronia:kelp");
        ModuleLoader.init(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
        ModuleLoader.postInit(event);
    }

    public void finalInit(FMLPostInitializationEvent event) {
        ModuleLoader.finalInit(event);
    }

    public void serverStarting(FMLServerStartingEvent event) {
        ModuleLoader.serverStarting(event);
    }

    public void addResourceOverride(String space, String dir, String file, String ext) {

    }

    public float getPartialTicks() {
        return 0.0F;
    }

}
