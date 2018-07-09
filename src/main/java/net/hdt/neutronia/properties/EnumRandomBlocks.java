package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumRandomBlocks implements IStringSerializable {

    OBSIDIAN_BRICKS(0, "obsidian_bricks"),
    SMALL_DARK_PRISMARINE_BRICKS(1, "small_dark_prismarine_bricks"),
    SMOOTH_DARK_PRISMARINE(2, "smooth_dark_prismarine"),
    SMOOTH_PRISMARINE(3, "smooth_prismarine"),
    BASALT_COBBLE(4, "basalt_cobble"),
    LIMESTONE(5, "raw_limestone"),
    LIMESTONE_SMOOTH(6, "polished_limestone"),
    MARBLE(7, "raw_marble"),
    MARBLE_SMOOTH(8, "smooth_marble"),
    MARBLE_CHISELED(9, "chiseled_marble"),
    MARBLE_BRICKS(10, "marble_bricks"),
    MARBLE_COBBLE(11, "marble_cobble"),
    METEORITE(12, "raw_meteorite"),
    METEORITE_BRICKS(13, "meteorite_bricks"),
    METEORITE_SMOOTH(14, "smooth_meteorite"),
    GRANITE_BRICKS(15, "granite_bricks"),
    GRANITE_COBBLE(16, "granite_cobble"),
    GRANITE_SMOOTH(16, "smooth_granite"),
    ANDESITE_BRICKS(17, "andesite_bricks"),
    ANDESITE_COBBLE(18, "andesite_cobble"),
    ANDESITE_SMOOTH(19, "smooth_andesite"),
    BLUE_ARDUIN(20, "blue_arduin"),
    SMOOTH_BLUE_ARDUIN(21, "smooth_blue_arduin"),
    RUST_ARDUIN(22, "rust_arduin"),
    SMOOTH_RUST_ARDUIN(23, "smooth_rust_arduin"),
    TINTED_ARDUIN(24, "tinted_arduin"),
    SMOOTH_TINTED_ARDUIN(25, "smooth_tinted_arduin");

    private static final EnumRandomBlocks[] META_LOOKUP = new EnumRandomBlocks[values().length];

    static {
        for (EnumRandomBlocks blockstone$enumtype : values()) {
            META_LOOKUP[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
        }
    }

    private final int meta;
    private final String name;

    EnumRandomBlocks(int p_i46384_3_, String p_i46384_5_) {
        this.meta = p_i46384_3_;
        this.name = p_i46384_5_;
    }

    public static EnumRandomBlocks byMetadata(int meta) {
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
