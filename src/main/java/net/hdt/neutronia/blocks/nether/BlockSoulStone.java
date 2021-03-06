package net.hdt.neutronia.blocks.nether;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.neutronia.init.NCreativeTabs;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockSoulStone extends BlockMod {

    private static final AxisAlignedBB SOUL_SAND_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D);

    public BlockSoulStone(String name) {
        super(Material.SAND, Reference.MOD_ID, name);
        setCreativeTab(NCreativeTabs.NETHER_EXPANSION_TAB);
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return SOUL_SAND_AABB;
    }

    /**
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        entityIn.motionX *= 0.4D;
        entityIn.motionZ *= 0.4D;
    }

}
