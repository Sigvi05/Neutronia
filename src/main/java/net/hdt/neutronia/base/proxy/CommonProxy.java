package net.hdt.neutronia.base.proxy;

import net.hdt.neutronia.base.module.ModuleLoader;
import net.hdt.neutronia.base.network.MessageRegister;
import net.hdt.neutronia.tileentity.TileEntityPot;
import net.hdt.neutronia.world.gen.WorldGenCustomStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
//        NBiomes.registerBiomes();
        ModuleLoader.preInit(event);
        MessageRegister.init();
    }

    public void init(FMLInitializationEvent event) {
//        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 1);
        GameRegistry.registerTileEntity(TileEntityPot.class, new ResourceLocation(MOD_ID, "pot"));
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
