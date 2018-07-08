package net.hdt.neutronia.proxy;

import net.hdt.neutronia.blocks.overworld.BlockKelp;
import net.hdt.neutronia.init.NBiomes;
import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.init.NDimension;
import net.hdt.neutronia.init.NItems;
import net.hdt.neutronia.module.ModModules;
import net.hdt.neutronia.module.ModuleHandler;
import net.hdt.neutronia.modules.moon.init.NMoonBiomes;
import net.hdt.neutronia.tileentity.TileCustomChest;
import net.hdt.neutronia.tileentity.TileEntityFloorTile;
import net.hdt.neutronia.tileentity.TileEntityNeonLight;
import net.hdt.neutronia.world.gen.WorldGenCustomStructures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(NBlocks.class);
        MinecraftForge.EVENT_BUS.register(NItems.class);
        ModModules.registerModules();

        NBiomes.registerBiomes();
        NMoonBiomes.registerBiomes();
        NDimension.registerDimensions();

        ModuleHandler.INSTANCE.handlePreInit(event);
        ModuleHandler.INSTANCE.handlePostPreInit(event);
    }

    public void init(FMLInitializationEvent event) {
//        NRecipes.register();
//        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 1);
//        GameRegistry.registerWorldGenerator(new BasaltGenerator(33, 80, 10, 1), 0);
        GameRegistry.registerTileEntity(TileCustomChest.class, "neutronia:custom_chest");
        GameRegistry.registerTileEntity(TileEntityFloorTile.class, "neutronia:floor_tile");
//        GameRegistry.registerTileEntity(TileEntityPotteryClayMachine.class, "neutronia:pottery_clay_machine");
        GameRegistry.registerTileEntity(TileEntityNeonLight.class, "neutronia:neon_lights");
        GameRegistry.registerTileEntity(BlockKelp.TileKelp.class, "neutronia:kelp");
        ModuleHandler.INSTANCE.handleInit(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
        ModuleHandler.INSTANCE.handlePostInit(event);
    }

    public void addResourceOverride(String space, String dir, String file, String ext) {

    }

    public float getPartialTicks() {
        return 0.0F;
    }

}
