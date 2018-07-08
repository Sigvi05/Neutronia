package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum EnumCoralColor implements IStringSerializable {

    BLUE(0, "blue", "tube", 3949738),
    PINK(1, "pink", "brain", 15961002),
    PURPLE(2, "purple", "bubble", 8991416),
    RED(3, "red", "fire", 11546150),
    YELLOW(4, "yellow", "horn", 16701501);

    private static final EnumCoralColor[] META_LOOKUP = new EnumCoralColor[values().length];

    static {
        for (EnumCoralColor enumdyecolor : values()) {
            META_LOOKUP[enumdyecolor.getMetadata()] = enumdyecolor;
        }
    }

    private final int meta;
    private final String oldName, newName;
    private final int colorValue;
    private final float[] colorComponentValues;

    EnumCoralColor(int metaIn, String oldName, int colorValueIn) {
        this.meta = metaIn;
        this.oldName = oldName;
        this.newName = oldName;
        this.colorValue = colorValueIn;
        int i = (colorValueIn & 16711680) >> 16;
        int j = (colorValueIn & 65280) >> 8;
        int k = (colorValueIn & 255);
        this.colorComponentValues = new float[]{(float) i / 255.0F, (float) j / 255.0F, (float) k / 255.0F};
    }

    EnumCoralColor(int metaIn, String oldName, String newName, int colorValueIn) {
        this.meta = metaIn;
        this.oldName = oldName;
        this.newName = newName;
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

    public String getNewName() {
        return newName;
    }

    @SideOnly(Side.CLIENT)
    public int getColorValue() {
        return this.colorValue;
    }

    public float[] getColorComponentValues() {
        return this.colorComponentValues;
    }

    public String toString() {
        return this.oldName;
    }

    public String getName() {
        return this.oldName;
    }

}