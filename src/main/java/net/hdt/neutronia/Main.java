package net.hdt.neutronia;

import net.hdt.huskylib2.utils.ProxyRegistry;
import net.hdt.neutronia.api.IModData;
import net.hdt.neutronia.colored_lighting.ColoredLights;
import net.hdt.neutronia.commands.TPBiomeCommand;
import net.hdt.neutronia.commands.TPDimensionCommand;
import net.hdt.neutronia.events.ILifeCycleHandler;
import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.init.NItems;
import net.hdt.neutronia.proxy.CommonProxy;
import net.hdt.neutronia.util.Reference;
import net.hdt.neutronia.util.handlers.WorldHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static net.hdt.neutronia.util.Reference.*;

@Mod(modid = MOD_ID, name = NAME, version = VERSION, dependencies = DEPENDENCIES, updateJSON = UPDATE_JSON)
public class Main implements IModData {

    public static final Logger LOGGER = LogManager.getLogger(NAME);
    public static CreativeTab OVERWORLD_EXPANSION_TAB = new CreativeTab("Overworld Expansion", true);
    public static CreativeTab NETHER_EXPANSION_TAB = new CreativeTab("Nether Expansion", true);
    public static CreativeTab END_EXPANSION_TAB = new CreativeTab("End Expansion", false) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(Blocks.END_BRICKS));
        }
    };
    /*public static CreativeTab FOOD_EXPANSION_TAB = new CreativeTab("Food Expansion") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.COOKED_BEEF);
        }
    };*/
    public static CreativeTab ITEM_EXPANSION_TAB = new CreativeTab("Item Expansion", true);

    @Mod.Instance
    public static Main instance;
    public static SimpleNetworkWrapper network;
    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    private static List<ILifeCycleHandler> handlers = new ArrayList<ILifeCycleHandler>(){{
        add(new WorldHandler());
    }};

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(ColoredLights.class);
        MinecraftForge.EVENT_BUS.register(NBlocks.class);
        MinecraftForge.EVENT_BUS.register(NItems.class);

        List<ResourceLocation> recipeList = new ArrayList<>(CraftingManager.REGISTRY.getKeys());
        for (ResourceLocation res : recipeList) {
            IRecipe recipe = CraftingManager.REGISTRY.getObject(res);
            ItemStack out = recipe.getRecipeOutput();
            if (recipe instanceof ShapedRecipes && !out.isEmpty() && (out.getItem() == Item.getItemFromBlock(Blocks.TRAPDOOR))) {
                ShapedRecipes shaped = (ShapedRecipes) recipe;
                NonNullList<Ingredient> ingredients = shaped.recipeItems;
                for (int i = 0; i < ingredients.size(); i++) {
                    Ingredient ingr = ingredients.get(i);
                    if (ingr.apply(ProxyRegistry.newStack(Blocks.PLANKS))) {
                        ingredients.set(i, Ingredient.fromStacks(ProxyRegistry.newStack(Blocks.PLANKS, 1, 0)));
                        out.setCount(6);
                    }
                }
            }
            if (recipe instanceof ShapedRecipes && !out.isEmpty() && (out.getItem() == Item.getItemFromBlock(Blocks.CHEST) || out.getItem() == Item.getItemFromBlock(Blocks.TRAPPED_CHEST))) {
                ShapedRecipes shaped = (ShapedRecipes) recipe;
                NonNullList<Ingredient> ingredients = shaped.recipeItems;
                for (int i = 0; i < ingredients.size(); i++) {
                    Ingredient ingr = ingredients.get(i);
                    if (ingr.apply(ProxyRegistry.newStack(Blocks.PLANKS)))
                        ingredients.set(i, Ingredient.fromStacks(ProxyRegistry.newStack(Blocks.PLANKS, 1, 0)));
                }
            }
            if (recipe instanceof ShapedRecipes && !out.isEmpty() && (out.getItem() == Item.getItemFromBlock(Blocks.BOOKSHELF))) {
                ShapedRecipes shaped = (ShapedRecipes) recipe;
                NonNullList<Ingredient> ingredients = shaped.recipeItems;
                for (int i = 0; i < ingredients.size(); i++) {
                    Ingredient ingr = ingredients.get(i);
                    if (ingr.apply(ProxyRegistry.newStack(Blocks.PLANKS)))
                        ingredients.set(i, Ingredient.fromStacks(ProxyRegistry.newStack(Blocks.PLANKS, 1, 0)));
                }
            }
        }
        handlers.forEach(handler -> handler.preInit(event));
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        handlers.forEach(handler -> handler.init(event));
        proxy.init(event);
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        handlers.forEach(handler -> handler.postInit(event));
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event){
        handlers.forEach(handler -> handler.loadComplete(event));
    }

    @Mod.EventHandler
    public static void serverInit(FMLServerStartingEvent event) {
        event.registerServerCommand(new TPBiomeCommand());
        event.registerServerCommand(new TPDimensionCommand());
    }

    @Override
    public String getModId() {
        return MOD_ID;
    }

    @Override
    public CreativeTabs getCreativeTab() {
        return Main.NETHER_EXPANSION_TAB;
    }

}