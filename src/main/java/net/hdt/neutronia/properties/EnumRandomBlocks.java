package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumRandomBlocks implements IStringSerializable {

    OBSIDIAN_BRICKS(0, "obsidian_bricks"),
    SMALL_DARK_PRISMARINE_BRICKS(1, "small_dark_prismarine_bricks"),
    SMOOTH_DARK_PRISMARINE(2, "smooth_dark_prismarine"),
    SMOOTH_PRISMARINE(3, "smooth_prismarine");

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
