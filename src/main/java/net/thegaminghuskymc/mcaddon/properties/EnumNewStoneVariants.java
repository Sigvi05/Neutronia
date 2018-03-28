package net.thegaminghuskymc.mcaddon.properties;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum EnumNewStoneVariants implements IStringSerializable {

    GRANITE_BRICKS(0, MapColor.DIRT, "granite_bricks", "graniteBricks", false),
    GRANITE_COBBLE(1, MapColor.DIRT, "granite_cobble", "graniteCobble", false),
    DIORITE_BRICKS(2, MapColor.QUARTZ, "diorite_bricks", "dioriteBricks", false),
    DIORITE_COBBLE(3, MapColor.QUARTZ, "diorite_cobble", "dioriteCobble", false),
    ANDESITE_BRICKS(4, MapColor.STONE, "andesite_bricks", "andesiteBricks", false),
    ANDESITE_COBBLE(5, MapColor.STONE, "andesite_cobble", "andesiteCobble", false),
    BASALT(6, MapColor.STONE, "raw_basalt", true),
    BASALT_SMOOTH(7, MapColor.STONE, "smooth_basalt", "basaltSmooth", false),
    BASALT_CHISELED(8, MapColor.STONE, "chiseled_basalt", "basaltChiseled", false),
    BASALT_BRICKS(9, MapColor.STONE, "basalt_bricks", "basaltBricks", false),
    BASALT_COBBLE(10, MapColor.STONE, "basalt_cobble", "basaltCobble", false),
    MARBLE(11, MapColor.STONE, "raw_marble", true),
    MARBLE_SMOOTH(12, MapColor.STONE, "smooth_marble", "marbleSmooth", false),
    MARBLE_CHISELED(13, MapColor.STONE, "marble_chiseled", "marbleChiseled", false),
    MARBLE_BRICKS(14, MapColor.STONE, "marble_bricks", "marbleBricks", false),
    MARBLE_COBBLE(15, MapColor.STONE, "marble_cobblestone", "marbleCobblestone", false),
    ASPHALT(16, MapColor.BLACK, "raw_asphalt", true),
    LIMESTONE(17, MapColor.STONE, "raw_limestone", true),
    LIMESTONE_SMOOTH(18, MapColor.STONE, "smooth_limestone", "limestoneSmooth", false),
    LIMESTONE_CHISELED(19, MapColor.STONE, "limestone_chiseled", "limestoneChiseled", false),
    LIMESTONE_BRICKS(20, MapColor.STONE, "limestone_bricks", "limestoneBricks", false),
    LIMESTONE_COBBLE(21, MapColor.STONE, "limestone_cobble", "limestoneCobble", false),
    METEORITE(22, MapColor.STONE, "raw_meteorite", false),
    METEORITE_BRICKS(23, MapColor.STONE, "meteorite_bricks", "meteoriteBricks", false),
    METEORITE_SMOOTH(24, MapColor.STONE, "smooth_meteorite", "meteoriteSmooth", false),
    FIERY_STONE(25, MapColor.RED_STAINED_HARDENED_CLAY, "fiery_stone", "fieryStone", false),
    FROSTY_STONE(25, MapColor.LIGHT_BLUE_STAINED_HARDENED_CLAY, "frosty_stone", "frostyStone", false);

    private static final EnumNewStoneVariants[] META_LOOKUP = new EnumNewStoneVariants[values().length];

    static {
        for (EnumNewStoneVariants blockstone$enumtype : values()) {
            META_LOOKUP[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
        }
    }

    private final int meta;
    private final String name;
    private final String unlocalizedName;
    private final MapColor mapColor;
    private final boolean isNatural;

    EnumNewStoneVariants(int p_i46383_3_, MapColor p_i46383_4_, String p_i46383_5_, boolean p_i46383_6_) {
        this(p_i46383_3_, p_i46383_4_, p_i46383_5_, p_i46383_5_, p_i46383_6_);
    }

    private EnumNewStoneVariants(int p_i46384_3_, MapColor p_i46384_4_, String p_i46384_5_, String p_i46384_6_, boolean p_i46384_7_) {
        this.meta = p_i46384_3_;
        this.name = p_i46384_5_;
        this.unlocalizedName = p_i46384_6_;
        this.mapColor = p_i46384_4_;
        this.isNatural = p_i46384_7_;
    }

    public static EnumNewStoneVariants byMetadata(int meta) {
        if (meta < 0 || meta >= META_LOOKUP.length) {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public int getMetadata() {
        return this.meta;
    }

    public MapColor getMapColor() {
        return this.mapColor;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    public boolean isNatural() {
        return this.isNatural;
    }

}
