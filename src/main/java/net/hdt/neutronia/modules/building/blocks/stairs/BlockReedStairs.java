/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [20/03/2016, 23:47:04 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks.stairs;

import net.hdt.neutronia.blocks.overworld.BlockOverworldStairBase;
import net.hdt.neutronia.modules.building.features.ReedBlock;

public class BlockReedStairs extends BlockOverworldStairBase {

    public BlockReedStairs() {
        super("reed_block_stairs", ReedBlock.reed_block.getDefaultState());
    }


}