package net.hdt.neutronia.base.module_rewrite;

import net.hdt.neutronia.base.lib.LibMisc;
import net.hdt.neutronia.modules_rewritten.NModules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public final class ModuleLoader {

	static {
		modules = new ArrayList<>();
		NModules.registerModules();
	}

    private static List<Module> modules;
	public static Map<Class<? extends Module>, Module> moduleInstances = new HashMap<>();
	static Map<Class<? extends Feature>, Feature> featureInstances = new HashMap<>();
	static Map<String, Feature> featureClassNames = new HashMap<>();

	private static List<Module> enabledModules;

	public static Configuration config;

    public static void preInit(FMLPreInitializationEvent event) {
		for(Module module : modules) {
            try {
                moduleInstances.put(module.getClass(), module);
            } catch (Exception e) {
                throw new RuntimeException("Can't initialize module " + module, e);
            }
        }

		setupConfig(event);

		forEachModule(module -> {
		    if(module.enabled) {
                LibMisc.LOGGER.info("Enabling Module " + module.name);
            }
        });

		forEachEnabled(module -> module.preInit(event));
		forEachEnabled(module -> module.postPreInit(event));
	}

	public static void init(FMLInitializationEvent event) {
		forEachEnabled(module -> module.init(event));
	}

	public static void postInit(FMLPostInitializationEvent event) {
		forEachEnabled(module -> module.postInit(event));
	}

	public static void finalInit(FMLPostInitializationEvent event) {
		forEachEnabled(module -> module.finalInit(event));
	}
	
	@SideOnly(Side.CLIENT)
	public static void preInitClient(FMLPreInitializationEvent event) {
		forEachEnabled(module -> module.preInitClient(event));
	}

	@SideOnly(Side.CLIENT)
	public static void initClient(FMLInitializationEvent event) {
		forEachEnabled(module -> module.initClient(event));
	}

	@SideOnly(Side.CLIENT)
	public static void postInitClient(FMLPostInitializationEvent event) {
		forEachEnabled(module -> module.postInitClient(event));
	}

	public static void serverStarting(FMLServerStartingEvent event) {
		forEachEnabled(module -> module.serverStarting(event));
	}

	public static void setupConfig(FMLPreInitializationEvent event) {
        File configFile = event.getSuggestedConfigurationFile();

		config = new Configuration(configFile);
		config.load();
		
		loadConfig();

		MinecraftForge.EVENT_BUS.register(new ChangeListener());
	}
	
	private static void loadConfig() {
		GlobalConfig.initGlobalConfig();

		forEachModule(module -> {
			module.enabled = true;
			if(module.canBeDisabled()) {
				ConfigHelper.needsRestart = true;
				module.enabled = ConfigHelper.loadPropBool(module.name, "_modules", module.getModuleDescription(), module.isEnabledByDefault());
				module.prop = ConfigHelper.lastProp;
			}
		});

		enabledModules = new ArrayList<>(moduleInstances.values());
		enabledModules.removeIf(module -> !module.enabled);

		loadModuleConfigs();
		
		if(config.hasChanged())
			config.save();
	}

	private static void loadModuleConfigs() {
		forEachModule(Module::setupConfig);
	}

	public static boolean isFeatureEnabled(Class<? extends Feature> clazz) {
		return featureInstances.get(clazz).enabled;
	}

	static void forEachModule(Consumer<Module> consumer) {
		moduleInstances.values().forEach(consumer);
	}

	private static void forEachEnabled(Consumer<Module> consumer) {
		enabledModules.forEach(consumer);
	}

    public static void registerModule(Module module) {
        if(!modules.contains(module)) {
            modules.add(module);
            if(!module.name.isEmpty())
                LibMisc.LOGGER.info("Registering Module " + module.name);
        }
    }

	public static class ChangeListener {

		@SubscribeEvent
		public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
			if(eventArgs.getModID().equals(LibMisc.MOD_ID))
				loadConfig();
		}

	}

}
