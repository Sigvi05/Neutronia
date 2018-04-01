package net.thegaminghuskymc.mcaddon.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.mcaddon.entity.EntityAtmosReefManta;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelAtmosReefManta;
import net.thegaminghuskymc.mcaddon.util.Reference;

import javax.annotation.Nullable;

public class RenderAtmosReefManta extends RenderLiving<EntityAtmosReefManta> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/ocean_creatures/reefmanta.png");

    public RenderAtmosReefManta(RenderManager manager) {
        super(manager, new ModelAtmosReefManta(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAtmosReefManta entity) {
        return TEXTURE;
    }

}
