package net.thegaminghuskymc.mcaddon;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class HuskysMinecraftAddon
{
    public HuskysMinecraftAddon instance;

    public HuskysMinecraftAddon instance() {
        return instance;
    }

    @SubscribeEvent
    public static void preInit(FMLPreInitializationEvent event) {}

    @SubscribeEvent
    public static void init(FMLInitializationEvent event) {}

    @SubscribeEvent
    public static void postInit(FMLPostInitializationEvent event) {}
}
