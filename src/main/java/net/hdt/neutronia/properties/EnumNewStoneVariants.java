package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumNewStoneVariants implements IStringSerializable {

    ANDESITE_BRICKS(0, "andesite_bricks"),
    ANDESITE_COBBLE(1, "andesite_cobble"),
    BASALT(2, "raw_basalt"),
    BASALT_SMOOTH(3, "smooth_basalt"),
    BASALT_CHISELED(4, "chiseled_basalt"),
    BASALT_BRICKS(5, "basalt_bricks"),
    BASALT_COBBLE(6, "basalt_cobble"),
    DIORITE_BRICKS(7, "diorite_bricks"),
    DIORITE_COBBLE(8, "diorite_cobble"),
    GRANITE_BRICKS(9, "granite_bricks"),
    GRANITE_COBBLE(10, "granite_cobble"),
    LIMESTONE(11, "raw_limestone"),
    LIMESTONE_SMOOTH(12, "smooth_limestone"),
    LIMESTONE_CHISELED(13, "chiseled_limestone"),
    LIMESTONE_BRICKS(14, "limestone_bricks"),
//    LIMESTONE_COBBLE(18, "limestone_cobble"),
    MARBLE(15, "raw_marble"),
    MARBLE_SMOOTH(16, "smooth_marble"),
    MARBLE_CHISELED(17, "chiseled_marble"),
    MARBLE_BRICKS(18, "marble_bricks"),
    MARBLE_COBBLE(19, "marble_cobble"),
    METEORITE(20, "raw_meteorite"),
    METEORITE_BRICKS(21, "meteorite_bricks"),
    METEORITE_SMOOTH(22, "smooth_meteorite");

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
