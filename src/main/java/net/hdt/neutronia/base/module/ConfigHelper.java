package net.hdt.neutronia.base.module;

import net.minecraftforge.common.config.Property;

public class ConfigHelper {

	static boolean needsRestart;
	static boolean allNeedRestart = false;
	static Property lastProp;
	
	static int loadPropInt(String propName, String category, String desc, int default_) {
		Property prop = ModuleLoader.config.get(category, propName, default_);
		prop.setComment(desc);
		setNeedsRestart(prop);
		
		lastProp = prop;
		return prop.getInt(default_);
	}

	static double loadPropDouble(String propName, String category, String desc, double default_) {
		Property prop = ModuleLoader.config.get(category, propName, default_);
		prop.setComment(desc);
		setNeedsRestart(prop);
		
		lastProp = prop;
		return prop.getDouble(default_);
	}

	public static boolean loadPropBool(String propName, String category, String desc, boolean default_) {
		Property prop = ModuleLoader.config.get(category, propName, default_);
		prop.setComment(desc);
		setNeedsRestart(prop);
		
		lastProp = prop;
		return prop.getBoolean(default_);
	}

	static String loadPropString(String propName, String category, String desc, String default_) {
		Property prop = ModuleLoader.config.get(category, propName, default_);
		prop.setComment(desc);
		setNeedsRestart(prop);
		
		lastProp = prop;
		return prop.getString();
	}

	static String[] loadPropStringList(String propName, String category, String desc, String[] default_) {
		Property prop = ModuleLoader.config.get(category, propName, default_);
		prop.setComment(desc);
		setNeedsRestart(prop);
		
		lastProp = prop;
		return prop.getStringList();
	}

	private static void setNeedsRestart(Property prop) {
		if(needsRestart)
			prop.setRequiresMcRestart(true);
		needsRestart = allNeedRestart;
	}
	
}
