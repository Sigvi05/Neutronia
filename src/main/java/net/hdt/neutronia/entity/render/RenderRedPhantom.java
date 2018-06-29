package net.hdt.neutronia.entity.render;

import net.hdt.neutronia.entity.EntityBloodPhantom;
import net.hdt.neutronia.entity.render.model.ModelPhantom;
import net.hdt.neutronia.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRedPhantom extends RenderLiving<EntityBloodPhantom> {

    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/phantom/red_phantom.png");

    public RenderRedPhantom(RenderManager manager) {
        super(manager, new ModelPhantom(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBloodPhantom entity) {
        return SCORP_TEXTURE;
    }
}
