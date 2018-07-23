package net.hdt.neutronia.modules.world.features;

import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.world.world.NetherFossilGenerator;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NetherFossils extends Feature {

	public static int chance;
	
	@Override
	public void setupConfig() {
		chance = loadPropInt("Fossil Chance", "The rarity of a fossil in a chunk. Higher means fewer fossils.", 25);
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new NetherFossilGenerator(), 0);
	}
	
}
