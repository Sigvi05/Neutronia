package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumPillarTypes implements IStringSerializable {

    OBSIDIAN(0, "obsidian_pillar"),
    AQUAMARINE(1, "aquamarine_pillar"),
    NATURAL_AQUAMARINE(1, "natural_aquamarine_pillar"),
    GRANITE(1, "granite_pillar"),
    ANDESITE(1, "andesite_pillar"),
    DIORITE(1, "diorite_pillar"),
    BASALT(1, "basalt_pillar"),
    MARBLE(1, "marble_pillar"),
    LIMESTONE(1, "limestone_pillar"),
    METEORITE(1, "meteorite_pillar");

    private static final EnumPillarTypes[] META_LOOKUP = new EnumPillarTypes[values().length];

    static {
        for (EnumPillarTypes blockstone$enumtype : values()) {
            META_LOOKUP[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
        }
    }

    private final int meta;
    private final String name;

    EnumPillarTypes(int p_i46384_3_, String p_i46384_5_) {
        this.meta = p_i46384_3_;
        this.name = p_i46384_5_;
    }

    public static EnumPillarTypes byMetadata(int meta) {
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
