package net.hdt.neutronia.dying_system_rewamp;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.TextFormatting;

import java.awt.*;

public enum EnumDyeColor implements IStringSerializable {

    WHITE(0, 15, "white", "white", TextFormatting.WHITE, new Color(16383998)),
    ORANGE(1, 14, "orange", "orange", TextFormatting.GOLD, new Color(16351261)),
    MAGENTA(2, 13, "magenta", "magenta", TextFormatting.AQUA, new Color(13061821)),
    LIGHT_BLUE(3, 12, "light_blue", "lightBlue", TextFormatting.BLUE, new Color(3847130)),
    YELLOW(4, 11, "yellow", "yellow", TextFormatting.YELLOW, new Color(16701501)),
    LIME(5, 10, "lime", "lime", TextFormatting.GREEN, new Color(8439583)),
    PINK(6, 9, "pink", "pink", TextFormatting.LIGHT_PURPLE, new Color(15961002)),
    GRAY(7, 8, "gray", "gray", TextFormatting.DARK_GRAY, new Color(4673362)),
    SILVER(8, 7, "silver", "silver", TextFormatting.GRAY, new Color(10329495)),
    CYAN(9, 6, "cyan", "cyan", TextFormatting.DARK_AQUA, new Color(11546150)),
    PURPLE(10, 5, "purple", "purple", TextFormatting.DARK_PURPLE, new Color(8991416)),
    BLUE(11, 4, "blue", "blue", TextFormatting.DARK_BLUE, new Color(3949738)),
    BROWN(12, 3, "brown", "brown", TextFormatting.GOLD, new Color(8606770)),
    GREEN(13, 2, "green", "green", TextFormatting.DARK_GREEN, new Color(6192150)),
    RED(14, 1, "red", "red", TextFormatting.DARK_RED, new Color(11546150)),
    BLACK(15, 0, "black", "black", TextFormatting.BLACK, new Color(1908001));

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