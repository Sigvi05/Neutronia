package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.blocks.base.BlockModBush;
import net.hdt.neutronia.init.NCreativeTabs;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class BlockCoralPlantBase extends BlockModBush {

    public BlockCoralPlantBase(String name) {
        super(Material.PLANTS, name, Reference.MOD_ID);
        this.setCreativeTab(NCreativeTabs.OCEAN_EXPANSION_TAB);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, 15));
    }

    @Override
    public IProperty[] getIgnoredProperties() {
        return new IProperty[]{LEVEL};
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

    public int getMetaFromState(IBlockState state) {
        return state.getValue(LEVEL);
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LEVEL);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Block.EnumOffsetType getOffsetType() {
        return Block.EnumOffsetType.XZ;
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess world, BlockPos pos) {
        return NULL_AABB;
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World world, BlockPos pos) {
        return (world.getBlockState(pos).getMaterial().isLiquid() &&
                world.getBlockState(pos.up()).getMaterial().isLiquid()) &&
                canThisPlantGrowOnThisBlock(world.getBlockState(pos.down()).getBlock());
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return super.canPlaceBlockAt(world, pos) && world.getBlockState(pos).getBlock() != this &&
                canThisPlantGrowOnThisBlock(world.getBlockState(pos.down()).getBlock()) &&
                world.getBlockState(pos).getMaterial() == Material.WATER &&
                world.getBlockState(pos.up()).getMaterial() == Material.WATER;
    }

    public boolean canThisPlantGrowOnThisBlock(Block b) {
        return b == Blocks.GRASS || b == Blocks.DIRT || b == Blocks.SAND;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Water;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return this.getDefaultState();
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        checkFlowerChange(world, pos, state);
        //System.out.println("Block update");
		/*if(!world.isRemote && world.getLoadedEntityList().size() < 200) {
			if(rand.nextInt(12) == 0) {
				EntityPiranha fish = new EntityPiranha(world);
				fish.setPosition(pos.getX(), pos.getY(), pos.getZ());
				world.spawnEntity(fish);
				fish.markAsLeader();
				int amt = rand.nextInt(12);
				for(int i =0 ; i < amt; i++) {
					EntityPiranha fishe = new EntityPiranha(fish);
					fishe.setPosition(pos.getX(), pos.getY(), pos.getZ());
					world.spawnEntity(fishe);
				}
			}
		}*/
    }

    protected void checkFlowerChange(World world, BlockPos pos, IBlockState state) {
        if (!canBlockStay(world, pos)) {
            dropBlockAsItem(world, pos, state, 0);
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        }
    }

    /**
     * Pop off decorativeCoralBlock block if sand underneath disappears
     */
    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
        this.checkFlowerChange(world, pos, state);
    }

}
