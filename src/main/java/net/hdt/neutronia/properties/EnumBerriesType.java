package net.hdt.neutronia.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumBerriesType implements IStringSerializable {

    STRAWBERRY(0, "strawberry", "strawberry", 0.5, 0.5, 1),
    BLACKBERRY(1, "blackberry", "blackberry", 0.5, 0.5, 1),
    BLUEBERRY(2, "blueberry", "blueberry", 0.5, 0.5, 1),
    CHERRIES(3, "cherries", "cherries", 0.5, 0.5, 1),
    RASPBERRY_BLUE(4, "raspberry_blue", "raspberry_blue", 0.5, 0.5, 1),
    RASPBERRY_RED(5, "raspberry_red", "raspberry_red", 0.5, 0.5, 1);

    private String name, texture;
    private int ID, eatTime, saturation, health;

    EnumBerriesType(int ID, String name, String texture, double eatTime, double saturation, double health) {
        this.name = name;
        this.texture = texture;
        this.ID = ID;
        this.eatTime = (int) eatTime;
        this.saturation = (int) saturation;
        this.health = (int) health;
    }

    EnumBerriesType(int ID, String name, String texture, int eatTime, int saturation, int health) {
        this.name = name;
        this.texture = texture;
        this.ID = ID;
        this.eatTime = eatTime;
        this.saturation = saturation;
        this.health = health;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getEatTime() {
        return eatTime;
    }

    public void setEatTime(int eatTime) {
        this.eatTime = eatTime;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
