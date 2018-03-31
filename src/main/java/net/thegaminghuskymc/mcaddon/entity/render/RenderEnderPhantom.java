package net.thegaminghuskymc.mcaddon.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.mcaddon.entity.EntityEnderPhantom;
import net.thegaminghuskymc.mcaddon.entity.EntityPhantom;
import net.thegaminghuskymc.mcaddon.entity.render.layer.LayerPhantomEyes;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelPhantom;
import net.thegaminghuskymc.mcaddon.util.Reference;

public class RenderEnderPhantom extends RenderLiving<EntityEnderPhantom> {

    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/phantom/ender_phantom.png");

    public RenderEnderPhantom(RenderManager manager) {
        super(manager, new ModelPhantom(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEnderPhantom entity)
    {
        return  SCORP_TEXTURE;
    }
}
