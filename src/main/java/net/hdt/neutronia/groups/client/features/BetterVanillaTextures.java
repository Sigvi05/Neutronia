package net.hdt.neutronia.groups.client.features;

import net.hdt.neutronia.base.Neutronia;
import net.hdt.neutronia.base.groups.Component;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.function.BiConsumer;

public class BetterVanillaTextures extends Component {

	boolean granite, andesite, diorite, bricks, glass, pumpkinFace, pistonModels, bowAnimation, observer;
	
	@Override
	public void setupConfig() {
		granite = loadPropBool("Override Granite", "", true);
		andesite = loadPropBool("Override Andesite", "", true);
		diorite = loadPropBool("Override Diorite", "", true);
		bricks = loadPropBool("Override Bricks", "", true);
		glass = loadPropBool("Override Glass", "", true);
		pumpkinFace = loadPropBool("Override Pumpkin Front Face", "", false);
		pistonModels = loadPropBool("Override Piston Models", "", true);
		bowAnimation = loadPropBool("Override Bow Animation", "", true);
		observer = loadPropBool("Override Observer", "", true);
	}
	
	@Override
	public void preInitClient(FMLPreInitializationEvent event) {
		overrideBlock("stone_granite", granite);
		overrideBlock("stone_andesite", andesite);
		overrideBlock("stone_diorite", diorite);
		overrideBlock("brick", bricks);
		overrideBlock("glass", glass);
		overrideBlock("pumpkin_face_off", pumpkinFace);
		
		batch(this::overrideBlockModel, pistonModels,
				"piston_extended_normal", "piston_head_normal", "piston_head_short_sticky",
				"piston_head_sticky", "piston_inventory_sticky", "sticky_piston");
		
		batch(this::overrideBlockModel, observer,
				"observer", "observer_powered");
		
		overrideItemModel("bow", bowAnimation);
	}
	
	private void overrideBlock(String str, boolean flag) {
		if(flag)
			Neutronia.proxy.addResourceOverride("textures", "block", str, "png");
	}
	
	private void overrideBlockModel(String str, boolean flag) {
		if(flag)
			Neutronia.proxy.addResourceOverride("models", "block", str, "json");
	}
	
	private void overrideItemModel(String str, boolean flag) {
		if(flag)
			Neutronia.proxy.addResourceOverride("models", "item", str, "json");
	}
	
	private void batch(BiConsumer<String, Boolean> f, boolean flag, String... vars) {
		for(String s : vars)
			f.accept(s, flag);
	}

	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}
	
}
