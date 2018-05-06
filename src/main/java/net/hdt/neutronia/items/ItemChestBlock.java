package net.hdt.neutronia.items;

import net.hdt.neutronia.blocks.overworld.BlockCustomChest;
import net.hdt.neutronia.properties.ChestType;
import net.hdt.neutronia.tileentity.TileCustomChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.huskylib2.items.blocks.ItemModBlock;

public class ItemChestBlock extends ItemModBlock {

    private BlockCustomChest block;

    public ItemChestBlock(BlockCustomChest block, ResourceLocation res) {
        super(block, res);
        this.block = block;
    }

    @Override
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState) {
        int typeCnt = 0;

        BlockPos posN = pos.north();
        BlockPos posS = pos.south();
        BlockPos posW = pos.west();
        BlockPos posE = pos.east();

        ChestType myType = block.getCustomType(stack);

        if (world.getBlockState(posN).getBlock() == block && block.getCustomType(world, posN) == myType)
            typeCnt += block.isDoubleChest(world, posN, myType) ? 2 : 1;
        if (world.getBlockState(posS).getBlock() == block && block.getCustomType(world, posS) == myType)
            typeCnt += block.isDoubleChest(world, posS, myType) ? 2 : 1;
        if (world.getBlockState(posW).getBlock() == block && block.getCustomType(world, posW) == myType)
            typeCnt += block.isDoubleChest(world, posW, myType) ? 2 : 1;
        if (world.getBlockState(posE).getBlock() == block && block.getCustomType(world, posE) == myType)
            typeCnt += block.isDoubleChest(world, posE, myType) ? 2 : 1;

        if (typeCnt <= 1 && super.placeBlockAt(stack, player, world, pos, side, hitX, hitY, hitZ, newState)) {
            TileEntity te = world.getTileEntity(pos);
            if (te instanceof TileCustomChest) {
                ((TileCustomChest) te).chestType = myType;
                return true;
            }
        }

        return false;
    }

}