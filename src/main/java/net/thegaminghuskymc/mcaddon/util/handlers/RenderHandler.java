package net.thegaminghuskymc.mcaddon.util.handlers;

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
        RenderingRegistry.registerEntityRenderingHandler(EntityPhantom.class, RenderPhantom::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRedPhantom.class, RenderRedPhantom::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderPhantom.class, RenderEnderPhantom::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityShadowPhantom.class, RenderShadowPhantom::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityAtmosCrow.class, RenderCrow::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityAtmosAngler.class, RenderAtmosAngler::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityAtmosReefManta.class, RenderAtmosReefManta::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySeaTurtle.class, RenderSeaTurtle::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityWhale.class, RenderWhale::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityHoveringInferno.class, RenderHoveringInferno::new);
    }

}
