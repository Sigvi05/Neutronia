/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 *
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 *
 * File Created @ [20/03/2016, 22:38:50 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class BlockSandyBricks extends BlockMod implements INeutroniaBlock {

	public BlockSandyBricks() {
		super(Material.ROCK, MOD_ID, "sandy_bricks");
		setHardness(2.0F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

}