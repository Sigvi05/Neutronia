package net.hdt.neutronia.base;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by primetoxinz on 5/10/17.
 */
public class BWOreDictionary {

    public static List<ItemStack> cropNames;
    public static List<Ore> nuggetNames;
    public static List<Ore> dustNames;
    public static List<Ore> oreNames;
    public static List<Ore> ingotNames;

    public static List<ItemStack> planks;
    public static List<ItemStack> logs;
    public static List<IRecipe> logRecipes = new ArrayList<>();

    public static HashMultimap<String, String> toolEffectiveOre = HashMultimap.create();


    public static void registerOres() {

        toolEffectiveOre.putAll("axe", Lists.newArrayList("logWood", "plankWood"));
        toolEffectiveOre.putAll("mattock", Lists.newArrayList("stone", "cobblestone"));

        registerOre("wool", new ItemStack(Blocks.WOOL, OreDictionary.WILDCARD_VALUE));
        registerOre("book", Items.BOOK, Items.WRITTEN_BOOK);

        registerOre("listAllmeat", Items.PORKCHOP, Items.BEEF, Items.CHICKEN, Items.FISH, Items.MUTTON);
        registerOre("listAllmeat", new ItemStack(Items.FISH, 1, ItemFishFood.FishType.SALMON.getMetadata()));
        registerOre("listAllmeatcooked", Items.COOKED_PORKCHOP, Items.COOKED_BEEF, Items.COOKED_CHICKEN, Items.COOKED_FISH, Items.COOKED_MUTTON, Items.COOKED_RABBIT);
        registerOre("listAllmeatcooked", new ItemStack(Items.COOKED_FISH, 1, ItemFishFood.FishType.SALMON.getMetadata()));
        registerOre("foodStewMeat", Items.COOKED_PORKCHOP, Items.COOKED_BEEF, Items.COOKED_FISH, Items.COOKED_MUTTON);
        registerOre("foodStewMeat", new ItemStack(Items.COOKED_FISH, 1, ItemFishFood.FishType.SALMON.getMetadata()));

        registerOre("dustBlaze", new ItemStack(Items.BLAZE_POWDER));

        registerOre("meatPork", Items.PORKCHOP, Items.COOKED_PORKCHOP);
        registerOre("meatBeef", Items.BEEF, Items.COOKED_BEEF);
        registerOre("meatMutton", Items.MUTTON, Items.COOKED_MUTTON);
        registerOre("meatChicken", Items.CHICKEN, Items.COOKED_CHICKEN);
        registerOre("meatRotten", Items.ROTTEN_FLESH);
        registerOre("meatFish",
                new ItemStack(Items.FISH, 1, ItemFishFood.FishType.COD.getMetadata()),
                new ItemStack(Items.FISH, 1, ItemFishFood.FishType.SALMON.getMetadata()),
                new ItemStack(Items.COOKED_FISH, 1, ItemFishFood.FishType.COD.getMetadata()),
                new ItemStack(Items.COOKED_FISH, 1, ItemFishFood.FishType.SALMON.getMetadata())
        );

        registerOre("cookedPotato", Items.BAKED_POTATO);
        registerOre("cookedCarrot", Items.CARROT);

        registerOre("listAllExplosives", new ItemStack(Blocks.TNT));
        registerOre("listAllExplosives", new ItemStack(Items.GUNPOWDER));


        registerOre("seed", new ItemStack(Items.WHEAT_SEEDS), new ItemStack(Items.MELON_SEEDS), new ItemStack(Items.PUMPKIN_SEEDS), new ItemStack(Items.BEETROOT_SEEDS));

    }

    private static ItemStack getPlankOutput(ItemStack log) {
        Iterator<IRecipe> it = CraftingManager.REGISTRY.iterator();
        ItemStack stack = ItemStack.EMPTY;
        while (it.hasNext() && stack.isEmpty()) {
            IRecipe recipe = it.next();
            if (isPlank(recipe.getRecipeOutput())) {
                NonNullList<Ingredient> ing = recipe.getIngredients();
                for (Ingredient in : ing) {
                    for (ItemStack check : in.getMatchingStacks()) {
                        if (check.isItemEqual(log)) {
                            stack = recipe.getRecipeOutput().copy();
                            logRecipes.add(recipe);
                            break;
                        }
                    }
                    if (!stack.isEmpty())
                        break;
                }
            }

        }
        return stack;
    }

