package net.thegaminghuskymc.mcaddon.entity.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCod extends ModelBase {

    private ModelRenderer body;
    private ModelRenderer head;
    private ModelRenderer leftFin;
    private ModelRenderer rightFin;
    private ModelRenderer tailFin;
    private ModelRenderer waist;

    public ModelCod() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0, 0,0);
        this.body.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 7);
        this.body.setTextureOffset(20, -6);
        this.body.setRotationPoint(0, 0,0);
        this.body.addBox(0.0016f, 3.9992f, -2.0f, 0, 1, 6);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-0.9992f, 1.0008f, -5.0f, 2, 3, 1);
        this.head.setTextureOffset(11, 0);
        this.head.addBox(-1f, 0f, -4f, 2, 4, 3);
        this.head.setRotationPoint(0, 0, 0);
        this.leftFin = new ModelRenderer(this, 24, 4);
        this.leftFin.addBox(1f, 0f, 2f, 2, 1, 2);
        this.rightFin = new ModelRenderer(this, 24, 1);
        this.rightFin.addBox(-3f, 0f, 2f, 2, 1, 2);
        this.tailFin = new ModelRenderer(this, 20, 1);
        this.tailFin.addBox(0f, 0f, 6f, 0, 4, 6);
        this.tailFin.setRotationPoint(0, 0, 0);
        this.waist = new ModelRenderer(this);
        this.waist.setRotationPoint(0, 0, 0);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.body.render(scale);
        this.head.render(scale);
        this.leftFin.render(scale);
        this.rightFin.render(scale);
        this.tailFin.render(scale);
        this.waist.render(scale);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
