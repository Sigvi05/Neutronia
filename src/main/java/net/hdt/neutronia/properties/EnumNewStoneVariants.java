package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumNewStoneVariants implements IStringSerializable {

    BASALT(0, "raw_basalt"),
    BASALT_SMOOTH(1, "smooth_basalt"),
    BASALT_CHISELED(2, "chiseled_basalt"),
    BASALT_BRICKS(3, "basalt_bricks"),
    BASALT_COBBLE(4, "basalt_cobble"),
    LIMESTONE(5, "raw_limestone"),
    LIMESTONE_SMOOTH(6, "smooth_limestone"),
    LIMESTONE_CHISELED(7, "chiseled_limestone"),
    LIMESTONE_BRICKS(8, "limestone_bricks"),
//    LIMESTONE_COBBLE(18, "limestone_cobble"),
    MARBLE(9, "raw_marble"),
    MARBLE_SMOOTH(10, "smooth_marble"),
    MARBLE_CHISELED(11, "chiseled_marble"),
    MARBLE_BRICKS(12, "marble_bricks"),
    MARBLE_COBBLE(13, "marble_cobble"),
    METEORITE(14, "raw_meteorite"),
    METEORITE_BRICKS(15, "meteorite_bricks"),
    METEORITE_SMOOTH(16, "smooth_meteorite")/*,
    DIORITE_BRICKS(17, "diorite_bricks"),
    DIORITE_COBBLE(18, "diorite_cobble")*/,
    GRANITE_BRICKS(17, "granite_bricks"),
    GRANITE_COBBLE(18, "granite_cobble"),
    ANDESITE_BRICKS(19, "andesite_bricks"),
    ANDESITE_COBBLE(20, "andesite_cobble");

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
