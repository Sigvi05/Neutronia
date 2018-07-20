package net.hdt.neutronia.modules.tweaks.features;

import net.hdt.neutronia.base.module.Feature;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TorchesBurnInFurnaces extends Feature {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerFuelHandler((ItemStack stack) -> stack.getItem() == Item.getItemFromBlock(Blocks.TORCH) ? 400 : 0);
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}
	
}
