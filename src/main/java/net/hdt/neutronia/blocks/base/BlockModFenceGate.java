package net.hdt.neutronia.blocks.base;

import net.hdt.neutronia.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.util.ResourceLocation;
import net.hdt.huskylib2.interf.IModBlock;
import net.hdt.huskylib2.items.blocks.ItemModBlock;
import net.hdt.huskylib2.utils.ProxyRegistry;

public class BlockModFenceGate extends BlockFenceGate implements IModBlock {

    private final String[] variants;
    private final String bareName;

    public BlockModFenceGate(BlockPlanks.EnumType woodType, String name) {
        super(woodType);

        setHardness(3.0F);
        setSoundType(SoundType.WOOD);

        variants = new String[]{name};
        bareName = name;

        setUnlocalizedName(name);
    }

    @Override
    public Block setUnlocalizedName(String name) {
        super.setUnlocalizedName(name);
        setRegistryName(getPrefix(), name);
        ProxyRegistry.register(this);
        ProxyRegistry.register(new ItemModBlock(this, new ResourceLocation(getPrefix(), name)));
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
    public String getModNamespace() {
        return Reference.MOD_ID;
    }

    @Override
    public String getPrefix() {
        return Reference.MOD_ID;
    }

    @Override
    public IProperty[] getIgnoredProperties() {
        return new IProperty[]{POWERED};
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