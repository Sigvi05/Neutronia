package net.hdt.neutronia.modules.building.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockMagmaBricks extends BlockMod implements IModBlock {

    public BlockMagmaBricks() {
        super(Material.ROCK, MOD_ID, "magma_bricks");
        setHardness(1.5F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setLightLevel(0.2F);
    }

    @Override
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos) {
        return 15728880;
    }

    @Override
    public boolean canEntitySpawn(IBlockState state, Entity entityIn) {
        return entityIn.isImmuneToFire();
    }

}
