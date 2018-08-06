package net.hdt.neutronia.groups.world.blocks.stairs;

import net.hdt.neutronia.base.blocks.BlockNeutroniaStairs;
import net.hdt.neutronia.groups.world.features.RevampStoneGen;

public class BlockLimestoneStairs extends BlockNeutroniaStairs {

    public BlockLimestoneStairs() {
        super("stone_limestone_stairs", RevampStoneGen.limestone.getDefaultState());
    }

}
