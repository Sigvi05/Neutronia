package net.thegaminghuskymc.mcaddon.blocks.overworld;


import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.thegaminghuskymc.mcaddon.tileentity.BaseTileEntity;
import net.thegaminghuskymc.mcaddon.tileentity.BlockTileEntity;

import javax.annotation.Nullable;

public class BlockAnimatedTest extends BlockTileEntity<BaseTileEntity> {

    public BlockAnimatedTest() {
        super("block_animated", Material.ROCK);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new BaseTileEntity();
    }

}
