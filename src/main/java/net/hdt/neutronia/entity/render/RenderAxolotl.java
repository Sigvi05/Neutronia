package net.hdt.neutronia.entity.render;

import net.hdt.neutronia.entity.EntityAxolotl;
import net.hdt.neutronia.entity.render.model.ModelAxolotl;
import net.hdt.neutronia.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderAxolotl extends RenderLiving<EntityAxolotl> {

    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/axolotl.png");

    public RenderAxolotl(RenderManager manager) {
        super(manager, new ModelAxolotl(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityAxolotl entity) {
        return SCORP_TEXTURE;
    }

}
