package net.hdt.neutronia.modules.building.blocks;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class BlockSnowBricks extends BlockMod implements INeutroniaBlock {

	public BlockSnowBricks() {
		super(Material.CRAFTED_SNOW, MOD_ID, "snow_bricks");
		setHardness(0.2F);
		setSoundType(SoundType.SNOW);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	@Override
	public boolean isToolEffective(String type, IBlockState state) {
		return type.equals("shovel");
	}

	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
		return true;
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

}
