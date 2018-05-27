package net.hdt.neutronia.module;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.hdt.neutronia.Main;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.hdt.huskylib2.utils.ReflectionUtils;

import java.util.Map;

public class ModuleHandler {

    public static final ModuleHandler INSTANCE = new ModuleHandler();
    private static Map<String, IModule> MODULES = Maps.newHashMap();

    public void registerModule(String dependency, Class<? extends IModule> module) {
        if(Loader.isModLoaded(dependency)) {
            MODULES.put(dependency, ReflectionUtils.createInstance(module));
        }
    }

    public void handlePreInit(FMLPreInitializationEvent event) {
        MODULES.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(IModule::isEnabled)
                .peek(module -> Main.LOGGER.info("Loading compat module {}...", module.getName()))
                .forEach(module -> module.handlePreInit(event));
    }

    @SideOnly(Side.CLIENT)
    public void handlePreInitClient(FMLPreInitializationEvent event) {
        MODULES.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(IModule::isEnabled)
                .forEach(module -> module.handlePreInitClient(event));
    }

    public void handlePostPreInit(FMLPreInitializationEvent event) {
        MODULES.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(IModule::isEnabled)
                .forEach(module -> module.handlePostPreInit(event));
    }

    @SideOnly(Side.CLIENT)
    public void handlePostPreInitClient(FMLPreInitializationEvent event) {
        MODULES.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(IModule::isEnabled)
                .forEach(module -> module.handlePostPreInitClient(event));
    }

    public void handleInit(FMLInitializationEvent event) {
        MODULES.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(IModule::isEnabled)
                .forEach(module -> module.handleInit(event));
    }

    @SideOnly(Side.CLIENT)
    public void handleInitClient(FMLInitializationEvent event) {
        MODULES.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(IModule::isEnabled)
                .forEach(module -> module.handleInitClient(event));
    }

    public void handlePostInit(FMLPostInitializationEvent event) {
        MODULES.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(IModule::isEnabled)
                .forEach(module -> module.handlePostInit(event));
    }

    @SideOnly(Side.CLIENT)
    public void handlePostInitClient(FMLPostInitializationEvent event) {
        MODULES.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(IModule::isEnabled)
                .forEach(module -> module.handlePostInitClient(event));
    }

    public boolean isModuleEnabled(String name) {
        return MODULES.containsKey(name);
    }

    public ImmutableMap<String, IModule> getModules() {
        return ImmutableMap.copyOf(MODULES);
    }

}