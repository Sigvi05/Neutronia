package net.thegaminghuskymc.mcaddon.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumNetherBlocks implements IStringSerializable {

    FIERY_STONE(0, "fiery_stone"),
    VOLCANIC_GLOW_ROCK(1, "volcanic_glow_rock"),
    VOLCANIC_ROCK(2, "volcanic_rock"),
    HOT_COBBLESTONE(3, "hot_cobblestone"),
    BURNED_BONES(4, "burned_bones"),
    ASH(5, "ash_block");

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
