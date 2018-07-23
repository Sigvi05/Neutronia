package net.hdt.neutronia.modules.world.blocks.stairs;

import net.hdt.neutronia.base.blocks.BlockNeutroniaStairs;
import net.hdt.neutronia.modules.world.features.RevampStoneGen;

public class BlockMarbleStairs extends BlockNeutroniaStairs {

	public BlockMarbleStairs() {
		super("stone_marble_stairs", RevampStoneGen.marble.getDefaultState());
	}

}
