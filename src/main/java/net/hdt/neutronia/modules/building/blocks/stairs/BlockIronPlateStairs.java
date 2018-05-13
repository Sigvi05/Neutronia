/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [30/06/2016, 14:51:44 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks.stairs;

import net.hdt.neutronia.blocks.overworld.BlockOverworldStairBase;
import net.hdt.neutronia.modules.building.features.IronPlates;

public class BlockIronPlateStairs extends BlockOverworldStairBase {

    public BlockIronPlateStairs() {
        super("iron_plate_stairs", IronPlates.iron_plate.getDefaultState());
    }

}
