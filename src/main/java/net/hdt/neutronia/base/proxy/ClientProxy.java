package net.hdt.neutronia.base.proxy;

import net.hdt.neutronia.base.client.DevCapeHandler;
import net.hdt.neutronia.base.client.ResourceProxy;
import net.hdt.neutronia.base.client.gui.ConfigEvents;
import net.hdt.neutronia.base.module.ModuleLoader;
import net.hdt.neutronia.base.util.LibObfuscation;
import net.hdt.neutronia.base.util.handlers.EntityEventHandler;
import net.hdt.neutronia.blocks.base.BlockColoredAlt;
import net.hdt.neutronia.blocks.overworld.BlockOverworldColoredSlab;
import net.hdt.neutronia.init.NBlocks;
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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.awt.*;
import java.util.List;

import static net.hdt.neutronia.base.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
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

        ModuleLoader.preInitClient(event);
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
            NBlocks.coloredPlanks
        };
        Block[] coloredStuff = new Block[16 * toColor.length];
        
        for(int i = 0; i < toColor.length; i++) {
        	Block[] colored = toColor[i];
            System.arraycopy(colored, 0, coloredStuff, i * 16, 16);
        }
        blocks.registerBlockColorHandler(handlerBlocks, coloredStuff);
        items.registerItemColorHandler(handlerItems, coloredStuff);

        IBlockColor handlerBlocksTranslucent = (s, w, p, t) -> t == 0 ? ((BlockColoredAlt) s.getBlock()).color.getColorValue() : new Color(255, 255, 255, 128).getRGB();
        IItemColor handlerItemsTranslucent = (s, t) -> blocks.colorMultiplier(((ItemBlock) s.getItem()).getBlock().getDefaultState(), null, null, t);
        Block[][] toColorTranslucent = new Block[][] {
                NBlocks.coloredSlimeBlock
        };
        Block[] coloredStuffTranslucent = new Block[16 * toColorTranslucent.length];

        for(int i = 0; i < toColorTranslucent.length; i++) {
            Block[] colored = toColorTranslucent[i];
            System.arraycopy(colored, 0, coloredStuffTranslucent, i * 16, 16);
        }
        blocks.registerBlockColorHandler(handlerBlocksTranslucent, coloredStuffTranslucent);
        items.registerItemColorHandler(handlerItemsTranslucent, coloredStuffTranslucent);

        IBlockColor handlerSlabBlocks = (s, w, p, t) -> t == 0 ? ((BlockOverworldColoredSlab) s.getBlock()).color.getColorValue() : 0xFFFFFF;
        IItemColor handlerSlabItems = (s, t) -> blocks.colorMultiplier(((ItemBlock) s.getItem()).getBlock().getDefaultState(), null, null, t);
        Block[][] toColorSlabs = new Block[][] {
                NBlocks.coloredPlanksSlabSingle,
                NBlocks.coloredPlanksSlabDouble
        };
        Block[] coloredSlabs = new Block[16 * toColorSlabs.length];

        for(int i = 0; i < toColorSlabs.length; i++) {
            Block[] colored = toColorSlabs[i];
            System.arraycopy(colored, 0, coloredSlabs, i * 16, 16);
        }
        blocks.registerBlockColorHandler(handlerSlabBlocks, coloredSlabs);
        items.registerItemColorHandler(handlerSlabItems, coloredSlabs);

        ModuleLoader.initClient(event);

        MinecraftForge.EVENT_BUS.register(DevCapeHandler.class);
        MinecraftForge.EVENT_BUS.register(ConfigEvents.class);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        ModuleLoader.postInitClient(event);
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
