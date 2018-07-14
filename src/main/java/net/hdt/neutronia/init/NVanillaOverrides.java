package net.hdt.neutronia.init;

import net.hdt.huskylib2.utils.ProxyRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NVanillaOverrides {

    public static void overrideRecipes() {
        List<ResourceLocation> recipeList = new ArrayList<>(CraftingManager.REGISTRY.getKeys());
        for (ResourceLocation res : recipeList) {
            IRecipe recipe = CraftingManager.REGISTRY.getObject(res);
            ItemStack out = Objects.requireNonNull(recipe).getRecipeOutput();
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
    }

}