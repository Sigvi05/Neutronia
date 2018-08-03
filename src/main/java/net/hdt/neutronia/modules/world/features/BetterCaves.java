package net.hdt.neutronia.modules.world.features;

import net.hdt.neutronia.base.handler.DimensionConfig;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.world.blocks.BlockCrystal;
import net.hdt.neutronia.modules.world.world.CrystalCaveGenerator;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CrystalCaves extends Feature {

	@SubscribeEvent
	public static void onMapGen(InitMapGenEvent event) {
		if (event.getType().equals(EventType.CAVE))	{
			event.setNewGen(new CaveGen());
		}
    }

	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}
	
}
