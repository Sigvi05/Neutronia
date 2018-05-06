/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [20/03/2016, 18:32:01 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks.stairs;

import net.hdt.neutronia.blocks.overworld.BlockOverworldStairBase;
import net.hdt.neutronia.modules.building.blocks.BlockStainedClayTiles;
import net.hdt.neutronia.modules.building.features.HardenedClayTiles;
import net.thegaminghuskymc.huskylib2.interf.IRecipeGrouped;

public class BlockStainedClayTilesStairs extends BlockOverworldStairBase implements IRecipeGrouped {

    public BlockStainedClayTilesStairs(BlockStainedClayTiles.Variants variant) {
        super(variant.getName() + "_stairs", HardenedClayTiles.stained_clay_tiles.getDefaultState().withProperty(HardenedClayTiles.stained_clay_tiles.getVariantProp(), variant));
    }

    @Override
    public String getRecipeGroup() {
        return "stained_clay_tiles_stairs";
    }

}
