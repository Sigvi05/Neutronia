package net.thegaminghuskymc.mcaddon.proxy;

import com.leviathanstudio.craftstudio.client.registry.CSRegistryHelper;
import com.leviathanstudio.craftstudio.client.registry.CraftStudioLoader;
import com.leviathanstudio.craftstudio.client.util.EnumRenderType;
import com.leviathanstudio.craftstudio.client.util.EnumResourceType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.thegaminghuskymc.mcaddon.util.handlers.EntityEventHandler;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class ClientProxy extends CommonProxy {

    CSRegistryHelper registry = new CSRegistryHelper(MOD_ID);

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

    @Override
    public void registerCraftStudioAnimations() {
        super.registerCraftStudioAnimations();
    }

    @Override
    public void registerCraftStudioModels() {
        super.registerCraftStudioModels();
    }

    @CraftStudioLoader
    public static void registerCraftStudioAssets()
    {
        CSRegistryHelper csRegistry = new CSRegistryHelper(MOD_ID);

        csRegistry.register(EnumResourceType.MODEL, EnumRenderType.BLOCK, "block_animated");
        csRegistry.register(EnumResourceType.ANIM, EnumRenderType.BLOCK, "block_animated_anim");
    }

}
