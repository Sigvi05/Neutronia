package net.hdt.neutronia.blocks.base;

import net.minecraft.item.EnumDyeColor;

public class BlockColoredLightSource extends BlockColored {

    public BlockColoredLightSource(String name, EnumDyeColor color) {
        super(name, color);
        this.setTickRandomly(true);
        setLightLevel(1.0F);
    }

}