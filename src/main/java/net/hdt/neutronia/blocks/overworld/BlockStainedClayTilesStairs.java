package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.init.HMBlocks;
import net.hdt.neutronia.modules.building.blocks.BlockStainedClayTiles;
import net.thegaminghuskymc.huskylib2.interf.IRecipeGrouped;

public class BlockStainedClayTilesStairs extends BlockOverworldStairBase implements IRecipeGrouped {

    public BlockStainedClayTilesStairs(BlockStainedClayTiles.Variants variant) {
        super(variant.getName() + "_stairs", HMBlocks.stained_clay_tiles.getDefaultState().withProperty(HMBlocks.stained_clay_tiles.getVariantProp(), variant));
    }

    @Override
    public String getRecipeGroup() {
        return "stained_clay_tiles_stairs";
    }

}