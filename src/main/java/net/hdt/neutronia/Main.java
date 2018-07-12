package net.hdt.neutronia;

import net.hdt.huskylib2.utils.ProxyRegistry;
import net.hdt.neutronia.commands.CommandFindBiome;
import net.hdt.neutronia.commands.CommandTeleportToDimension;
import net.hdt.neutronia.events.ILifeCycleHandler;
import net.hdt.neutronia.events.handlers.BlockHandlers;
import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.init.NItems;
import net.hdt.neutronia.proxy.CommonProxy;
import net.hdt.neutronia.util.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
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
public class Main {

    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @Mod.Instance
    public static Main instance;
    public static SimpleNetworkWrapper network;
    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    private List<ILifeCycleHandler> handlers = new ArrayList<ILifeCycleHandler>(){{
        add(new BlockHandlers());
    }};

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

//        Utilities.setModInfo(event);
        MinecraftForge.EVENT_BUS.register(NBlocks.class);
        MinecraftForge.EVENT_BUS.register(NItems.class);
        List<ResourceLocation> recipeList = new ArrayList<>(CraftingManager.REGISTRY.getKeys());
        for (ResourceLocation res : recipeList) {
            IRecipe recipe = CraftingManager.REGISTRY.getObject(res);
            ItemStack out = recipe.getRecipeOutput();
            if (recipe instanceof ShapelessRecipes && !out.isEmpty() && (out.getItem() == Item.getItemFromBlock(Blocks.WOODEN_PRESSURE_PLATE))) {
                ShapelessRecipes shaped = (ShapelessRecipes) recipe;
                NonNullList<Ingredient> ingredients = shaped.recipeItems;
                for (int i = 0; i < ingredients.size(); i++) {
                    Ingredient ingr = ingredients.get(i);
                    if (ingr.apply(ProxyRegistry.newStack(Blocks.PLANKS))) {
                        ingredients.set(i, Ingredient.fromStacks(ProxyRegistry.newStack(Blocks.PLANKS, 1, 0)));
                        out.setCount(6);
                    }
                    if (ingr.apply(ProxyRegistry.newStack(Blocks.LOG))) {
                        ingredients.set(i, Ingredient.fromStacks(ProxyRegistry.newStack(Blocks.LOG, 1, 0)));
                        out.setCount(6);
                    }
                }
            }
            if (recipe instanceof ShapelessRecipes && !out.isEmpty() && (out.getItem() == Item.getItemFromBlock(Blocks.WOODEN_BUTTON))) {
                ShapelessRecipes shaped = (ShapelessRecipes) recipe;
                NonNullList<Ingredient> ingredients = shaped.recipeItems;
                for (int i = 0; i < ingredients.size(); i++) {
                    Ingredient ingr = ingredients.get(i);
                    if (ingr.apply(ProxyRegistry.newStack(Blocks.PLANKS))) {
                        ingredients.set(i, Ingredient.fromStacks(ProxyRegistry.newStack(Blocks.PLANKS, 1, 0)));
                        out.setCount(6);
                    }
                    if (ingr.apply(ProxyRegistry.newStack(Blocks.LOG))) {
                        ingredients.set(i, Ingredient.fromStacks(ProxyRegistry.newStack(Blocks.LOG, 1, 0)));
                        out.setCount(6);
                    }
                }
            }
        }
        handlers.forEach(handler -> handler.preInit(event));
        MinecraftForge.EVENT_BUS.register(this);
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        handlers.forEach(handler -> handler.init(event));
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        handlers.forEach(handler -> handler.postInit(event));
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event){
        handlers.forEach(handler -> handler.loadComplete(event));
    }

    @Mod.EventHandler
    public void serverInit(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandFindBiome());
        event.registerServerCommand(new CommandTeleportToDimension());
    }

}