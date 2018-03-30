package json_generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import net.thegaminghuskymc.mcaddon.properties.EnumAquamarineVariants;
import net.thegaminghuskymc.mcaddon.properties.EnumCoralColor;
import net.thegaminghuskymc.mcaddon.properties.EnumNewStoneVariants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class JsonGenerator {

    public static void main(String[] args) {

        for (EnumCoralColor type : EnumCoralColor.values()) {

        }

        for(EnumAquamarineVariants aquamarineVariants : EnumAquamarineVariants.values()) {

        }

        for(EnumNewStoneVariants newStoneVariants : EnumNewStoneVariants.values()) {
            genSlabBlock("hmca", newStoneVariants.getName() + "_slab", newStoneVariants.getName(), newStoneVariants.getName());
        }

    }

    private static void genBlock(String modId, String blockName, String textureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("model", modId + ":" + blockName);
        defaults.addProperty("transform", "forge:default-animation.animations.blocks");
        root.add("defaults", defaults);

        JsonObject variants = new JsonObject();
        variants.add("normal", new JsonObject());
        variants.add("inventory", new JsonObject());
        root.add("variants", variants);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

        genBlockModel(modId, blockName, textureName);
        genBlockItemModel(modId, blockName);
    }

    public static void genBlockModel(String modId, String blockName, String textureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "animation.animations.blocks");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
        root.addProperty("parent", "animation.animations.blocks/cube_all");

        JsonObject textures = new JsonObject();
        textures.addProperty("all", modId + ":animations.blocks/" + textureName);
        root.add("textures", textures);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    public static void genBlockItemModel(String modId, String blockName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "items");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
        root.addProperty("parent", modId + ":" + blockName);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(blockName + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

    }

    //SS

    private static void genCoralFan(String modId, String blockName, int meta, String textureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("transform", "forge:default-animation.animations.blocks");
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
            System.out.print(String.format("Created file with meta %d and with the name %s" + "\n", meta, blockName));
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }
        genCoralFanModel(modId, blockName, textureName);
        genCoralFanItemModel(modId, blockName, textureName);
    }

    public static void genCoralFanModel(String modId, String blockName, String textureName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "animation.animations.blocks");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
        root.addProperty("parent", "hmca:animation.animations.blocks/coral_fan");

        JsonObject textures = new JsonObject();
        textures.addProperty("fan", modId + ":animations.blocks/" + textureName);
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
        root.addProperty("parent", "item/generated");

        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", modId + ":animations.blocks/" + textureName);
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
        root.addProperty("forge_marker", 1);

        JsonObject defaults = new JsonObject();
        defaults.addProperty("model", modId + ":" + blockName);
        defaults.addProperty("transform", "forge:default-animation.animations.blocks");
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
        } catch (IOException e) {
            System.out.print(String.format("Error creating file %s.json" + "\n", blockName));
        }

        genBlockOrientedModel(modId, blockName, topTextureName, frontTextureName, sidesTextureName);
    }

    public static void genBlockOrientedModel(String modId, String blockName, String topTextureName, String frontTextureName, String sidesTextureName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "models", "animation.animations.blocks").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw.name("parent").value("animation.animations.blocks/orientable");
            jw.name("textures");
            jw.beginObject();
            jw.name("top").value(modId + ":animations.blocks/" + topTextureName);
            jw.name("front").value(modId + ":animations.blocks/" + frontTextureName);
            jw.name("side").value(modId + ":animations.blocks/" + sidesTextureName);
            jw.endObject();
            jw.endObject();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
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

            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw.name("parent").value(modId + ":animation.animations.blocks/" + blockName);

            jw.endObject();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
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
            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
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

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "models", "animation.animations.blocks").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_up" + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw.name("parent").value("animation.animations.blocks/pressure_plate_up");
            jw.name("textures");
            jw.beginObject();
            jw.name("texture").value(modId + ":animations.blocks/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_down" + ".json"), "UTF-8");
            JsonWriter jw2 = gson.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw2.name("parent").value("animation.animations.blocks/pressure_plate_down");
            jw2.name("textures");
            jw2.beginObject();
            jw2.name("texture").value(modId + ":animations.blocks/" + textureName);
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

            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw.name("parent").value(modId + ":animation.animations.blocks/" + blockName + "_up");

            jw.endObject();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void genSlabBlock(String modId, String blockName, String textureName, String blockMockName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "blockstates").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw.name("variants");
            jw.beginObject();

            jw.name("half=bottom");
            jw.beginObject();
            jw.name("model").value(modId + ":half_" + blockName);
            jw.endObject();

            jw.name("half=top");
            jw.beginObject();
            jw.name("model").value(modId + ":upper_" + blockName);
            jw.endObject();

            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_double" + ".json"), "UTF-8");
            Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw2 = gson2.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw2.name("variants");
            jw2.beginObject();

            jw2.name("normal");
            jw2.beginObject();
            jw2.name("model").value(modId + ":" + blockMockName);
            jw2.endObject();

            jw2.name("all");
            jw2.beginObject();
            jw2.name("model").value(modId + ":" + blockMockName);
            jw2.endObject();

            jw2.endObject();
            jw2.endObject();

            writer2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        genBlockSlabModel(modId, blockName, textureName);
        genBlockSlabItemModel(modId, blockName);

    }

    public static void genBlockSlabModel(String modId, String blockName, String textureName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "models", "animation.animations.blocks").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + "half_" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw.name("parent").value("hmca:animation.animations.blocks/slab");
            jw.name("textures");
            jw.beginObject();
            jw.name("top").value(modId + ":animations.blocks/" + textureName);
            jw.name("side").value(modId + ":animations.blocks/" + textureName);
            jw.name("bottom").value(modId + ":animations.blocks/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + "upper_" + blockName + ".json"), "UTF-8");
            JsonWriter jw2 = gson.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw2.name("parent").value("hmca:animation.animations.blocks/slab_top");
            jw2.name("textures");
            jw2.beginObject();
            jw2.name("top").value(modId + ":animations.blocks/" + textureName);
            jw2.name("side").value(modId + ":animations.blocks/" + textureName);
            jw2.name("bottom").value(modId + ":animations.blocks/" + textureName);
            jw2.endObject();
            jw2.endObject();

            writer2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void genBlockSlabItemModel(String modId, String blockName) {

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "models", "item").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();

            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw.name("parent").value(modId + ":animation.animations.blocks/" + "half_" + blockName);

            jw.endObject();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
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
            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
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

        File fileDir = Paths.get("src", "main", "resources", "assets", modId, "models", "animation.animations.blocks").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_post" + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw.name("parent").value("animation.animations.blocks/fence_post");
            jw.name("textures");
            jw.beginObject();
            jw.name("texture").value(modId + ":animations.blocks/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_side" + ".json"), "UTF-8");
            JsonWriter jw2 = gson.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw2.name("parent").value("animation.animations.blocks/fence_side");
            jw2.name("textures");
            jw2.beginObject();
            jw2.name("texture").value(modId + ":animations.blocks/" + textureName);
            jw2.endObject();
            jw2.endObject();

            writer2.close();

            Writer writer3 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_inventory" + ".json"), "UTF-8");
            JsonWriter jw3 = gson.newJsonWriter(writer3);

            jw3.beginObject();
            jw3.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw3.name("parent").value("animation.animations.blocks/fence_inventory");
            jw3.name("textures");
            jw3.beginObject();
            jw3.name("texture").value(modId + ":animations.blocks/" + textureName);
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

            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw.name("parent").value(modId + ":animation.animations.blocks/" + blockName + "_inventory");

            jw.endObject();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void genModInfo(String modId, String modName, String version, String gameVersion, String author, String url, String description, String credits) {

        File fileDir = Paths.get("src", "main", "resources").toFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\mcmod.info"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginArray();
            jw.beginObject();

            jw.name("_comment").value("Generated using Husky's JSON Generator v2.");
            jw.name("modid").value(modId);
            jw.name("name").value(modName);
            jw.name("description").value(description);
            jw.name("version").value(version);
            jw.name("credits").value(credits);
            jw.name("mcversion").value(gameVersion);
            jw.name("url").value(url);
            jw.name("authorList");
            jw.beginArray();
            jw.value(author);
            jw.endArray();
            jw.name("parent").value("");
            jw.name("screenshots");
            jw.beginArray();
            jw.endArray();

            jw.endObject();
            jw.endArray();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void genShapedRecipe(String modId, String name, boolean isShaped, String row1, String row2, String row3, String[] keys, String[] values, String result, int resultCount) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "recipes");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");

        if (isShaped) {
            root.addProperty("type", "crafting_shaped");
        } else {
            root.addProperty("type", "crafting_shapeless");
        }

        JsonArray pattern = new JsonArray();
        pattern.add(row1);
        pattern.add(row2);
        pattern.add(row3);
        root.add("pattern", pattern);

        JsonObject key = new JsonObject();
        for (int i = 0; i <= keys.length - 1; i++) {
            if (!values[i].equalsIgnoreCase("")) {
                JsonObject item = new JsonObject();
                item.addProperty("item", values[i]);
                key.add(keys[i], item);
            }
        }
        root.add("key", key);

        if (resultCount > 1) root.addProperty("count", resultCount);

        String json = gson.toJson(root);

        try {
            FileUtils.writeStringToFile(base.resolve(name + ".json").toFile(), StringEscapeUtils.unescapeJson(json), CharEncoding.UTF_8);
        } catch (IOException e) {
            System.out.print(String.format("Error creating recipe file %s.json" + "\n", name));
        }
    }

    public static void genItemModel(String modId, String itemName, String textureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "models", "item");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
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
        if( !base.toFile().exists() ) {
            base.toFile().mkdirs();
        }

        try( BufferedWriter w = Files.newBufferedWriter( base.resolve( String.format("%s.lang", lang_file_name) ), StandardOpenOption.CREATE, StandardOpenOption.APPEND) ) {
            String name = unlocalized_name.replace("_", " ");
            unlocalized_name = WordUtils.capitalizeFully(name);
            w.write("tile." + block_name + ".name=" + unlocalized_name + "\n");
        } catch(IOException ignored) {
            System.out.print(String.format("Error creating file %s.json" + "\n", lang_file_name));
        }

    }

}