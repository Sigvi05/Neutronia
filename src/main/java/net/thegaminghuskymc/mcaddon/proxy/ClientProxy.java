package net.thegaminghuskymc.mcaddon.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.mcaddon.init.MCAddonItems;
import net.thegaminghuskymc.mcaddon.items.models.ModelCustomArmor;
import net.thegaminghuskymc.mcaddon.util.handlers.EntityEventHandler;

import java.util.HashMap;
import java.util.Map;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    public static final Map<Item, ModelBiped> armorModels = new HashMap<>();

    public static void registerArmorRenders(){

        ModelCustomArmor custom_armor = new ModelCustomArmor(1F);
        ModelCustomArmor custom_legs = new ModelCustomArmor(0.5F);

        armorModels.put(MCAddonItems.healmet, custom_armor);
        armorModels.put(MCAddonItems.chestplate, custom_armor);
        armorModels.put(MCAddonItems.leggings, custom_legs);
        armorModels.put(MCAddonItems.boots, custom_armor);

    }

}
