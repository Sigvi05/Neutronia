package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumNaturalAquamarineVariants implements IStringSerializable {

    BRICKS(0, "natural_aquamarine_bricks"),
    CHISELED(0, "natural_chiseled_aquamarine"),
    RAW(0, "raw_natural_aquamarine"),
    SMALL_BRICKS(0, "small_natural_aquamarine_bricks"),
    SMOOTH(0, "natural_smooth_aquamarine");

    private String name;
    private int ID;

    EnumNaturalAquamarineVariants(int ID, String name) {
        this.name = name;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

}