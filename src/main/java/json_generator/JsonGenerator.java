package json_generator;

import net.thegaminghuskymc.mcaddon.properties.EnumAquamarineVariants;
import net.thegaminghuskymc.mcaddon.properties.EnumNewStoneVariants;

import static net.thegaminghuskymc.huskylib2.json_generation.JsonGenerator.genBlock;

public class JsonGenerator {

    public static void main(String[] args) {

        /*for (EnumCoralColor type : EnumCoralColor.values()) {
            genBlock("mc_addon", type.getName() + "_coral", type.getName() + "_coral");
            genBlock("mc_addon", type.getName() + "_dead_coral", type.getName() + "_dead_coral");
            genBlock("mc_addon", type.getName() + "_brain_coral", type.getName() + "_brain_coral");
            genBlock("mc_addon", type.getName() + "_dead_brain_coral", type.getName() + "_dead_brain_coral");
            genOrientedBlock("mc_addon", type.getName() + "_coral_fan", type.getName() + "_coral_fan", type.getName() + "_coral_fan", type.getName() + "_coral_fan");
            genOrientedBlock("mc_addon", type.getName() + "_dead_coral_fan", type.getName() + "_dead_coral_fan", type.getName() + "_dead_coral_fan", type.getName() + "_dead_coral_fan");
            genOrientedBlock("mc_addon", type.getName() + "_pipe_coral", type.getName() + "_pipe_coral", type.getName() + "_pipe_coral", type.getName() + "_pipe_coral");
            genOrientedBlock("mc_addon", type.getName() + "_dead_pipe_coral", type.getName() + "_dead_pipe_coral", type.getName() + "_dead_pipe_coral", type.getName() + "_dead_pipe_coral");
            genOrientedBlock("mc_addon", type.getName() + "_sea_fan", type.getName() + "_sea_fan", type.getName() + "_sea_fan", type.getName() + "_sea_fan");
            genOrientedBlock("mc_addon", type.getName() + "_dead_sea_fan", type.getName() + "_dead_sea_fan", type.getName() + "_dead_sea_fan", type.getName() + "_dead_sea_fan");
        }*/

        for(EnumAquamarineVariants aquamarineVariants : EnumAquamarineVariants.values()) {
            genBlock("hmca", aquamarineVariants.getName() + "_natural_aquamarine", aquamarineVariants.getName() + "_natural_aquamarine");
            genBlock("hmca", aquamarineVariants.getName() + "_aquamarine", aquamarineVariants.getName() + "_aquamarine");
        }

        for(EnumNewStoneVariants newStoneVariants : EnumNewStoneVariants.values()) {
            genBlock("hmca", newStoneVariants.getName(), newStoneVariants.getName());
        }

    }

}