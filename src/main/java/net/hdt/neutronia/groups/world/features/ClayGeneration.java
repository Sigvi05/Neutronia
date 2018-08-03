package net.hdt.neutronia.groups.world.features;

import net.hdt.neutronia.base.groups.Feature;
import net.hdt.neutronia.groups.world.world.ClayGenerator;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClayGeneration extends Feature {

	int clusterSize, clusterCount;

	@Override
	public void setupConfig() {
		clusterSize = loadPropInt("Cluster size", "", 20);
		clusterCount = loadPropInt("Cluster count", "", 3);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new ClayGenerator(clusterSize, clusterCount), 0);
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}
	
	@Override
	public String getFeatureIngameConfigName() {
		return "Underground Clay";
	}

}
