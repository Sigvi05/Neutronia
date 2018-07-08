package net.hdt.neutronia.proxy;

import net.hdt.neutronia.blocks.base.BlockColoredAlt;
import net.hdt.neutronia.client.rendering.ResourceProxy;
import net.hdt.neutronia.colored_lighting.ColoredLights;
import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.module.ModuleHandler;
import net.hdt.neutronia.util.LibObfuscation;
import net.hdt.neutronia.util.Reference;
import net.hdt.neutronia.util.handlers.EntityEventHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Timer;
import net.minecraftforge.client.model.ModelLoader;
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
        };
        Block[] coloredStuff = new Block[16*toColor.length];
        
        for(int i = 0; i < toColor.length; i++) {
        	Block[] colored = toColor[i];
	        for(int j = 0; j < 16; j++) {
	        	coloredStuff[i*16+j] = colored[j];
	        }
        }
        blocks.registerBlockColorHandler(handlerBlocks, coloredStuff);
        items.registerItemColorHandler(handlerItems, coloredStuff);
        
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

    @Override
    public void registerBlockItemModel(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),0,new ModelResourceLocation(Reference.MOD_ID+":"+block.getRegistryName().getResourcePath(),"inventory"));
    }

    @Override
    public void registerBlockItemModel(Block block, String modelName) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),0,new ModelResourceLocation(Reference.MOD_ID+":"+modelName,"inventory"));
    }
}
