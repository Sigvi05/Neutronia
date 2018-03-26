package net.thegaminghuskymc.mcaddon.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.huskylib2.lib.blocks.BlockFacing;
import net.thegaminghuskymc.mcaddon.Reference;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class BlockWaterlogged extends BlockFacing {

    public static final PropertyBool WATER_LOGGED = PropertyBool.create("waterlogged");

    public BlockWaterlogged(String name) {
        super(Material.WATER, Reference.MOD_ID, name);
        setDefaultState(getDefaultState().withProperty(WATER_LOGGED, true));
    }

    public int getMetaFromState(IBlockState state) {
        return state.getValue(LEVEL);
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, WATER_LOGGED);
    }

}
