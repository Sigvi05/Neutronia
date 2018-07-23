package net.hdt.neutronia.modules.world.blocks.stairs;

import net.hdt.neutronia.base.blocks.BlockNeutroniaStairs;
import net.hdt.neutronia.modules.world.features.RevampStoneGen;

public class BlockLimestoneStairs extends BlockNeutroniaStairs {

	public BlockLimestoneStairs() {
		super("stone_limestone_stairs", RevampStoneGen.limestone.getDefaultState());
	}

}
