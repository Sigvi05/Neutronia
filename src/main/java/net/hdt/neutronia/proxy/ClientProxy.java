package net.hdt.neutronia.proxy;

import net.hdt.neutronia.client.rendering.ResourceProxy;
import net.hdt.neutronia.module.ModuleHandler;
import net.hdt.neutronia.util.LibObfuscation;
import net.hdt.neutronia.util.handlers.EntityEventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientProxy extends CommonProxy {

    public static final Map<Item, ModelBiped> armorModels = new HashMap<>();

    static ResourceProxy resourceProxy;

    static {
        List<IResourcePack> packs = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), LibObfuscation.DEFAULT_RESOURCE_PACKS);
        resourceProxy = new ResourceProxy();
        packs.add(resourceProxy);
    }

    public static void registerArmorRenders() {

        /*ModelCustomArmor custom_armor = new ModelCustomArmor(1F);
        ModelCustomArmor custom_legs = new ModelCustomArmor(0.5F);

        armorModels.put(NItems.healmet, custom_armor);
        armorModels.put(NItems.chestplate, custom_armor);
        armorModels.put(NItems.leggings, custom_legs);
        armorModels.put(NItems.boots, custom_armor);*/

    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());

        overrideBlock("stone_granite", true);
        overrideBlock("stone_andesite", true);
        overrideBlock("stone_diorite", true);
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

    private void overrideBlockModel(String str, boolean flag) {
        if (flag)
            addResourceOverride("models", "block", str, "json");
    }

    private void overrideItemModel(String str, boolean flag) {
        if (flag)
            addResourceOverride("models", "item", str, "json");
    }

}
