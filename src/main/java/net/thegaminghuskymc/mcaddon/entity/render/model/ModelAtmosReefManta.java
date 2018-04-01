// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModelAtmosReefManta.java

package net.thegaminghuskymc.mcaddon.entity.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAtmosReefManta extends ModelBase {

    public ModelAtmosReefManta() {
        textureWidth = 64;
        textureHeight = 32;
        Body1 = new ModelRenderer(this, 0, 16);
        Body1.addBox(-5F, -1.5F, -6F, 10, 3, 12);
        Body1.setRotationPoint(0.0F, 21F, 0.0F);
        Body1.setTextureOffset(64, 32);
        Body1.mirror = true;
        setRotation(Body1, 0.0F, 0.0F, 0.0F);
        Body2 = new ModelRenderer(this, 31, 9);
        Body2.addBox(-3F, -0.5F, 0.0F, 6, 1, 4);
        Body2.setRotationPoint(0.0F, 21.5F, 6F);
        Body2.setTextureOffset(64, 32);
        Body2.mirror = true;
        setRotation(Body2, 0.0F, 0.0F, 0.0F);
        Body3 = new ModelRenderer(this, 31, 0);
        Body3.addBox(-0.5F, -0.5F, 4F, 1, 1, 6);
        Body3.setRotationPoint(0.0F, 21.5F, 6F);
        Body3.setTextureOffset(64, 32);
        Body3.mirror = true;
        setRotation(Body3, 0.0F, 0.0F, 0.0F);
        Wing1 = new ModelRenderer(this, 0, 8);
        Wing1.addBox(0.0F, -1F, -3F, 12, 1, 7);
        Wing1.setRotationPoint(5F, 21F, 0.0F);
        Wing1.setTextureOffset(64, 32);
        Wing1.mirror = true;
        setRotation(Wing1, 0.0F, 0.0F, 0.0F);
        Wing2 = new ModelRenderer(this, 0, 0);
        Wing2.addBox(-12F, -1F, -3F, 12, 1, 7);
        Wing2.setRotationPoint(-5F, 21F, 0.0F);
        Wing2.setTextureOffset(64, 32);
        Wing2.mirror = true;
        setRotation(Wing2, 0.0F, 0.0F, 0.0F);
        Beak1 = new ModelRenderer(this, 0, 21);
        Beak1.addBox(0.0F, 0.0F, -4F, 2, 1, 4);
        Beak1.setRotationPoint(3F, 21F, -6F);
        Beak1.setTextureOffset(64, 32);
        Beak1.mirror = true;
        setRotation(Beak1, 0.0F, -0.3490659F, 0.0F);
        Beak2 = new ModelRenderer(this, 0, 16);
        Beak2.addBox(-2F, 0.0F, -4F, 2, 1, 4);
        Beak2.setRotationPoint(-3F, 21F, -6F);
        Beak2.setTextureOffset(64, 32);
        Beak2.mirror = true;
        setRotation(Beak2, 0.0F, 0.3490659F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Body1.render(f5);
        Body2.render(f5);
        Body3.render(f5);
        Wing1.render(f5);
        Wing2.render(f5);
        Beak1.render(f5);
        Beak2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleX = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
//        Wing1.h = ke.b(f * 0.6662F * 2.0F + 0.0F) * 0.6F * f1;
//        Wing2.h = -ke.b(f * 0.6662F * 2.0F + 0.0F) * 0.6F * f1;
    }

    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Body3;
    ModelRenderer Wing1;
    ModelRenderer Wing2;
    ModelRenderer Beak1;
    ModelRenderer Beak2;
}
