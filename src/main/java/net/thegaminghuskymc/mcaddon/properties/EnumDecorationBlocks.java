package net.thegaminghuskymc.mcaddon.properties;

import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum EnumDecorationBlocks implements IStringSerializable
{
    YELLOW(0, "yellow"),
    PINK(1, "pink"),
    PURPLE(2, "purple"),
    BLUE(3, "blue"),
    RED(4, "red");

    private static final EnumDecorationBlocks[] META_LOOKUP = new EnumDecorationBlocks[values().length];
    private final int meta;
    private final String name;

    private EnumDecorationBlocks(int metaIn, String nameIn)
    {
        this.meta = metaIn;
        this.name = nameIn;
    }

    public int getMetadata()
    {
        return this.meta;
    }

    public static EnumDecorationBlocks byMetadata(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public String toString()
    {
        return this.name;
    }

    public String getName()
    {
        return this.name;
    }

    static
    {
        for (EnumDecorationBlocks enumdyecolor : values())
        {
            META_LOOKUP[enumdyecolor.getMetadata()] = enumdyecolor;
        }
    }
}