package net.hdt.neutronia.events.handlers;

import net.hdt.huskylib2.recipie.MultiRecipe;
import net.hdt.huskylib2.recipie.RecipeHandler;
import net.hdt.neutronia.Main;
import net.hdt.neutronia.events.ILifeCycleHandler;
import net.hdt.neutronia.init.NVanillaOverrides;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.*;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class RecipeHandlers implements ILifeCycleHandler {

    public static Map<IBlockState, ItemStack> stairs = new HashMap<>();
    public static Map<IBlockState, ItemStack> slabs = new HashMap<>();

    private MultiRecipe slabMultiRecipe, returnMultiRecipe, multiRecipe;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        NVanillaOverrides.overrideRecipes();
        slabMultiRecipe = new MultiRecipe(new ResourceLocation(MOD_ID, "slabs_to_stairs"));
        returnMultiRecipe = new MultiRecipe(new ResourceLocation(MOD_ID, "stairs_to_blocks"));
        multiRecipe = new MultiRecipe(new ResourceLocation(MOD_ID, "slabs_to_blocks"));
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        Main.LOGGER.debug("This is a test");
        List<ResourceLocation> recipeList = new ArrayList<>(CraftingManager.REGISTRY.getKeys());
        int targetSize = 8;
        for(ResourceLocation res : recipeList) {
            IRecipe recipe = CraftingManager.REGISTRY.getObject(res);
            ItemStack output = Objects.requireNonNull(recipe).getRecipeOutput();
            int originalSize = 4;
            if(!output.isEmpty() && output.getCount() == originalSize) {
                Item outputItem = output.getItem();
                Block outputBlock = Block.getBlockFromItem(outputItem);
                if(outputBlock instanceof BlockStairs) {
                    output.setCount(targetSize);

                    if(recipe instanceof ShapedRecipes || recipe instanceof ShapedOreRecipe) {
                        NonNullList<Ingredient> recipeItems;
                        if(recipe instanceof ShapedRecipes)
                            recipeItems = ((ShapedRecipes) recipe).recipeItems;
                        else recipeItems = recipe.getIngredients();

                        ItemStack outStack = ItemStack.EMPTY;
                        int inputItems = 0;

                        for(Ingredient ingredient : recipeItems) {
                            ItemStack recipeItem = ItemStack.EMPTY;
                            ItemStack[] matches = ingredient.getMatchingStacks();
                            if(matches.length > 0)
                                recipeItem = matches[0];

                            if(recipeItem != null && !recipeItem.isEmpty()) {
                                if(outStack.isEmpty())
                                    outStack = recipeItem;

                                if(ItemStack.areItemsEqual(outStack, recipeItem))
                                    inputItems++;
                                else {
                                    outStack = ItemStack.EMPTY;
                                    break;
                                }
                            }
                        }

                        if(!outStack.isEmpty() && inputItems == 6) {
                            ItemStack outCopy = outStack.copy();
                            if(outCopy.getItemDamage() == OreDictionary.WILDCARD_VALUE)
                                outCopy.setItemDamage(0);

                            outCopy.setCount(24 / targetSize);
                            ItemStack in = output.copy();
                            in.setCount(1);
                            if(in.getItem() instanceof ItemBlock && outCopy.getItem() instanceof ItemBlock) {
                                Block block = Block.getBlockFromItem(outCopy.getItem());
                                stairs.put(block.getStateFromMeta(outCopy.getItemDamage()), in);
                            }
                            RecipeHandler.addShapelessOreDictRecipe(returnMultiRecipe, outCopy, in, in, in, in);
                        }
                    }
                }
            }
            if(recipe instanceof ShapedRecipes || recipe instanceof ShapedOreRecipe) {
                NonNullList<Ingredient> recipeItems;
                if(recipe instanceof ShapedRecipes)
                    recipeItems = ((ShapedRecipes) recipe).recipeItems;
                else recipeItems = recipe.getIngredients();

                if(!output.isEmpty() && output.getCount() == originalSize) {
                    Item outputItem = output.getItem();
                    Block outputBlock = Block.getBlockFromItem(outputItem);
                    if(outputBlock instanceof BlockSlab) {
                        ItemStack outStack = ItemStack.EMPTY;
                        int inputItems = 0;

                        for(Ingredient ingredient : recipeItems) {
                            ItemStack recipeItem = ItemStack.EMPTY;
                            ItemStack[] matches = ingredient.getMatchingStacks();
                            if(matches.length > 0)
                                recipeItem = matches[0];

                            if(recipeItem != null && !recipeItem.isEmpty()) {
                                if(outStack.isEmpty())
                                    outStack = recipeItem;

                                if(ItemStack.areItemsEqual(outStack, recipeItem))
                                    inputItems++;
                                else {
                                    outStack = ItemStack.EMPTY;
                                    break;
                                }
                            }
                        }

                        if(!outStack.isEmpty() && inputItems == 3) {
                            ItemStack outCopy = outStack.copy();
                            if(outCopy.getItemDamage() == OreDictionary.WILDCARD_VALUE)
                                outCopy.setItemDamage(0);

                            ItemStack in = output.copy();
                            in.setCount(1);
                            if(in.getItem() instanceof ItemBlock && outCopy.getItem() instanceof ItemBlock) {
                                Block block = Block.getBlockFromItem(outCopy.getItem());
                                slabs.put(block.getStateFromMeta(outCopy.getItemDamage()), in);
                            }

                            RecipeHandler.addShapelessOreDictRecipe(multiRecipe, outCopy, in, in);
                        }
                    }
                }
            }
        }
        if(!stairs.isEmpty() && !slabs.isEmpty())
            for(IBlockState state : stairs.keySet())
                if(slabs.containsKey(state)) {
                    ItemStack stair = stairs.get(state).copy();
                    if(!stair.isEmpty()) {
                        stair.setCount(targetSize / 2);
                        ItemStack slab = slabs.get(state);

                        RecipeHandler.addOreDictRecipe(slabMultiRecipe, stair,
                                "S  ", "SS ", "SSS",
                                'S', slab);
                    }
                }
    }

    @Override
    public void loadComplete(FMLLoadCompleteEvent event) {

    }

    @Override
    public void serverInit(FMLServerStartingEvent event) {

    }

}
