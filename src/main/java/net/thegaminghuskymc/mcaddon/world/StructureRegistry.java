package net.thegaminghuskymc.mcaddon.world;

import java.util.HashMap;
import java.util.Map;

public class StructureRegistry {
    public static Map<String, IGeneratable> structures = new HashMap<>();

    public StructureRegistry() {
    }

    public static String addStructure(String name, IGeneratable data) {
        structures.put(name, data);
        return name;
    }
}
