package net.hdt.neutronia.modules.building.blocks.stairs;

import net.hdt.neutronia.blocks.overworld.BlockOverworldStairBase;
import net.hdt.neutronia.modules.building.blocks.BlockStainedPlanks;
import net.hdt.neutronia.modules.building.features.StainedPlanks;
import net.thegaminghuskymc.huskylib2.interf.IRecipeGrouped;

public class BlockStainedPlanksStairs extends BlockOverworldStairBase implements IRecipeGrouped {

    public BlockStainedPlanksStairs(BlockStainedPlanks.Variants variant) {
        super(variant.getName() + "_stairs", StainedPlanks.stained_planks.getDefaultState().withProperty(StainedPlanks.stained_planks.getVariantProp(), variant));
    }

    @Override
    public String getRecipeGroup() {
        return "stained_planks_stairs";
    }

}
