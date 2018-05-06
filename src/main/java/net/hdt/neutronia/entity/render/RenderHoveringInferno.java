package net.hdt.neutronia.entity.render;

import net.hdt.neutronia.entity.EntityHoveringInferno;
import net.hdt.neutronia.entity.render.model.ModelHoveringInferno;
import net.hdt.neutronia.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHoveringInferno extends RenderLiving<EntityHoveringInferno> {
    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/nether/hovering_inferno/hovering_inferno.png");

    public RenderHoveringInferno(RenderManager manager) {
        super(manager, new ModelHoveringInferno(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityHoveringInferno entity) {
        return SCORP_TEXTURE;
    }

    @Override
    protected void applyRotations(EntityHoveringInferno entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
