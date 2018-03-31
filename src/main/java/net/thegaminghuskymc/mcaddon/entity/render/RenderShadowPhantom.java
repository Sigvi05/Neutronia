package net.thegaminghuskymc.mcaddon.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.mcaddon.entity.EntityEnderPhantom;
import net.thegaminghuskymc.mcaddon.entity.EntityShadowPhantom;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelPhantom;
import net.thegaminghuskymc.mcaddon.util.Reference;

public class RenderShadowPhantom extends RenderLiving<EntityShadowPhantom> {

    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/phantom/shadow_phantom.png");

    public RenderShadowPhantom(RenderManager manager) {
        super(manager, new ModelPhantom(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityShadowPhantom entity)
    {
        return  SCORP_TEXTURE;
    }
}
