package net.thegaminghuskymc.mcaddon.world.gen;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.thegaminghuskymc.mcaddon.init.MCAddonBlocks;
import net.thegaminghuskymc.mcaddon.util.Util;
import net.thegaminghuskymc.mcaddon.world.*;

import java.util.Random;

public class WorldGenTest extends WorldGenBase {
    public String structureId;
    public static final String[] compass = new String[]{"....E....", ".........", "....^....", "....|....", "N.<-O->.S", "....|....", "....v....", ".........", "....W...."};

    public WorldGenTest(float chance) {
        super(chance);
        StructureData tower = new StructureData();
        tower.addBlock("R", Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE));
        tower.addBlock("r", Blocks.NETHERRACK.getDefaultState());
        tower.addBlock("B", Blocks.STONE.getDefaultState());
        tower.addBlock("1", Blocks.SOUL_SAND.getDefaultState());
        tower.addBlock("2", MCAddonBlocks.netherBlocks[0].getDefaultState());
        tower.addBlock("3", MCAddonBlocks.netherBlocks[3].getDefaultState());
        tower.addBlock("4", MCAddonBlocks.newStoneVariants[10].getDefaultState());
        tower.addBlock(" ", Blocks.AIR.getDefaultState());
        tower.addLayer(new String[]{"BBBBB", "BBBBB", "BBBBB", "BBBBB", "BBBBB"}, 0);
        tower.addLayer(new String[]{"2   3", "     ", "     ", "     ", "1   4"}, 1);
        tower.addLayer(new String[]{"2   3", "     ", "     ", "     ", "1   4"}, 2);
        tower.addLayer(new String[]{"2   3", "     ", "     ", "rrrrr", "RRRRR"}, 3);
        tower.addLayer(new String[]{"2   3", "     ", "rrrrr", "RRRRR", "     "}, 4);
        tower.addLayer(new String[]{"2   3", "rrrrr", "RRRRR", "     ", "     "}, 5);
        tower.addLayer(new String[]{"2rrr3", "RRRRR", "     ", "     ", "     "}, 6);
        tower.addLayer(new String[]{"RRRRR", "     ", "     ", "     ", "     "}, 7);
        this.structureId = StructureRegistry.addStructure(Util.getLowercaseClassName(this.getClass()) + "_0", tower);
    }

    public void generateStruct(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        GenerationData.get(world).addNode(new GenerationNode(world.getTopSolidOrLiquidBlock(new BlockPos(chunkX * 16, 64, chunkZ * 16)).down(1), structureId, Rotation.values()[random.nextInt(4)], Mirror.NONE, true));
    }
}
