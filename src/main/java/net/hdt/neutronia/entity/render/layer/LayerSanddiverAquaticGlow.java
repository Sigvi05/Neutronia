package net.hdt.neutronia.entity.render.layer;

import net.hdt.neutronia.entity.EntitySandDiverAquatic;
import net.hdt.neutronia.entity.render.model.ModelSanddiver;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerSanddiverAquaticGlow implements LayerRenderer<EntitySandDiverAquatic> {

    private static final ResourceLocation STRAY_CLOTHES_TEXTURES = new ResourceLocation("neutronia:textures/entity/sanddiver_aquatic_glow.png");
    private final RenderLivingBase<?> renderer;
    private final ModelSanddiver layerModel = new ModelSanddiver();

    public LayerSanddiverAquaticGlow(RenderLivingBase<?> p_i47183_1_) {
        this.renderer = p_i47183_1_;
    }

    public void doRenderLayer(EntitySandDiverAquatic entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.layerModel.setModelAttributes(this.renderer.getMainModel());
        this.layerModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.renderer.bindTexture(STRAY_CLOTHES_TEXTURES);
        this.layerModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    public boolean shouldCombineTextures() {
        return false;
    }

}