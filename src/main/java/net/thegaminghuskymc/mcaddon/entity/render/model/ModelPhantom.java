package net.thegaminghuskymc.mcaddon.entity.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelPhantom extends ModelBase  {

    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leftWing;
    ModelRenderer rightWing;
    ModelRenderer bodyLeft;
    ModelRenderer bodyMiddle;
    ModelRenderer tailStart;
    ModelRenderer tailEnd;

    public ModelPhantom() {
        textureWidth = 128;
        textureHeight = 32;
        head = new ModelRenderer(this, 0, 0);
        head.addBox(0F, 0F, 0F, 7, 3, 5);
        head.setRotationPoint(0F, 0F, 1.266667F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 56, 8);
        body.addBox(0F, 0F, 0F, 6, 2, 9);
        body.setRotationPoint(-5F, -1F, 6.266667F);
        body.setTextureSize(128, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        leftWing = new ModelRenderer(this, 0, 20);
        leftWing.addBox(0F, 0F, 0F, 13, 1, 9);
        leftWing.setRotationPoint(12F, -1F, 6.266667F);
        leftWing.setTextureSize(128, 32);
        leftWing.mirror = true;
        setRotation(leftWing, 0F, 0F, 0F);
        rightWing = new ModelRenderer(this, 44, 20);
        rightWing.addBox(0F, 0F, 0F, 13, 1, 9);
        rightWing.setRotationPoint(-18F, -1F, 6.266667F);
        rightWing.setTextureSize(128, 32);
        rightWing.mirror = true;
        setRotation(rightWing, 0F, 0F, 0F);
        bodyLeft = new ModelRenderer(this, 0, 8);
        bodyLeft.addBox(0F, 0F, 0F, 6, 2, 9);
        bodyLeft.setRotationPoint(6F, -1F, 6.266667F);
        bodyLeft.setTextureSize(128, 32);
        bodyLeft.mirror = true;
        setRotation(bodyLeft, 0F, 0F, 0F);
        bodyMiddle = new ModelRenderer(this, 28, 8);
        bodyMiddle.addBox(0F, 0F, 0F, 5, 3, 9);
        bodyMiddle.setRotationPoint(1F, -1F, 6.266667F);
        bodyMiddle.setTextureSize(128, 32);
        bodyMiddle.mirror = true;
        setRotation(bodyMiddle, 0F, 0F, 0F);
        tailStart = new ModelRenderer(this, 26, 0);
        tailStart.addBox(0F, 0F, 0F, 3, 2, 6);
        tailStart.setRotationPoint(2F, -0.3333333F, 15.26667F);
        tailStart.setTextureSize(128, 32);
        tailStart.mirror = true;
        setRotation(tailStart, 0F, 0F, 0F);
        tailEnd = new ModelRenderer(this, 46, 0);
        tailEnd.addBox(0F, 0F, 0F, 1, 1, 6);
        tailEnd.setRotationPoint(3F, 0.1333333F, 20F);
        tailEnd.setTextureSize(128, 32);
        tailEnd.mirror = true;
        setRotation(tailEnd, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body.render(f5);
        leftWing.render(f5);
        rightWing.render(f5);
        bodyLeft.render(f5);
        bodyMiddle.render(f5);
        tailStart.render(f5);
        tailEnd.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}