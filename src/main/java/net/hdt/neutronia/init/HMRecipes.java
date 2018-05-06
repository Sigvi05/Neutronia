package net.hdt.neutronia.init;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class HMRecipes {

    public static void registerRecipes(IRecipe recipe) {
        ForgeRegistries.RECIPES.register(recipe);
    }

}
