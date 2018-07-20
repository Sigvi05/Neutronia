package net.hdt.neutronia.blocks.overworld;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.huskylib2.interf.IModBlock;
import net.hdt.neutronia.base.util.Reference;
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

public class BlockCustomBookshelf extends BlockMod implements IModBlock {

    public BlockCustomBookshelf(String name) {
        super(Material.WOOD, Reference.MOD_ID, name + "_bookshelf");
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

}