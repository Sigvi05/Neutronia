/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [29/06/2016, 18:29:08 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks.slab;

import net.hdt.neutronia.blocks.overworld.BlockOverworldSlabBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockMidoriSlab extends BlockOverworldSlabBase {

    public BlockMidoriSlab(boolean doubleSlab) {
        super("midori_block_slab", Material.ROCK, doubleSlab);
        setHardness(1.5F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
    }

}
