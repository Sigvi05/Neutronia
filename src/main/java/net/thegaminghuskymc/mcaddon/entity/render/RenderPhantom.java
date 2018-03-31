package net.thegaminghuskymc.mcaddon.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.mcaddon.entity.EntityPhantom;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelPhantom;
import net.thegaminghuskymc.mcaddon.util.Reference;

public class RenderPhantom extends RenderLiving<EntityPhantom> {

    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/phantom/phantom.png");

    public RenderPhantom(RenderManager manager) {
        super(manager, new ModelPhantom(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPhantom entity)
    {
        return  SCORP_TEXTURE;
    }
}
