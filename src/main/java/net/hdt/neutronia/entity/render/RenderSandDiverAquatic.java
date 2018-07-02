package net.hdt.neutronia.entity.render;

import net.hdt.neutronia.entity.EntitySandDiverAquatic;
import net.hdt.neutronia.entity.render.layer.LayerSanddiverAquaticGlow;
import net.hdt.neutronia.entity.render.model.ModelSanddiver;
import net.hdt.neutronia.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSandDiverAquatic extends RenderLiving<EntitySandDiverAquatic> {

    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/sanddiver_aquatic.png");

    public RenderSandDiverAquatic(RenderManager manager) {
        super(manager, new ModelSanddiver(), 0.5F);
        this.addLayer(new LayerSanddiverAquaticGlow(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySandDiverAquatic entity) {
        return SCORP_TEXTURE;
    }
}
