// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModelAtmosCrow.java

package net.thegaminghuskymc.mcaddon.entity.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.thegaminghuskymc.mcaddon.entity.EntityAtmosCrow;
import org.lwjgl.opengl.GL11;

// Referenced classes of package atmosmobs.birds:
//            EntityAtmosCrow

public class ModelAtmosCrow extends ModelBase
{

    public ModelAtmosCrow()
    {
        textureWidth = 64;
        textureHeight = 32;
        Head = new ModelRenderer(this, 0, 0);
        Head.addBox(-1F, -1F, -2F, 2, 2, 2);
        Head.setRotationPoint(0.0F, 0.0F, -5F);
        Head.setTextureOffset(64, 32);
        Head.mirror = true;
        setRotation(Head, 0.0F, 0.0F, 0.0F);
        Beak1 = new ModelRenderer(this, 10, 4);
        Beak1.addBox(-0.5F, -4F, -1F, 1, 2, 1);
        Beak1.setRotationPoint(0.0F, 0.0F, -5F);
        Beak1.setTextureOffset(64, 32);
        Beak1.mirror = true;
        setRotation(Beak1, 1.570796F, 0.0F, 0.0F);
        Beak2 = new ModelRenderer(this, 10, 0);
        Beak2.addBox(-0.5F, 1.2F, -1.2F, 1, 3, 1);
        Beak2.setRotationPoint(0.0F, 0.0F, -5F);
        Beak2.setTextureOffset(64, 32);
        Beak2.mirror = true;
        setRotation(Beak2, -1.291544F, 0.0F, 0.0F);
        Neck = new ModelRenderer(this, 0, 4);
        Neck.addBox(-1F, -1F, -2F, 2, 2, 2);
        Neck.setRotationPoint(0.0F, 0.0F, -3F);
        Neck.setTextureOffset(64, 32);
        Neck.mirror = true;
        setRotation(Neck, 0.0F, 0.0F, 0.0F);
        Body = new ModelRenderer(this, 0, 17);
        Body.addBox(-1.5F, -6F, 0.0F, 3, 6, 3);
        Body.setRotationPoint(0.0F, 2.0F, 2.0F);
        Body.setTextureOffset(64, 32);
        Body.mirror = true;
        setRotation(Body, 1.570796F, 0.0F, 0.0F);
        Tail1 = new ModelRenderer(this, 12, 20);
        Tail1.addBox(-1F, -1F, 1.0F, 2, 1, 1);
        Tail1.setRotationPoint(0.0F, 0.0F, 2.0F);
        Tail1.setTextureOffset(64, 32);
        Tail1.mirror = true;
        setRotation(Tail1, 0.0F, 0.0F, 0.0F);
        Tail2 = new ModelRenderer(this, 12, 17);
        Tail2.addBox(-1F, -1F, 0.0F, 2, 2, 1);
        Tail2.setRotationPoint(0.0F, 0.0F, 2.0F);
        Tail2.setTextureOffset(64, 32);
        Tail2.mirror = true;
        setRotation(Tail2, 0.0F, 0.0F, 0.0F);
        LegLeft1 = new ModelRenderer(this, 22, 0);
        LegLeft1.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        LegLeft1.setRotationPoint(1.0F, 2.0F, 2.0F);
        LegLeft1.setTextureOffset(64, 32);
        LegLeft1.mirror = true;
        setRotation(LegLeft1, 0.0F, 0.0F, 0.0F);
        LegLeft2 = new ModelRenderer(this, 18, 0);
        LegLeft2.addBox(-0.5F, 1.0F, 1.7F, 1, 2, 1);
        LegLeft2.setRotationPoint(1.0F, 2.0F, 2.0F);
        LegLeft2.setTextureOffset(64, 32);
        LegLeft2.mirror = true;
        setRotation(LegLeft2, -1.047198F, 0.0F, 0.0F);
        LegRight1 = new ModelRenderer(this, 22, 0);
        LegRight1.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        LegRight1.setRotationPoint(-1F, 2.0F, 2.0F);
        setRotation(LegRight1, 0.0F, 0.0F, 0.0F);
        LegRight1.mirror = false;
        LegRight2 = new ModelRenderer(this, 18, 0);
        LegRight2.addBox(-0.5F, 1.0F, 1.7F, 1, 2, 1);
        LegRight2.setRotationPoint(-1F, 2.0F, 2.0F);
        LegRight2.setTextureOffset(64, 32);
        setRotation(LegRight2, -1.047198F, 0.0F, 0.0F);
        LegRight2.mirror = false;
        TailFeather1 = new ModelRenderer(this, 34, 12);
        TailFeather1.addBox(-1.5F, 0.0F, -1F, 3, 7, 1);
        TailFeather1.setRotationPoint(0.0F, -1F, 2.0F);
        TailFeather1.setTextureOffset(64, 32);
        TailFeather1.mirror = true;
        setRotation(TailFeather1, 1.570796F, 0.0F, 0.0F);
        TailFeather2 = new ModelRenderer(this, 42, 12);
        TailFeather2.addBox(-1.5F, 0.0F, -1F, 3, 6, 1);
        TailFeather2.setRotationPoint(0.0F, -1.2F, 2.0F);
        TailFeather2.setTextureOffset(64, 32);
        TailFeather2.mirror = true;
        setRotation(TailFeather2, 1.570796F, 0.3490659F, 0.0F);
        TailFeather3 = new ModelRenderer(this, 42, 12);
        TailFeather3.addBox(-1.5F, 0.0F, -1F, 3, 6, 1);
        TailFeather3.setRotationPoint(0.0F, -1.1F, 2.0F);
        TailFeather3.setTextureOffset(64, 32);
        setRotation(TailFeather3, 1.570796F, -0.3490659F, 0.0F);
        TailFeather3.mirror = false;
        WingLeft1 = new ModelRenderer(this, 34, 0);
        WingLeft1.addBox(0.0F, -3F, -1F, 3, 6, 1);
        WingLeft1.setRotationPoint(1.5F, -1F, -1F);
        WingLeft1.setTextureOffset(64, 32);
        WingLeft1.mirror = true;
        setRotation(WingLeft1, 1.570796F, 0.0F, 0.0F);
        WingLeft2 = new ModelRenderer(this, 42, 0);
        WingLeft2.addBox(3F, -3F, -1F, 3, 6, 1);
        WingLeft2.setRotationPoint(1.5F, -1F, -1F);
        WingLeft2.setTextureOffset(64, 32);
        WingLeft2.mirror = true;
        setRotation(WingLeft2, 1.570796F, 0.0F, 0.0F);
        WingLeft3 = new ModelRenderer(this, 50, 0);
        WingLeft3.addBox(-1F, 4.5F, -1F, 6, 10, 1);
        WingLeft3.setRotationPoint(1.5F, -0.9F, -1F);
        WingLeft3.setTextureOffset(64, 32);
        WingLeft3.mirror = true;
        setRotation(WingLeft3, 1.570796F, 1.22173F, 0.0F);
        WingRight1 = new ModelRenderer(this, 34, 0);
        WingRight1.addBox(-3F, -3F, -1F, 3, 6, 1);
        WingRight1.setRotationPoint(-1.5F, -1F, -1F);
        WingRight1.setTextureOffset(64, 32);
        setRotation(WingRight1, 1.570796F, 0.0F, 0.0F);
        WingRight1.mirror = false;
        WingRight2 = new ModelRenderer(this, 42, 0);
        WingRight2.addBox(-6F, -3F, -1F, 3, 6, 1);
        WingRight2.setRotationPoint(-1.5F, -1F, -1F);
        WingRight2.setTextureOffset(64, 32);
        setRotation(WingRight2, 1.570796F, 0.0F, 0.0F);
        WingRight2.mirror = false;
        WingRight3 = new ModelRenderer(this, 50, 11);
        WingRight3.addBox(-1F, 4.5F, 0.0F, 6, 10, 1);
        WingRight3.setRotationPoint(-1.5F, -0.9F, -1F);
        WingRight3.setTextureOffset(64, 32);
        WingRight3.mirror = true;
        setRotation(WingRight3, 1.570796F, -1.22173F, 3.141593F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        EntityAtmosCrow entitycrow = (EntityAtmosCrow)entity;
        /*if(entitycrow.isFlying() || entitycrow.flyingMode)
        {
            float f6 = 1.5F;
            GL11.glPushMatrix();
            Head.render(f5);
            Beak1.render(f5);
            Beak2.render(f5);
            Neck.render(f5);
            Body.render(f5);
            Tail1.render(f5);
            Tail2.render(f5);
            LegLeft1.render(f5);
            LegLeft2.render(f5);
            LegRight1.render(f5);
            LegRight2.render(f5);
            TailFeather1.render(f5);
            TailFeather2.render(f5);
            TailFeather3.render(f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.05F, 0.0F * f5, -0.1F);
            WingLeft1.render(f5);
            WingLeft2.render(f5);
            WingLeft3.render(f5);
            GL11.glTranslatef(-0.1F, 0.0F, 0.0F);
            WingRight1.render(f5);
            WingRight2.render(f5);
            WingRight3.render(f5);
            GL11.glPopMatrix();
        } else
        {*/
            Head.render(f5);
            Beak1.render(f5);
            Beak2.render(f5);
            Neck.render(f5);
            Body.render(f5);
            Tail1.render(f5);
            Tail2.render(f5);
            LegLeft1.render(f5);
            LegLeft2.render(f5);
            LegRight1.render(f5);
            LegRight2.render(f5);
            TailFeather1.render(f5);
            TailFeather2.render(f5);
            TailFeather3.render(f5);
            WingLeft1.render(f5);
            WingLeft2.render(f5);
            WingLeft3.render(f5);
            WingRight1.render(f5);
            WingRight2.render(f5);
            WingRight3.render(f5);
//        }
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
        Head.rotateAngleX = f4 / 57.29578F;
        Head.rotateAngleZ = f3 / 57.29578F;
        Beak1.rotateAngleX = f4 / 57.29578F + 1.570796F;
        Beak1.rotateAngleY = f3 / 57.29578F;
        Beak2.rotateAngleX = f4 / 57.29578F - 1.291544F;
        Beak2.rotateAngleY = f3 / 57.29578F;
        WingLeft1.rotateAngleZ = -f2;
        WingRight1.rotateAngleZ = f2;
        WingLeft2.rotateAngleZ = -f2;
        WingRight2.rotateAngleZ = f2;
        WingLeft3.rotateAngleZ = -f2;
        WingRight3.rotateAngleZ = f2;
//        WingLeft2.d = -1F;
//        WingRight2.d = -1F;
        WingLeft3.rotateAngleY = 1.22173F;
        WingLeft3.rotateAngleX = 1.570796F;
//        WingLeft3.d = -0.9F;
//        WingLeft3.e = -1F;
        WingRight3.rotateAngleY = 1.919862F;
        WingRight3.rotateAngleX = -1.570796F;
//        WingRight3.d = -0.9F;
//        WingRight3.e = -1F;
        EntityAtmosCrow entitycrow = (EntityAtmosCrow)entity;
        /*if(entitycrow.flyingMode || entitycrow.isFlying())
        {
            WingLeft1.rotateAngleZ = 1.5F;
            WingRight1.rotateAngleZ = -1.5F;
            WingLeft2.rotateAngleZ = -1.5F;
            WingRight2.rotateAngleZ = 1.5F;
//            WingLeft2.d = 5F;
//            WingRight2.d = 5F;
            WingLeft3.rotateAngleZ = -1.5F;
            WingLeft3.rotateAngleY = 0.3F;
            WingLeft3.rotateAngleX = 1.5F;
//            WingLeft3.d = 5.9F;
//            WingLeft3.e = -7F;
            WingRight3.rotateAngleZ = -1.5F;
            WingRight3.rotateAngleY = 0.3F;
            WingRight3.rotateAngleX = 1.7F;
//            WingRight3.d = 5.9F;
//            WingRight3.e = -7F;
        }*/
//        LegLeft1.rotateAngleX = -ke.setTextureOffset(f * 0.6662F * 2.0F + 0.0F) * 0.6F * f1;
//        LegLeft2.rotateAngleX = -ke.setTextureOffset(f * 0.6662F * 2.0F + 0.0F) * 0.6F * f1 - 1.047198F;
//        LegRight1.rotateAngleX = ke.setTextureOffset(f * 0.6662F * 2.0F + 0.0F) * 0.6F * f1;
//        LegRight2.rotateAngleX = ke.setTextureOffset(f * 0.6662F * 2.0F + 0.0F) * 0.6F * f1 - 1.047198F;
    }

    ModelRenderer Head;
    ModelRenderer Beak1;
    ModelRenderer Beak2;
    ModelRenderer Neck;
    ModelRenderer Body;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer LegLeft1;
    ModelRenderer LegLeft2;
    ModelRenderer LegRight1;
    ModelRenderer LegRight2;
    ModelRenderer TailFeather1;
    ModelRenderer TailFeather2;
    ModelRenderer TailFeather3;
    ModelRenderer WingLeft1;
    ModelRenderer WingLeft2;
    ModelRenderer WingLeft3;
    ModelRenderer WingRight1;
    ModelRenderer WingRight2;
    ModelRenderer WingRight3;
}
