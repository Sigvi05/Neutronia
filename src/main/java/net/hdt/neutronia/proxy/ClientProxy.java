package net.hdt.neutronia.proxy;

import net.hdt.neutronia.blocks.base.BlockColoredAlt;
import net.hdt.neutronia.blocks.overworld.BlockOverworldColoredSlab;
import net.hdt.neutronia.client.rendering.ResourceProxy;
import net.hdt.neutronia.colored_lighting.ColoredLights;
import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.module.ModuleHandler;
import net.hdt.neutronia.util.LibObfuscation;
import net.hdt.neutronia.util.handlers.EntityEventHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Timer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.util.List;

public class ClientProxy extends CommonProxy {

    private static ResourceProxy resourceProxy;
    public static final Minecraft minecraft = Minecraft.getMinecraft();
    public static final Timer timer = ReflectionHelper.getPrivateValue(Minecraft.class, ClientProxy.minecraft, "timer", "field_71428_T", "aa");

    static {
        List<IResourcePack> packs = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), LibObfuscation.DEFAULT_RESOURCE_PACKS);
        resourceProxy = new ResourceProxy();
        packs.add(resourceProxy);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());

        overrideBlock("stone_granite", true);
        overrideBlock("stone_andesite", false);
        overrideBlock("stone_diorite", true);
        overrideBlock("stone_granite_smooth", true);
        overrideBlock("stone_diorite_smooth", true);

        ModuleHandler.INSTANCE.handlePreInitClient(event);
        ModuleHandler.INSTANCE.handlePostPreInitClient(event);

        MinecraftForge.EVENT_BUS.register(ColoredLights.class);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        
        ItemColors items = Minecraft.getMinecraft().getItemColors();
        BlockColors blocks = Minecraft.getMinecraft().getBlockColors();

        IBlockColor handlerBlocks = (s, w, p, t) -> t == 0 ? ((BlockColoredAlt) s.getBlock()).color.getColorValue() : 0xFFFFFF;
        IItemColor handlerItems = (s, t) -> blocks.colorMultiplier(((ItemBlock) s.getItem()).getBlock().getDefaultState(), null, null, t);
        Block[][] toColor = new Block[][] {
        	NBlocks.coloredCandles,
        	NBlocks.coloredLitCandles,
        	NBlocks.coloredLanterns,
        	NBlocks.coloredLitLanterns,
        	NBlocks.coloredRedstoneLamp,
        	NBlocks.coloredLitRedstoneLamp,
            NBlocks.coloredPlanks,
        };
        Block[] coloredStuff = new Block[16 * toColor.length];
        
        for(int i = 0; i < toColor.length; i++) {
        	Block[] colored = toColor[i];
            System.arraycopy(colored, 0, coloredStuff, i * 16, 16);
        }
        blocks.registerBlockColorHandler(handlerBlocks, coloredStuff);
        items.registerItemColorHandler(handlerItems, coloredStuff);

        IBlockColor handlerSlabBlocks = (s, w, p, t) -> t == 0 ? ((BlockOverworldColoredSlab) s.getBlock()).color.getColorValue() : 0xFFFFFF;
        IItemColor handlerSlabItems = (s, t) -> blocks.colorMultiplier(((ItemBlock) s.getItem()).getBlock().getDefaultState(), null, null, t);
        Block[][] toColorSlabs = new Block[][] {
                NBlocks.coloredPlanksSlabSingle,
                NBlocks.coloredPlanksSlabDouble,
        };
        Block[] coloredSlabs = new Block[16 * toColorSlabs.length];

        for(int i = 0; i < toColorSlabs.length; i++) {
            Block[] colored = toColorSlabs[i];
            System.arraycopy(colored, 0, coloredSlabs, i * 16, 16);
        }
        blocks.registerBlockColorHandler(handlerSlabBlocks, coloredSlabs);
        items.registerItemColorHandler(handlerSlabItems, coloredSlabs);

        /*IBlockColor handlerStairBlocks = (s, w, p, t) -> t == 0 ? ((BlockOverworldColoredStair) s.getBlock()).color.getColorValue() : 0xFFFFFF;
        IItemColor handlerStairItems = (s, t) -> blocks.colorMultiplier(((ItemBlock) s.getItem()).getBlock().getDefaultState(), null, null, t);
        Block[][] toColorStair = new Block[][] {
                NBlocks.coloredPlanksStair,
        };
        Block[] coloredStairs = new Block[16 * toColorStair.length];

        for(int i = 0; i < toColorStair.length; i++) {
            Block[] colored = toColorStair[i];
            System.arraycopy(colored, 0, coloredStairs, i * 16, 16);
        }
        blocks.registerBlockColorHandler(handlerStairBlocks, coloredStairs);
        items.registerItemColorHandler(handlerStairItems, coloredStairs);*/
        
        ModuleHandler.INSTANCE.handleInitClient(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        ModuleHandler.INSTANCE.handlePostInitClient(event);
    }

    @Override
    public void addResourceOverride(String space, String dir, String file, String ext) {
        resourceProxy.addResource(space, dir, file, ext);
    }

    private void overrideBlock(String str, boolean flag) {
        if (flag)
            addResourceOverride("textures", "blocks", str, "png");
    }

    @Override
    public float getPartialTicks() {
        return ClientProxy.timer.renderPartialTicks;
    }

}
