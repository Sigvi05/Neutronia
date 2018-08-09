package net.hdt.neutronia.base.client.models;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import java.util.List;

public interface ItemVariantGetter {
    public void addItemVariants(List<ModelResourceLocation> list);
}
