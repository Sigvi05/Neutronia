package net.hdt.neutronia.base.blocks;

import net.hdt.huskylib2.interf.IModBlock;
import net.hdt.neutronia.base.lib.LibMisc;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public interface INeutroniaBlock extends IModBlock {

	@Override
	default String getModNamespace() {
		return LibMisc.MOD_ID;
	}

	@Override
	default EnumRarity getBlockRarity(ItemStack stack) {
		return EnumRarity.COMMON;
	}
	
}
