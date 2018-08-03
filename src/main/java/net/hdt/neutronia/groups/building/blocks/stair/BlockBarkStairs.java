package net.hdt.neutronia.groups.building.blocks.stair;

import net.hdt.huskylib2.interf.IRecipeGrouped;
import net.hdt.neutronia.base.blocks.BlockNeutroniaStairs;
import net.hdt.neutronia.groups.building.blocks.BlockBark;
import net.hdt.neutronia.groups.building.features.BarkBlocks;

public class BlockBarkStairs extends BlockNeutroniaStairs implements IRecipeGrouped {

	public BlockBarkStairs(BlockBark.Variants variant) {
		super(variant.getName() + "_stairs", BarkBlocks.bark.getDefaultState().withProperty(BarkBlocks.bark.getVariantProp(), variant));
	}
	
	@Override
	public String getRecipeGroup() {
		return "bark_stairs";
	}

}
