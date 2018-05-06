package net.hdt.neutronia.blocks.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;
import net.thegaminghuskymc.huskylib2.items.blocks.ItemModBlock;
import net.thegaminghuskymc.huskylib2.utils.ProxyRegistry;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public abstract class BlockMod extends Block implements IModBlock {

    private final String[] variants;
    private String bareName, modid;

    public BlockMod(Material material, String modid, String name, String textureName, String... variants) {
        super(material);

        if (variants.length == 0)
            variants = new String[]{name};

        bareName = name;
        this.variants = variants;
        this.modid = modid;

        if (registerInConstruction())
            setUnlocalizedName(name, textureName);

        setHardness(1.5F);
        setResistance(30F);
        setHarvestLevel("pickaxe", 1);
    }

    public static void genBlock(String modId, String blockName, String textureName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path base = Paths.get("src", "main", "resources", "assets", modId, "blockstates");
        if (!base.toFile().exists()) {
            base.toFile().mkdirs();
        }

        JsonObject root = new JsonObject();
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
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
        root.addProperty("_comment", "Generated using Husky's JSON Generator v2.");
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

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

    public Block setUnlocalizedName(String name, String textureName) {
        super.setUnlocalizedName(name);
        this.setRegistryName(getPrefix(), name);
        ProxyRegistry.register(this);
        ProxyRegistry.register(createItemBlock(new ResourceLocation(getPrefix(), name)));
        genBlock(getPrefix(), name, textureName);
        return this;
    }

    private ItemBlock createItemBlock(ResourceLocation res) {
        return new ItemModBlock(this, res);
    }

    private boolean registerInConstruction() {
        return true;
    }

    @Override
    public String getPrefix() {
        return this.modid;
    }

    @Override
    public IStateMapper getStateMapper() {
        return new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return new ModelResourceLocation(new ResourceLocation(getPrefix(), getBareName()), "normal");
            }
        };
    }

    @Override
    public String getModNamespace() {
        return this.modid;
    }

    @Override
    public String getBareName() {
        return bareName;
    }

    @Override
    public String[] getVariants() {
        return variants;
    }

    @Override
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return layer == BlockRenderLayer.CUTOUT_MIPPED || layer == BlockRenderLayer.CUTOUT || layer == BlockRenderLayer.SOLID || layer == BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }

    @Override
    public IProperty[] getIgnoredProperties() {
        return new IProperty[0];
    }

    @Override
    public IProperty getVariantProp() {
        return null;
    }

    @Override
    public Class getVariantEnum() {
        return null;
    }

}