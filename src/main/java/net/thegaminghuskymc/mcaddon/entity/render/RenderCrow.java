package net.thegaminghuskymc.mcaddon.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.mcaddon.entity.EntityAtmosCrow;
import net.thegaminghuskymc.mcaddon.entity.EntityCod;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelAtmosCrow;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelCod;
import net.thegaminghuskymc.mcaddon.util.Reference;

public class RenderCrow extends RenderLiving<EntityAtmosCrow> {
    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/crow/crow.png");

    public RenderCrow(RenderManager manager)
    {
        super(manager, new ModelAtmosCrow(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityAtmosCrow entity)
    {
        return  SCORP_TEXTURE;
    }

    @Override
    protected void applyRotations(EntityAtmosCrow entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
