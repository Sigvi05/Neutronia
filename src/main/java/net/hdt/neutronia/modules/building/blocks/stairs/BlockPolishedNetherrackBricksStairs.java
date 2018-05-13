package net.hdt.neutronia.modules.building.blocks.stairs;

import net.hdt.neutronia.blocks.overworld.BlockOverworldStairBase;
import net.hdt.neutronia.modules.building.blocks.BlockPolishedNetherrack;
import net.hdt.neutronia.modules.building.features.PolishedNetherrack;

public class BlockPolishedNetherrackBricksStairs extends BlockOverworldStairBase {

    public BlockPolishedNetherrackBricksStairs() {
        super("polished_netherrack_bricks_stairs", PolishedNetherrack.polished_netherrack.getDefaultState().withProperty(PolishedNetherrack.polished_netherrack.getVariantProp(), BlockPolishedNetherrack.Variants.POLISHED_NETHERRACK_BRICKS));
    }

}
