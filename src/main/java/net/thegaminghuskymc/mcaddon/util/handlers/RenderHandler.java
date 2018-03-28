package net.thegaminghuskymc.mcaddon.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.thegaminghuskymc.mcaddon.entity.EntityMummy;
import net.thegaminghuskymc.mcaddon.entity.EntityMummyVillager;
import net.thegaminghuskymc.mcaddon.entity.render.RenderMummy;
import net.thegaminghuskymc.mcaddon.entity.render.RenderMummyVillager;

public class RenderHandler {

    public static void registerEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new IRenderFactory<EntityMummy>() {
            @Override
            public Render<? super EntityMummy> createRenderFor(RenderManager manager) {
                return new RenderMummy(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityMummyVillager.class, new IRenderFactory<EntityMummyVillager>() {
            @Override
            public Render<? super EntityMummyVillager> createRenderFor(RenderManager manager) {
                return new RenderMummyVillager(manager);
            }
        });
    }

}
