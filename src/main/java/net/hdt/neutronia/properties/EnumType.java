package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumType implements IStringSerializable {

    NORMAL(0, "normal"),
    HYDROUS(1, "hydrous"),
    SALTY(2, "salty"),
    STARRY(3, "starry"),
    BARREN(4, "barren");

    private int ID;
    private String name;

    EnumType(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public static EnumType fromMeta(int meta) {
        if (meta < 0 || meta >= values().length) {
            meta = 0;
        }

        return values()[meta];
    }

    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

}