package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumFrostedDirtVariants implements IStringSerializable {

    DIRT(0, "frozen_dirt"),
    COARSE_DIRT(1, "frozen_coarse_dirt"),
    DARK_DIRT(2, "dark_dirt"),
    DARK_DIRT_FROSTED(3, "dark_frozen_dirt"),
    DARK_COARSE_DIRT(4, "dark_coarse_dirt"),
    DARK_COARSE_DIRT_FROSTED(5, "dark_frozen_coarse_dirt"),
    GRAVEL(6, "frozen_gravel"),
    GRASS(7, "frozen_grass"),
    PODZOL(8, "frozen_podzol"),
    MYCELIUM(9, "frozen_mycelium"),
    SAND(10, "frozen_sand"),
    RED_SAND(11, "red_frozen_sand");

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