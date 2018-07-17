package net.hdt.neutronia.blocks;

import net.hdt.huskylib2.interf.IModBlock;
import net.hdt.huskylib2.items.blocks.ItemModBlock;
import net.hdt.huskylib2.utils.ProxyRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public abstract class BlockMod extends Block implements IModBlock {
    private final String[] variants;
    private String bareName;
    private String modid;

    public BlockMod(Material material, String modid, String translationKey, String registryName, String... variants) {
        super(material);
        if (variants.length == 0) {
            variants = new String[]{registryName};
        }

        this.bareName = registryName;
        this.variants = variants;
        this.modid = modid;
        if (this.registerInConstruction()) {
            this.setTranslationKey(this.getPrefix(), translationKey, registryName);
        }

        this.setHardness(1.5F);
        this.setResistance(30.0F);
        this.setHarvestLevel("pickaxe", 1);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

    public Block setTranslationKey(String modid, String translationKey, String registryName) {
        super.setTranslationKey(translationKey);
        this.setRegistryName(modid, registryName);
        ProxyRegistry.register(this);
        ProxyRegistry.register(this.createItemBlock(new ResourceLocation(this.getPrefix(), registryName)));
        return this;
    }

    protected ItemBlock createItemBlock(ResourceLocation res) {
        return new ItemModBlock(this, res);
    }

    public boolean registerInConstruction() {
        return true;
    }

    public String getPrefix() {
        return this.modid;
    }

    public String getModNamespace() {
        return this.modid;
    }

    public String getBareName() {
        return this.bareName;
    }

    public String[] getVariants() {
        return this.variants;
    }

    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return layer == BlockRenderLayer.CUTOUT_MIPPED || layer == BlockRenderLayer.CUTOUT || layer == BlockRenderLayer.SOLID || layer == BlockRenderLayer.TRANSLUCENT;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }

    public IProperty[] getIgnoredProperties() {
        return new IProperty[0];
    }

    public IProperty getVariantProp() {
        return null;
    }

    public Class getVariantEnum() {
        return null;
    }
}
