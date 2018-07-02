package json_generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import net.hdt.neutronia.properties.EnumAquamarineVariants;
import net.hdt.neutronia.properties.EnumCoralColor;
import net.hdt.neutronia.properties.EnumNaturalAquamarineVariants;
import net.hdt.neutronia.properties.EnumNewStoneVariants;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class JsonGenerator {

    private static String modid = "neutronia";

    public static void main(String[] args) {

        /*for(EnumCoralColor color : EnumCoralColor.values()) {
            genBlock(modid, color.getName() + "_brain_coral", color.getName() + "_brain_coral");
            genBlock(modid, color.getName() + "_brain_coral_dead", color.getName() + "_brain_coral_dead");
            genBlock(modid, color.getName() + "_coral", color.getName() + "_coral");
            genBlock(modid, color.getName() + "_dead_coral", color.getName() + "_dead_coral");
            genCoralFan(modid, color.getName() + "_coral_fan", color.getName() + "_coral_fan");
        }*/

        for(EnumNaturalAquamarineVariants naturalAquamarineVariants : EnumNaturalAquamarineVariants.values()) {
//            genBlock(modid, naturalAquamarineVariants.getName(), naturalAquamarineVariants.getName());
//            genLangFile(MOD_ID, naturalAquamarineVariants.getName(), naturalAquamarineVariants.getName(), "natural_aquamarine");
        }

        genSlab(new ResourceLocation(MOD_ID, "smooth_quartz_slab"), new ResourceLocation("quartz_block_bottom"), new ResourceLocation("quartz_block_bottom"), new ResourceLocation("quartz_block_bottom"));
        genSlab(new ResourceLocation(MOD_ID, "smooth_sandstone_slab"), new ResourceLocation("sandstone_top"), new ResourceLocation("sandstone_top"), new ResourceLocation("sandstone_top"));
        genSlab(new ResourceLocation(MOD_ID, "smooth_red_sandstone_slab"), new ResourceLocation("red_sandstone_top"), new ResourceLocation("red_sandstone_top"), new ResourceLocation("red_sandstone_top"));
        genSlab(new ResourceLocation(MOD_ID, "quartz_bricks_slab"), new ResourceLocation(MOD_ID, "quartz_bricks"), new ResourceLocation(MOD_ID,"quartz_bricks"), new ResourceLocation(MOD_ID,"quartz_bricks"));

        for(EnumAquamarineVariants aquamarineVariants : EnumAquamarineVariants.values()) {
//            genBlock(modid, aquamarineVariants.getName(), aquamarineVariants.getName());
//            genSlabBlock(modid, aquamarineVariants.getName() + "_slab", aquamarineVariants.getName(), aquamarineVariants.getName());
//            genLangFile(MOD_ID, aquamarineVariants.getName(), aquamarineVariants.getName(), "aquamarine");
//            genLangFile(MOD_ID, aquamarineVariants.getName() + "_slab", aquamarineVariants.getName() + "_slab", "aquamarine");
//            genLangFile(MOD_ID, aquamarineVariants.getName() + "_slab_double", aquamarineVariants.getName() + "_slab_double", "aquamarine");
        }

        /*for(EnumCoralTypes coralTypes : EnumCoralTypes.values()) {
            genPlant(modid, coralTypes.getName(), coralTypes.getName());
        }

        for(EnumNetherBlocks netherBlocks : EnumNetherBlocks.values()) {
            genBlock(modid, netherBlocks.getName(), netherBlocks.getName());
        }*/

        /*for(EnumDyeColor dyeColor : EnumDyeColor.values()) {
            genLangFile(modid, "frosted_" + dyeColor.getName() + "_terracotta", "frosted_" + dyeColor.getName() + "_terracotta", "colored_blocks");
            genLangFile(modid, "frosted_" + dyeColor.getName() + "_terracotta_slab", "frosted_" + dyeColor.getName() + "_terracotta_slab", "colored_blocks");
            genLangFile(modid, "frosted_" + dyeColor.getName() + "_terracotta_slab_double", "frosted_" + dyeColor.getName() + "_terracotta_slab_double", "colored_blocks");
            genLangFile(modid, "frosted_" + dyeColor.getName() + "_terracotta_stairs", "frosted_" + dyeColor.getName() + "_terracotta_stairs", "colored_blocks");
            genLangFile(modid, dyeColor.getName() + "_colored_vase", dyeColor.getName() + "_colored_vase", "colored_blocks");
        }*/

        /*for (EnumAquamarineVariants aquamarineVariants : EnumAquamarineVariants.values()) {
            genLangFile(modid, aquamarineVariants.getName(), aquamarineVariants.getName(), "aquamarine");
        }

        for (EnumNaturalAquamarineVariants naturalAquamarineVariants : EnumNaturalAquamarineVariants.values()) {
            genLangFile(modid, naturalAquamarineVariants.getName(), naturalAquamarineVariants.getName(), "natural_aquamarine");
        }

        for (EnumNetherBlocks netherBlockTypes : EnumNetherBlocks.values()) {
            genLangFile(modid, netherBlockTypes.getName(), netherBlockTypes.getName(), "nether_blocks");
            genLangFile(modid, netherBlockTypes.getName(), netherBlockTypes.getName(), "nether_blocks");
            genLangFile(modid, netherBlockTypes.getName(), netherBlockTypes.getName(), "nether_blocks");
            genLangFile(modid, netherBlockTypes.getName(), netherBlockTypes.getName(), "nether_blocks");
        }
        for (EnumSoulStoneTypes soulStoneTypes : EnumSoulStoneTypes.values()) {
            genLangFile(modid, soulStoneTypes.getName(), soulStoneTypes.getName(), "nether_blocks");
            genLangFile(modid, soulStoneTypes.getName(), soulStoneTypes.getName(), "nether_blocks");
            genLangFile(modid, soulStoneTypes.getName(), soulStoneTypes.getName(), "nether_blocks");
            genLangFile(modid, soulStoneTypes.getName(), soulStoneTypes.getName(), "nether_blocks");
        }
        for (EnumGlowingNetherBlocks enumGlowingNetherBlocks : EnumGlowingNetherBlocks.values()) {
            genLangFile(modid, enumGlowingNetherBlocks.getName(), enumGlowingNetherBlocks.getName(), "nether_blocks");
            genLangFile(modid, enumGlowingNetherBlocks.getName() + "_slab", enumGlowingNetherBlocks.getName(), "nether_blocks");
            genLangFile(modid, enumGlowingNetherBlocks.getName() + "_slab_double", enumGlowingNetherBlocks.getName(), "nether_blocks");
            genLangFile(modid, enumGlowingNetherBlocks.getName() + "_stairs", enumGlowingNetherBlocks.getName(), "nether_blocks");
        }
        for (EnumNetherPlantTypes netherPlantTypes : EnumNetherPlantTypes.values()) {
            genLangFile(modid, netherPlantTypes.getName(), netherPlantTypes.getName(), "nether_blocks");
        }
        for (EnumTallNetherPlantTypes netherPlantTypes : EnumTallNetherPlantTypes.values()) {
            genLangFile(modid, netherPlantTypes.getName(), netherPlantTypes.getName(), "nether_blocks");
        }

        for (BlockPlanks.EnumType woodVariants : BlockPlanks.EnumType.values()) {
        }*/

//        genRecipe(modid, "obsidian_axe", true, "OO ", "OS ", " S ", new String[]{ "O", "S" }, new String[]{ "minecraft:obsidian", "minecraft:stick" }, new int[]{ 0, 0 }, "neutronia:obsidian_axe", "Neutronia", 1);
//        genRecipe(modid, "obsidian_shovel", true, " O ", " S ", " S ", new String[]{ "O", "S" }, new String[]{ "minecraft:obsidian", "minecraft:stick" }, new int[]{ 0, 0 }, "neutronia:obsidian_shovel", "Neutronia", 1);
//        genRecipe(modid, "obsidian_pickaxe", true, "OOO", " S ", " S ", new String[]{ "O", "S" }, new String[]{ "minecraft:obsidian", "minecraft:stick" }, new int[]{ 0, 0 }, "neutronia:obsidian_pickaxe", "Neutronia", 1);
//        genRecipe(modid, "obsidian_sword", true, " O ", " O ", " S ", new String[]{ "O", "S" }, new String[]{ "minecraft:obsidian", "minecraft:stick" }, new int[]{ 0, 0 }, "neutronia:obsidian_sword", "Neutronia", 1);

//        genSlabBlock(modid, "smooth_basalt_slab", "basalt_smooth", "basalt_smooth", "basalt_smooth", "smooth_basalt");

        for (EnumNewStoneVariants newStoneVariants : EnumNewStoneVariants.values()) {
//            genLangFile(modid, newStoneVariants.getName(), newStoneVariants.getName(), "stones");
//            genLangFile(modid, newStoneVariants.getName() + "_slab", newStoneVariants.getName() + "_slab", "stones");
//            genLangFile(modid, newStoneVariants.getName() + "_slab_double", newStoneVariants.getName() + "_slab_double", "stones");
//            genLangFile(modid, newStoneVariants.getName() + "_stairs", newStoneVariants.getName() + "_stairs", "stones");
//            genBlock(modid, newStoneVariants.getName(), newStoneVariants.getName());
//            genStair(modid, newStoneVariants.getName() + "_stair", newStoneVariants.getName(), newStoneVariants.getName(), newStoneVariants.getName());
//            genSlabBlock(modid, newStoneVariants.getName() + "_slab", newStoneVariants.getName(), newStoneVariants.getName());
        }

//        genModInfo(modid, "Neutronia", "0.0.1", "1.12.2", new String[]{"TheGamingHuskyMC"}, new String[]{""}, " ", "This is a moon file", "This is the credits things", " ", " ");

        for(EnumDyeColor color : EnumDyeColor.values()) {
//            genOrientedBlock(modid, String.format("%s_glazed_terracotta_pillar", color.getName()), String.format("%s_glazed_terracotta_pillar_top", color.getName()), String.format("%s_glazed_terracotta_pillar", color.getName()), String.format("%s_glazed_terracotta_pillar", color.getName()));
//            genOrientedBlock(modid, String.format("%s_terracotta_pillar", color.getName()), String.format("%s_terracotta_pillar_top", color.getName()), String.format("%s_terracotta_pillar", color.getName()), String.format("%s_terracotta_pillar", color.getName()));

//            genSlabBlock(modid, String.format("frosted_%s_terracotta_slab", color.getName()), String.format("frosted_%s_terracotta", color.getName()), String.format("frosted_%s_terracotta", color.getName()));
//            genSlabBlock(modid, String.format("%s_glazed_terracotta_slab", color.getName()), String.format("%s_glazed_terracotta", color.getName()), String.format("%s_glazed_terracotta", color.getName()));
//            genSlabBlock(modid, String.format("%s_terracotta_slab", color.getName()), String.format("hardened_clay_stained_%s", color.getName()), String.format("hardened_clay_stained_%s", color.getName()));
//            genLangFile(modid, String.format("frozen_%s_terracotta", color.getName()), String.format("frozen_%s_terracotta", color.getName()), "frozen_colored_blocks");
//            genLangFile(modid, String.format("frozen_%s_terracotta_slab", color.getName()), String.format("frozen_%s_terracotta_slab", color.getName()), "frozen_colored_blocks");
//            genLangFile(modid, String.format("%s_terracotta_slab", color.getName()), String.format("%s_terracotta_slab", color.getName()), "colored_blocks");
//            genLangFile(modid, String.format("%s_glazed_terracotta_slab", color.getName()), String.format("%s_glazed_terracotta_slab", color.getName()), "colored_blocks");
//            genLangFile(modid, String.format("%s_terracotta_stairs", color.getName()), String.format("%s_terracotta_stairs", color.getName()), "colored_blocks");
//            genLayeredSlab(modid, String.format("frozen_%s_terracotta_slab", color.getName()), new ResourceLocation(String.format("blocks/hardened_clay_stained_%s", color.getName())), new ResourceLocation(modid, "blocks/ice_packed"));


//            genSlab(new ResourceLocation(modid, String.format("%s_terracotta_slab", color.getName())), new ResourceLocation(String.format("hardened_clay_stained_%s", color.getName())), new ResourceLocation(String.format("hardened_clay_stained_%s", color.getName())), new ResourceLocation(String.format("hardened_clay_stained_%s", color.getName())));
//            genStair("minecraft", String.format("%s_terracotta_stair", color.getName()), String.format("hardened_clay_stained_%s", color.getName()), String.format("hardened_clay_stained_%s", color.getName()), String.format("hardened_clay_stained_%s", color.getName()));
//
//            genSlab(new ResourceLocation(modid, String.format("%s_glazed_terracotta_slab", color.getName())), new ResourceLocation(String.format("glazed_terracotta_%s", color.getName())), new ResourceLocation(String.format("glazed_terracotta_%s", color.getName())), new ResourceLocation(String.format("glazed_terracotta_%s", color.getName())));
//            genStair("minecraft", String.format("%s_glazed_terracotta_stair", color.getName()), String.format("glazed_terracotta_%s", color.getName()), String.format("glazed_terracotta_%s", color.getName()), String.format("glazed_terracotta_%s", color.getName()));
        }

        for(EnumCoralColor coralColor : EnumCoralColor.values()) {
//            genCoralFan(modid, String.format("%s_dead_coral_fan", coralColor.getName()), String.format("coral_fan_%s_dead", coralColor.getName()));
//            genCoralFan(modid, String.format("%s_coral_fan", coralColor.getName()), String.format("coral_fan_%s", coralColor.getName()));
//            genCoralFan(modid, String.format("%s_coral_plant", coralColor.getName()), String.format("coral_plant_%s", coralColor.getName()));
//            genCoralFan(modid, String.format("%s_dead_coral_fan", coralColor.getName()), String.format("coral_plant_%s_dead", coralColor.getName()));
        }

        for(BlockPlanks.EnumType enumType : BlockPlanks.EnumType.values()) {
//            genOrientedBlock(modid, String.format("stripped_%s_log", enumType.getName()), String.format("stripped_%s_log_top", enumType.getName()), String.format("stripped_%s_log", enumType.getName()), String.format("stripped_%s_log", enumType.getName()));
//            genBlock(modid, String.format("stripped_%s_bark", enumType.getName()), String.format("stripped_%s_log", enumType.getName()));
//            genBlock("minecraft", String.format("%s_bark", enumType.getName()), String.format("log_%s", enumType.getName()));
//            genBlock(modid, String.format("unnamed_%s_bark_chiseled", enumType.getName()), String.format("%s_bark_top", enumType.getName()));
//            genBlock(modid, String.format("%s_bark_chiseled", enumType.getName()), String.format("%s_chiseled", enumType.getName()));
//            genItemModel(modid, String.format("%s_bark_item", enumType.getName()), String.format("%s_bark", enumType.getName()));
//            genLangFile(MOD_ID, String.format("%s_bark", enumType.getName()), String.format("%s_bark", enumType.getName()), "wood_blocks");
//            genLangFile(MOD_ID, String.format("%s_bark_chiseled", enumType.getName()), String.format("%s_bark_chiseled", enumType.getName()), "wood_blocks");
//            genLangFile(MOD_ID, String.format("unnamed_%s_bark_chiseled", enumType.getName()), String.format("unnamed_%s_bark_chiseled", enumType.getName()), "wood_blocks");
//            genLangFile(MOD_ID, String.format("%s_log_pole", enumType.getName()), String.format("%s_log_pole", enumType.getName()), "wood_blocks");
//            genLangFile(MOD_ID, String.format("stripped_%s_log", enumType.getName()), String.format("stripped_%s_log", enumType.getName()), "wood_blocks");
//            genLangFile(MOD_ID, String.format("stripped_%s_bark", enumType.getName()), String.format("stripped_%s_bark", enumType.getName()), "wood_blocks");
//            genLangFile(MOD_ID, String.format("stripped_%s_log_pole", enumType.getName()), String.format("stripped_%s_log_pole", enumType.getName()), "wood_blocks");
//            genLangFile(MOD_ID, String.format("%s_plank_pole", enumType.getName()), String.format("%s_plank_pole", enumType.getName()), "wood_blocks");
        }

    }

    public static void genBlock(String modId, String blockName, String textureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("model", "cube_all");

        JsonObject textures = new JsonObject();
        textures.addProperty("all", modId + ":blocks/" + textureName);
        defaults.add("textures", textures);

        defaults.addProperty("transform", "forge:default-block");
        root.add("defaults", defaults);

        JsonObject variants = new JsonObject();

        JsonArray empty = new JsonArray();
        empty.add(new JsonObject());

        variants.add("normal", empty);
        variants.add("inventory", empty);
        root.add("variants", variants);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

//        genBlockModel(modId, blockName, textureName);
        genBlockItemModel(modId, blockName, textureName);
    }

    public static void genBlockModel(String modId, String blockName, String textureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "block");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "block/cube_all");

        JsonObject textures = new JsonObject();
        textures.addProperty("all", modId + ":blocks/" + textureName);
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    public static void genBlockItemModel(String modId, String blockName, String textureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "block/cube_all");

        JsonObject textures = new JsonObject();
        textures.addProperty("all", modId + ":blocks/" + textureName);
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    //SS

    private static void genCoralFan(String modId, String blockName, String textureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("transform", "forge:default-block");
        defaults.addProperty("model", modId + ":" + blockName);
        root.add("defaults", defaults);

        JsonObject variants = new JsonObject();
        JsonObject facing = new JsonObject();
        facing.add("north", new JsonObject());

        JsonObject south = new JsonObject();
        south.addProperty("y", "90");
        facing.add("south", south);

        JsonObject east = new JsonObject();
        east.addProperty("y", "180");
        facing.add("east", east);

        JsonObject west = new JsonObject();
        west.addProperty("y", "270");
        facing.add("west", west);

        variants.add("facing", facing);
        variants.add("inventory", new JsonObject());
        root.add("variants", variants);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            System.out.print(String.format("Created file with the name %s" + "\n", blockName));
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }
        genCoralFanModel(modId, blockName, textureName);
        genCoralFanItemModel(modId, blockName, textureName);
    }

    public static void genCoralFanModel(String modId, String blockName, String textureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "block");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "neutronia:block/coralFan");

        JsonObject textures = new JsonObject();
        textures.addProperty("fan", modId + ":blocks/" + textureName);
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    public static void genCoralFanItemModel(String modId, String blockName, String textureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "item/generated");

        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", modId + ":blocks/" + textureName);
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    public static void genPlant(String modId, String blockName, String textureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("model", modId + ":" + blockName);
        defaults.addProperty("transform", "forge:default-block");
        root.add("defaults", defaults);

        JsonObject variants = new JsonObject();

        JsonArray empty = new JsonArray();
        empty.add(new JsonObject());

        variants.add("normal", empty);
        variants.add("inventory", empty);
        root.add("variants", variants);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

        genPlantBlockModel(modId, blockName, textureName);
        genPlantItemModel(modId, blockName, textureName);
    }

    public static void genPlantBlockModel(String modId, String blockName, String textureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "block");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "block/cross");

        JsonObject textures = new JsonObject();
        textures.addProperty("cross", modId + ":blocks/" + textureName);
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    public static void genPlantItemModel(String modId, String blockName, String textureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "item/generated");

        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", modId + ":blocks/" + textureName);
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    public static void genOrientedBlock(String modId, String blockName, String topTextureName, String frontTextureName, String sidesTextureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("model", modId + ":" + blockName);
        defaults.addProperty("transform", "forge:default-block");
        root.add("defaults", defaults);

        JsonObject variants = new JsonObject();

        JsonObject facing = new JsonObject();
        facing.add("north", new JsonObject());

        JsonObject south = new JsonObject();
        south.addProperty("y", "90");
        facing.add("south", south);

        JsonObject east = new JsonObject();
        east.addProperty("y", "180");
        facing.add("east", east);

        JsonObject west = new JsonObject();
        west.addProperty("y", "270");
        facing.add("west", west);

        variants.add("facing", facing);

        JsonArray empty = new JsonArray();
        empty.add(new JsonObject());

        variants.add("inventory", empty);
        root.add("variants", variants);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

        genBlockOrientedModel(modId, blockName, topTextureName, frontTextureName, sidesTextureName);
        genBlockOrientedItemModel(modId, blockName);
    }

    public static void genBlockOrientedModel(String modId, String blockName, String topTextureName, String frontTextureName, String sidesTextureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "block");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "block/orientable");

        JsonObject textures = new JsonObject();
        textures.addProperty("top", modId + ":blocks/" + topTextureName);
        textures.addProperty("front", modId + ":blocks/" + frontTextureName);
        textures.addProperty("side", modId + ":blocks/" + sidesTextureName);
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    public static void genBlockOrientedItemModel(String modId, String blockName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "models", "item").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();

            jw.name("_comment").value("Generated using Husky's JSON Generator v3.");
            jw.name("parent").value(modId + ":block/" + blockName);

            jw.endObject();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void genStair(String modId, String blockName, String topTexture, String sideTexture, String bottomTexture) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonArray empty = new JsonArray();
        empty.add(new JsonObject());

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();

        JsonObject textures = new JsonObject();
        textures.addProperty("bottom", modId + ":blocks/" + bottomTexture);
        textures.addProperty("side", modId + ":blocks/" + sideTexture);
        textures.addProperty("top", modId + ":blocks/" + topTexture);

        defaults.add("textures", textures);
        defaults.addProperty("transform", "forge:default-block");
        root.add("defaults", defaults);

        JsonObject variants = new JsonObject();

        JsonObject straight = new JsonObject();
        straight.addProperty("model", "minecraft:stairs");
        straight.addProperty("y", 270);
        straight.addProperty("uvlock", true);

        JsonObject innerLeft = new JsonObject();
        innerLeft.addProperty("model", "minecraft:inner_stairs");
        innerLeft.addProperty("y", 270);
        innerLeft.addProperty("uvlock", true);

        JsonObject innerRight = new JsonObject();
        innerRight.addProperty("model", "minecraft:inner_stairs");
        innerRight.addProperty("y", 270);
        innerRight.addProperty("uvlock", true);

        JsonObject outerLeft = new JsonObject();
        innerLeft.addProperty("model", "minecraft:outer_stairs");
        innerLeft.addProperty("y", 270);
        innerLeft.addProperty("uvlock", true);

        JsonObject outerRight = new JsonObject();
        innerRight.addProperty("model", "minecraft:outer_stairs");
        innerRight.addProperty("y", 270);
        innerRight.addProperty("uvlock", true);

        for (EnumFacing facing : EnumFacing.values()) {
            for (BlockStairs.EnumHalf enumHalf : BlockStairs.EnumHalf.values()) {
                for (BlockStairs.EnumShape enumShape : BlockStairs.EnumShape.values()) {
                    if (Objects.equals(enumShape.getName(), "straight")) {
                        variants.add(String.format("facing=%s,half=%s,shape=%s", facing.getName(), enumHalf.getName(), enumShape.getName()), straight);
                    }
                    if (Objects.equals(enumShape.getName(), "inner_left")) {
                        variants.add(String.format("facing=%s,half=%s,shape=%s", facing.getName(), enumHalf.getName(), enumShape.getName()), innerLeft);
                    }
                    if (Objects.equals(enumShape.getName(), "inner_right")) {
                        variants.add(String.format("facing=%s,half=%s,shape=%s", facing.getName(), enumHalf.getName(), enumShape.getName()), innerRight);
                    }
                    if (Objects.equals(enumShape.getName(), "outer_left")) {
                        variants.add(String.format("facing=%s,half=%s,shape=%s", facing.getName(), enumHalf.getName(), enumShape.getName()), outerLeft);
                    }
                    if (Objects.equals(enumShape.getName(), "outer_right")) {
                        variants.add(String.format("facing=%s,half=%s,shape=%s", facing.getName(), enumHalf.getName(), enumShape.getName()), outerRight);
                    }
                }
            }
        }

        variants.add("inventory", empty);
        root.add("variants", variants);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }
        genStairItemModel(modId, blockName, topTexture, sideTexture, bottomTexture);
    }

    public static void genStairItemModel(String modId, String blockName, String topTexture, String sideTexture, String bottomTexture) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "block/stairs");

        JsonObject textures = new JsonObject();
        textures.addProperty("bottom", modId + ":blocks/" + bottomTexture);
        textures.addProperty("side", modId + ":blocks/" + sideTexture);
        textures.addProperty("top", modId + ":blocks/" + topTexture);
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }



    public static void genTest(String modId, String blockName, String topTexture, String sideTexture, String bottomTexture) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonArray empty = new JsonArray();
        empty.add(new JsonObject());

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();

        JsonObject textures = new JsonObject();
        textures.addProperty("bottom", modId + ":blocks/" + bottomTexture);
        textures.addProperty("side", modId + ":blocks/" + sideTexture);
        textures.addProperty("top", modId + ":blocks/" + topTexture);

        defaults.add("textures", textures);
        defaults.addProperty("transform", "forge:default-block");
        root.add("defaults", defaults);

        JsonObject variants = new JsonObject();

        JsonObject facing = new JsonObject();
        facing.add("north", new JsonObject());

        JsonObject south = new JsonObject();
        south.addProperty("y", "90");
        facing.add("south", south);

        JsonObject east = new JsonObject();
        east.addProperty("y", "180");
        facing.add("east", east);

        JsonObject west = new JsonObject();
        west.addProperty("y", "270");
        facing.add("west", west);

        variants.add("facing", facing);

        variants.add("inventory", empty);
        root.add("variants", variants);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }
        genStairItemModel(modId, blockName, topTexture, sideTexture, bottomTexture);
    }

    public static void genTestItemModel(String modId, String blockName, String topTexture, String sideTexture, String bottomTexture) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "block/stairs");

        JsonObject textures = new JsonObject();
        textures.addProperty("bottom", modId + ":blocks/" + bottomTexture);
        textures.addProperty("side", modId + ":blocks/" + sideTexture);
        textures.addProperty("top", modId + ":blocks/" + topTexture);
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }



    public static void genPressurePlateBlock(String modId, String blockName, String textureName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "blockstates").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using Husky's JSON Generator v3.");
            jw.name("variants");
            jw.beginObject();

            jw.name("powered=false");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_up");
            jw.endObject();

            jw.name("powered=true");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_down");
            jw.endObject();

            jw.endObject();
            jw.endObject();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        genBlockPressurePlateModel(modId, blockName, textureName);
        genBlockPressurePlateItemModel(modId, blockName);

    }

    public static void genBlockPressurePlateModel(String modId, String blockName, String textureName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "models", "block").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_up" + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using Husky's JSON Generator v3.");
            jw.name("parent").value("block/pressure_plate_up");
            jw.name("textures");
            jw.beginObject();
            jw.name("texture").value(modId + ":blocks/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_down" + ".json"), "UTF-8");
            JsonWriter jw2 = gson.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("_comment").value("Generated using Husky's JSON Generator v3.");
            jw2.name("parent").value("block/pressure_plate_down");
            jw2.name("textures");
            jw2.beginObject();
            jw2.name("texture").value(modId + ":blocks/" + textureName);
            jw2.endObject();
            jw2.endObject();

            writer2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void genBlockPressurePlateItemModel(String modId, String blockName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "models", "item").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();

            jw.name("_comment").value("Generated using Husky's JSON Generator v3.");
            jw.name("parent").value(modId + ":block/" + blockName + "_up");

            jw.endObject();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void genSlab(ResourceLocation modIDAndName, ResourceLocation topTextureLocation, ResourceLocation sideTextureLocation, ResourceLocation bottomTextureLocation) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIDAndName.getResourceDomain(), "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("forge_marker", 1);

        JsonObject variants = new JsonObject();

        JsonObject half = new JsonObject();

        JsonObject upper = new JsonObject();
        upper.addProperty("model", modIDAndName.getResourceDomain() + ":upper_" + modIDAndName.getResourcePath());
        half.add("top", upper);

        JsonObject lower = new JsonObject();
        lower.addProperty("model", modIDAndName.getResourceDomain() + ":half_" + modIDAndName.getResourcePath());
        half.add("bottom", lower);

        variants.add("half", half);

        root.add("variants", variants);

        String json = gson.toJson(root);

        JsonObject root2 = new JsonObject();
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root2.addProperty("forge_marker", 1);

        JsonObject variants2 = new JsonObject();

        JsonObject prop = new JsonObject();

        JsonObject blarg = new JsonObject();
        blarg.addProperty("model", "cube_all");

        JsonObject textures = new JsonObject();
        textures.addProperty("all", sideTextureLocation.getResourceDomain() + ":blocks/" + sideTextureLocation.getResourcePath());

        blarg.add("textures", textures);

        prop.add("blarg", blarg);

        variants2.add("prop", prop);

        root2.add("variants", variants2);

        String json2 = gson.toJson(root2);

        try {
            FileUtils.writeStringToFile(base.resolve(modIDAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            FileUtils.writeStringToFile(base.resolve(modIDAndName.getResourcePath() + "_double.json").toFile(), StringEscapeUtils.unescapeJson(json2), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIDAndName.getResourcePath()));
        }

        genSlabBlockModel(modIDAndName, topTextureLocation, sideTextureLocation, bottomTextureLocation);
        genSlabItemModel(modIDAndName.getResourceDomain(), modIDAndName.getResourcePath());

    }

    public static void genSlabBlock(String modId, String blockName, String bottomTexture, String sideTexture, String topTexture, String blockMockName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("forge_marker", 1);

        JsonObject variants = new JsonObject();

        JsonObject half = new JsonObject();

        JsonObject upper = new JsonObject();
        upper.addProperty("model", modId + ":upper_" + blockName);
        half.add("top", upper);

        JsonObject lower = new JsonObject();
        lower.addProperty("model", modId + ":half_" + blockName);
        half.add("bottom", lower);

        variants.add("half", half);

        root.add("variants", variants);

        String json = gson.toJson(root);

        JsonObject root2 = new JsonObject();
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root2.addProperty("forge_marker", 1);

        JsonObject variants2 = new JsonObject();

        JsonObject prop = new JsonObject();

        JsonObject blarg = new JsonObject();
        blarg.addProperty("model", modId + ":upper_" + blockName);

        prop.add("blarg", blarg);

        variants2.add("prop", prop);

        root2.add("variants", variants2);

        String json2 = gson.toJson(root2);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            FileUtils.writeStringToFile(base.resolve(blockName + "_double.json").toFile(), StringEscapeUtils.unescapeJson(json2), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

//        genSlabBlockModel(modId, blockName, bottomTexture, sideTexture, topTexture);
//        genSlabItemModel(modId, blockName);

    }

    public static void genSlabBlockModel(ResourceLocation modIDAndName, ResourceLocation topTextureLocation, ResourceLocation sideTextureLocation, ResourceLocation bottomTextureLocation) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIDAndName.getResourceDomain(), "models", "block");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "neutronia:block/slab");

        JsonObject textures = new JsonObject();
        textures.addProperty("bottom", bottomTextureLocation.getResourceDomain() + ":blocks/" + bottomTextureLocation.getResourcePath());
        textures.addProperty("side", sideTextureLocation.getResourceDomain() + ":blocks/" + sideTextureLocation.getResourcePath());
        textures.addProperty("top", topTextureLocation.getResourceDomain() + ":blocks/" + topTextureLocation.getResourcePath());
        root.add("textures", textures);

        String json = gson.toJson(root);

        JsonObject root2 = new JsonObject();
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root2.addProperty("parent", "neutronia:block/slab_top");

        JsonObject textures2 = new JsonObject();
        textures2.addProperty("bottom", bottomTextureLocation.getResourceDomain() + ":blocks/" + bottomTextureLocation.getResourcePath());
        textures2.addProperty("side", sideTextureLocation.getResourceDomain() + ":blocks/" + sideTextureLocation.getResourcePath());
        textures2.addProperty("top", topTextureLocation.getResourceDomain() + ":blocks/" + topTextureLocation.getResourcePath());
        root2.add("textures", textures2);

        String json2 = gson.toJson(root2);

        try {
            FileUtils.writeStringToFile(base.resolve("half_" + modIDAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            FileUtils.writeStringToFile(base.resolve("upper_" + modIDAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json2), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIDAndName.getResourcePath()));
        }

    }

    public static void genSlabItemModel(String modId, String blockName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", modId + ":block/" + "half_" + blockName);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    public static void genSlabBlock(String modId, String blockName, String textureName, String blockMockName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("forge_marker", 1);

        JsonObject variants = new JsonObject();

        JsonObject half = new JsonObject();

        JsonObject upper = new JsonObject();
        upper.addProperty("model", modId + ":upper_" + blockName);
        half.add("top", upper);

        JsonObject lower = new JsonObject();
        lower.addProperty("model", modId + ":half_" + blockName);
        half.add("bottom", lower);

        variants.add("half", half);

        root.add("variants", variants);

        String json = gson.toJson(root);

        JsonObject root2 = new JsonObject();
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root2.addProperty("forge_marker", 1);

        JsonObject variants2 = new JsonObject();

        JsonObject prop = new JsonObject();

        JsonObject blarg = new JsonObject();
        blarg.addProperty("model", "cube_all");

        JsonObject textures = new JsonObject();
        textures.addProperty("all", modId + ":blocks/" + textureName);

        blarg.add("textures", textures);

        prop.add("blarg", blarg);

        variants2.add("prop", prop);

        root2.add("variants", variants2);

        String json2 = gson.toJson(root2);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            FileUtils.writeStringToFile(base.resolve(blockName + "_double.json").toFile(), StringEscapeUtils.unescapeJson(json2), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

//        genSlabBlockModel(modId, blockName, textureName, textureName, textureName);
//        genSlabItemModel(modId, blockName);

    }

    public static void genLayeredSlab(String modId, String blockName, ResourceLocation mainTexture, ResourceLocation overlayTexture) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("forge_marker", 1);

        JsonObject variants = new JsonObject();

        JsonObject half = new JsonObject();

        JsonObject upper = new JsonObject();
        upper.addProperty("model", modId + ":upper_" + blockName);
        half.add("top", upper);

        JsonObject lower = new JsonObject();
        lower.addProperty("model", modId + ":half_" + blockName);
        half.add("bottom", lower);

        variants.add("half", half);

        root.add("variants", variants);

        String json = gson.toJson(root);

        JsonObject root2 = new JsonObject();
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root2.addProperty("forge_marker", 1);

        JsonObject variants2 = new JsonObject();

        JsonObject prop = new JsonObject();

        JsonObject blarg = new JsonObject();
        blarg.addProperty("model", modId + ":upper_" + blockName);

        prop.add("blarg", blarg);

        variants2.add("prop", prop);

        root2.add("variants", variants2);

        String json2 = gson.toJson(root2);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            FileUtils.writeStringToFile(base.resolve(blockName + "_double.json").toFile(), StringEscapeUtils.unescapeJson(json2), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

        genLayeredSlabModel(modId, blockName, mainTexture, overlayTexture);
        genLayeredSlabItemModel(modId, blockName);

    }

    public static void genLayeredSlabModel(String modId, String blockName, ResourceLocation mainTexture, ResourceLocation overlayTexture) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "block");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", new ResourceLocation("neutronia","block/cube_bottom_half_overlay_all").toString());

        JsonObject textures = new JsonObject();
        textures.addProperty("all", mainTexture.toString());
        textures.addProperty("overlay", overlayTexture.toString());
        root.add("textures", textures);

        String json = gson.toJson(root);

        JsonObject root2 = new JsonObject();
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root2.addProperty("parent", new ResourceLocation("neutronia","block/cube_top_half_overlay_all").toString());

        JsonObject textures2 = new JsonObject();
        textures2.addProperty("all", mainTexture.toString());
        textures2.addProperty("overlay", overlayTexture.toString());
        root2.add("textures", textures2);

        String json2 = gson.toJson(root2);

        try {
            FileUtils.writeStringToFile(base.resolve("half_" + blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            FileUtils.writeStringToFile(base.resolve("upper_" + blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json2), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    public static void genLayeredSlabItemModel(String modId, String blockName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", modId + ":block/" + "half_" + blockName);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    public static void genFenceBlock(String modId, String blockName, String textureName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "blockstates").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using Husky's JSON Generator v3.");
            jw.name("multipart");
            jw.beginArray();
            jw.beginObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_post");
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("north").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_side");
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("east").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_side");
            jw.name("y").value(90);
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("south").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_side");
            jw.name("y").value(180);
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("west").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_side");
            jw.name("y").value(270);
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.endArray();
            jw.endObject();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        genBlockFenceModel(modId, blockName, textureName);
        genBlockFenceItemModel(modId, blockName);

    }

    public static void genBlockFenceModel(String modId, String blockName, String textureName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "models", "block").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_post" + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using Husky's JSON Generator v3.");
            jw.name("parent").value("block/fence_post");
            jw.name("textures");
            jw.beginObject();
            jw.name("texture").value(modId + ":blocks/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_side" + ".json"), "UTF-8");
            JsonWriter jw2 = gson.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("_comment").value("Generated using Husky's JSON Generator v3.");
            jw2.name("parent").value("block/fence_side");
            jw2.name("textures");
            jw2.beginObject();
            jw2.name("texture").value(modId + ":blocks/" + textureName);
            jw2.endObject();
            jw2.endObject();

            writer2.close();

            Writer writer3 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_inventory" + ".json"), "UTF-8");
            JsonWriter jw3 = gson.newJsonWriter(writer3);

            jw3.beginObject();
            jw3.name("_comment").value("Generated using Husky's JSON Generator v3.");
            jw3.name("parent").value("block/fence_inventory");
            jw3.name("textures");
            jw3.beginObject();
            jw3.name("texture").value(modId + ":blocks/" + textureName);
            jw3.endObject();
            jw3.endObject();

            writer3.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void genBlockFenceItemModel(String modId, String blockName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "models", "item").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();

            jw.name("_comment").value("Generated using Husky's JSON Generator v3.");
            jw.name("parent").value(modId + ":block/" + blockName + "_inventory");

            jw.endObject();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void genModInfo(String modId, String modName, String version, String gameVersion, String[] authors, String[] screenshots, String url, String description, String credits, String parentMod, String logoFile) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonArray root = new JsonArray();

        JsonObject rootObject = new JsonObject();
        rootObject.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        if (!modId.equalsIgnoreCase(" ") || modId != null)
            rootObject.addProperty("mod_id", modId);
        if (!modName.equalsIgnoreCase(" ") || modName != null)
            rootObject.addProperty("name", modName);
        if (!description.equalsIgnoreCase(" ") || description != null)
            rootObject.addProperty("description", description);
        if (!version.equalsIgnoreCase(" ") || version != null)
            rootObject.addProperty("version", version);
        if (!credits.equalsIgnoreCase(" ") || credits != null)
            rootObject.addProperty("credits", credits);
        if (!gameVersion.equalsIgnoreCase(" ") || gameVersion != null)
            rootObject.addProperty("mcversion", gameVersion);
        if (!url.equalsIgnoreCase(" ") || url != null)
            rootObject.addProperty("url", url);

        JsonArray authorList = new JsonArray();
        for (int i = 0; i <= authors.length - 1; i++) {
            authorList.add(authors[i]);
        }
        rootObject.add("authorList", authorList);
        if (!parentMod.equalsIgnoreCase(" ") || parentMod != null)
            rootObject.addProperty("parent", parentMod);
        if (!logoFile.equalsIgnoreCase(" ") || logoFile != null)
            rootObject.addProperty("logoFile", logoFile);

        JsonArray screenshotList = new JsonArray();
        for (int i = 0; i <= screenshots.length - 1; i++) {
            screenshotList.add(screenshots[i]);
        }
        rootObject.add("screenshots", screenshotList);
        root.add(rootObject);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve("moon.info").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print("Error creating file mcmod file" + "\n");
        }
    }

    public static void genRecipe(String modId, String name, boolean isShaped, String row1, String row2, String row3, String[] keys, String[] values, int[] data, String result, String craftingGroup, int resultCount) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path base = Paths.get("src", "main", "resources", "assets", modId, "recipes");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }
        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        if (isShaped) {
            root.addProperty("type", "forge:ore_shaped");
            if (!craftingGroup.equalsIgnoreCase("")) root.addProperty("group", craftingGroup);
            JsonArray pattern = new JsonArray();
            if (!row1.equalsIgnoreCase(" ")) pattern.add(row1);
            if (!row2.equalsIgnoreCase(" ")) pattern.add(row2);
            if (!row3.equalsIgnoreCase(" ")) pattern.add(row3);
            root.add("pattern", pattern);
            JsonObject key = new JsonObject();
            for (int i = 0; i <= keys.length - 1; i++) {
                if (!values[i].equalsIgnoreCase("")) {
                    JsonObject item = new JsonObject();
                    item.addProperty("item", values[i]);
                    key.add(keys[i], item);
                    if (data != null)
                        if (data[i] != 0) item.addProperty("data", data[i]);
                }
            }
            root.add("key", key);
            JsonObject resultName = new JsonObject();
            resultName.addProperty("item", result);
            if (resultCount > 1) resultName.addProperty("count", resultCount);
            root.add("result", resultName);
            String json = gson.toJson(root);
            try {
                FileUtils.writeStringToFile(base.resolve(name + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            } catch (IOException e) {
                System.out.print(String.format("Error creating recipe file %s.json" + "\n", name));
            }
        } else {
            root.addProperty("type", "forge:ore_shapeless");
            if (!craftingGroup.equalsIgnoreCase("")) root.addProperty("group", craftingGroup);
            JsonArray ingredients = new JsonArray();
            for (int i2 = 0; i2 <= values.length - 1; i2++) {
                if (!values[i2].equalsIgnoreCase("")) {
                    JsonObject item = new JsonObject();
                    item.addProperty("item", values[i2]);
                    ingredients.add(item);
                    if (data != null) item.addProperty("data", data[i2]);
                }
            }
            root.add("ingredients", ingredients);
            JsonObject resultName = new JsonObject();
            resultName.addProperty("item", result);
            if (resultCount > 1) resultName.addProperty("count", resultCount);
            root.add("result", resultName);
            String json = gson.toJson(root);
            try {
                FileUtils.writeStringToFile(base.resolve(name + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            } catch (IOException e) {
                System.out.print(String.format("Error creating recipe file %s.json" + "\n", name));
            }
        }
    }

    public static void genItemModel(String modId, String itemName, String textureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }
        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "item/generated");
        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", modId + ":items/" + textureName);
        root.add("textures", textures);
        String json = gson.toJson(root);
        try {
            FileUtils.writeStringToFile(base.resolve(itemName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", itemName));
        }
    }

    public static void genToolModel(String modId, String itemName, String textureName, String path) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }
        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");
        root.addProperty("parent", "item/handheld");
        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", modId + ":items/" + textureName);
        root.add("textures", textures);
        String json = gson.toJson(root);
        try {
            FileUtils.writeStringToFile(base.resolve(itemName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", itemName));
        }
    }

    private static void genLangFile(String modid, String block_name, String unlocalized_name, String lang_file_name) {
        Path base = Paths.get("src", "main", "resources", "assets", modid, "lang");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }
        try (BufferedWriter w = Files.newBufferedWriter(base.resolve(String.format("%s.lang", lang_file_name)), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            String name = unlocalized_name.replace("_", " ");
            unlocalized_name = WordUtils.capitalizeFully(name);
            w.write("tile." + block_name + ".name=" + unlocalized_name + "\n");
        } catch (IOException ignored) {
            System.out.print(String.format("Error creating file %s.json" + "\n", lang_file_name));
        }
    }

    public static void genAdvancementRootJson(String modId, String advancement_name, String item_name, String title, String desc, String background_texture_name, boolean show_toast, boolean announce_to_chat, boolean hidden) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "advancements");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");

        JsonObject display = new JsonObject();

        JsonObject icon = new JsonObject();
        icon.addProperty("item", modId + ":" + item_name);
        display.add("icon", icon);

        JsonObject titleObject = new JsonObject();
        titleObject.addProperty("translate", modId + ".advancements." + title);
        display.add("title", titleObject);

        JsonObject descObject = new JsonObject();
        descObject.addProperty("translate", modId + ".advancements." + desc + ".desc");
        display.add("description", descObject);

        display.addProperty("background", modId + ":textures/advancements/" + background_texture_name + ".png");
        display.addProperty("show_toast", show_toast);
        display.addProperty("announce_to_chat", announce_to_chat);
        display.addProperty("hidden", hidden);

        JsonObject criteria = new JsonObject();

        root.add("display", display);
        root.add("criteria", criteria);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve("root.json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", advancement_name));
        }

    }

    public static void genAdvancementJson(String modId, String advancement_name, String item_name, String title, String desc, String background_texture_name, boolean show_toast, boolean announce_to_chat, boolean hidden) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "advancements");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v3.");

        JsonObject display = new JsonObject();

        JsonObject icon = new JsonObject();
        icon.addProperty("item", modId + ":" + item_name);
        display.add("icon", icon);

        JsonObject titleObject = new JsonObject();
        titleObject.addProperty("translate", modId + ".advancements." + title);
        display.add("title", titleObject);

        JsonObject descObject = new JsonObject();
        descObject.addProperty("translate", modId + ".advancements." + desc + ".desc");
        display.add("description", descObject);

        display.addProperty("background", modId + ":textures/advancements/" + background_texture_name + ".png");
        display.addProperty("show_toast", show_toast);
        display.addProperty("announce_to_chat", announce_to_chat);
        display.addProperty("hidden", hidden);

        JsonObject criteria = new JsonObject();

        root.add("display", display);
        root.addProperty("parent", modId + ":" + "root");
        root.add("criteria", criteria);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve("root.json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", advancement_name));
        }

    }

    private static void stringToFile(String text, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName + ".txt", true);
            writer.write(text + "\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String text, String targetFilePath) throws IOException {
        Path targetPath = Paths.get(targetFilePath);
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        Files.write(targetPath, bytes, StandardOpenOption.CREATE);
    }

}