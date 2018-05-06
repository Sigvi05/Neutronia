package net.hdt.neutronia.entity.render;

import com.google.common.collect.Maps;
import net.hdt.neutronia.entity.EntityScorp;
import net.hdt.neutronia.entity.render.model.ModelScorpion;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import java.util.Map;

public class RenderScorp extends RenderLiving<EntityScorp> {

    private static final Map<String, ResourceLocation> LAYERED_LOCATION_CACHE = Maps.newHashMap();

    public RenderScorp(RenderManager manager) {
        super(manager, new ModelScorpion(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityScorp entity) {
        String s = entity.getHorseTexture();
        ResourceLocation resourcelocation = LAYERED_LOCATION_CACHE.get(s);

        if (resourcelocation == null) {
            resourcelocation = new ResourceLocation(s);
            LAYERED_LOCATION_CACHE.put(s, resourcelocation);
        }

        return resourcelocation;
    }

    @Override
    protected void applyRotations(EntityScorp entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
