package json_generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import net.hdt.neutronia.properties.EnumCoralColor;
import net.hdt.neutronia.properties.EnumNewStoneVariants;
import net.hdt.neutronia.properties.EnumNewStoneVariantsSlabsAndStairs;
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

public class JsonGenerator {

    private static String modid = "neutronia";

    public static void main(String[] args) {

        for(BlockPlanks.EnumType type : BlockPlanks.EnumType.values()) {
//            genSlab(new ResourceLocation(modid, String.format("%s_log_slab", type.getName())), new ResourceLocation("minecraft", String.format("log_%s_top", type.getName())), new ResourceLocation("minecraft", String.format("log_%s", type.getName())), new ResourceLocation("minecraft", String.format("log_%s_top", type.getName())));
//            genSlab(new ResourceLocation(modid, String.format("%s_bark_slstrab", type.getName())), new ResourceLocation("minecraft", String.format("log_%s", type.getName())), new ResourceLocation("minecraft", String.format("log_%s", type.getName())), new ResourceLocation("minecraft", String.format("log_%s", type.getName())));
//            genPillarBlock(new ResourceLocation(modid, String.format("stripped_%s_log", type.getName())), new ResourceLocation(modid, String.format("stripped_%s_bark", type.getName())), new ResourceLocation(modid, String.format("stripped_%s_log_top", type.getName())), new ResourceLocation(modid, String.format("stripped_%s_log", type.getName())));
//            genBlock(new ResourceLocation(modid, String.format("stripped_%s_bark", type.getName())), new ResourceLocation(modid, String.format("stripped_%s_log", type.getName())));
//            genFenceBlock(new ResourceLocation(modid, String.format("stripped_%s_bark_fence", type.getName())), new ResourceLocation(modid, String.format("stripped_%s_bark", type.getName())));
        }

        for(EnumDyeColor color : EnumDyeColor.values()) {
//            genBlock(new ResourceLocation(modid, String.format("centered_glazed_terracotta_%s", color.getName())), new ResourceLocation(modid, String.format("centered_glazed_terracotta/centered_glazed_terracotta_%s", color.getName())));
//            genCustomBlockWithTexture(new ResourceLocation(modid, String.format("%s_colored_redstone_lamp", color.getName())), new ResourceLocation(modid, "cube_all_colored"), new ResourceLocation(modid, "coloured_redstone_lamp_off"));
//            genCustomBlockWithTexture(new ResourceLocation(modid, String.format("%s_colored_lit_redstone_lamp", color.getName())), new ResourceLocation(modid, "cube_all_colored"), new ResourceLocation(modid, "coloured_redstone_lamp_on"));
//            genCustomBlock(new ResourceLocation(modid, String.format("%s_lantern", color.getName())), new ResourceLocation(modid, "lantern"));
//            genCustomBlock(new ResourceLocation(modid, String.format("%s_lit_lantern", color.getName())), new ResourceLocation(modid, "lantern"));
//            genCustomBlock(new ResourceLocation(modid, String.format("%s_candle", color.getName())), new ResourceLocation(modid, "candle"));
//            genCustomBlock(new ResourceLocation(modid, String.format("%s_lit_candle", color.getName())), new ResourceLocation(modid, "candle"));
//            genSlab(new ResourceLocation(modid, String.format("%s_glass_slab", color.getName())), new ResourceLocation("minecraft", String.format("glass_%s", color.getName())), new ResourceLocation("minecraft", String.format("glass_%s", color.getName())), new ResourceLocation("minecraft", String.format("glass_%s", color.getName())));
        }

        for(EnumNewStoneVariants newStoneVariants : EnumNewStoneVariants.values()) {
            genBlock(new ResourceLocation(modid, newStoneVariants.getName()), new ResourceLocation(modid, newStoneVariants.getName()));
        }

        for(EnumNewStoneVariantsSlabsAndStairs newStoneVariantsSlabsAndStairs : EnumNewStoneVariantsSlabsAndStairs.values()) {
            genSlab(new ResourceLocation(modid, newStoneVariantsSlabsAndStairs.getName() + "_slab"), new ResourceLocation(modid, newStoneVariantsSlabsAndStairs.getName()), new ResourceLocation(modid, newStoneVariantsSlabsAndStairs.getName()), new ResourceLocation(modid, newStoneVariantsSlabsAndStairs.getName()));
        }

//        genSlab(new ResourceLocation(modid, "stone_slab"), new ResourceLocation("minecraft", "stone"), new ResourceLocation("minecraft", "stone"), new ResourceLocation("minecraft", "stone"));

        for(EnumCoralColor coralColor : EnumCoralColor.values()) {
//            genBlock(new ResourceLocation(modid, String.format("%s_coral", coralColor.getNewName())), new ResourceLocation(modid, String.format("%s_coral", coralColor.getName())));
//            genBlock(new ResourceLocation(modid, String.format("dead_%s_coral", coralColor.getNewName())), new ResourceLocation(modid, String.format("%s_dead_coral", coralColor.getName())));
//            genBlock(new ResourceLocation(modid, String.format("decorative_%s_coral", coralColor.getNewName())), new ResourceLocation(modid, String.format("%s_coral", coralColor.getName())));
//            genBlock(new ResourceLocation(modid, String.format("decorative_dead_%s_coral", coralColor.getNewName())), new ResourceLocation(modid, String.format("%s_dead_coral", coralColor.getName())));
//            genCoralFan(new ResourceLocation(modid, String.format("%s_coral_fan", coralColor.getNewName())), new ResourceLocation(modid, String.format("coral_fan_%s", coralColor.getName())));
//            genCoralFan(new ResourceLocation(modid, String.format("dead_%s_coral_fan", coralColor.getNewName())), new ResourceLocation(modid, String.format("coral_fan_%s_dead", coralColor.getName())));
        }

    }

