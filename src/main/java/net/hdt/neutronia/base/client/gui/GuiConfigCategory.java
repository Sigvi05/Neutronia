package net.hdt.neutronia.base.client.gui;

import net.hdt.neutronia.base.lib.LibMisc;
import net.hdt.neutronia.base.module.ModuleLoader;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

class GuiConfigCategory extends GuiConfig {

	GuiConfigCategory(GuiScreen parentScreen, String baseCategory) {
		super(parentScreen, getAllElements(baseCategory), LibMisc.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ModuleLoader.config.toString()));
	}

	private static List<IConfigElement> getAllElements(String baseCategory) {
		return new ArrayList<>(new ConfigElement(ModuleLoader.config.getCategory(baseCategory)).getChildElements());
	}

}