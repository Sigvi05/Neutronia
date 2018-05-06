package net.hdt.neutronia.blocks.base;

import net.minecraft.item.EnumDyeColor;

public class BlockColoredLightSourceAlt extends BlockColoredAlt {

    public BlockColoredLightSourceAlt(String modid, String name, EnumDyeColor color) {
        super(modid, name, color);
        this.setTickRandomly(true);
        setLightLevel(1.0F);
    }

}