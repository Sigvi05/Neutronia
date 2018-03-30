package net.thegaminghuskymc.mcaddon.util.handlers;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.thegaminghuskymc.mcaddon.entity.EntityDrowned;
import net.thegaminghuskymc.mcaddon.entity.EntityMummy;
import net.thegaminghuskymc.mcaddon.entity.EntityMummyVillager;
import net.thegaminghuskymc.mcaddon.entity.EntityScorp;
import net.thegaminghuskymc.mcaddon.entity.render.RenderDrowned;
import net.thegaminghuskymc.mcaddon.entity.render.RenderMummy;
import net.thegaminghuskymc.mcaddon.entity.render.RenderMummyVillager;
import net.thegaminghuskymc.mcaddon.entity.render.RenderScorp;

public class RenderHandler {

    public static void registerEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, RenderMummy::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMummyVillager.class, RenderMummyVillager::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityScorp.class, RenderScorp::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDrowned.class, RenderDrowned::new);
    }

}
