package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumFrostedDirtVariants implements IStringSerializable {

    DIRT(0, "frosted_dirt"),
    COARSE_DIRT(1, "frosted_coarse_dirt"),
    DARK_DIRT(2, "dark_dirt"),
    DARK_DIRT_FROSTED(3, "dark_frosted_dirt"),
    DARK_COARSE_DIRT(4, "dark_coarse_dirt"),
    DARK_COARSE_DIRT_FROSTED(5, "dark_frosted_coarse_dirt"),
    GRAVEL(6, "frosted_gravel"),
    GRASS(7, "frosted_grass"),
    SAND(8, "frosted_sand"),
    RED_SAND(9, "red_frosted_sand");

    private static final EnumFrostedDirtVariants[] META_LOOKUP = new EnumFrostedDirtVariants[values().length];

    static {
        for (EnumFrostedDirtVariants enumdyecolor : values()) {
            META_LOOKUP[enumdyecolor.getMetadata()] = enumdyecolor;
        }
    }

    private final int meta;
    private final String name;

    EnumFrostedDirtVariants(int metaIn, String nameIn) {
        this.meta = metaIn;
        this.name = nameIn;
    }

    public static EnumFrostedDirtVariants byMetadata(int meta) {
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