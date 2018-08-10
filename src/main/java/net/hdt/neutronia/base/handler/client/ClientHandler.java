package net.hdt.neutronia.base.handler.client;

import net.hdt.neutronia.blocks.base.BlockColoredAlt;
import net.hdt.neutronia.blocks.overworld.BlockOverworldColoredSlab;
import net.hdt.neutronia.init.NBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientHandler {

    private static Block[][] normalBlocks = new Block[][]{
            NBlocks.coloredCandles,
            NBlocks.coloredLitCandles,
            NBlocks.coloredLanterns,
            NBlocks.coloredLitLanterns,
            NBlocks.coloredRedstoneLamp,
            NBlocks.coloredLitRedstoneLamp,
            NBlocks.coloredPlanks,
            NBlocks.coloredSlimeBlock
    };
    private static Block[][] slabs = new Block[][]{
            NBlocks.coloredPlanksSlabSingle,
            NBlocks.coloredPlanksSlabDouble
    };
    private static IBlockColor slabHandler = (s, w, p, t) -> t == 0 ?
            ((BlockOverworldColoredSlab) s.getBlock()).color.getColorValue() : 0xFFFFFF;
    private static IBlockColor blockHandler = (s, w, p, t) -> t == 0 ?
            ((BlockColoredAlt) s.getBlock()).color.getColorValue() : 0xFFFFFF;
    private static IItemColor itemBlockHandler = (s, t) -> blockHandler.colorMultiplier(((ItemBlock) s.getItem())
            .getBlock().getDefaultState(), null, null, t);
    private static IItemColor itemSlabHander = (s, t) -> slabHandler.colorMultiplier(((ItemBlock) s.getItem())
            .getBlock().getDefaultState(), null, null, t);

    private static Block[] coloredStuff = new Block[16 * normalBlocks.length];
    private static Block[] coloredSlabs = new Block[16 * slabs.length];

    static {
        for (int i = 0; i < normalBlocks.length; i++) {
            Block[] colored = normalBlocks[i];
            System.arraycopy(colored, 0, coloredStuff, i * 16, 16);
        }
        for (int i = 0; i < slabs.length; i++) {
            Block[] colored = slabs[i];
            System.arraycopy(colored, 0, coloredSlabs, i * 16, 16);
        }
    }

    @SubscribeEvent
    public static void onColorBlocks(ColorHandlerEvent.Block event) {
        event.getBlockColors().registerBlockColorHandler(blockHandler, coloredStuff);
        event.getBlockColors().registerBlockColorHandler(slabHandler, coloredSlabs);
    }

    @SubscribeEvent
    public static void onItemColored(ColorHandlerEvent.Item event) {
        event.getItemColors().registerItemColorHandler(itemBlockHandler, coloredStuff);
        event.getItemColors().registerItemColorHandler(itemSlabHander, coloredSlabs);
    }

}