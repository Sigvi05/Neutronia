package net.hdt.neutronia.modules.building.blocks.stairs;

import net.hdt.neutronia.blocks.overworld.BlockOverworldStairBase;
import net.hdt.neutronia.modules.building.blocks.BlockBark;
import net.hdt.neutronia.modules.building.features.BarkBlocks;
import net.thegaminghuskymc.huskylib2.interf.IRecipeGrouped;

public class BlockBarkStairs extends BlockOverworldStairBase implements IRecipeGrouped {

    public BlockBarkStairs(BlockBark.Variants variant) {
        super(variant.getName() + "_stairs", BarkBlocks.bark.getDefaultState().withProperty(BarkBlocks.bark.getVariantProp(), variant));
    }

    @Override
    public String getRecipeGroup() {
        return "bark_stairs";
    }

}
