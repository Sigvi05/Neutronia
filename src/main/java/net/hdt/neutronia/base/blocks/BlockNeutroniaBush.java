package net.hdt.neutronia.base.blocks;

import net.hdt.huskylib2.items.blocks.ItemModBlock;
import net.hdt.huskylib2.utils.ProxyRegistry;
import net.hdt.neutronia.base.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.util.ResourceLocation;

public class BlockNeutroniaBush extends BlockBush implements INeutroniaBlock {

	private final String[] variants;
	private final String bareName;

	public BlockNeutroniaBush(String name) {
		variants = new String[] { name };
		bareName = name;

		setTranslationKey(name);
	}

	@Override
	public Block setTranslationKey(String name) {
		super.setTranslationKey(name);
		setRegistryName(LibMisc.PREFIX_MOD + name);
		ProxyRegistry.register(this);
		ProxyRegistry.register(new ItemModBlock(this, new ResourceLocation(LibMisc.PREFIX_MOD + name)));
		return this;
	}

	@Override
	public String getBareName() {
		return bareName;
	}

	@Override
	public String[] getVariants() {
		return variants;
	}

	@Override
	public ItemMeshDefinition getCustomMeshDefinition() {
		return null;
	}

	@Override
	public IProperty[] getIgnoredProperties() {
		return new IProperty[0];
	}

	@Override
	public IProperty getVariantProp() {
		return null;
	}

	@Override
	public Class getVariantEnum() {
		return null;
	}

}
