package net.hdt.neutronia.tileentity;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityCraftingTable extends TileEntity {

    public Capability<IItemHandler> ITEM_HANDLER_CAPABILITY = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
    public ItemStackHandler INVENTORY = new ItemStackHandler(9);

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        ITEM_HANDLER_CAPABILITY.readNBT(INVENTORY, null, compound.getTag("inventory"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTBase INVENTORY = ITEM_HANDLER_CAPABILITY.writeNBT(this.INVENTORY, null);
        compound.setTag("inventory", INVENTORY);
        return compound;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == ITEM_HANDLER_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == ITEM_HANDLER_CAPABILITY ? (T) INVENTORY : null;
    }
}
