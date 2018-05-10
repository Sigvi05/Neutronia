package net.hdt.neutronia.init;

import net.hdt.neutronia.properties.EnumCoralColor;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class NOreDict {

    public static void register() {
        for(EnumCoralColor coralColor : EnumCoralColor.values()) {
            registerToOreDict(String.format("%sBrainCoral", coralColor.getName()), NBlocks.brain_coral[coralColor.getMetadata()]);
            registerToOreDict(String.format("dead%sBrainCoral", coralColor.getNameNormalcase()), NBlocks.dead_brain_coral[coralColor.getMetadata()]);
            registerToOreDict(String.format("%sCoral", coralColor.getName()), NBlocks.normal_coral[coralColor.getMetadata()]);
            registerToOreDict(String.format("dead%sCoral", coralColor.getNameNormalcase()), NBlocks.dead_normal_coral[coralColor.getMetadata()]);
            registerToOreDict(String.format("%sCoralFan", coralColor.getName()), NBlocks.coral_fan[coralColor.getMetadata()]);
            registerToOreDict(String.format("dead%sCoralFan", coralColor.getNameNormalcase()), NBlocks.dead_coral_fan[coralColor.getMetadata()]);
        }
    }

    public static void registerToOreDict(String name, Item item) {
        OreDictionary.registerOre(name, item);
    }

    public static void registerToOreDict(String name, Block block) {
        OreDictionary.registerOre(name, block);
    }

}
