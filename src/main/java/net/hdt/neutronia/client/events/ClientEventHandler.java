package net.hdt.neutronia.client.events;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.client.gui.update.ModUpdateGUI;
import net.hdt.neutronia.client.model.VoxelModel;
import net.hdt.neutronia.proxy.ClientProxy;
import net.hdt.neutronia.update.UpdateHandler;
import net.hdt.neutronia.util.ClientUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.UUID;

@SideOnly(Side.CLIENT)
public enum ClientEventHandler {
    INSTANCE;

    private boolean checkedForUpdates;
    private ModelBase voxelModel = new VoxelModel();

    @SubscribeEvent
    public void onInitGuiPost(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.getGui() instanceof GuiMainMenu) {
            int offsetX = 0;
            int offsetY = 0;
            int buttonX = event.getGui().width / 2 - 124 + offsetX;
            int buttonY = event.getGui().height / 4 + 48 + 24 * 2 + offsetY;
            while (true) {
                if (buttonX < 0) {
                    if (offsetY <= -48) {
                        buttonX = 0;
                        buttonY = 0;
                        break;
                    } else {
                        offsetX = 0;
                        offsetY -= 24;
                        buttonX = event.getGui().width / 2 - 124 + offsetX;
                        buttonY = event.getGui().height / 4 + 48 + 24 * 2 + offsetY;
                    }
                }

                Rectangle rectangle = new Rectangle(buttonX, buttonY, 20, 20);
                boolean intersects = false;
                for (int i = 0; i < event.getButtonList().size(); i++) {
                    GuiButton button = event.getButtonList().get(i);
                    if (!intersects) {
                        intersects = rectangle.intersects(new Rectangle(button.x, button.y, button.width, button.height));
                    }
                }

                if (!intersects) {
                    break;
                }

                buttonX -= 24;
            }

            if (!this.checkedForUpdates && !UpdateHandler.INSTANCE.getOutdatedModList().isEmpty()) {
                event.getButtonList().add(new GuiButton(ClientProxy.updateButtonID, buttonX, buttonY, 20, 20, "U"));
                this.checkedForUpdates = true;
//                SnackbarHandler.INSTANCE.showSnackbar(Snackbar.create(I18n.format("snackbar.llibrary.updates_found")));
            }
        }
    }

    @SubscribeEvent
    public void onButtonPressPre(GuiScreenEvent.ActionPerformedEvent.Pre event) {
        if (event.getGui() instanceof GuiMainMenu && event.getButton().id == ClientProxy.updateButtonID) {
            ClientProxy.minecraft.displayGuiScreen(new ModUpdateGUI((GuiMainMenu) event.getGui()));
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onRenderPlayer(RenderPlayerEvent.Post event) {
        EntityPlayer player = event.getEntityPlayer();
        if ((ClientProxy.minecraft.gameSettings.thirdPersonView != 0 || player != ClientProxy.minecraft.player)) {
            UUID id = player.getGameProfile().getId();
            if (id != null && ClientProxy.patrons.contains(id.toString())) {
                GlStateManager.pushMatrix();
                GlStateManager.translate(event.getX(), event.getY(), event.getZ());
                GlStateManager.depthMask(false);
                GlStateManager.disableLighting();
                GlStateManager.translate(0.0F, -1.37F, 0.0F);
                this.renderVoxel(event, 1.1F, 0.23F);
                GlStateManager.depthMask(true);
                GlStateManager.enableLighting();
                GlStateManager.translate(0.0F, 0.128F, 0.0F);
                this.renderVoxel(event, 1.0F, 1.0F);
                GlStateManager.popMatrix();
            }
        }
    }

    private void renderVoxel(RenderPlayerEvent.Post event, float scale, float color) {
        EntityPlayer player = event.getEntityPlayer();
        int ticksExisted = player.ticksExisted;
        float partialTicks = Main.proxy.getPartialTicks();
        float bob = MathHelper.sin(((float) ticksExisted + partialTicks) / 15.0F) * 0.1F;
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.rotate(-ClientUtils.interpolateRotation(player.prevRenderYawOffset, player.renderYawOffset, partialTicks), 0, 1.0F, 0);
        GlStateManager.color(color, color, color, 1.0F);
        GlStateManager.translate(0.0F, -1.0F + bob, 0.0F);
        GlStateManager.rotate(ClientUtils.interpolateRotation((ticksExisted - 1) % 360, ticksExisted % 360, partialTicks), 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.75F, 0.0F, 0.0F);
        GlStateManager.rotate(ClientUtils.interpolateRotation((ticksExisted - 1) % 360, ticksExisted % 360, partialTicks), 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(scale, scale, scale);
        this.voxelModel.render(player, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

}
