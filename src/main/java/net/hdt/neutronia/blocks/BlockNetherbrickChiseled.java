package net.hdt.neutronia.blocks;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.init.NCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockNetherbrickChiseled extends BlockMod {

    private boolean filled;

    public BlockNetherbrickChiseled(String name, boolean filled) {
        super(Material.ROCK, MOD_ID, name);
        this.filled = filled;
        setCreativeTab(filled ? null : NCreativeTabs.NETHER_EXPANSION_TAB);
        setHardness(2.0F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = playerIn.getHeldItem(hand);

        if (itemstack.isEmpty()) {
            return false;
        }
        else {
            Item item = itemstack.getItem();

            if (item == Items.LAVA_BUCKET) {
                if (!filled) {
                    worldIn.playSound( null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    worldIn.setBlockState(pos, NBlocks.chiseledNetherbrickFilled.getDefaultState(), 2);
                    playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
                }
                return true;
            } else if (item == Items.BUCKET) {
                if (filled) {
                    worldIn.playSound( null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    worldIn.setBlockState(pos, NBlocks.chiseledNetherbrick.getDefaultState(), 2);
                    itemstack.shrink(1);
                    playerIn.setHeldItem(hand, new ItemStack(Items.LAVA_BUCKET));
                    return true;
                }
            }
        }
        return false;
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (filled)
        {
            int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
            harvesters.set(player);
            this.dropBlockAsItem(worldIn, pos, state, i);
            harvesters.set(null);
            Material material = worldIn.getBlockState(pos.down()).getMaterial();

            if (material.blocksMovement() || material.isLiquid())
            {
                worldIn.setBlockState(pos, Blocks.FLOWING_LAVA.getDefaultState());
            }
        }
    }
}
