package net.hdt.neutronia.dying_system_rewamp;

import net.minecraft.util.IStringSerializable;

import java.awt.*;

public enum EnumDyeColor implements IStringSerializable {

    LIGHT_YELLOW(0, 4, "light_yellow", "lightYellow", TextFormatting.LIGHT_YELLOW, new Color(0xF4FF00)),
    BEIGE(1, 3, "beige", "beige", TextFormatting.BEIGE, new Color(245,245,220)),
    PEACH(2, 2, "peach", "peach", TextFormatting.PEACH, new Color(245,245,220)),
    TAN(3, 1, "tan", "tan", TextFormatting.TAN, new Color(245,245,220)),
    LUMINOUS(4, 0, "luminous", "luminous", TextFormatting.LUMINOUS, new Color(245,245,220));

    private static final EnumDyeColor[] META_LOOKUP = new EnumDyeColor[values().length];
    private static final EnumDyeColor[] DYE_DMG_LOOKUP = new EnumDyeColor[values().length];

    static {
        for (EnumDyeColor enumdyecolor : values()) {
            META_LOOKUP[enumdyecolor.getMetadata()] = enumdyecolor;
            DYE_DMG_LOOKUP[enumdyecolor.getDyeDamage()] = enumdyecolor;
        }
    }

    private final int meta;
    private final int dyeDamage;
    private final String name;
    private final String unlocalizedName;
    /**
     * An array containing 3 floats ranging from 0.0 to 1.0: the red, green, and blue components of the corresponding
     * color.
     */
    private final float[] colorComponentValues;
    private final TextFormatting chatColor;
    private final Color color;

    EnumDyeColor(int metaIn, int dyeDamageIn, String nameIn, String unlocalizedNameIn, TextFormatting chatColorIn, Color colorValueIn) {
        this.meta = metaIn;
        this.dyeDamage = dyeDamageIn;
        this.name = nameIn;
        this.unlocalizedName = unlocalizedNameIn;;
        this.color = colorValueIn;
        this.chatColor = chatColorIn;
        int i = (colorValueIn.getRGB() & 16711680) >> 16;
        int j = (colorValueIn.getRGB() & 65280) >> 8;
        int k = (colorValueIn.getRGB() & 255);
        this.colorComponentValues = new float[] {(float)i / 255.0F, (float)j / 255.0F, (float)k / 255.0F};
    }

    public static EnumDyeColor byDyeDamage(int damage) {
        if (damage < 0 || damage >= DYE_DMG_LOOKUP.length) {
            damage = 0;
        }

        return DYE_DMG_LOOKUP[damage];
    }

    public static EnumDyeColor byMetadata(int meta) {
        if (meta < 0 || meta >= META_LOOKUP.length) {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public int getMetadata() {
        return this.meta;
    }

    public int getDyeDamage() {
        return this.dyeDamage;
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    public String toString() {
        return this.unlocalizedName;
    }

    public Color getColor() {
        return color;
    }

    public TextFormatting getChatColor() {
        return chatColor;
    }

    /**
     * Gets an array containing 3 floats ranging from 0.0 to 1.0: the red, green, and blue components of the
     * corresponding color.
     */
    public float[] getColorComponentValues()
    {
        return this.colorComponentValues;
    }

    public String getName() {
        return this.name;
    }
}