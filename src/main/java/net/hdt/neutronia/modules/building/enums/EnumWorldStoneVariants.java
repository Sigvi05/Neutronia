package net.hdt.neutronia.modules.building.enums;

import net.minecraft.util.IStringSerializable;

public enum EnumWorldStoneVariants implements IStringSerializable {

    ;

    private int ID;
    private String name;

    EnumWorldStoneVariants(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }
}
