package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumNewStoneVariants implements IStringSerializable {

    ANDESITE_BRICKS(0, "andesite_bricks"),
    ANDESITE_COBBLE(1, "andesite_cobble"),
    SMOOTH_ANDESITE(2, "smooth_andesite"),
    BASALT(3, "raw_basalt"),
    BASALT_SMOOTH(4, "smooth_basalt"),
    BASALT_CHISELED(5, "chiseled_basalt"),
    BASALT_BRICKS(6, "basalt_bricks"),
    BASALT_COBBLE(7, "basalt_cobble"),
    DIORITE_BRICKS(8, "diorite_bricks"),
    DIORITE_COBBLE(9, "diorite_cobble"),
    SMOOTH_DIORITE(10, "smooth_diorite"),
    GRANITE_BRICKS(11, "granite_bricks"),
    GRANITE_COBBLE(12, "granite_cobble"),
    SMOOTH_GRANITE(13, "smooth_granite"),
    LIMESTONE(14, "raw_limestone"),
    LIMESTONE_SMOOTH(15, "smooth_limestone"),
    LIMESTONE_CHISELED(16, "chiseled_limestone"),
    LIMESTONE_BRICKS(17, "limestone_bricks"),
    LIMESTONE_COBBLE(18, "limestone_cobble"),
    MARBLE(19, "raw_marble"),
    MARBLE_SMOOTH(20, "smooth_marble"),
    MARBLE_CHISELED(21, "chiseled_marble"),
    MARBLE_BRICKS(22, "marble_bricks"),
    MARBLE_COBBLE(23, "marble_cobble"),
    METEORITE(24, "raw_meteorite"),
    METEORITE_BRICKS(25, "meteorite_bricks"),
    METEORITE_SMOOTH(26, "smooth_meteorite");

    private static final EnumNewStoneVariants[] META_LOOKUP = new EnumNewStoneVariants[values().length];

    static {
        for (EnumNewStoneVariants blockstone$enumtype : values()) {
            META_LOOKUP[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
        }
    }

    private final int meta;
    private final String name;

    EnumNewStoneVariants(int p_i46384_3_, String p_i46384_5_) {
        this.meta = p_i46384_3_;
        this.name = p_i46384_5_;
    }

    public static EnumNewStoneVariants byMetadata(int meta) {
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
