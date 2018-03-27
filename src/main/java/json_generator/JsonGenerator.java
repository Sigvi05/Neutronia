package json_generator;

import net.thegaminghuskymc.mcaddon.properties.EnumAquamarineVariants;
import net.thegaminghuskymc.mcaddon.properties.EnumCoralColor;
import net.thegaminghuskymc.mcaddon.properties.EnumNewStoneVariants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Locale;

import static net.thegaminghuskymc.huskylib2.json_generation.JsonGenerator.genBlock;
import static net.thegaminghuskymc.huskylib2.json_generation.JsonGenerator.genOrientedBlock;
import static net.thegaminghuskymc.huskylib2.json_generation.JsonGenerator.genSlabBlock;

public class JsonGenerator {

    public static void main(String[] args) {

        for (EnumCoralColor type : EnumCoralColor.values()) {
            /*genSlabBlock("hmca", type.getName() + "_brain_coral_slab", type.getName() + "_brain_coral", type.getName() + "_brain_coral");
            genSlabBlock("hmca", type.getName() + "_dead_brain_coral_slab", type.getName() + "_dead_brain_coral", type.getName() + "_dead_brain_coral");
            genSlabBlock("hmca", type.getName() + "_coral_slab", type.getName() + "_brain_coral", type.getName() + "_brain_coral");
            genSlabBlock("hmca", type.getName() + "_dead_coral_slab", type.getName() + "_coral", type.getName() + "_coral");*/
            /*genBlock("hmca", type.getName() + "_coral", type.getName() + "_coral");
            genBlock("hmca", type.getName() + "_dead_coral", type.getName() + "_dead_coral");
            genBlock("hmca", type.getName() + "_brain_coral", type.getName() + "_brain_coral");
            genBlock("hmca", type.getName() + "_dead_brain_coral", type.getName() + "_dead_brain_coral");
            genOrientedBlock("hmca", type.getName() + "_coral_fan", type.getName() + "_coral_fan", type.getName() + "_coral_fan", type.getName() + "_coral_fan");
            genOrientedBlock("hmca", type.getName() + "_dead_coral_fan", type.getName() + "_dead_coral_fan", type.getName() + "_dead_coral_fan", type.getName() + "_dead_coral_fan");
            genOrientedBlock("hmca", type.getName() + "_pipe_coral", type.getName() + "_pipe_coral", type.getName() + "_pipe_coral", type.getName() + "_pipe_coral");
            genOrientedBlock("hmca", type.getName() + "_dead_pipe_coral", type.getName() + "_dead_pipe_coral", type.getName() + "_dead_pipe_coral", type.getName() + "_dead_pipe_coral");
            genOrientedBlock("hmca", type.getName() + "_sea_fan", type.getName() + "_sea_fan", type.getName() + "_sea_fan", type.getName() + "_sea_fan");
            genOrientedBlock("hmca", type.getName() + "_dead_sea_fan", type.getName() + "_dead_sea_fan", type.getName() + "_dead_sea_fan", type.getName() + "_dead_sea_fan");*/
            genLangFile("hmca", type.getName() + "_brain_coral_slab", type.getName() + "_brain_coral_slab", "slabs");
            genLangFile("hmca", type.getName() + "_dead_brain_coral_slab", type.getName() + "_dead_brain_coral_slab", "slabs");
            genLangFile("hmca", type.getName() + "_coral_slab", type.getName() + "_coral_slab", "slabs");
            genLangFile("hmca", type.getName() + "_dead_coral_slab", type.getName() + "_dead_coral_slab" + "\n", "slabs");

            genLangFile("hmca", type.getName() + "_brain_coral_stairs", type.getName() + "_brain_coral_stairs", "stairs");
            genLangFile("hmca", type.getName() + "_dead_brain_coral_stairs", type.getName() + "_dead_brain_coral_stairs", "stairs");
            genLangFile("hmca", type.getName() + "_coral_stairs", type.getName() + "_coral_stairs", "stairs");
            genLangFile("hmca", type.getName() + "_dead_coral_stairs", type.getName() + "_dead_coral_stairs" + "\n", "stairs");

            genLangFile("hmca", type.getName() + "_coral", type.getName() + "_coral", "blocks");
            genLangFile("hmca", type.getName() + "_dead_coral", type.getName() + "_dead_coral", "blocks");
            genLangFile("hmca", type.getName() + "_brain_coral", type.getName() + "_brain_coral", "blocks");
            genLangFile("hmca", type.getName() + "_dead_brain_coral", type.getName() + "_dead_brain_coral", "blocks");
            genLangFile("hmca", type.getName() + "_coral_fan", type.getName() + "_coral_fan", "blocks");
            genLangFile("hmca", type.getName() + "_dead_coral_fan", type.getName() + "_dead_coral_fan", "blocks");
            genLangFile("hmca", type.getName() + "_pipe_coral", type.getName() + "_pipe_coral", "blocks");
            genLangFile("hmca", type.getName() + "_dead_pipe_coral", type.getName() + "_dead_pipe_coral", "blocks");
            genLangFile("hmca", type.getName() + "_sea_fan", type.getName() + "_sea_fan", "blocks");
            genLangFile("hmca", type.getName() + "_dead_sea_fan", type.getName() + "_dead_sea_fan" + "\n", "blocks");
            
        }

        for(EnumAquamarineVariants aquamarineVariants : EnumAquamarineVariants.values()) {
//            genBlock("hmca", aquamarineVariants.getName() + "_natural_aquamarine", aquamarineVariants.getName() + "_natural_aquamarine");
//            genBlock("hmca", aquamarineVariants.getName() + "_aquamarine", aquamarineVariants.getName() + "_aquamarine");
            genLangFile("hmca", aquamarineVariants.getName() + "_natural_aquamarine_slab", aquamarineVariants.getName() + "_natural_aquamarine_slab", "slabs");
            genLangFile("hmca", aquamarineVariants.getName() + "_aquamarine_slab", aquamarineVariants.getName() + "_aquamarine_slab" + "\n", "slabs");

            genLangFile("hmca", aquamarineVariants.getName() + "_natural_aquamarine_stairs", aquamarineVariants.getName() + "_natural_aquamarine_stairs", "stairs");
            genLangFile("hmca", aquamarineVariants.getName() + "_aquamarine_stairs", aquamarineVariants.getName() + "_aquamarine_stairs" + "\n", "stairs");

            genLangFile("hmca", aquamarineVariants.getName() + "_natural_aquamarine", aquamarineVariants.getName() + "_natural_aquamarine", "blocks");
            genLangFile("hmca", aquamarineVariants.getName() + "_aquamarine", aquamarineVariants.getName() + "_aquamarine" + "\n", "blocks");
        }

        for(EnumNewStoneVariants newStoneVariants : EnumNewStoneVariants.values()) {
//            genBlock("hmca", newStoneVariants.getName(), newStoneVariants.getName());
            genLangFile("hmca", newStoneVariants.getName() + "_slab", newStoneVariants.getName() + "_slab" + "\n", "slabs");

            genLangFile("hmca", newStoneVariants.getName() + "_stairs", newStoneVariants.getName() + "_stairs" + "\n", "stairs");

            genLangFile("hmca", newStoneVariants.getName() , newStoneVariants.getName() + "\n", "blocks");
        }

    }

    private static void genLangFile(String modid, String block_name, String unlocalized_name, String lang_file_name) {
        Path base = Paths.get("src", "main", "resources", "assets", modid, "lang");
        if( !base.toFile().exists() ) {
            base.toFile().mkdirs();
        }

        try( BufferedWriter w = Files.newBufferedWriter( base.resolve( String.format("%s.lang", lang_file_name) ), StandardOpenOption.CREATE, StandardOpenOption.APPEND) ) {
            String name = unlocalized_name.replace("_", " ");
            unlocalized_name = WordUtils.capitalizeFully(name);
            w.write("tile." + block_name + ".name=" + unlocalized_name + "\n");
        } catch(IOException e) {

        }

    }

}