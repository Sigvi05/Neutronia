package net.hdt.neutronia.modules.decoration.features;

import net.hdt.huskylib2.recipe.RecipeHandler;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.NeutroniaMain;
import net.hdt.neutronia.base.lib.LibEntityIDs;
import net.hdt.neutronia.base.lib.LibMisc;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.decoration.client.render.RenderColoredItemFrame;
import net.hdt.neutronia.modules.decoration.entity.EntityColoredItemFrame;
import net.hdt.neutronia.modules.decoration.item.ItemColoredItemFrame;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ColoredItemFrames extends Feature {

	public static Item colored_item_frame;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		colored_item_frame = new ItemColoredItemFrame();

		String coloredItemFrameName = "quark:colored_item_frame";
		EntityRegistry.registerModEntity(new ResourceLocation(coloredItemFrameName), EntityColoredItemFrame.class, coloredItemFrameName, LibEntityIDs.COLORED_ITEM_FRAME, NeutroniaMain.instance, 256, 64, false);

		for(int i = 0; i < 16; i++)
			RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(colored_item_frame, 1, i), ProxyRegistry.newStack(Items.ITEM_FRAME), LibMisc.OREDICT_DYES.get(15 - i));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void preInitClient(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityColoredItemFrame.class, RenderColoredItemFrame.FACTORY);
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

}