    public static void genBlock(ResourceLocation modIdAndName, ResourceLocation textureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("model", "cube_all");

        JsonObject textures = new JsonObject();
        textures.addProperty("all", textureName.getResourceDomain() + ":blocks/" + textureName.getResourcePath());
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
            FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath()));
        }
    }

    public static void genCustomBlock(ResourceLocation modIdAndName, ResourceLocation modelPath) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("model", modelPath.getResourceDomain() + ":" + modelPath.getResourcePath());

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
            FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath()));
        }
    }

    public static void genCustomBlockWithTexture(ResourceLocation modIdAndName, ResourceLocation modelPath, ResourceLocation textureLocation) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("model", modelPath.getResourceDomain() + ":" + modelPath.getResourcePath());

        JsonObject textures = new JsonObject();
        textures.addProperty("all", textureLocation.getResourceDomain() + ":blocks/" + textureLocation.getResourcePath());
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
            FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath()));
        }
    }

    private static void genCoralFan(ResourceLocation modIdAndName, ResourceLocation textureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("transform", "forge:default-block");
        defaults.addProperty("model", modIdAndName.getResourceDomain() + ":" + modIdAndName.getResourcePath());
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
            FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            System.out.print(String.format("Created file with the name %s" + "\n", modIdAndName.getResourcePath()));
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath()));
        }
        genCoralFanModel(modIdAndName, textureName);
        genCoralFanItemModel(modIdAndName, textureName);
    }

    public static void genCoralFanModel(ResourceLocation modIdAndName, ResourceLocation textureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "models", "block");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("parent", "neutronia:block/coral_fan");

        JsonObject textures = new JsonObject();
        textures.addProperty("fan", textureName.getResourceDomain() + ":blocks/" + textureName.getResourcePath());
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath()));
        }

    }

    public static void genCoralFanItemModel(ResourceLocation modIdAndName, ResourceLocation textureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("parent", "item/generated");

        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", textureName.getResourceDomain() + ":blocks/" + textureName.getResourcePath());
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath()));
        }

    }

    public static void genPlant(String modId, String blockName, String textureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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

    public static void genOrientedBlock(ResourceLocation modIdAndName, ResourceLocation topTextureName, ResourceLocation frontTextureName, ResourceLocation sidesTextureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("model", "block/orientable");

        JsonObject textures = new JsonObject();
        textures.addProperty("top", topTextureName.getResourceDomain() + ":blocks/" + topTextureName.getResourcePath());
        textures.addProperty("front", frontTextureName.getResourceDomain() + ":blocks/" + frontTextureName.getResourcePath());
        textures.addProperty("side", sidesTextureName.getResourceDomain() + ":blocks/" + sidesTextureName.getResourcePath());
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

        JsonArray empty = new JsonArray();
        empty.add(new JsonObject());

        variants.add("inventory", empty);
        root.add("variants", variants);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath()));
        }

        genBlockOrientedItemModel(modIdAndName, topTextureName, frontTextureName, sidesTextureName);
    }

    public static void genBlockOrientedItemModel(ResourceLocation modIdAndName, ResourceLocation topTextureName, ResourceLocation frontTextureName, ResourceLocation sidesTextureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }
        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("parent", "block/orientable");
        JsonObject textures = new JsonObject();
        textures.addProperty("top", topTextureName.getResourceDomain() + ":blocks/" + topTextureName.getResourcePath());
        textures.addProperty("front", frontTextureName.getResourceDomain() + ":blocks/" + frontTextureName.getResourcePath());
        textures.addProperty("side", sidesTextureName.getResourceDomain() + ":blocks/" + sidesTextureName.getResourcePath());
        root.add("textures", textures);
        String json = gson.toJson(root);
        try {
            FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath()));
        }
    }

    public static void genPillarBlock(ResourceLocation modIdAndName, ResourceLocation modIdAndBarkName, ResourceLocation endTextureName, ResourceLocation sidesTextureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("model", "block/cube_column");

        JsonObject textures = new JsonObject();
        textures.addProperty("end", endTextureName.getResourceDomain() + ":blocks/" + endTextureName.getResourcePath());
        textures.addProperty("side", sidesTextureName.getResourceDomain() + ":blocks/" + sidesTextureName.getResourcePath());
        defaults.add("textures", textures);

        defaults.addProperty("transform", "forge:default-block");

        root.add("defaults", defaults);

        JsonObject variants = new JsonObject();

        JsonObject axis = new JsonObject();

        JsonObject axisX = new JsonObject();
        axisX.addProperty("x", 90);
        axisX.addProperty("y", 90);
        axis.add("x", axisX);

        axis.add("y", new JsonObject());

        JsonObject axisZ = new JsonObject();
        axisZ.addProperty("x", 90);
        axis.add("z", axisZ);

        JsonObject axisNone = new JsonObject();
        axisNone.addProperty("model", modIdAndBarkName.getResourceDomain() + ":" + modIdAndBarkName.getResourcePath());
        axis.add("none", axisNone);

        variants.add("axis", axis);

        JsonArray empty = new JsonArray();
        empty.add(new JsonObject());

        variants.add("inventory", empty);
        root.add("variants", variants);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath()));
        }

        genBlockPillarItemModel(modIdAndName, endTextureName, sidesTextureName);
    }

    public static void genBlockPillarItemModel(ResourceLocation modIdAndName, ResourceLocation endTextureName, ResourceLocation sidesTextureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }
        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("parent", "block/cube_column");
        JsonObject textures = new JsonObject();
        textures.addProperty("end", endTextureName.getResourceDomain() + ":blocks/" + endTextureName.getResourcePath());
        textures.addProperty("side", sidesTextureName.getResourceDomain() + ":blocks/" + sidesTextureName.getResourcePath());
        root.add("textures", textures);
        String json = gson.toJson(root);
        try {
            FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath()));
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
            jw.name("_comment").value("Generated using Husky's JSON Generator v4.");
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
            jw.name("_comment").value("Generated using Husky's JSON Generator v4.");
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
            jw2.name("_comment").value("Generated using Husky's JSON Generator v4.");
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

            jw.name("_comment").value("Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("parent", "neutronia:block/slab");

        JsonObject textures = new JsonObject();
        textures.addProperty("bottom", bottomTextureLocation.getResourceDomain() + ":blocks/" + bottomTextureLocation.getResourcePath());
        textures.addProperty("side", sideTextureLocation.getResourceDomain() + ":blocks/" + sideTextureLocation.getResourcePath());
        textures.addProperty("top", topTextureLocation.getResourceDomain() + ":blocks/" + topTextureLocation.getResourcePath());
        root.add("textures", textures);

        String json = gson.toJson(root);

        JsonObject root2 = new JsonObject();
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("parent", new ResourceLocation("neutronia","block/cube_bottom_half_overlay_all").toString());

        JsonObject textures = new JsonObject();
        textures.addProperty("all", mainTexture.toString());
        textures.addProperty("overlay", overlayTexture.toString());
        root.add("textures", textures);

        String json = gson.toJson(root);

        JsonObject root2 = new JsonObject();
        root2.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
        root.addProperty("parent", modId + ":block/" + "half_" + blockName);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    public static void genFenceBlock(ResourceLocation modIdAndName, ResourceLocation textureName) {

        /*try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + modIdAndName.getResourcePath() + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using Husky's JSON Generator v4.");
            jw.name("multipart");
            jw.beginArray();
            jw.beginObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modIdAndName.getResourceDomain() + ":" + modIdAndName.getResourcePath() + "_post");
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("north").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modIdAndName.getResourceDomain() + ":" + modIdAndName.getResourcePath() + "_side");
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
            jw.name("model").value(modIdAndName.getResourceDomain() + ":" + modIdAndName.getResourcePath() + "_side");
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
            jw.name("model").value(modIdAndName.getResourceDomain() + ":" + modIdAndName.getResourcePath() + "_side");
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
            jw.name("model").value(modIdAndName.getResourceDomain() + ":" + modIdAndName.getResourcePath() + "_side");
            jw.name("y").value(270);
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.endArray();
            jw.endObject();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");

        JsonArray multipart = new JsonArray();

        JsonObject pole = new JsonObject();

        JsonObject applyPost = new JsonObject();
        applyPost.addProperty("model", modIdAndName.getResourceDomain() + ":" + modIdAndName.getResourcePath() + "_post");
        pole.add("apply", applyPost);

        multipart.add(pole);

        JsonObject sideNorth = new JsonObject();

        JsonObject whenNorth = new JsonObject();
        whenNorth.addProperty("north", true);
        sideNorth.add("when", whenNorth);

        JsonObject applyNorth = new JsonObject();
        applyNorth.addProperty("model", modIdAndName.getResourceDomain() + ":" + modIdAndName.getResourcePath() + "_side");
        applyNorth.addProperty("uvlock", true);
        sideNorth.add("apply", applyNorth);

        multipart.add(sideNorth);

        JsonObject sideEast = new JsonObject();

        JsonObject whenEast = new JsonObject();
        whenEast.addProperty("north", true);
        sideEast.add("when", whenEast);

        JsonObject applyEast = new JsonObject();
        applyEast.addProperty("model", modIdAndName.getResourceDomain() + ":" + modIdAndName.getResourcePath() + "_side");
        applyEast.addProperty("uvlock", true);
        applyEast.addProperty("y", 90);
        sideEast.add("apply", applyEast);

        multipart.add(sideEast);

        JsonObject sideSouth = new JsonObject();

        JsonObject whenSouth = new JsonObject();
        whenSouth.addProperty("north", true);
        sideSouth.add("when", whenSouth);

        JsonObject applySouth = new JsonObject();
        applySouth.addProperty("model", modIdAndName.getResourceDomain() + ":" + modIdAndName.getResourcePath() + "_side");
        applySouth.addProperty("uvlock", true);
        applySouth.addProperty("y", 180);
        sideSouth.add("apply", applySouth);

        multipart.add(sideSouth);

        JsonObject sideWest = new JsonObject();

        JsonObject whenWest = new JsonObject();
        whenWest.addProperty("west", true);
        sideWest.add("when", whenWest);

        JsonObject applyWest = new JsonObject();
        applyWest.addProperty("model", modIdAndName.getResourceDomain() + ":" + modIdAndName.getResourcePath() + "_side");
        applyWest.addProperty("uvlock", true);
        applyWest.addProperty("y", 270);
        sideWest.add("apply", applyWest);

        multipart.add(sideWest);

        root.add("multipart", multipart);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath()));
        }

        genBlockFenceModel(modIdAndName, textureName);
        genBlockFenceItemModel(modIdAndName);

    }

    public static void genBlockFenceModel(ResourceLocation modIdAndName, ResourceLocation textureName) {

        /*File fileDir = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "models", "block").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + modIdAndName.getResourcePath() + "_post" + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using Husky's JSON Generator v4.");
            jw.name("parent").value("block/fence_post");
            jw.name("textures");
            jw.beginObject();
            jw.name("texture").value(modIdAndName.getResourceDomain() + ":blocks/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + modIdAndName.getResourcePath() + "_side" + ".json"), "UTF-8");
            JsonWriter jw2 = gson.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("_comment").value("Generated using Husky's JSON Generator v4.");
            jw2.name("parent").value("block/fence_side");
            jw2.name("textures");
            jw2.beginObject();
            jw2.name("texture").value(textureName.getResourceDomain() + ":blocks/" + textureName.getResourcePath());
            jw2.endObject();
            jw2.endObject();

            writer2.close();

            Writer writer3 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + modIdAndName.getResourcePath() + "_inventory" + ".json"), "UTF-8");
            JsonWriter jw3 = gson.newJsonWriter(writer3);

            jw3.beginObject();
            jw3.name("_comment").value("Generated using Husky's JSON Generator v4.");
            jw3.name("parent").value("block/fence_inventory");
            jw3.name("textures");
            jw3.beginObject();
            jw3.name("texture").value(textureName.getResourceDomain() + ":blocks/" + textureName.getResourceDomain());
            jw3.endObject();
            jw3.endObject();

            writer3.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "models", "block");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        {
            JsonObject root = new JsonObject();
            root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
            root.addProperty("parent", "block/fence_post");

            JsonObject textures = new JsonObject();
            textures.addProperty("texture", textureName.getResourceDomain() + ":blocks/" + textureName.getResourcePath());
            root.add("textures", textures);

            String json = gson.toJson(root);

            try {
                FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + "_post.json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            } catch (IOException e) {
                System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath() + "_post"));
            }
        }
        {
            JsonObject root = new JsonObject();
            root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
            root.addProperty("parent", "block/fence_side");

            JsonObject textures = new JsonObject();
            textures.addProperty("texture", textureName.getResourceDomain() + ":blocks/" + textureName.getResourcePath());
            root.add("textures", textures);

            String json = gson.toJson(root);

            try {
                FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + "_side.json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            } catch (IOException e) {
                System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath() + "_side"));
            }
        }
        {
            JsonObject root = new JsonObject();
            root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
            root.addProperty("parent", "block/fence_inventory");

            JsonObject textures = new JsonObject();
            textures.addProperty("texture", textureName.getResourceDomain() + ":blocks/" + textureName.getResourcePath());
            root.add("textures", textures);

            String json = gson.toJson(root);

            try {
                FileUtils.writeStringToFile(base.resolve(modIdAndName.getResourcePath() + "_inventory.json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
            } catch (IOException e) {
                System.out.print(String.format("Error creating file %s.json" + "\n", modIdAndName.getResourcePath() + "_inventory"));
            }
        }

    }

    public static void genBlockFenceItemModel(ResourceLocation modIdAndName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modIdAndName.getResourceDomain(), "models", "item").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + modIdAndName.getResourcePath() + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();

            jw.name("_comment").value("Generated using Husky's JSON Generator v4.");
            jw.name("parent").value(modIdAndName.getResourceDomain() + ":block/" + modIdAndName.getResourcePath() + "_inventory");

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
        rootObject.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");

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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v4.");

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
