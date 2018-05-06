package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.init.HMBlocks;
import net.thegaminghuskymc.huskylib2.interf.IRecipeGrouped;

public class BlockStainedPlanksStairs extends BlockOverworldStairBase implements IRecipeGrouped {

    public BlockStainedPlanksStairs(BlockStainedPlanks.Variants variant) {
        super(variant.getName() + "_stairs", HMBlocks.stained_planks.getDefaultState().withProperty(HMBlocks.stained_planks.getVariantProp(), variant));
    }

    @Override
    public String getRecipeGroup() {
        return "stained_planks_stairs";
    }

}