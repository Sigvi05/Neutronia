package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum Type implements IStringSerializable {

    RAW(0, "raw"),
    PAVER(1, "paver"),
    BRICKS(2, "bricks"),
    CHISELED(3, "chiseled"),
    BRICK_SMALL(4, "brick_small"),
    TILE(5, "tile"),
    PILLAR(6, "pillar"),
    ARCH(7, "arch"),
    ENGRAVED(8, "engraved"),
    RUNED(9, "runed"),
    PILLAR_TOP(10, "pillar_top"),
    PILLAR_BOTTOM(11, "pillar_bottom"),
    PILLAR_MIDDLE(12, "pillar_middle");

    private static final Type[] METADATA_LOOKUP = new Type[values().length];

    static {
        for (Type type : values()) {
            METADATA_LOOKUP[type.getMetadata()] = type;
        }
    }

    private final int metadata;
    private final String name;
    private final int light;
    private final float hardness;
    private final float resistance;

    Type(int metadata, String name, int light, float hardness, float resistance) {

        this.metadata = metadata;
        this.name = name;
        this.light = light;
        this.hardness = hardness;
        this.resistance = resistance;
    }

    Type(int metadata, String name, float hardness, float resistance) {
        this(metadata, name, 0, hardness, resistance);
    }

    Type(int metadata, String name, int light) {

        this(metadata, name, light, 5.0F, 6.0F);
    }

    Type(int metadata, String name) {

        this(metadata, name, 0, 5.0F, 6.0F);
    }

    public static Type byMetadata(int metadata) {

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

    public int getLight() {

        return this.light;
    }

    public float getHardness() {

        return this.hardness;
    }

    public float getResistance() {

        return this.resistance;
    }
}