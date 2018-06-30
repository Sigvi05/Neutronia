package net.hdt.neutronia.client.render.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCustomShield extends ModelBase {

    ModelRenderer e0;
    ModelRenderer e1;
    ModelRenderer e2;
    ModelRenderer e3;
    ModelRenderer e4;
    ModelRenderer e5;
    ModelRenderer e6;
    ModelRenderer e7;
    ModelRenderer e8;

    public ModelCustomShield() {
        this.textureWidth = 16;
        this.textureHeight = 16;

        this.e0 = new ModelRenderer(this, 0, 0);
        this.e0.addBox(5F, 0F, 2F, 6, 1, 13, 1.0F);
        this.e1 = new ModelRenderer(this, 0, 0);
        this.e1.addBox(3F, 0F, 3F, 2, 1, 10, 1.0F);
        this.e2 = new ModelRenderer(this, 0, 0);
        this.e2.addBox(11F, 0F, 3F, 2, 1, 10, 1.0F);
        this.e3 = new ModelRenderer(this, 0, 0);
        this.e3.addBox(2F, 0F, 4F, 1, 1, 6, 1.0F);
        this.e4 = new ModelRenderer(this, 0, 0);
        this.e4.addBox(13F, 0F, 4F, 1, 1, 6, 1.0F);
        this.e5 = new ModelRenderer(this, 0, 0);
        this.e5.addBox(1F, 0F, 5F, 1, 1, 3, 1.0F);
        this.e6 = new ModelRenderer(this, 0, 0);
        this.e6.addBox(14F, 0F, 5F, 1, 1, 3, 1.0F);
        this.e7 = new ModelRenderer(this, 0, 0);
        this.e7.addBox(4F, 0F, 13F, 1, 1, 1, 1.0F);
        this.e8 = new ModelRenderer(this, 0, 0);
        this.e8.addBox(11F, 0F, 13F, 1, 1, 1, 1.0F);
    }

    public void render() {
        this.e0.render(0.0625F);
        this.e1.render(0.0625F);
        this.e2.render(0.0625F);
        this.e3.render(0.0625F);
        this.e4.render(0.0625F);
        this.e5.render(0.0625F);
        this.e6.render(0.0625F);
        this.e7.render(0.0625F);
        this.e8.render(0.0625F);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}