package net.hdt.neutronia.tileentity;

import codechicken.lib.colour.Colour;
import com.elytradev.mirage.event.GatherLightsEvent;
import com.elytradev.mirage.lighting.ILightEventConsumer;
import com.elytradev.mirage.lighting.Light;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Optional.Interface(modid = "mirage", iface = "com.elytradev.mirage.lighting.ILightEventConsumer", striprefs = true)
public class TileEntityNeonLight extends TileEntity implements ILightEventConsumer {

    private int color = 0xFFFFFFFF;

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        color = compound.getInteger("color");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("color", color);
        return compound;
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
        return oldState.getBlock() != newSate.getBlock();
    }

    @Optional.Method(modid = "mirage")
    @Override
    @SideOnly(Side.CLIENT)
    public void gatherLights(GatherLightsEvent event) {
        if(getBlockMetadata() == 1) {
            int[] c = Colour.unpack(color);
            event.add(Light.builder().pos(pos).color(c[0] / 255F, c[1] / 255F, c[2] / 255F).radius(4F).build());
        }
    }

    public void setColor(int color) {
        this.color = color;
        markDirty();
    }

    public int getColor() {
        return color;
    }

}