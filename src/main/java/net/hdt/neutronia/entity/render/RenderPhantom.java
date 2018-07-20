package net.hdt.neutronia.entity.render;

import net.hdt.neutronia.entity.EntityPhantom;
import net.hdt.neutronia.entity.render.model.ModelPhantom;
import net.hdt.neutronia.base.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPhantom extends RenderLiving<EntityPhantom> {

    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/phantom/phantom.png");

    public RenderPhantom(RenderManager manager) {
        super(manager, new ModelPhantom(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPhantom entity) {
        return SCORP_TEXTURE;
    }
}
