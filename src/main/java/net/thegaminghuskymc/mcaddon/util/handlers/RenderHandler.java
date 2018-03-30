package net.thegaminghuskymc.mcaddon.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.thegaminghuskymc.mcaddon.entity.*;
import net.thegaminghuskymc.mcaddon.entity.render.*;

public class RenderHandler {

    public static void registerEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, RenderMummy::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMummyVillager.class, RenderMummyVillager::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityScorp.class, RenderScorp::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDrowned.class, RenderDrowned::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCod.class, RenderCod::new);
    }

}
