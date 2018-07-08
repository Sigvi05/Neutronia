package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.properties.Properties;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTurtleEgg extends BlockWaterBlockBase {

    private static final PropertyInteger EGGS = Properties.EGGS;
    private static final PropertyInteger HATCH = Properties.HATCH;

    public BlockTurtleEgg(String name) {
        super(name);
        setDefaultState(getDefaultState().withProperty(EGGS, 1).withProperty(HATCH, 0));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, EGGS, HATCH);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        int eggs = state.getValue(EGGS);
        if(playerIn.getActiveItemStack() == new ItemStack(this)) {
            int i = 0;
            while (i < eggs) {
                worldIn.setBlockState(pos, state.withProperty(EGGS, i));
                return true;
            }
        }
        return false;
    }

}