package net.hdt.neutronia.properties;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum EnumWoodType implements IStringSerializable {
    SPRUCE(0, "spruce", MapColor.OBSIDIAN),
    BIRCH(1, "birch", MapColor.SAND),
    JUNGLE(2, "jungle", MapColor.DIRT),
    ACACIA(3, "acacia", MapColor.ADOBE),
    DARK_OAK(4, "dark_oak", "big_oak", MapColor.BROWN),
    REDWOOD(5, "redwood", MapColor.RED),
    PALM(6, "palm", MapColor.DIRT),
    CHERRY(7, "cherry", MapColor.PINK);

    private static final EnumWoodType[] META_LOOKUP = new EnumWoodType[values().length];

    static {
        for (EnumWoodType blockplanks$enumtype : values()) {
            META_LOOKUP[blockplanks$enumtype.getMetadata()] = blockplanks$enumtype;
        }
    }

    private final int meta;
    private final String name;
    private final String unlocalizedName;
    /**
     * The color that represents this entry on a map.
     */
    private final MapColor mapColor;

    EnumWoodType(int metaIn, String nameIn, MapColor mapColorIn) {
        this(metaIn, nameIn, nameIn, mapColorIn);
    }

    EnumWoodType(int metaIn, String nameIn, String unlocalizedNameIn, MapColor mapColorIn) {
        this.meta = metaIn;
        this.name = nameIn;
        this.unlocalizedName = unlocalizedNameIn;
        this.mapColor = mapColorIn;
    }

    public static EnumWoodType byMetadata(int meta) {
        if (meta < 0 || meta >= META_LOOKUP.length) {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public int getMetadata() {
        return this.meta;
    }

    /**
     * The color which represents this entry on a map.
     */
    public MapColor getMapColor() {
        return this.mapColor;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public String getTranslationKey() {
        return this.unlocalizedName;
    }
}