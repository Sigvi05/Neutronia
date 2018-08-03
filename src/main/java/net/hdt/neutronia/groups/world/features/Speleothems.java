package net.hdt.neutronia.groups.world.features;

import net.hdt.neutronia.base.handler.DimensionConfig;
import net.hdt.neutronia.base.groups.Feature;
import net.hdt.neutronia.base.groups.GroupLoader;
import net.hdt.neutronia.groups.world.blocks.BlockSpeleothem;
import net.hdt.neutronia.groups.world.world.SpeleothemGenerator;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Speleothems extends Feature {

	public static Block stone_speleothem, granite_speleothem, diorite_speleothem,
		andesite_speleothem, basalt_speleothem, marble_speleothem, limestone_speleothem,
		netherrack_speleothem;

	public static int tries, clusterCount, netherTries, netherClusterCount;
	public static DimensionConfig dimensionConfig;

	@Override
	public void setupConfig() {
		tries = loadPropInt("Cluster Attempts Per Chunk", "", 60);
		clusterCount = loadPropInt("Speleothems Per Cluster", "", 12);
		netherTries = loadPropInt("Cluster Attempts Per Chunk (Nether)", "", 4);
		netherClusterCount = loadPropInt("Speleothems Per Cluster (Nether)", "", 12);

		dimensionConfig = new DimensionConfig(configCategory, "0,-1");
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		stone_speleothem = new BlockSpeleothem("stone");
		granite_speleothem = new BlockSpeleothem("granite");
		diorite_speleothem = new BlockSpeleothem("diorite");
		andesite_speleothem = new BlockSpeleothem("andesite");
		netherrack_speleothem = new BlockSpeleothem("netherrack").setNetherrack();

		if(GroupLoader.isFeatureEnabled(Basalt.class))
			basalt_speleothem = new BlockSpeleothem("basalt");

		if(GroupLoader.isFeatureEnabled(RevampStoneGen.class)) {
			if(RevampStoneGen.enableMarble)
				marble_speleothem = new BlockSpeleothem("marble");

			if(RevampStoneGen.enableLimestone)
				limestone_speleothem = new BlockSpeleothem("limestone");
		}

		GameRegistry.registerWorldGenerator(new SpeleothemGenerator(), 1000);
	}

}
