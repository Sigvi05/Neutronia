package net.hdt.neutronia.blocks;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.init.NCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockPrismarineChiseled extends BlockMod {

    private boolean filled;

    public BlockPrismarineChiseled(String name, boolean filled) {
        super(Material.ROCK, MOD_ID, name);
        this.filled = filled;
        setCreativeTab(filled ? null : NCreativeTabs.OCEAN_EXPANSION_TAB);
        setHardness(0.3F);
        setResistance(6.5F);
        setSoundType(SoundType.STONE);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = playerIn.getHeldItem(hand);

        if (itemstack.isEmpty()) {
            return false;
        }
        else {
            Item item = itemstack.getItem();

            if (item == Items.PRISMARINE_CRYSTALS) {
                if (!filled) {
                    worldIn.setBlockState(pos, NBlocks.chiseledPrismarineFilled.getDefaultState(), 2);
                    itemstack.shrink(1);
                    return true;
                }
                return false;
            }
            else {
                if (filled) {
                    worldIn.setBlockState(pos, NBlocks.chiseledPrismarine.getDefaultState(), 2);
                    playerIn.inventory.addItemStackToInventory(new ItemStack(Items.PRISMARINE_CRYSTALS));
                    return true;
                }
                return false;
            }
        }
    }
}
