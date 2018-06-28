package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumFrostedStoneVariants implements IStringSerializable {

    STONE(0, "frozen_stone"),
    COBBLESTONE(1, "frozen_cobblestone"),
    GRANITE(2, "frozen_granite"),
    DIORITE(3, "frozen_diorite"),
    ANDESITE(4, "frozen_andesite"),
    HARDENED_CLAY(5, "hardened_frozen_clay");

    private static final EnumFrostedStoneVariants[] META_LOOKUP = new EnumFrostedStoneVariants[values().length];

    static {
        for (EnumFrostedStoneVariants enumdyecolor : values()) {
            META_LOOKUP[enumdyecolor.getMetadata()] = enumdyecolor;
        }
    }

    private final int meta;
    private final String name;

    EnumFrostedStoneVariants(int metaIn, String nameIn) {
        this.meta = metaIn;
        this.name = nameIn;
    }

    public static EnumFrostedStoneVariants byMetadata(int meta) {
        if (meta < 0 || meta >= META_LOOKUP.length) {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public int getMetadata() {
        return this.meta;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

}