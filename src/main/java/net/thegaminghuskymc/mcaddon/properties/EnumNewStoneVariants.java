package net.thegaminghuskymc.mcaddon.properties;

import net.minecraft.block.material.MapColor;
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
    MARBLE(11, "raw_marble"),
    MARBLE_SMOOTH(12, "smooth_marble"),
    MARBLE_CHISELED(13, "marble_chiseled"),
    MARBLE_BRICKS(14, "marble_bricks"),
    MARBLE_COBBLE(15, "marble_cobblestone"),
    ASPHALT(16, "raw_asphalt"),
    LIMESTONE(17, "raw_limestone"),
    LIMESTONE_SMOOTH(18, "smooth_limestone"),
    LIMESTONE_CHISELED(19, "limestone_chiseled"),
    LIMESTONE_BRICKS(20, "limestone_bricks"),
    LIMESTONE_COBBLE(21, "limestone_cobble"),
    METEORITE(22, "raw_meteorite"),
    METEORITE_BRICKS(23, "meteorite_bricks"),
    METEORITE_SMOOTH(24, "smooth_meteorite"),
    FROSTY_STONE(25, "frosty_stone");

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
