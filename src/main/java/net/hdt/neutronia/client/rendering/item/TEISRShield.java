package net.hdt.neutronia.client.rendering.item;

import net.hdt.neutronia.client.render.item.ModelCustomShield;
import net.hdt.neutronia.init.NItems;
import net.minecraft.block.BlockPlanks;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TEISRShield extends TileEntityItemStackRenderer {

    private final ModelCustomShield modelShield = new ModelCustomShield();

    @Override
    public void renderByItem(ItemStack p_192838_1_, float partialTicks) {

        Item item = p_192838_1_.getItem();

        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values()) {
            if (item == NItems.logShields[type.getMetadata()]) {
                GlStateManager.pushMatrix();
                GlStateManager.scale(1.0F, -1.0F, -1.0F);
                this.modelShield.render();
                GlStateManager.popMatrix();
            }
            if (item == NItems.planksShields[type.getMetadata()]) {
                GlStateManager.pushMatrix();
                GlStateManager.scale(1.0F, -1.0F, -1.0F);
                this.modelShield.render();
                GlStateManager.popMatrix();
            }
        }

    }

}
