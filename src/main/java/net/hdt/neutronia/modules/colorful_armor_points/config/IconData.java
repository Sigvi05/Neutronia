package net.hdt.neutronia.modules.colorful_armor_points.config;

import net.hdt.neutronia.modules.colorful_armor_points.features.ColoredArmorPoints;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

@SuppressWarnings("serial")
public class IconData extends HashMap<String, IconData.ModEntry> {
	/** @return The armor icon corresponding to {@code stack} */
	public int getIcon(ItemStack stack) {
		ModEntry mod = get(stack.getItem().getRegistryName().getNamespace());
		return mod != null ? mod.getIcon(stack) : ColoredArmorPoints.iconDefault;
	}

	@Override
	public ModEntry put(String key, ModEntry value) {
		// Combine mod entries if needed
		if(containsKey(key)) {
			ModEntry existing = get(key);
			existing.combine(value);
			return existing;
		} else {
			return super.put(key, value);
		}
	}

	/** Stores icon entries for a single mod */
	public static class ModEntry {
		IconMap.MaterialIconMap materials = new IconMap.MaterialIconMap();
		IconMap.ItemIconMap items = new IconMap.ItemIconMap();

		/** @return The armor icon corresponding to {@code stack} limited to the mod */
		public int getIcon(ItemStack stack) {
			Integer iconIndex = items.get(stack);
			if(iconIndex != null) return iconIndex;

			iconIndex = materials.get(stack);
			return iconIndex != null ? iconIndex : ColoredArmorPoints.iconDefault;
		}

		/** Adds all icons from {@code other} to the entry */
		public void combine(ModEntry other) {
			materials.putAll(other.materials);
			items.putAll(other.items);
		}
	}
}