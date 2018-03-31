package net.thegaminghuskymc.mcaddon.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelScorpion;
import net.thegaminghuskymc.mcaddon.util.Reference;
import net.thegaminghuskymc.mcaddon.entity.EntityScorp;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelScorp;

public class RenderScorp extends RenderLiving<EntityScorp>
{
    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/scorpion.png");

    public  RenderScorp(RenderManager manager)
    {
        super(manager, new ModelScorpion(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityScorp entity)
    {
        return  SCORP_TEXTURE;
    }

    @Override
    protected void applyRotations(EntityScorp entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
