package net.hdt.neutronia.modules.decoration.blocks;

import net.hdt.huskylib2.blocks.BlockMetaVariants;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class BlockCustomBookshelf extends BlockMetaVariants implements INeutroniaBlock {

	public BlockCustomBookshelf() {
		super("custom_bookshelf", MOD_ID, Material.WOOD, Variants.class);
		setHardness(1.5F);
		setSoundType(SoundType.WOOD);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@Override
	public float getEnchantPowerBonus(World world, BlockPos pos) {
		return 1;
	}

	@Override
    public int quantityDropped(Random random) {
        return 3;
    }

	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}
	
    @Override
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.BOOK;
    }
	
	public enum Variants implements EnumBase {
		BOOKSHELF_SPRUCE,
		BOOKSHELF_BIRCH,
		BOOKSHELF_JUNGLE,
		BOOKSHELF_ACACIA,
		BOOKSHELF_DARK_OAK
	}

}