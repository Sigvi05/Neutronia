package net.thegaminghuskymc.mcaddon.client.tesr;

import java.nio.FloatBuffer;

import javax.vecmath.Matrix4f;

import com.leviathanstudio.craftstudio.client.model.ModelCraftStudio;
import com.leviathanstudio.craftstudio.client.util.MathHelper;
import com.leviathanstudio.craftstudio.common.animation.simpleImpl.CSTileEntitySpecialRenderer;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.mcaddon.tileentity.te.TileEntityBlockAnimated;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class RenderAnimatedBlock<T extends TileEntityBlockAnimated> extends TileEntitySpecialRenderer<T>
{
    /** Efficient rotation corrector, you can use it in your renderer. */
    public static final FloatBuffer ROTATION_CORRECTOR;
    static {
        Matrix4f mat = new Matrix4f();
        mat.set(MathHelper.quatFromEuler(180, 0, 0));
        ROTATION_CORRECTOR = MathHelper.makeFloatBuffer(mat);
    }

    /** The model of the animation.animations.blocks. */
    protected ModelCraftStudio model;
    /** The texture of the animation.animations.blocks */
    protected ResourceLocation texture = new ResourceLocation(MOD_ID, "textures/example.png");

    /** The constructor that initialize the model and save texture. */
    public RenderAnimatedBlock() {
        this.model = new ModelCraftStudio(MOD_ID, "block_animated", 64);
    }

    @Override
    public void render(T tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.5, y - 0.4370, z + 0.5);
        GlStateManager.multMatrix(CSTileEntitySpecialRenderer.ROTATION_CORRECTOR);
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        bindTexture(this.texture);
        this.model.render(tile);
        GlStateManager.popMatrix();
    }

    public boolean isGlobalRenderer(TileEntityBlockAnimated te) {
        return true;
    }
}