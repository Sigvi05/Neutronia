package net.hdt.neutronia.properties;

import net.hdt.neutronia.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public enum ChestType {
    NONE(""),
    SPRUCE("spruce"),
    BIRCH("birch"),
    JUNGLE("jungle"),
    ACACIA("acacia"),
    DARK_OAK("dark_oak"),
    REDWOOD("redwood"),
    PALM("palm"),
    CHERRY("cherry");

    public static final ChestType[] VALID_TYPES;
    public static final Map<String, ChestType> NAME_TO_TYPE;

    static {
        VALID_TYPES = new ChestType[]{SPRUCE, BIRCH, JUNGLE, ACACIA, DARK_OAK};
        NAME_TO_TYPE = new HashMap<>();
        for (ChestType type : VALID_TYPES)
            NAME_TO_TYPE.put(type.name, type);
    }

    public final String name;
    public final ResourceLocation nrmTex;
    public final ResourceLocation dblTex;
    public final ModelResourceLocation normalModel;
    public final ModelResourceLocation trapModel;

    ChestType(String name) {
        this.name = name;
        nrmTex = new ResourceLocation(Reference.MOD_ID, "textures/blocks/chests/" + name + ".png");
        dblTex = new ResourceLocation(Reference.MOD_ID, "textures/blocks/chests/" + name + "_double.png");

        normalModel = new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "custom_chest_" + name), "inventory");
        trapModel = new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "custom_chest_trap_" + name), "inventory");
    }

    public static ChestType getType(String type) {
        return NAME_TO_TYPE.getOrDefault(type, NONE);
    }
}