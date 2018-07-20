package net.hdt.neutronia.modules.building.blocks;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class BlockPolishedStone extends BlockMod implements INeutroniaBlock {

	public BlockPolishedStone() {
		super(Material.ROCK, MOD_ID, "polished_stone");
		setHardness(1.5F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

}
