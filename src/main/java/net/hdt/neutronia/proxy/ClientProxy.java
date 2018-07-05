package net.hdt.neutronia.proxy;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.Gson;
import net.hdt.neutronia.Main;
import net.hdt.neutronia.blocks.base.BlockColoredAlt;
import net.hdt.neutronia.client.events.ClientEventHandler;
import net.hdt.neutronia.client.rendering.ResourceProxy;
import net.hdt.neutronia.colored_lighting.ColoredLights;
import net.hdt.neutronia.module.ModuleHandler;
import net.hdt.neutronia.util.LibObfuscation;
import net.hdt.neutronia.util.Reference;
import net.hdt.neutronia.util.WebUtils;
import net.hdt.neutronia.util.handlers.EntityEventHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.item.Item;
import net.minecraft.util.Timer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientProxy extends CommonProxy {

    private static ResourceProxy resourceProxy;
    public static final Minecraft minecraft = Minecraft.getMinecraft();
    public static final int updateButtonID = "updateButtonID".hashCode();
    public static final Set<String> patrons = new HashSet<>();
    public static final Timer timer = ReflectionHelper.getPrivateValue(Minecraft.class, ClientProxy.minecraft, "timer", "field_71428_T", "aa");

    static {
        List<IResourcePack> packs = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), LibObfuscation.DEFAULT_RESOURCE_PACKS);
        resourceProxy = new ResourceProxy();
        packs.add(resourceProxy);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        ListenableFuture<String> patronFuture = WebUtils.readURLAsync("https://gist.githubusercontent.com/sindrefag/ab5f86cd67e735e6df1d503c162334f1/raw/e6d05aad4da42b81abd51849564d8bb129647d57/patrons.json");
        patronFuture.addListener(() -> {
            try {
                String result = patronFuture.get();
                if (result != null) {
                    Collections.addAll(patrons, new Gson().fromJson(result, String[].class));
                }
            } catch (Exception e) {
                Main.LOGGER.error("Failed to load Patron list", e);
            }
        }, Runnable::run);
        MinecraftForge.EVENT_BUS.register(ClientEventHandler.INSTANCE);
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());

        overrideBlock("stone_granite", true);
        overrideBlock("stone_andesite", false);
        overrideBlock("stone_diorite", true);
        overrideBlock("stone_granite_smooth", true);
        overrideBlock("stone_diorite_smooth", true);

        ModuleHandler.INSTANCE.handlePreInitClient(event);
        ModuleHandler.INSTANCE.handlePostPreInitClient(event);

        ItemColors items = Minecraft.getMinecraft().getItemColors();
        BlockColors blocks = Minecraft.getMinecraft().getBlockColors();

        IBlockColor handlerBlocks = (s, w, p, t) -> t == 0 ? ((BlockColoredAlt) s.getBlock()).color.getColorValue() : 0xFFFFFF;
        /*for(int i = 0; i < EnumDyeColor.values().length; i++) {
            blocks.registerBlockColorHandler(handlerBlocks, NBlocks.coloredCandles[i]);
            blocks.registerBlockColorHandler(handlerBlocks, NBlocks.coloredLitCandles[i]);
            blocks.registerBlockColorHandler(handlerBlocks, NBlocks.coloredLanterns[i]);
            blocks.registerBlockColorHandler(handlerBlocks, NBlocks.coloredLitLanterns[i]);
            blocks.registerBlockColorHandler(handlerBlocks, NBlocks.coloredRedstoneLamp[i]);
            blocks.registerBlockColorHandler(handlerBlocks, NBlocks.coloredLitRedstoneLamp[i]);
            items.registerItemColorHandler((stack, tintIndex) -> blocks.colorMultiplier(((ItemBlock) stack.getItem()).getBlock().getDefaultState(), null, null, tintIndex),
                    NBlocks.coloredCandles[i]);
            items.registerItemColorHandler((stack, tintIndex) -> blocks.colorMultiplier(((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata()), null, null, tintIndex),
                    NBlocks.coloredLitCandles[i]);
            items.registerItemColorHandler((stack, tintIndex) -> blocks.colorMultiplier(((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata()), null, null, tintIndex),
                    NBlocks.coloredLanterns[i]);
            items.registerItemColorHandler((stack, tintIndex) -> blocks.colorMultiplier(((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata()), null, null, tintIndex),
                    NBlocks.coloredLitLanterns[i]);
            items.registerItemColorHandler((stack, tintIndex) -> blocks.colorMultiplier(((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata()), null, null, tintIndex),
                    NBlocks.coloredRedstoneLamp[i]);
            items.registerItemColorHandler((stack, tintIndex) -> blocks.colorMultiplier(((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata()), null, null, tintIndex),
                    NBlocks.coloredLitRedstoneLamp[i]);
        }*/

        MinecraftForge.EVENT_BUS.register(ColoredLights.class);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
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
