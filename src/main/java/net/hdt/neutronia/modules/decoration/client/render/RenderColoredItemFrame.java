package net.hdt.neutronia.modules.decoration.client.render;

import net.hdt.huskylib2.util.ModelHandler;
import net.hdt.neutronia.modules.decoration.entity.EntityColoredItemFrame;
import net.hdt.neutronia.modules.decoration.entity.EntityFlatItemFrame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderColoredItemFrame extends RenderFlatItemFrame {
	public static final IRenderFactory FACTORY = RenderColoredItemFrame::new;

	public RenderColoredItemFrame(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	protected void renderModel(EntityFlatItemFrame entity, Minecraft mc) {
		EntityColoredItemFrame entityColored = (EntityColoredItemFrame) entity;
		BlockRendererDispatcher blockrendererdispatcher = mc.getBlockRendererDispatcher();
		ModelManager modelmanager = blockrendererdispatcher.getBlockModelShapes().getModelManager();
		IBakedModel ibakedmodel1, ibakedmodel2;

		if(!entity.getDisplayedItem().isEmpty() && entity.getDisplayedItem().getItem() == Items.FILLED_MAP) {
			ibakedmodel1 = modelmanager.getModel(ModelHandler.resourceLocations.get("colored_item_frame_map_wood"));
			ibakedmodel2 = modelmanager.getModel(ModelHandler.resourceLocations.get("colored_item_frame_map"));
		} else {
			ibakedmodel1 = modelmanager.getModel(ModelHandler.resourceLocations.get("colored_item_frame_wood"));
			ibakedmodel2 = modelmanager.getModel(ModelHandler.resourceLocations.get("colored_item_frame_normal"));
		}

		blockrendererdispatcher.getBlockModelRenderer().renderModelBrightnessColor(ibakedmodel1, 1.0F, 1.0F, 1.0F, 1.0F);

		int color = ItemDye.DYE_COLORS[15 - entityColored.getColor()];
		float r = (color >> 16 & 0xFF) / 255F;
		float g = (color >> 8 & 0xFF) / 255F;
		float b = (color & 0xFF) / 255F;

		blockrendererdispatcher.getBlockModelRenderer().renderModelBrightnessColor(ibakedmodel2, 1.0F, r, g, b);
	}
}