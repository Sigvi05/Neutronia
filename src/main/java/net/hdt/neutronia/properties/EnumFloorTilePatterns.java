package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumFloorTilePatterns implements IStringSerializable {

    BLANK(0, "frosted_dirt"),
    STAR(1, "dark_dirt"),
    ROCKET(2, "frosted_dark_dirt"),
    LAVA_ROCKS(3, "frosted_gravel");

    private static final EnumFloorTilePatterns[] META_LOOKUP = new EnumFloorTilePatterns[values().length];

    static {
        for (EnumFloorTilePatterns enumdyecolor : values()) {
            META_LOOKUP[enumdyecolor.getMetadata()] = enumdyecolor;
        }
    }

    private final int meta;
    private final String name;

    EnumFloorTilePatterns(int metaIn, String nameIn) {
        this.meta = metaIn;
        this.name = nameIn;
    }

    public static EnumFloorTilePatterns byMetadata(int meta) {
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