package net.hdt.neutronia.proxy;

import net.hdt.neutronia.client.rendering.ResourceProxy;
import net.hdt.neutronia.module.ModuleHandler;
import net.hdt.neutronia.util.LibObfuscation;
import net.hdt.neutronia.util.handlers.EntityEventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourcePack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.util.List;

public class ClientProxy extends CommonProxy {

    private static ResourceProxy resourceProxy;

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

}
