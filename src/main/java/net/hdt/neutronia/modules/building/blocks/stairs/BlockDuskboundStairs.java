package net.hdt.neutronia.modules.building.blocks.stairs;

import net.hdt.neutronia.blocks.nether.BlockNetherStairBase;
import net.hdt.neutronia.modules.building.features.DuskboundBlocks;

public class BlockDuskboundStairs extends BlockNetherStairBase {

    public BlockDuskboundStairs() {
        super("duskbound_block_stairs", DuskboundBlocks.duskbound_block.getDefaultState());
    }

}
