package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumFrostedStoneVariants implements IStringSerializable {

    STONE(0, "frosted_stone"),
    COBBLESTONE(1, "frosted_cobblestone"),
    GRANITE(2, "frosted_granite"),
    DIORITE(3, "frosted_diorite"),
    ANDESITE(4, "frosted_andesite"),
    HARDENED_CLAY(5, "hardened_frosted_clay");

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