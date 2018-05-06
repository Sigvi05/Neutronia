package net.hdt.neutronia.client.container;

import net.hdt.neutronia.tileentity.TileEntityCraftingTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

public class ContainerWorkbench extends net.minecraft.inventory.ContainerWorkbench {

    private TileEntityCraftingTable TE = new TileEntityCraftingTable();

    public ContainerWorkbench(InventoryPlayer playerInventory, World worldIn, BlockPos posIn) {
        super(playerInventory, worldIn, posIn);

        ItemStackHandler inv = TE.INVENTORY;
        for (int index = 0; index < 9; index++) {
            craftMatrix.setInventorySlotContents(index, inv.extractItem(index, inv.getStackInSlot(index).getCount(), false));
        }

    }

    public void onContainerClosed(EntityPlayer playerIn) {
        Container c = this;
        c.onContainerClosed(playerIn);
        ItemStackHandler inv = TE.INVENTORY;
        for (int index = 0; index < 9; index++) {
            inv.insertItem(index, craftMatrix.getStackInSlot(index), true);
        }
    }

}