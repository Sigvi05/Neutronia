package net.hdt.neutronia.modules.colorful_armor_points.config;

import com.google.gson.Gson;
import net.hdt.neutronia.modules.colorful_armor_points.ColorfulArmorPoints;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class Config extends Configuration {
	public Config(File file) {
		super(file);
	}

	/** Information from icons.json */
	private IconData iconData;

	/** Default armor icon Y position */
	public int iconDefault;
	/** Flag to render glint on enchanted pieces */
	public boolean renderGlint;
	/** Flag to compress the bar into different colored borders */
	public boolean compressBar;

	/** Returns the icon index of the given {@link ItemStack}.
	 * @param stack The item stack to look up
	 * @return The icon index found, or {@link #iconDefault} if none was found. */
	public int getIcon(ItemStack stack) {
		return iconData.getIcon(stack);
	}

	@Override
	public void load() {
		ColorfulArmorPoints.logger.info("Reloading config");
		super.load(); // Load file as default

		// Custom properties
		iconDefault = getInt("iconDefault", CATEGORY_GENERAL, 2, "Default icon index");
		renderGlint = getBoolean("renderGlint", CATEGORY_GENERAL, true, "Display enchanted shine");
		compressBar = getBoolean("compressBar", CATEGORY_GENERAL, false, "Compress the bar into different colored borders when your armor exceeds 20");

		// Load icon data and overrides
		try {
			this.iconData = getIconData();
		} catch(IOException e) {
			ColorfulArmorPoints.logger.error("An error occurred loading icon data");
			e.printStackTrace();
		}
		if(hasChanged()) save();
	}

	/** Reads (and copies, if necessary) icons.json to load icon information.
	 * @return The resultant icon data from file */
	private IconData getIconData() throws IOException {
		// Default icons
		BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/assets/colorful_armor_points/icons.json")));
		IconData data = new Gson().fromJson(reader, IconData.class);
		reader.close();

		// Combine default with overrides
		File overrides = new File(getConfigFile().getParentFile(), "icons.json");

		if(overrides.exists()) {
			reader = new BufferedReader(new FileReader(overrides));
			IconData dataOverrides = new Gson().fromJson(reader, IconData.class);
			reader.close();

			data.putAll(dataOverrides);
		} else {
			// First run, or file has been deleted
			ColorfulArmorPoints.logger.warn(overrides.getAbsolutePath() + " did not exist. Loading defaults");
			FileUtils.copyURLToFile(getClass().getResource("/assets/colorful_armor_points/overrides.json"), overrides);
		}
		return data;
	}

	/** As {@link #getInt(String, String, int, int, int, String)} but with no limits */
	private int getInt(String name, String category, int defaultValue, String comment) {
		Property prop = get(category, name, defaultValue);

		prop.setLanguageKey(name);
		prop.setComment(comment + " [default: " + defaultValue + "]");

		return prop.getInt(defaultValue);
	}
}