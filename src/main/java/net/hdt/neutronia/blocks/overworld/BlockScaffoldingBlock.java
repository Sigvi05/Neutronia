package net.hdt.neutronia.blocks.overworld;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.neutronia.init.NBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Objects;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockScaffoldingBlock extends BlockMod {

    public BlockScaffoldingBlock() {
        super(Material.WOOD, MOD_ID, "scaffolding_block");
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(0.2F);
        setHarvestLevel("axe", 0);
        this.setSoundType(SoundType.WOOD);
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        if (!worldIn.isRemote && stack.getItem() instanceof ItemAxe) {
            player.addStat(Objects.requireNonNull(StatList.getBlockStats(this)));
            spawnAsEntity(worldIn, pos, new ItemStack(NBlocks.scaffoldingBlock, 1, 0));
        } else {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
        return true;
    }

    @Override
    public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        super.onEntityCollision(worldIn, pos, state, entityIn);
        if (entityIn instanceof EntityLivingBase && !((EntityLivingBase) entityIn).isOnLadder() && isLadder(state, worldIn, pos, (EntityLivingBase) entityIn)) {
            float f5 = 0.15F;
            if (entityIn.motionX < -f5)
                entityIn.motionX = -f5;
            if (entityIn.motionX > f5)
                entityIn.motionX = f5;
            if (entityIn.motionZ < -f5)
                entityIn.motionZ = -f5;
            if (entityIn.motionZ > f5)
                entityIn.motionZ = f5;

            entityIn.fallDistance = 0.0F;
            if (entityIn.motionY < -0.15D)
                entityIn.motionY = -0.15D;

            if (entityIn.motionY < 0 && entityIn instanceof EntityPlayer && entityIn.isSneaking()) {
                entityIn.motionY = 0;
                return;
            }
            if (entityIn.collidedHorizontally)
                entityIn.motionY = .2;
        }
    }

}