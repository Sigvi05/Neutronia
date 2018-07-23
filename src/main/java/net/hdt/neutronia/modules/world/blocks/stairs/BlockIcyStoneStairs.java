package net.hdt.neutronia.modules.world.blocks.stairs;

import net.hdt.neutronia.base.blocks.BlockNeutroniaStairs;
import net.hdt.neutronia.modules.world.features.UndergroundBiomes;

public class BlockIcyStoneStairs extends BlockNeutroniaStairs {

	public BlockIcyStoneStairs() {
		super("icy_stone_stairs", UndergroundBiomes.biome_cobblestone.getStateFromMeta(1));
	}
	
}