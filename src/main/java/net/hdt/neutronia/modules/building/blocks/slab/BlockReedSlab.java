/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [20/03/2016, 23:45:26 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks.slab;

import net.hdt.neutronia.blocks.overworld.BlockOverworldSlabBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockReedSlab extends BlockOverworldSlabBase {

    public BlockReedSlab(boolean doubleSlab) {
        super("reed_block_slab", Material.WOOD, doubleSlab);
        setHardness(0.5F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

}
	