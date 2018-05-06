package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumCoralTypes implements IStringSerializable {

    BRAIN_CORAL(0, "brain_coral"),
    ELEGANCE_CORAL(1, "elegance_coral"),
    FIRE_CORAL(2, "fire_coral"),
    SEA_GRASS(3, "sea_grass"),
    LETTUCE_CORAL(4, "lettuce_coral"),
    MIXED_CORAL_PLATES(5, "mixed_coral_plates"),
    MIXED_CORAL_ROCKS(6, "mixed_coral_rocks"),
    STAGHORN_CORAL(7, "staghorn_coral"),
    LARGE_SEA_ANEMONE(8, "large_sea_anemone"),
    SMALL_SEA_URCHIN(9, "small_sea_urchin"),
    SMALL_SEA_ANEMONE(10, "small_sea_anemone"),
    LARGE_SEA_URCHIN(11, "large_sea_urchin"),
    BLADDERWRACK(12, "bladderwrack"),
    GRACILARIA(13, "gracilaria"),
    PYROPIA(14, "pyropia"),
    SEA_URCHIN_TROPICAL(15, "sea_urchin_tropical");

    private String name;
    private int ID;

    EnumCoralTypes(int ID, String name) {
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
