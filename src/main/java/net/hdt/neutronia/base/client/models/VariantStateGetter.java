package net.hdt.neutronia.base.client.models;

import net.minecraft.block.state.IBlockState;

public interface VariantStateGetter {
    public String getVariantForState(IBlockState state);
}
