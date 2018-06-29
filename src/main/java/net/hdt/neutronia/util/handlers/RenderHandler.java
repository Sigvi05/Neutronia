package net.hdt.neutronia.util.handlers;

import net.hdt.neutronia.entity.*;
import net.hdt.neutronia.entity.render.*;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, RenderMummy::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMummyVillager.class, RenderMummyVillager::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityScorp.class, RenderScorp::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDrowned.class, RenderDrowned::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityCod.class, RenderCod::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPhantom.class, RenderPhantom::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBloodPhantom.class, RenderRedPhantom::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderPhantom.class, RenderEnderPhantom::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityShadowPhantom.class, RenderShadowPhantom::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntitySeaTurtle.class, RenderSeaTurtle::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityWhale.class, RenderWhale::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityHoveringInferno.class, RenderHoveringInferno::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityAnchored.class, RenderAnchored::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLostMiner.class, RenderLostMiner::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityYetiGolem.class, RenderYetiGolem::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySteampunkGolem.class, RenderSteampunkGolem::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPharaohGolem.class, RenderPharaoGolem::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityForsakenDiver.class, RenderForsakenDiver::new);
    }

}
