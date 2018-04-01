// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModelAtmosAngler.java

package net.thegaminghuskymc.mcaddon.entity.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAtmosAngler extends ModelBase {

    public ModelAtmosAngler()
    {
        textureWidth = 64;
        textureHeight = 32;
        Body1 = new ModelRenderer(this, 0, 18);
        Body1.addBox(-2F, -4F, -5F, 4, 4, 10);
        Body1.setRotationPoint(0.0F, 20F, 0.0F);
        Body1.setTextureOffset(64, 32);
        Body1.mirror = true;
        setRotation(Body1, 0.0F, 0.0F, 0.0F);
        Body2 = new ModelRenderer(this, 28, 19);
        Body2.addBox(-2F, 2.0F, 3F, 4, 2, 2);
        Body2.setRotationPoint(0.0F, 18F, 0.0F);
        Body2.setTextureOffset(64, 32);
        Body2.mirror = true;
        setRotation(Body2, 0.0F, 0.0F, 0.0F);
        Beak1 = new ModelRenderer(this, 0, 8);
        Beak1.addBox(-3F, 0.0F, -7F, 6, 2, 8);
        Beak1.setRotationPoint(0.0F, 20F, 2.0F);
        Beak1.setTextureOffset(64, 32);
        Beak1.mirror = true;
        setRotation(Beak1, 0.2443461F, 0.0F, 0.0F);
        Teeth1 = new ModelRenderer(this, 28, 20);
        Teeth1.addBox(-3F, -2F, -7F, 6, 2, 8);
        Teeth1.setRotationPoint(0.0F, 20F, 2.0F);
        Teeth1.setTextureOffset(64, 32);
        Teeth1.mirror = true;
        setRotation(Teeth1, 0.2443461F, 0.0F, 0.0F);
        Teeth2 = new ModelRenderer(this, 28, 24);
        Teeth2.addBox(-2F, 0.0F, -5F, 4, 1, 7);
        Teeth2.setRotationPoint(0.0F, 20F, 0.0F);
        Teeth2.setTextureOffset(64, 32);
        Teeth2.mirror = true;
        setRotation(Teeth2, 0.0F, 0.0F, 0.0F);
        Fin1 = new ModelRenderer(this, 0, 0);
        Fin1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
        Fin1.setRotationPoint(1.0F, 22F, 4F);
        Fin1.setTextureOffset(64, 32);
        Fin1.mirror = true;
        setRotation(Fin1, 0.2792527F, 0.0F, -1.047198F);
        Fin2 = new ModelRenderer(this, 4, 0);
        Fin2.addBox(-1F, 0.0F, 0.0F, 1, 4, 1);
        Fin2.setRotationPoint(-1F, 22F, 4F);
        Fin2.setTextureOffset(64, 32);
        Fin2.mirror = true;
        setRotation(Fin2, 0.2792527F, 0.0F, 1.047198F);
        Fin3 = new ModelRenderer(this, 19, 0);
        Fin3.addBox(-0.5F, -1F, 1.0F, 1, 2, 4);
        Fin3.setRotationPoint(0.0F, 19F, 4F);
        Fin3.setTextureOffset(64, 32);
        Fin3.mirror = true;
        setRotation(Fin3, 0.7853982F, 0.0F, 0.0F);
        Fin4 = new ModelRenderer(this, 29, 0);
        Fin4.addBox(-0.5F, -1F, 1.0F, 1, 2, 4);
        Fin4.setRotationPoint(0.0F, 19F, 4F);
        Fin4.setTextureOffset(64, 32);
        Fin4.mirror = true;
        setRotation(Fin4, -0.7853982F, 0.0F, 0.0F);
        Light1 = new ModelRenderer(this, 8, 0);
        Light1.addBox(-0.5F, -4F, -1F, 1, 4, 1);
        Light1.setRotationPoint(0.0F, 16F, -4F);
        Light1.setTextureOffset(64, 32);
        Light1.mirror = true;
        setRotation(Light1, 0.0F, 0.0F, 0.0F);
        Light2 = new ModelRenderer(this, 9, 2);
        Light2.addBox(-0.5F, -4F, -4F, 1, 1, 3);
        Light2.setRotationPoint(0.0F, 16F, -4F);
        Light2.setTextureOffset(64, 32);
        Light2.mirror = true;
        setRotation(Light2, 0.0F, 0.0F, 0.0F);
        Bulb = new ModelRenderer(this, 42, 16);
        Bulb.addBox(-0.5F, -4F, -5F, 1, 1, 1);
        Bulb.setRotationPoint(0.0F, 16F, -4F);
        Bulb.setTextureOffset(64, 32);
        Bulb.mirror = true;
        setRotation(Bulb, 0.0F, 0.0F, 0.0F);
    }

    public void a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Body1.render(f5);
        Body2.render(f5);
        Beak1.render(f5);
        Teeth1.render(f5);
        Teeth2.render(f5);
        Fin1.render(f5);
        Fin2.render(f5);
        Fin3.render(f5);
        Fin4.render(f5);
        Light1.render(f5);
        Light2.render(f5);
        Bulb.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
//        Fin3.rotateAngleX = -ke.setTextureOffset(f3 * 0.6662F * 2.0F + 0.0F) * 0.6F * f1;
//        Fin4.rotateAngleZ = -ke.setTextureOffset(f3 * 0.6662F * 2.0F + 0.0F) * 0.6F * f1;
    }

    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Beak1;
    ModelRenderer Teeth1;
    ModelRenderer Teeth2;
    ModelRenderer Fin1;
    ModelRenderer Fin2;
    ModelRenderer Fin3;
    ModelRenderer Fin4;
    ModelRenderer Light1;
    ModelRenderer Light2;
    ModelRenderer Bulb;
}
