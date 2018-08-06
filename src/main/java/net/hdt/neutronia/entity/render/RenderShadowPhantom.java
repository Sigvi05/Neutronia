package net.hdt.neutronia.entity.render;

import net.hdt.neutronia.base.util.Reference;
import net.hdt.neutronia.entity.EntityShadowPhantom;
import net.hdt.neutronia.entity.render.model.ModelPhantom;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderShadowPhantom extends RenderLiving<EntityShadowPhantom> {

    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/phantom/shadow_phantom.png");

    public RenderShadowPhantom(RenderManager manager) {
        super(manager, new ModelPhantom(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityShadowPhantom entity) {
        return SCORP_TEXTURE;
    }
}
