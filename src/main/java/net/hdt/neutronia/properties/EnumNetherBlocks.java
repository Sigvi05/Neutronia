package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumNetherBlocks implements IStringSerializable {

    ASH(0, "ash")/*,
    NETHER_DIRT(1, "nether_dirt")*/;

    private static final EnumNetherBlocks[] META_LOOKUP = new EnumNetherBlocks[values().length];

    static {
        for (EnumNetherBlocks blockstone$enumtype : values()) {
            META_LOOKUP[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
        }
    }

    private final int meta;
    private final String name;

    EnumNetherBlocks(int p_i46384_3_, String p_i46384_5_) {
        this.meta = p_i46384_3_;
        this.name = p_i46384_5_;
    }

    public static EnumNetherBlocks byMetadata(int meta) {
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
