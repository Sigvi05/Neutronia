package net.thegaminghuskymc.mcaddon.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.mcaddon.entity.EntityPhantom;
import net.thegaminghuskymc.mcaddon.entity.EntityRedPhantom;
import net.thegaminghuskymc.mcaddon.entity.render.layer.LayerPhantomEyes;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelPhantom;
import net.thegaminghuskymc.mcaddon.util.Reference;

public class RenderRedPhantom extends RenderLiving<EntityRedPhantom> {

    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/phantom/red_phantom.png");

    public RenderRedPhantom(RenderManager manager) {
        super(manager, new ModelPhantom(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityRedPhantom entity)
    {
        return  SCORP_TEXTURE;
    }
}
