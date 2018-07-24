package net.hdt.neutronia.modules.decoration.features;

import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.init.NItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.BannerPattern;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class MoreBanners extends Feature {

	private boolean dragon, eye, shield, sword, scute, phantom, nautilus, trident, anchor;

	@Override
	public void setupConfig() {
		dragon = loadPropBool("Dragon", "", true);
		eye = loadPropBool("Eye", "", true);
		shield = loadPropBool("Shield", "", true);
		sword = loadPropBool("Sword", "", true);
		scute = loadPropBool("Scute", "", true);
		phantom = loadPropBool("Phantom", "", true);
		nautilus = loadPropBool("Nautilus", "", true);
		trident = loadPropBool("Trident", "", true);
		anchor = loadPropBool("Anchor", "", true);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		addPattern(dragon, "dragon", "dr", ProxyRegistry.newStack(Items.SKULL, 1, 5));
		addPattern(eye, "eye", "ey", ProxyRegistry.newStack(Items.ENDER_EYE));
		addPattern(shield, "shield", "sh", ProxyRegistry.newStack(Items.IRON_CHESTPLATE));
		addPattern(sword, "sword", "sw", ProxyRegistry.newStack(Items.IRON_SWORD));
		addPattern(scute, "scute", "sc", ProxyRegistry.newStack(NItems.scute));
		addPattern(phantom, "phantom", "ph", ProxyRegistry.newStack(NItems.phantomMembrane));
		addPattern(nautilus, "nautilus", "nt", ProxyRegistry.newStack(NItems.nautilusShell));
		addPattern(trident, "trident", "tr", ProxyRegistry.newStack(NItems.trident));
		addPattern(anchor, "anchor", "an", ProxyRegistry.newStack(NItems.anchor));
	}

	public static void addPattern(boolean doit, String name, String id, ItemStack craftingItem) {
		if(!doit)
			return;

		name = "neutronia_" + name;
		id = "n_" + id;
		EnumHelper.addEnum(BannerPattern.class, name.toUpperCase(), new Class[] { String.class, String.class, ItemStack.class }, name, id, craftingItem);
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

}