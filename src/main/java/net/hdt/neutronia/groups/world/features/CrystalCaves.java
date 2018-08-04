package net.hdt.neutronia.groups.world.features;

import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.base.handler.DimensionConfig;
import net.hdt.neutronia.groups.world.blocks.BlockCrystal;
import net.hdt.neutronia.groups.world.world.CrystalCaveGenerator;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CrystalCaves extends Component {

	public static Block crystal;
	
	DimensionConfig dims;
	public static int crystalCaveRarity;
	
	@Override
	public void setupConfig() {
		crystalCaveRarity = loadPropInt("Crystal Cave Rarity", "Given this value as X, crystal caves will spawn on average 1 per X chunks", 150);
		dims = new DimensionConfig(configCategory);
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		crystal = new BlockCrystal();
		
		GameRegistry.registerWorldGenerator(new CrystalCaveGenerator(dims), 1);
	}

	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}
	
}
