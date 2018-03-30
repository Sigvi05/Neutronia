package net.thegaminghuskymc.mcaddon.entity.render;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.mcaddon.entity.EntityMummy;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

@SideOnly(Side.CLIENT)
public class RenderMummy extends RenderBiped<EntityMummy> {

    private static final ResourceLocation MUMMY_TEXTURE = new ResourceLocation(MOD_ID,"textures/entity/mummy/mummy.png");

    public RenderMummy(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelZombie(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMummy entity) {
        return MUMMY_TEXTURE;
    }

}
