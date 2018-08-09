package net.hdt.neutronia.base;

import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.base.groups.GroupLoader;
import net.hdt.neutronia.base.util.InvUtils;
import net.hdt.neutronia.groups.tweaks.features.HCTools;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Potion;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = MOD_ID)
public class BWRegistry {

    @GameRegistry.ObjectHolder("neutronia:true_sight")
    public static final Potion POTION_TRUESIGHT = null;
    @GameRegistry.ObjectHolder("neutronia:fortune")
    public static final Potion POTION_FORTUNE = null;
    @GameRegistry.ObjectHolder("neutronia:looting")
    public static final Potion POTION_LOOTING = null;
    @GameRegistry.ObjectHolder("neutronia:slow_fall")
    public static final Potion POTION_SLOWFALL = null;

    private static int availableEntityId = 0;

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        ForgeRegistry<IRecipe> reg = (ForgeRegistry<IRecipe>) event.getRegistry();

        for (IRecipe recipe : BWMRecipes.getRecipes()) {
            event.getRegistry().register(recipe);
        }

        for (IRecipe recipe : reg) {
            for (Pattern pattern : BWMRecipes.REMOVE_BY_REGEX) {
                Matcher matcher = pattern.matcher(recipe.getRegistryName().toString());
                if (matcher.matches()) {
                    reg.remove(recipe.getRegistryName());
                }
            }
            for (ResourceLocation loc : BWMRecipes.REMOVE_RECIPE_BY_RL) {
                if (loc.equals(recipe.getRegistryName()))
                    reg.remove(recipe.getRegistryName());
            }
            for (ItemStack output : BWMRecipes.REMOVE_RECIPE_BY_OUTPUT) {
                if (InvUtils.matches(recipe.getRecipeOutput(), output)) {
                    reg.remove(recipe.getRegistryName());
                }
            }
            for (List<Ingredient> inputs : BWMRecipes.REMOVE_RECIPE_BY_INPUT) {
                if (InvUtils.containsIngredient(recipe.getIngredients(), inputs)) {
                    reg.remove(recipe.getRegistryName());
                }
            }
        }
    }

    public static void init() {
        BWOreDictionary.registerOres();
    }

    public static void postInit() {
        BWOreDictionary.postInitOreDictGathering();
    }

    public static void postPostInit() {
        registerRecipes();
    }

    /**
     * Registers an entity for this mod. Handles automatic available ID
     * assignment.
     */
    public static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange,
                                      int updateFrequency, boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(new ResourceLocation(MOD_ID, entityName), entityClass, entityName, availableEntityId, Neutronia.instance, trackingRange,
                updateFrequency, sendsVelocityUpdates);
        availableEntityId++;
    }


    public static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int primaryColor, int secondaryColor) {
        EntityRegistry.registerModEntity(new ResourceLocation(MOD_ID, entityName), entityClass, entityName, availableEntityId, Neutronia.instance, trackingRange,
                updateFrequency, sendsVelocityUpdates, primaryColor, secondaryColor);
        availableEntityId++;
    }

    /*@SubscribeEvent
    public static void registerPotions(RegistryEvent.Register<Potion> event) {
        event.getRegistry().register(registerPotion(new PotionTruesight("true_sight", true, 14270531).setIconIndex(4, 1)));
        event.getRegistry().register(registerPotion(new BWPotion("fortune", true, 14270531).setIconIndex(5, 2)));
        event.getRegistry().register(registerPotion(new BWPotion("looting", true, 14270531).setIconIndex(6, 2)));
        event.getRegistry().register(registerPotion(new PotionSlowfall("slow_fall", true, 0xF46F20).setIconIndex(4, 1)));
    }*/

    private static Potion registerPotion(Potion potion) {
        String potionName = potion.getRegistryName().getPath();
        potion.setPotionName("neutronia.effect." + potionName);
        return potion;
    }

    public static void registerRecipes() {
        ForgeRegistry<IRecipe> reg = (ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES;

        replaceIRecipe(HCTools.class, reg);
    }

    private static void retrieveRecipes(String category, ForgeRegistry<IRecipe> reg) {
        List<IRecipe> recipes = BWMRecipes.getHardcoreRecipes(category);
        if (recipes != null) {
            for (IRecipe recipe : recipes) {
                ResourceLocation location = recipe.getRegistryName();
                if (reg.containsKey(location))
                    registerReplacements(reg.getValue(location), recipe);
                else
                    reg.register(recipe);
            }
        }
    }

    private static void replaceIRecipe(Class<? extends Component> clazz, IForgeRegistry<IRecipe> reg) {
        if (GroupLoader.isFeatureEnabled(clazz)) {
            List<IRecipe> recipes = BWMRecipes.getHardcoreRecipes(clazz.getSimpleName());
            if (recipes != null) {
                recipes.forEach(reg::register);
            }
        }
    }

    private static void registerReplacements(IRecipe original, IRecipe from) {
        NonNullList<Ingredient> ing = original.getIngredients();
        for (int i = 0; i < ing.size(); i++) {
            ing.set(i, from.getIngredients().get(i));
        }
    }
}

