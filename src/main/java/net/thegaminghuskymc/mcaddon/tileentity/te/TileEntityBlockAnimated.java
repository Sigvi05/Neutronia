package net.thegaminghuskymc.mcaddon.tileentity.te;

import com.leviathanstudio.craftstudio.CraftStudioApi;
import com.leviathanstudio.craftstudio.common.animation.AnimationHandler;
import net.thegaminghuskymc.mcaddon.tileentity.BaseTileEntity;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

/**
 * Sample TileEntity for an animated animation.animations.blocks
 * */
public class TileEntityBlockAnimated extends BaseTileEntity
{
	//Create a new animation handler for this TileEntity
    protected static AnimationHandler animHandler = CraftStudioApi.getNewAnimationHandler(TileEntityBlockAnimated.class);

    //Register Animation
    static {
        TileEntityBlockAnimated.animHandler.addAnim(MOD_ID, "block_animated_anim", "block_animated", true);
    }

    public TileEntityBlockAnimated() {}

    @Override
    public AnimationHandler getAnimationHandler() {
        return TileEntityBlockAnimated.animHandler;
    }

    /**
     * Update method to launch animation of the animated animation.animations.blocks
     * It always loop, with the checking condition,
     * !this.getAnimationHandler().isAnimationActive()
     */
    @Override
    public void update() {
        super.update();
        if (this.isWorldRemote() && !this.getAnimationHandler().isAnimationActive(MOD_ID, "block_animated_anim", this))
            this.getAnimationHandler().startAnimation(MOD_ID, "block_animated_anim", this);
    }
}