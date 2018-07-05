package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.properties.EnumCoralColor;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created on 7/5/18 by alexiy.
 * This coral turns dead if no water blocks are adjacent to it
 */
public class BlockCoral2 extends BlockColoredWaterBlockBase {

    private boolean dead;
    public BlockCoral2(EnumCoralColor colorIn, String name, boolean isDead) {
        super(colorIn, name);
        dead=isDead;
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if(!dead && !canLive(worldIn,pos))
            worldIn.scheduleUpdate(pos,this,100);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

        if(!dead && !canLive(worldIn,pos))
            worldIn.scheduleUpdate(pos,this,100);

    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if(!dead && !canLive(worldIn,pos))
        {
            worldIn.setBlockState(pos,NBlocks.deadCorals.get(NBlocks.livingCorals.indexOf(this)).getDefaultState());
        }
    }

    protected boolean canLive(World world,BlockPos itsPosition)
    {
        for (EnumFacing facing : EnumFacing.values()) {
            IBlockState sidestate=world.getBlockState(itsPosition.offset(facing));
            if(sidestate.getBlock()== Blocks.WATER || sidestate.getBlock()==Blocks.FLOWING_WATER)
            {
                return true;
            }
        }
        return false;
    }

}
