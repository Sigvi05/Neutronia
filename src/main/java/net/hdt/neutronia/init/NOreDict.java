package net.hdt.neutronia.init;

import net.hdt.neutronia.properties.EnumCoralColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

public class NOreDict {

    public static void register() {
        for(EnumCoralColor coralColor : EnumCoralColor.values()) {
            String color = StringUtils.capitalize(coralColor.getName());
            registerToOreDict(String.format("%sBrainCoral", coralColor.getName()), new ItemStack(NBlocks.brain_coral[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("dead%sBrainCoral", color), new ItemStack(NBlocks.dead_brain_coral[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("%sCoral", coralColor.getName()), new ItemStack(NBlocks.normal_coral[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("dead%sCoral", color), new ItemStack(NBlocks.dead_normal_coral[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("%sCoralFan", coralColor.getName()), new ItemStack(NBlocks.coral_fan[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("dead%sCoralFan", color), new ItemStack(NBlocks.dead_coral_fan[coralColor.getMetadata()], 1));
        }
    }

    public static void registerToOreDict(String name, ItemStack block) {
        OreDictionary.registerOre(name, block);
    }

}
