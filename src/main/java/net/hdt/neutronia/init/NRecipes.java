package net.hdt.neutronia.init;

import de.kitsunealex.silverfish.recipe.RecipeHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static net.hdt.neutronia.util.Reference.NAME;

public class NRecipes {

    private static RecipeHandler RECIPE_HANDLER = new RecipeHandler();

    public static void register() {
        RECIPE_HANDLER.setGroup(NAME);

        RECIPE_HANDLER.addRecipe(new ItemStack(NBlocks.soulStone[0], 4), "XX ", "XX ", "   ", 'X', Blocks.SOUL_SAND);
        RECIPE_HANDLER.addRecipe(new ItemStack(NBlocks.soulStone[1], 4), "X ", "X ", "  ", 'X', Block.getBlockFromName("neutronia:normal_soulstone_slab"));
        RECIPE_HANDLER.addRecipe(new ItemStack(NBlocks.soulStone[2], 4), "XX ", "XX ", "   ", 'X', Block.getBlockFromName("neutronia:normal_soulstone"));

        RECIPE_HANDLER.registerRecipes();

    }

}
