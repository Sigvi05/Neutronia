package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumBasaltTypes implements IStringSerializable {

    PAVER(1, "paver"),
    BRICK_SMALL(4, "brick_small"),
    TILE(5, "tile"),
    PILLAR(6, "pillar"),
    ARCH(7, "arch"),
    ENGRAVED(8, "engraved"),
    RUNED(9, "runed"),
    PILLAR_TOP(10, "pillar_top"),
    PILLAR_BOTTOM(11, "pillar_bottom"),
    PILLAR_MIDDLE(12, "pillar_middle"),
    BRICKS_CRACKED(14, "bricks_cracked"),
    CRACKED_LAVA(15, "cracked_lava");

    private static final EnumBasaltTypes[] METADATA_LOOKUP = new EnumBasaltTypes[values().length];

    static {
        for (EnumBasaltTypes type : values()) {
            METADATA_LOOKUP[type.getMetadata()] = type;
        }
    }

    private final int metadata;
    private final String name;

    EnumBasaltTypes(int metadata, String name) {

        this.metadata = metadata;
        this.name = name;
    }

    public static EnumBasaltTypes byMetadata(int metadata) {

        if (metadata < 0 || metadata >= METADATA_LOOKUP.length) {
            metadata = 0;
        }
        return METADATA_LOOKUP[metadata];
    }

    public int getMetadata() {
        return this.metadata;
    }

    @Override
    public String getName() {

        return this.name;
    }
}