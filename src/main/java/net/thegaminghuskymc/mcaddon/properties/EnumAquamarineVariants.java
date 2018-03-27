package net.thegaminghuskymc.mcaddon.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumAquamarineVariants implements IStringSerializable {

    BRICKS,
    CHISELED,
    PILLAR,
    RAW,
    SMALL_BRICKS,
    SMOOTH;

    @Override
    public String getName() {
        return toString().toLowerCase();
    }
}
