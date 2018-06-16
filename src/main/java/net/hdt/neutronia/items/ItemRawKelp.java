package net.hdt.neutronia.items;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.blocks.overworld.BlockKelp;
import net.hdt.neutronia.init.NBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemRawKelp extends ItemBase {

    public ItemRawKelp() {
        super("kelp", Main.ITEM_EXPANSION_TAB);
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (facing != EnumFacing.UP) {
            return EnumActionResult.FAIL;
        } else {
            ItemStack itemstack = player.getHeldItem(hand);

            // All is well
            if (player.canPlayerEdit(pos, facing, itemstack)) {
                IBlockState state = NBlocks.kelp.getDefaultState();
                worldIn.setBlockState(pos, state);
                SoundType soundtype = SoundType.SAND;
                worldIn.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                itemstack.shrink(1);

                TileEntity te = worldIn.getTileEntity(pos);
                if (te instanceof BlockKelp.TileKelp) {
                    BlockKelp.TileKelp tileEntity = (BlockKelp.TileKelp)te;
                    tileEntity.setHeight(1);
                }

                return EnumActionResult.SUCCESS;
            }
        }
        
        return EnumActionResult.PASS;
    }
}