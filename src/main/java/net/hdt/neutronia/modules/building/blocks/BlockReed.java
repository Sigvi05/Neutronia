/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [20/03/2016, 23:35:53 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks;

import net.hdt.neutronia.blocks.base.BlockModPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockReed extends BlockModPillar {

    public BlockReed() {
        super("reed_block", Material.WOOD);
        setHardness(0.5F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

}
