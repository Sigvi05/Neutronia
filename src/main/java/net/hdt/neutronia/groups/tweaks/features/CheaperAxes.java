package net.hdt.neutronia.groups.tweaks.features;

import net.hdt.neutronia.base.BWMRecipes;
import net.hdt.neutronia.base.groups.Component;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CheaperAxes extends Component {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        BWMRecipes.removeRecipe(new ResourceLocation("minecraft:stone_axe"));
        BWMRecipes.removeRecipe(new ResourceLocation("minecraft:iron_axe"));
        BWMRecipes.removeRecipe(new ResourceLocation("minecraft:golden_axe"));
        BWMRecipes.removeRecipe(new ResourceLocation("minecraft:diamond_axe"));
    }

    @Override
    public String getFeatureDescription() {
        return "Change vanilla axe recipes to only require 2 material rather than 3.";
    }
}
