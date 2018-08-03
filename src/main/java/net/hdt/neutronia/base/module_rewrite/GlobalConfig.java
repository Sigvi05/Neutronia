package net.hdt.neutronia.base.module_rewrite;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public final class GlobalConfig {

	static boolean enableAntiOverlap;
	public static boolean enableSeasonalFeatures;
	public static boolean enableVariants;
	public static boolean enableNButton;
	public static boolean NButtonOnRight;
	
	public static Property NButtonProp;

	static void initGlobalConfig() {
		String category = "_global";
		
		ConfigHelper.needsRestart = ConfigHelper.allNeedRestart = true;

		enableAntiOverlap = ConfigHelper.loadPropBool("Enable Anti-Overlap", category,
				"Set this to false to remove the system that has features turn themselves off automatically when "
				+ "other mods are present that add similar features."
				+ "\nNote that you can force features to be enabled individually through their respective configs.", true);

		enableSeasonalFeatures = ConfigHelper.loadPropBool("Enable Seasonal Features", category,
				"Whether features that are based on the time of year should be enabled."
						+ "\nAn example is chests turning to presents when it's Christmas."
						+ "\nNote that this will not affect vanilla's own seasonal features.", true);

		enableVariants = ConfigHelper.loadPropBool("Allow Block Variants", category,
				"Set this to false to disable stairs, slabs, and walls, mod-wide. As these blocks can use a lot of Block IDs,\n"
				+ "this is helpful to reduce the load, if you intend on running a really large modpack.\n"
				+ "Note: Blocks that require stairs and/or slabs for their recipes (such as Soul Sandstone or Midori) won't be affected.", true);

		ConfigHelper.needsRestart = ConfigHelper.allNeedRestart = false;

		enableNButton = ConfigHelper.loadPropBool("Enable N Button", category,
				"Set this to false to disable the q button in the main and pause menus.\n"
				+ "If you disable this, you can still access the neutronia config from Mod Options > Neutronia > Config", true);
		NButtonProp = ConfigHelper.lastProp;

		NButtonOnRight = ConfigHelper.loadPropBool("N Button on the Right", category,
				"Set this to true to move the N button to the right of the buttons, instead\n"
				+ "of to the left as it is by default.", false);

	}

	public static void changeConfig(String moduleName, String category, String key, String value, boolean saveToFile) {
		Configuration config = ModuleLoader.config;
		String fullCategory = moduleName;
		if(!category.equals("-"))
			fullCategory += "." + category;
		
		char type = key.charAt(0);
		key = key.substring(2);
		
		if(config.hasKey(fullCategory, key)) {

            try {
				switch(type) {
				case 'B': 
					boolean b = Boolean.parseBoolean(value);
					config.get(fullCategory, key, false).setValue(b);
				case 'I':
					int i = Integer.parseInt(value);
					config.get(fullCategory, key, 0).setValue(i);
				case 'D':
					double d = Double.parseDouble(value);
					config.get(fullCategory, key, 0.0).setValue(d);
				case 'S':
					config.get(fullCategory, key, "").setValue(value);
				}
			} catch(IllegalArgumentException ignored) {}
			
			if(config.hasChanged()) {
				ModuleLoader.forEachModule(Module::setupConfig);
				
				if(saveToFile)
					config.save();
			}
		}
	}
	
}
