package net.hdt.neutronia.entity.render.model;

import net.hdt.neutronia.entity.EntityMummy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Mummy - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelMummy extends ModelBiped {

    public ModelRenderer Body1;
    public ModelRenderer Body2;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;
    public ModelRenderer RightLeg;
    public ModelRenderer LeftLeg;
    public ModelRenderer Cloth1;
    public ModelRenderer Hat;
    public ModelRenderer Head;
    public ModelRenderer Cloth4;
    public ModelRenderer Cloth2;
    public ModelRenderer Cloth3;

    public ModelMummy() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LeftLeg = new ModelRenderer(this, 0, 16);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(1.75F, 12.0F, 0.0F);
        this.LeftLeg.addBox(-1.5F, 0.0F, 0.0F, 3, 12, 4, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.Cloth3 = new ModelRenderer(this, 50, 31);
        this.Cloth3.setRotationPoint(0.5F, 4.0F, 1.5F);
        this.Cloth3.addBox(-1.0F, -6.0F, 0.0F, 2, 12, 3, 0.0F);
        this.Body1 = new ModelRenderer(this, 14, 16);
        this.Body1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body1.addBox(-4.0F, 0.0F, -2.0F, 8, 6, 4, 0.0F);
        this.RightArm = new ModelRenderer(this, 38, 16);
        this.RightArm.setRotationPoint(-4.5F, 2.5F, 0.0F);
        this.RightArm.addBox(-2.0F, -2.0F, -1.5F, 3, 12, 3, 0.0F);
        this.setRotateAngle(RightArm, -1.3089969389957472F, 0.08726646259971647F, 0.0F);
        this.Cloth4 = new ModelRenderer(this, 14, 36);
        this.Cloth4.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Cloth4.addBox(-4.0F, 0.0F, -2.0F, 8, 2, 4, 0.0F);
        this.LeftArm = new ModelRenderer(this, 38, 16);
        this.LeftArm.mirror = true;
        this.LeftArm.setRotationPoint(4.5F, 2.5F, 0.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -1.5F, 3, 12, 3, 0.0F);
        this.setRotateAngle(LeftArm, -1.3089969389957472F, -0.08726646259971647F, 0.0F);
        this.Body2 = new ModelRenderer(this, 16, 26);
        this.Body2.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Body2.addBox(-3.0F, 0.0F, -2.0F, 6, 6, 4, 0.0F);
        this.RightLeg = new ModelRenderer(this, 0, 16);
        this.RightLeg.setRotationPoint(-1.75F, 12.0F, 0.0F);
        this.RightLeg.addBox(-1.5F, 0.0F, 0.0F, 3, 12, 4, 0.0F);
        this.Hat = new ModelRenderer(this, 32, 0);
        this.Hat.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.25F);
        this.Cloth1 = new ModelRenderer(this, 24, 0);
        this.Cloth1.setRotationPoint(0.0F, -6.0F, 4.25F);
        this.Cloth1.addBox(-4.0F, -2.0F, 0.0F, 8, 8, 0, 0.0F);
        this.setRotateAngle(Cloth1, 0.17453292519943295F, 0.0F, 0.0F);
        this.Cloth2 = new ModelRenderer(this, 50, 16);
        this.Cloth2.setRotationPoint(-0.5F, 4.0F, 1.5F);
        this.Cloth2.addBox(-1.0F, -6.0F, 0.0F, 2, 12, 3, 0.0F);
        this.LeftArm.addChild(this.Cloth3);
        this.Body1.addChild(this.Cloth4);
        this.RightArm.addChild(this.Cloth2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.LeftLeg.render(f5);
        this.Head.render(f5);
        this.Body1.render(f5);
        this.RightArm.render(f5);
        this.LeftArm.render(f5);
        this.Body2.render(f5);
        this.RightLeg.render(f5);
        this.Hat.render(f5);
        this.Cloth1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        bipedBody = Body1;
        bipedBody = Body2;
        bipedHead = Head;
        bipedLeftArm = LeftArm;
        bipedLeftLeg = LeftLeg;
        bipedRightArm = RightArm;
        bipedRightLeg = RightLeg;
        boolean flag = entityIn instanceof EntityMummy && ((EntityMummy)entityIn).isArmsRaised();
        float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
        float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
        this.RightArm.rotateAngleZ = 0.0F;
        this.LeftArm.rotateAngleZ = 0.0F;
        this.RightArm.rotateAngleY = -(0.1F - f * 0.6F);
        this.LeftArm.rotateAngleY = 0.1F - f * 0.6F;
        float f2 = -(float)Math.PI / (flag ? 1.5F : 2.25F);
        this.RightArm.rotateAngleX = f2;
        this.LeftArm.rotateAngleX = f2;
        this.RightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
        this.LeftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
        this.RightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.LeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.RightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.LeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

        this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
        this.bipedRightLeg.rotateAngleY = 0.0F;
        this.bipedLeftLeg.rotateAngleY = 0.0F;
        this.bipedRightLeg.rotateAngleZ = 0.0F;
        this.bipedLeftLeg.rotateAngleZ = 0.0F;

        this.bipedRightLeg.rotationPointZ = 0.1F;
        this.bipedLeftLeg.rotationPointZ = 0.1F;
        this.bipedRightLeg.rotationPointY = 12.0F;
        this.bipedLeftLeg.rotationPointY = 12.0F;
    }

}
