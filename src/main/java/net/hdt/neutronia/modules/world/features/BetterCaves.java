package net.hdt.neutronia.modules.world.features;

import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.world.world.gen.WorldGenNewCave;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BetterCaves extends Feature {

	@SubscribeEvent
	public static void onMapGen(InitMapGenEvent event) {
		if (event.getType().equals(InitMapGenEvent.EventType.CAVE))	{
			event.setNewGen(new WorldGenNewCave());
		}
    }

	@Override
	public boolean hasTerrainSubscriptions() {
		return true;
	}

}
