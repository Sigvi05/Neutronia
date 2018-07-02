package net.hdt.neutronia.init;

import net.hdt.neutronia.properties.EnumCoralColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

public class NOreDict {

    public static void register() {
        for(EnumCoralColor coralColor : EnumCoralColor.values()) {
            String color = StringUtils.capitalize(coralColor.getName());
            registerToOreDict(String.format("%sBrainCoral", coralColor.getName()), new ItemStack(NBlocks.brainCoral[coralColor.getMetadata()], 1));
            registerToOreDict("deadBrainCoral", new ItemStack(NBlocks.deadBrainCoral, 1));
            registerToOreDict(String.format("%sCoral", coralColor.getName()), new ItemStack(NBlocks.normalCoral[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("dead%sCoral", color), new ItemStack(NBlocks.deadNormalCoral[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("%sCoralFan", coralColor.getName()), new ItemStack(NBlocks.coralFan[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("dead%sCoralFan", color), new ItemStack(NBlocks.deadCoralFan[coralColor.getMetadata()], 1));
        }
    }

    public static void registerToOreDict(String name, ItemStack block) {
        OreDictionary.registerOre(name, block);
    }

}
