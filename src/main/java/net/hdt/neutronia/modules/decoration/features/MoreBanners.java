package net.hdt.neutronia.modules.decoration.features;

import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.module.Feature;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.BannerPattern;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class MoreBanners extends Feature {

	boolean dragon, eye, shield, sword;

	@Override
	public void setupConfig() {
		dragon = loadPropBool("Dragon", "", true);
		eye = loadPropBool("Eye", "", true);
		shield = loadPropBool("Shield", "", true);
		sword = loadPropBool("Sword", "", true);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		addPattern(dragon, "dragon", "dr", ProxyRegistry.newStack(Items.SKULL, 1, 5));
		addPattern(eye, "eye", "ey", ProxyRegistry.newStack(Items.ENDER_EYE));
		addPattern(shield, "shield", "sh", ProxyRegistry.newStack(Items.IRON_CHESTPLATE));
		addPattern(sword, "sword", "sw", ProxyRegistry.newStack(Items.IRON_SWORD));
	}

	public static void addPattern(boolean doit, String name, String id, ItemStack craftingItem) {
		if(!doit)
			return;

		name = "quark_" + name;
		id = "q_" + id;
		EnumHelper.addEnum(BannerPattern.class, name.toUpperCase(), new Class[] { String.class, String.class, ItemStack.class }, name, id, craftingItem);
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

}