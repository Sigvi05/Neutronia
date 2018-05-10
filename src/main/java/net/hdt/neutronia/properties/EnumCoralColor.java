package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum EnumCoralColor implements IStringSerializable {

    YELLOW(0, "yellow", "Yellow", 16701501),
    PINK(1, "pink", "Pink", 15961002),
    PURPLE(2, "purple", "Purple", 8991416),
    BLUE(3, "blue", "Blue", 3949738),
    RED(4, "red", "Red", 11546150);

    private static final EnumCoralColor[] META_LOOKUP = new EnumCoralColor[values().length];

    static {
        for (EnumCoralColor enumdyecolor : values()) {
            META_LOOKUP[enumdyecolor.getMetadata()] = enumdyecolor;
        }
    }

    private final int meta;
    private final String name, nameNormalcase;
    private final int colorValue;
    private final float[] colorComponentValues;

    EnumCoralColor(int metaIn, String nameIn, String nameNormalcase, int colorValueIn) {
        this.meta = metaIn;
        this.name = nameIn;
        this.nameNormalcase = nameNormalcase;
        this.colorValue = colorValueIn;
        int i = (colorValueIn & 16711680) >> 16;
        int j = (colorValueIn & 65280) >> 8;
        int k = (colorValueIn & 255);
        this.colorComponentValues = new float[]{(float) i / 255.0F, (float) j / 255.0F, (float) k / 255.0F};
    }

    public static EnumCoralColor byMetadata(int meta) {
        if (meta < 0 || meta >= META_LOOKUP.length) {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public int getMetadata() {
        return this.meta;
    }

    @SideOnly(Side.CLIENT)
    public String getDyeColorName() {
        return this.name;
    }

    @SideOnly(Side.CLIENT)
    public int getColorValue() {
        return this.colorValue;
    }

    public float[] getColorComponentValues() {
        return this.colorComponentValues;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public String getNameNormalcase() {
        return nameNormalcase;
    }

}