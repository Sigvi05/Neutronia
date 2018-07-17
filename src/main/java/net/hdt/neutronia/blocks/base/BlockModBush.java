package net.hdt.neutronia.blocks.base;

import net.hdt.huskylib2.interf.IModBlock;
import net.hdt.huskylib2.items.blocks.ItemModBlock;
import net.hdt.huskylib2.utils.ProxyRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class BlockModBush extends BlockBush implements IModBlock {

    private final String[] variants;
    private final String bareName, modid;

    public BlockModBush(Material material, String name, String modid) {
        super(material);
        variants = new String[]{name};
        bareName = name;
        this.modid = modid;

        setTranslationKey(name);
        setCreativeTab(CreativeTabs.SEARCH);
    }

    public Block setTranslationKey(String name) {
        super.setTranslationKey(name);
        this.setRegistryName(getPrefix(), name);
        ProxyRegistry.register(this);
        ProxyRegistry.register(createItemBlock(new ResourceLocation(getPrefix(), name)));
        return this;
    }

    private ItemBlock createItemBlock(ResourceLocation res) {
        return new ItemModBlock(this, res);
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
    public String getPrefix() {
        return this.modid;
    }

    @Override
    public String getModNamespace() {
        return this.modid;
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