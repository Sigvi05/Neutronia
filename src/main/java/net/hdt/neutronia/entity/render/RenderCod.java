package net.hdt.neutronia.entity.render;

import net.hdt.neutronia.base.util.Reference;
import net.hdt.neutronia.entity.EntityCod;
import net.hdt.neutronia.entity.render.model.ModelCod;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/*
 *TODO:Add Custom Model and Textures
 */
public class RenderCod extends RenderLiving<EntityCod> {
    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/fish/fish.png");

    public RenderCod(RenderManager manager) {
        super(manager, new ModelCod(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCod entity) {
        return SCORP_TEXTURE;
    }

    @Override
    protected void applyRotations(EntityCod entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
