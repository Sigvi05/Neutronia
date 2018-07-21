package net.hdt.neutronia.init;

import net.hdt.neutronia.properties.EnumCoralColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

public class NOreDict {

    public static void register() {
        /*for(EnumCoralColor coralColor : EnumCoralColor.values()) {
            String color = StringUtils.capitalize(coralColor.getName());
//            registerToOreDict(String.format("%sBrainCoral", coralColor.getName()), new ItemStack(NBlocks.brainCoral[coralColor.getMetadata()], 1));
//            registerToOreDict(String.format("dead%sBrainCoral", color), new ItemStack(NBlocks.deadBrainCoral[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("%sCoral", coralColor.getName()), new ItemStack(NBlocks.decorativeCoralBlock[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("dead%sCoral", color), new ItemStack(NBlocks.decorativeDeadCoralBlock[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("%sCoralFan", coralColor.getName()), new ItemStack(NBlocks.coralFan[coralColor.getMetadata()], 1));
            registerToOreDict(String.format("dead%sCoralFan", color), new ItemStack(NBlocks.deadCoralFan[coralColor.getMetadata()], 1));
        }*/
        for(EnumCoralColor coralColor : EnumCoralColor.values()) {
            String color = StringUtils.capitalize(coralColor.getNewName());
//            registerToOreDict(String.format("%sBrainCoral", coralColor.getName()), new ItemStack(NBlocks.brainCoral[coralColor.getMetadata()], 1));
//            registerToOreDict(String.format("dead%sBrainCoral", color), new ItemStack(NBlocks.deadBrainCoral[coralColor.getMetadata()], 1));
//            registerToOreDict(String.format("%sCoral", coralColor.getNewName()), new ItemStack(NBlocks.coralBlock[coralColor.getMetadata()], 1));
//            registerToOreDict(String.format("dead%sCoral", color), new ItemStack(NBlocks.deadCoralBlock[coralColor.getMetadata()], 1));
//            registerToOreDict(String.format("decorative%sCoral", color), new ItemStack(NBlocks.decorativeCoralBlock[coralColor.getMetadata()], 1));
//            registerToOreDict(String.format("deadDecorative%sCoral", color), new ItemStack(NBlocks.decorativeDeadCoralBlock[coralColor.getMetadata()], 1));
//            registerToOreDict(String.format("%sCoralFan", coralColor.getNewName()), new ItemStack(NBlocks.coralFan[coralColor.getMetadata()], 1));
//            registerToOreDict(String.format("dead%sCoralFan", color), new ItemStack(NBlocks.deadCoralFan[coralColor.getMetadata()], 1));
        }
    }

    public static void registerToOreDict(String name, ItemStack block) {
        OreDictionary.registerOre(name, block);
    }

}
