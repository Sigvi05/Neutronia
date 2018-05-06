package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumNewStoneVariants implements IStringSerializable {

    GRANITE_BRICKS(0, "granite_bricks"),
    GRANITE_COBBLE(1, "granite_cobble"),
    DIORITE_BRICKS(2, "diorite_bricks"),
    DIORITE_COBBLE(3, "diorite_cobble"),
    ANDESITE_BRICKS(4, "andesite_bricks"),
    ANDESITE_COBBLE(5, "andesite_cobble"),
    BASALT(6, "raw_basalt"),
    BASALT_SMOOTH(7, "smooth_basalt"),
    BASALT_CHISELED(8, "chiseled_basalt"),
    BASALT_BRICKS(9, "basalt_bricks"),
    BASALT_COBBLE(10, "basalt_cobble"),
    BASALT_CRACKED_BRICKS(11, "cracked_basalt_bricks"),
    BASALT_SMALL_BRICKS(12, "small_basalt_bricks"),
    MARBLE(13, "raw_marble"),
    MARBLE_SMOOTH(14, "smooth_marble"),
    MARBLE_CHISELED(15, "chiseled_marble"),
    MARBLE_BRICKS(16, "marble_bricks"),
    MARBLE_COBBLE(17, "marble_cobble"),
    MARBLE_CRACKED_BRICKS(18, "cracked_marble_bricks"),
    MARBLE_SMALL_BRICKS(19, "small_marble_bricks"),
    LIMESTONE(20, "raw_limestone"),
    LIMESTONE_SMOOTH(21, "smooth_limestone"),
    LIMESTONE_CHISELED(22, "chiseled_limestone"),
    LIMESTONE_BRICKS(23, "limestone_bricks"),
    LIMESTONE_COBBLE(24, "limestone_cobble"),
    LIMESTONE_CRACKED_BRICKS(25, "cracked_limestone_bricks"),
    LIMESTONE_SMALL_BRICKS(26, "small_limestone_bricks"),
    METEORITE(27, "raw_meteorite"),
    METEORITE_BRICKS(28, "meteorite_bricks"),
    METEORITE_SMOOTH(29, "smooth_meteorite");

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
