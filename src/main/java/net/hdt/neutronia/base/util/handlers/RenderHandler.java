package net.hdt.neutronia.base.util.handlers;

import net.hdt.neutronia.client.render.item.RenderTrident;
import net.hdt.neutronia.entity.*;
import net.hdt.neutronia.entity.projectile.EntityTrident;
import net.hdt.neutronia.entity.render.*;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, RenderMummy::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMummyVillager.class, RenderMummyVillager::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDrowned.class, RenderDrowned::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPhantom.class, RenderPhantom::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBloodPhantom.class, RenderRedPhantom::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderPhantom.class, RenderEnderPhantom::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityShadowPhantom.class, RenderShadowPhantom::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInferno.class, RenderInferno::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityAnchored.class, RenderAnchored::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLostMiner.class, RenderLostMiner::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityYetiGolem.class, RenderYetiGolem::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySteampunkGolem.class, RenderSteampunkGolem::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPharaohGolem.class, RenderPharaoGolem::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityForsakenDiver.class, RenderForsakenDiver::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityScubaVillager.class, RenderScubaVillager::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDrownedScubaVillager.class, RenderDrownedScubaVillager::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySandDiverAquatic.class, RenderSandDiverAquatic::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityAlbadon.class, RenderAlbadon::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityAxolotl.class, RenderAxolotl::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityArcticWolf.class, RenderArcticWolf::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityFox.class, RenderFox::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, RenderBird::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMushroomShroomGlutton.class, RenderMushroomShroomGlutton::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySeaSwallowedCaptain.class, RenderSeaSwallowedCaptain::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityOlDiggy.class, RenderOlDiggy::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityWellWisher.class, RenderWellWisher::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityScorp.class, RenderScorp::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTrident.class, RenderTrident::new);
    }

}