    private static boolean isPlank(ItemStack output) {
        return BWOreDictionary.listContains(output, OreDictionary.getOres("plankWood"));
    }

    public static void registerOre(String ore, ItemStack... items) {
        for (ItemStack i : items)
            OreDictionary.registerOre(ore, i);
    }

    public static void registerOre(String ore, Item... items) {
        for (Item item : items)
            registerOre(ore, new ItemStack(item));
    }

    public static void postInitOreDictGathering() {
        nuggetNames = getOreIngredients("nugget");
        dustNames = getOreIngredients("dust");
        oreNames = getOreIngredients("ore");
        ingotNames = getOreIngredients("ingot");
        cropNames = getOreNames("crop");
    }

    public static List<ItemStack> getOreNames(String prefix) {
        return Arrays.stream(OreDictionary.getOreNames()).filter(Objects::nonNull).filter(n -> n.startsWith(prefix)).map(OreDictionary::getOres).filter(o -> !o.isEmpty()).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static List<ItemStack> getItems(List<Ore> ores) {
        return ores.stream().flatMap(o -> o.getOres().stream()).collect(Collectors.toList());
    }

    public static List<Ore> getOreIngredients(String prefix) {
        return Arrays.stream(OreDictionary.getOreNames()).filter(Objects::nonNull).filter(n -> n.startsWith(prefix)).map(n -> new Ore(prefix, n)).collect(Collectors.toList());
    }

    public static int listContains(Object obj, List<Object> list) {
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (obj instanceof ItemStack && list.get(i) instanceof ItemStack) {
                    ItemStack stack = (ItemStack) obj;
                    ItemStack toCheck = (ItemStack) list.get(i);
                    if (ItemStack.areItemsEqual(stack, toCheck)) {
                        if (toCheck.hasTagCompound()) {
                            if (ItemStack.areItemStackTagsEqual(stack, toCheck))
                                return i;
                        } else if (stack.hasTagCompound()) {
                            return -1;
                        } else
                            return i;
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isOre(ItemStack stack, String ore) {
        return listContains(stack, OreDictionary.getOres(ore));
    }

    public static boolean listContains(ItemStack check, List<ItemStack> list) {
        if (list != null) {
            if (list.isEmpty()) return false;
            for (ItemStack item : list) {
                if (ItemStack.areItemsEqual(check, item) || (check.getItem() == item.getItem() && item.getItemDamage() == OreDictionary.WILDCARD_VALUE)) {
                    return !item.hasTagCompound() || ItemStack.areItemStackTagsEqual(check, item);
                }
            }
        }
        return false;
    }

    public static List<String> getOres(ItemStack stack) {
        return IntStream.of(OreDictionary.getOreIDs(stack)).mapToObj(OreDictionary::getOreName).collect(Collectors.toList());
    }

    public static boolean hasPrefix(ItemStack stack, String suffix) {
        return listContains(stack, getOreNames(suffix));
    }

    public static boolean isToolForOre(String tool, ItemStack stack) {
        return toolEffectiveOre.get(tool).stream().anyMatch(getOres(stack)::contains);
    }

    public static List<Ingredient> fromOres(String... ores) {
        return Arrays.stream(ores).map(OreIngredient::new).collect(Collectors.toList());
    }

    public static class Ore extends OreIngredient {
        private String prefix;
        private String ore;

        public Ore(String prefix, String ore) {
            super(ore);
            this.prefix = prefix;
            this.ore = ore;
        }

        public List<ItemStack> getOres() {
            return OreDictionary.getOres(ore);
        }

        public String getOre() {
            return ore;
        }

        public String getPrefix() {
            return prefix;
        }

        public String getSuffix() {
            return ore.substring(getPrefix().length());
        }

    }
}
