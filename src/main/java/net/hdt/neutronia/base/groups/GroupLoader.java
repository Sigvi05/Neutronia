package net.hdt.neutronia.base.groups;

import net.hdt.neutronia.base.lib.LibMisc;
import net.hdt.neutronia.groups.NGroups;
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

public final class GroupLoader {

	static {
		groups = new ArrayList<>();
	}

    private static List<Group> groups;
	public static Map<Class<? extends Group>, Group> groupInstances = new HashMap<>();
	static Map<Class<? extends Component>, Component> componentInstances = new HashMap<>();
	public static Map<String, Component> componentClassNames = new HashMap<>();

	private static List<Group> enabledGroups;

	public static Configuration config;

    public static void preInit(FMLPreInitializationEvent event) {
        NGroups.registerGroups();
		for(Group group : groups) {
            try {
                groupInstances.put(group.getClass(), group);
            } catch (Exception e) {
                throw new RuntimeException("Can't initialize group " + group, e);
            }
        }

		setupConfig(event);

		forEachModule(module -> {
		    if(module.enabled) {
                LibMisc.LOGGER.info("Enabling Group " + module.name);
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
	
	public static void loadConfig() {
		GlobalConfig.initGlobalConfig();

		forEachModule(module -> {
			module.enabled = true;
			if(module.canBeDisabled()) {
				ConfigHelper.needsRestart = true;
				module.enabled = ConfigHelper.loadPropBool(module.name, "_groups", module.getModuleDescription(), module.isEnabledByDefault());
				module.prop = ConfigHelper.lastProp;
			}
		});

		enabledGroups = new ArrayList<>(groupInstances.values());
		enabledGroups.removeIf(module -> !module.enabled);

		loadModuleConfigs();
		
		if(config.hasChanged())
			config.save();
	}

	private static void loadModuleConfigs() {
		forEachModule(Group::setupConfig);
	}

	public static boolean isFeatureEnabled(Class<? extends Component> clazz) {
		return componentInstances.get(clazz).enabled;
	}

	static void forEachModule(Consumer<Group> consumer) {
		groupInstances.values().forEach(consumer);
	}

	private static void forEachEnabled(Consumer<Group> consumer) {
		enabledGroups.forEach(consumer);
	}

    static void registerGroup(Group group) {
        if(!groups.contains(group)) {
            groups.add(group);
            if(!group.name.isEmpty())
                LibMisc.LOGGER.info("Registering Group " + group.name);
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
