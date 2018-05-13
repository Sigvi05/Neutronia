package net.hdt.neutronia.blocks.overworld;

import codechicken.lib.colour.Colour;
import codechicken.lib.colour.EnumColour;
import codechicken.lib.util.ItemNBTUtils;
import codechicken.lib.util.ItemUtils;
import com.google.common.collect.Lists;
import de.kitsunealex.silverfish.util.IShiftDescription;
import net.hdt.neutronia.blocks.base.BlockColoredLightSourceAlt;
import net.hdt.neutronia.tileentity.TileEntityNeonLight;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockNeonLight extends BlockColoredLightSourceAlt implements IShiftDescription {

    public BlockNeonLight(EnumDyeColor color) {
        super(MOD_ID, "neon_light", color);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityNeonLight();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);

        if(world.getTileEntity(pos) != null && !stack.isEmpty()) {
            TileEntityNeonLight tile = (TileEntityNeonLight)world.getTileEntity(pos);
            int[] color = Colour.unpack(tile.getColor());

            if(stack.getItem() == Items.DYE) {
                if(player.isSneaking()) {
                    if(color[0] > 0 && stack.getMetadata() == 2) {
                        color[0]--;
                    }
                    else if(color[1] > 0 && stack.getMetadata() == 1) {
                        color[1]--;
                    }
                    else if(color[2] > 0 && stack.getMetadata() == 0) {
                        color[2]--;
                    }
                }
                else {
                    if(color[0] < 255 && stack.getMetadata() == 2) {
                        color[0]++;
                    }
                    else if(color[1] < 255 && stack.getMetadata() == 1) {
                        color[1]++;
                    }
                    else if(color[2] < 255 && stack.getMetadata() == 0) {
                        color[2]++;
                    }
                }

                if(!world.isRemote) {
                    tile.setColor(Colour.pack(color));
                    tile.markDirty();
                    world.markBlockRangeForRenderUpdate(pos, pos);
                }

                return true;
            }
        }

        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if(world.getTileEntity(pos) != null && !world.isRemote && ItemNBTUtils.hasKey(stack, "color")) {
            TileEntityNeonLight tile = (TileEntityNeonLight)world.getTileEntity(pos);
            tile.setColor(ItemNBTUtils.getInteger(stack, "color"));
            tile.markDirty();
            world.markBlockRangeForRenderUpdate(pos, pos);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos sourcePos) {

    }

    @SuppressWarnings("deprecation")
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        return Lists.newArrayList();
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        if(!world.isRemote) {
            if(!player.capabilities.isCreativeMode && world.getTileEntity(pos) != null) {
                TileEntityNeonLight tile = (TileEntityNeonLight)world.getTileEntity(pos);
                ItemStack stack = new ItemStack(this, 1, 0);
                ItemNBTUtils.setInteger(stack, "color", tile.getColor());
                ItemUtils.dropItem(world, pos, stack);
            }
        }
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        return getMetaFromState(state) == 1 && Loader.isModLoaded("mirage") ? 255 : 0;
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
        for(EnumColour color : EnumColour.values()) {
            ItemStack stack = new ItemStack(this, 1, 0);
            ItemNBTUtils.setInteger(stack, "color", color.rgba());
            items.add(stack);
        }
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        if(world.getTileEntity(pos) != null) {
            TileEntityNeonLight tile = (TileEntityNeonLight)world.getTileEntity(pos);
            ItemStack stack = new ItemStack(this, 1, 0);
            ItemNBTUtils.setInteger(stack, "color", tile.getColor());
            return stack;
        }
        else {
            return super.getPickBlock(state, target, world, pos, player);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean addDescription(ItemStack stack, World world, List<String> lines, boolean isShiftDown) {
        if(isShiftDown) {
            int color = ItemNBTUtils.hasKey(stack, "color") ? ItemNBTUtils.getInteger(stack, "color") : 0xFFFFFFFF;
            int[] colorArray = Colour.unpack(color);
            lines.add(TextFormatting.RED + "R: " + colorArray[0]);
            lines.add(TextFormatting.GREEN + "G: " + colorArray[1]);
            lines.add(TextFormatting.BLUE + "B: " + colorArray[2]);
        }

        return !isShiftDown;
    }

}
