package net.hdt.neutronia.init;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.items.*;
import net.hdt.neutronia.items.base.tools.*;
import net.hdt.neutronia.properties.FishType;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.hdt.neutronia.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class NItems {
    public static final Item.ToolMaterial CAXE = EnumHelper.addToolMaterial("caxe", 3, 350, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CPICK = EnumHelper.addToolMaterial("cpick", 3, 350, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CHOE = EnumHelper.addToolMaterial("choe", 3, 325, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CSHOVEL = EnumHelper.addToolMaterial("cshovel", 3, 325, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CSWORD = EnumHelper.addToolMaterial("csword", 3, 325, 7.0F, 8.0F, 12);

    public static final Item.ToolMaterial OBSDIDIAN = EnumHelper.addToolMaterial("obsidian", 7, 1200, 9.0F, 10.0F, 12);

    public static final ItemArmor.ArmorMaterial TEST = EnumHelper.addArmorMaterial("test", "test", 100, new int[]{10, 10, 10, 10}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 3F);

    public static final Item ancientSword, bandage, witherBone, witherBonemeal, driedKelp, stinger, chitin, nautilusShell, heartOfTheSea, heartOfTheNether, heartOfTheEnd, scute;

    public static final Item AXE_CHITIN, PICKAXE_CHITIN, HOE_CHITIN, SHOVEL_CHITIN, SWORD_CHITIN;
    public static final Item OBSIDIAN_AXE, OBSIDIAN_PICKAXE, OBSIDIAN_HOE, OBSIDIAN_SHOVEL, OBSIDIAN_SWORD;

    /*public static final ArmorTM helmet;
    public static final ArmorTM chestplate;
    public static final ArmorTM leggings;
    public static final ArmorTM boots;*/

    public static final Item easter_egg;

    public static final ItemSpear woodSpear;
    public static final ItemSpear stoneSpear;
    public static final ItemSpear ironSpear;
    public static final ItemSpear goldSpear;
    public static final ItemSpear diamondSpear;

    public static final ItemSpear trident;
    public static final ItemSpear anchor;

    // Items
    public static Item hamsterFood;
    public static Item truffle;
    public static Item brownEgg;
    public static Item carvingKnife;
    public static Item cheeseMold;
    public static Item hamsterBallClear;
    public static Item hamsterBallColored;
    public static Item peacockEggBlue;
    public static Item peacockEggWhite;
    public static Item salt;
    public static Item peacockFeatherBlue;
    public static Item peacockFeatherWhite;
    public static Item peacockFeatherCharcoal;
    public static Item peacockFeatherOpal;
    public static Item peacockFeatherPeach;
    public static Item peacockFeatherPurple;
    public static Item peacockFeatherTaupe;
    public static Item ridingCrop;
    public static Item wheel;
    public static Item milkBottle;

    // Beef
    public static Item rawHerefordBeef;
    public static Item rawLonghornBeef;
    public static Item rawAngusBeef;
    public static Item rawHerefordSteak;
    public static Item rawLonghornSteak;
    public static Item rawAngusSteak;
    public static Item cookedHerefordRoast;
    public static Item cookedLonghornRoast;
    public static Item cookedAngusRoast;
    public static Item cookedHerefordSteak;
    public static Item cookedLonghornSteak;
    public static Item cookedAngusSteak;

    public static Item rawPrimeSteak;
    public static Item rawPrimeBeef;
    public static Item cookedPrimeSteak;
    public static Item cookedPrimeBeef;

    // Horse
    public static Item rawHorse;
    public static Item cookedHorse;

    // Pork
    public static Item rawLargeBlackPork;
    public static Item rawDurocPork;
    public static Item rawOldSpotPork;
    public static Item rawHampshirePork;
    public static Item rawLargeBlackBacon;
    public static Item rawDurocBacon;
    public static Item rawOldSpotBacon;
    public static Item rawHampshireBacon;
    public static Item cookedLargeBlackRoast;
    public static Item cookedDurocRoast;
    public static Item cookedOldSpotRoast;
    public static Item cookedHampshireRoast;
    public static Item cookedLargeBlackBacon;
    public static Item cookedDurocBacon;
    public static Item cookedOldSpotBacon;
    public static Item cookedHampshireBacon;

    public static Item rawPrimePork;
    public static Item rawPrimeBacon;
    public static Item cookedPrimePork;
    public static Item cookedPrimeBacon;

    // Chicken
    public static Item rawOrpingtonChicken;
    public static Item rawPlymouthRockChicken;
    public static Item rawWyandotteChicken;
    public static Item rawRhodeIslandRedChicken;
    public static Item cookedOrpingtonChicken;
    public static Item cookedPlymouthRockChicken;
    public static Item cookedWyandotteChicken;
    public static Item cookedRhodeIslandRedChicken;

    public static Item rawPrimeChicken;
    public static Item cookedPrimeChicken;

    // Frogs
    public static Item rawFrogLegs;
    public static Item cookedFrogLegs;

    // Goats
    public static Item rawChevon;
    public static Item cookedChevon;
    public static Item rawPrimeChevon;
    public static Item cookedPrimeChevon;

    // Sheep
    public static Item rawMutton;
    public static Item cookedMutton;

    // Rabbit
    public static Item rawRabbit;
    public static Item cookedRabbit;

    // Other Foods
    public static Item plainOmelette;
    public static Item cheeseOmelette;
    public static Item baconOmelette;
    public static Item truffleOmelette;
    public static Item ultimateOmelette;
    public static Item cheeseWheelFriesian;
    public static Item cheeseWedgeFriesian;
    public static Item cheeseWheelHolstein;
    public static Item cheeseWedgeHolstein;
    public static Item cheeseWheelJersey;
    public static Item cheeseWedgeJersey;
    public static Item cheeseWheelGoat;
    public static Item cheeseWedgeGoat;
    public static Item cheeseWheelSheep;
    public static Item cheeseWedgeSheep;
    public static Item truffleSoup;
    public static Item chocolateTruffle;

    public static Item newFishesRaw, newFishesCooked;

    static {
        ancientSword = new ItemAncientSword();
        bandage = new ItemBandage();
        witherBone = new ItemBase("wither_bone", Main.ITEM_EXPANSION_TAB);
        witherBonemeal = new ItemBase("wither_bonemeal", Main.ITEM_EXPANSION_TAB);
        driedKelp = new ItemFood("dried_kelp", Main.ITEM_EXPANSION_TAB, 1, false);
        stinger = new ItemBase("stinger", Main.ITEM_EXPANSION_TAB);
        chitin = new ItemBase("chitin", Main.ITEM_EXPANSION_TAB);
        nautilusShell = new ItemBase("nautilus_shell", Main.ITEM_EXPANSION_TAB);
        heartOfTheSea = new ItemBase("heart_of_the_sea", Main.ITEM_EXPANSION_TAB);
        heartOfTheNether = new ItemBase("heart_of_the_nether", Main.ITEM_EXPANSION_TAB);
        heartOfTheEnd = new ItemBase("heart_of_the_end", Main.ITEM_EXPANSION_TAB);
        scute = new ItemBase("scute", Main.ITEM_EXPANSION_TAB);

        AXE_CHITIN = new BaseAxe("axe_chitin", CAXE);
        PICKAXE_CHITIN = new BasePickaxe("pickaxe_chitin", CPICK);
        HOE_CHITIN = new BaseHoe("hoe_chitin", CHOE);
        SHOVEL_CHITIN = new BaseShovel("shovel_chitin", CSHOVEL);
        SWORD_CHITIN = new BaseSword("sword_chitin", CSWORD);

        OBSIDIAN_AXE = new BaseAxe("obsidian_axe", OBSDIDIAN);
        OBSIDIAN_PICKAXE = new BasePickaxe("obsidian_pickaxe", OBSDIDIAN);
        OBSIDIAN_HOE = new BaseHoe("obsidian_hoe", OBSDIDIAN);
        OBSIDIAN_SHOVEL = new BaseShovel("obsidian_shovel", OBSDIDIAN);
        OBSIDIAN_SWORD = new BaseSword("obsidian_sword", OBSDIDIAN);

        /*helmet = new ArmorTM("test_helmet", TEST, 0, EntityEquipmentSlot.HEAD);
        chestplate = new ArmorTM("test_chestplate", TEST, 0, EntityEquipmentSlot.CHEST);
        leggings = new ArmorTM("test_leggings", TEST, 0, EntityEquipmentSlot.LEGS);
        boots = new ArmorTM("test_boots", TEST, 0, EntityEquipmentSlot.FEET);*/
        easter_egg = new ItemEasterEgg();

        woodSpear = new ItemSpear("wood_spear", Item.ToolMaterial.WOOD);
        stoneSpear = new ItemSpear("stone_spear", Item.ToolMaterial.STONE);
        ironSpear = new ItemSpear("iron_spear", Item.ToolMaterial.IRON);
        goldSpear = new ItemSpear("gold_spear", Item.ToolMaterial.GOLD);
        diamondSpear = new ItemSpear("diamond_spear", Item.ToolMaterial.DIAMOND);
        trident = new ItemSpear("trident", Item.ToolMaterial.DIAMOND);
        anchor = new ItemSpear("anchor", Item.ToolMaterial.IRON);

        for (FishType fishType : FishType.values()) {
            newFishesRaw = new ItemFishFood("raw_", Main.FOOD_EXPANSION_TAB, fishType, false);
            newFishesCooked = new ItemFishFood("cooked_", Main.FOOD_EXPANSION_TAB, fishType, true);
        }

        // Items for Animals
        hamsterFood = new AnimaniaItem("hamster_food");
        truffle = new AnimaniaItem("truffle");
        salt = new AnimaniaItem("salt");
        peacockFeatherBlue = new AnimaniaItem("blue_peacock_feather");
        peacockFeatherWhite = new AnimaniaItem("white_peacock_feather");
        peacockFeatherCharcoal = new AnimaniaItem("charcoal_peacock_feather");
        peacockFeatherOpal = new AnimaniaItem("opal_peacock_feather");
        peacockFeatherPeach = new AnimaniaItem("peach_peacock_feather");
        peacockFeatherPurple = new AnimaniaItem("purple_peacock_feather");
        peacockFeatherTaupe = new AnimaniaItem("taupe_peacock_feather");

        // Other foods
        ultimateOmelette = new ItemAnimaniaFood(5, 2f, "super_omelette", new PotionEffect(MobEffects.REGENERATION, 600, 1, false, false), new PotionEffect(MobEffects.STRENGTH, 600, 0, false, false), new PotionEffect(MobEffects.RESISTANCE, 600, 1, false, false));
        truffleOmelette = new ItemAnimaniaFood(5, 2f, "truffle_omelette", new PotionEffect(MobEffects.REGENERATION, 600, 1, false, false));
        baconOmelette = new ItemAnimaniaFood(5, 2f, "bacon_omelette", new PotionEffect(MobEffects.STRENGTH, 600, 0, false, false));
        cheeseOmelette = new ItemAnimaniaFood(5, 2f, "cheese_omelette", new PotionEffect(MobEffects.INSTANT_HEALTH, 2, 2, false, false));
        plainOmelette = new ItemAnimaniaFood(5, 2f, "plain_omelette");
        chocolateTruffle = new ItemAnimaniaFood(6, 2f, "chocolate_truffle", new PotionEffect(MobEffects.SPEED, 1200, 3, false, false));

        // ITEMS produced by Animals
        // COW ITEMS
        rawHerefordBeef = new ItemAnimaniaFoodRaw("raw_hereford_beef");
        rawLonghornBeef = new ItemAnimaniaFoodRaw("raw_longhorn_beef");
        rawAngusBeef = new ItemAnimaniaFoodRaw("raw_angus_beef");

        rawLonghornSteak = new ItemAnimaniaFoodRaw("raw_longhorn_steak");
        rawHerefordSteak = new ItemAnimaniaFoodRaw("raw_hereford_steak");
        rawAngusSteak = new ItemAnimaniaFoodRaw("raw_angus_steak");

        cookedLonghornRoast = new ItemAnimaniaFood(10, 1f, "cooked_longhorn_roast", new PotionEffect(MobEffects.INSTANT_HEALTH, 6, 1, false, false));
        cookedHerefordRoast = new ItemAnimaniaFood(12, 1f, "cooked_hereford_roast", new PotionEffect(MobEffects.INSTANT_HEALTH, 4, 1, false, false));
        cookedAngusRoast = new ItemAnimaniaFood(20, 1f, "cooked_angus_roast", new PotionEffect(MobEffects.INSTANT_HEALTH, 10, 1, false, false));

        cookedLonghornSteak = new ItemAnimaniaFood(5, 1f, "cooked_longhorn_steak", new PotionEffect(MobEffects.INSTANT_HEALTH, 3, 1, false, false));
        cookedHerefordSteak = new ItemAnimaniaFood(6, 1f, "cooked_hereford_steak", new PotionEffect(MobEffects.INSTANT_HEALTH, 2, 1, false, false));
        cookedAngusSteak = new ItemAnimaniaFood(10, 1f, "cooked_angus_steak", new PotionEffect(MobEffects.INSTANT_HEALTH, 5, 1, false, false));

        rawPrimeBeef = new ItemAnimaniaFoodRaw("raw_prime_beef");
        cookedPrimeBeef = new ItemAnimaniaFood(20, 1f, "cooked_prime_beef", new PotionEffect(MobEffects.INSTANT_HEALTH, 10, 1, false, false));
        rawPrimeSteak = new ItemAnimaniaFoodRaw("raw_prime_steak");
        cookedPrimeSteak = new ItemAnimaniaFood(10, 1f, "cooked_prime_steak", new PotionEffect(MobEffects.INSTANT_HEALTH, 5, 1, false, false));

        // PIG ITEMS
        rawLargeBlackPork = new ItemAnimaniaFoodRaw("raw_large_black_pork");
        rawDurocPork = new ItemAnimaniaFoodRaw("raw_duroc_pork");
        rawOldSpotPork = new ItemAnimaniaFoodRaw("raw_old_spot_pork");
        rawHampshirePork = new ItemAnimaniaFoodRaw("raw_hampshire_pork");
        cookedLargeBlackRoast = new ItemAnimaniaFood(16, 1f, "cooked_large_black_roast", new PotionEffect(MobEffects.ABSORPTION, 1800, 2, false, false));
        cookedDurocRoast = new ItemAnimaniaFood(12, 1f, "cooked_duroc_roast", new PotionEffect(MobEffects.ABSORPTION, 1800, 1, false, false));
        cookedOldSpotRoast = new ItemAnimaniaFood(10, 1f, "cooked_old_spot_roast", new PotionEffect(MobEffects.ABSORPTION, 1800, 1, false, false));
        cookedHampshireRoast = new ItemAnimaniaFood(8, 1f, "cooked_hampshire_roast", new PotionEffect(MobEffects.ABSORPTION, 1800, 1, false, false));
        cookedLargeBlackBacon = new ItemAnimaniaFood(8, 1f, "cooked_large_black_bacon", new PotionEffect(MobEffects.ABSORPTION, 1200, 2, false, false));
        cookedDurocBacon = new ItemAnimaniaFood(6, 1f, "cooked_duroc_bacon", new PotionEffect(MobEffects.ABSORPTION, 1200, 0, false, false));
        cookedOldSpotBacon = new ItemAnimaniaFood(5, 1f, "cooked_old_spot_bacon", new PotionEffect(MobEffects.ABSORPTION, 1200, 0, false, false));
        cookedHampshireBacon = new ItemAnimaniaFood(4, 1f, "cooked_hampshire_bacon", new PotionEffect(MobEffects.ABSORPTION, 1200, 0, false, false));
        rawPrimePork = new ItemAnimaniaFoodRaw("raw_prime_pork");
        cookedPrimePork = new ItemAnimaniaFood(12, 1f, "cooked_prime_pork", new PotionEffect(MobEffects.ABSORPTION, 3000, 0, false, false));

        rawPrimeBacon = new ItemAnimaniaFoodRaw("raw_prime_bacon");
        cookedPrimeBacon = new ItemAnimaniaFood(12, 1f, "cooked_prime_bacon", new PotionEffect(MobEffects.ABSORPTION, 1800, 0, false, false));

        // CHICKEN ITEMS
        rawOrpingtonChicken = new ItemAnimaniaFoodRaw("raw_orpington_chicken");
        rawPlymouthRockChicken = new ItemAnimaniaFoodRaw("raw_plymouth_rock_chicken");
        rawWyandotteChicken = new ItemAnimaniaFoodRaw("raw_wyandotte_chicken");
        rawRhodeIslandRedChicken = new ItemAnimaniaFoodRaw("raw_rhode_island_red_chicken");
        cookedOrpingtonChicken = new ItemAnimaniaFood(12, 1f, "cooked_orpington_chicken", new PotionEffect(MobEffects.HASTE, 3000, 0, false, false));
        cookedPlymouthRockChicken = new ItemAnimaniaFood(10, 1f, "cooked_plymouth_rock_chicken", new PotionEffect(MobEffects.HASTE, 2400, 0, false, false));
        cookedWyandotteChicken = new ItemAnimaniaFood(6, 1f, "cooked_wyandotte_chicken", new PotionEffect(MobEffects.HASTE, 1800, 0, false, false));
        cookedRhodeIslandRedChicken = new ItemAnimaniaFood(8, 1f, "cooked_rhode_island_red_chicken", new PotionEffect(MobEffects.HASTE, 1200, 0, false, false));
        rawPrimeChicken = new ItemAnimaniaFoodRaw("raw_prime_chicken");
        cookedPrimeChicken = new ItemAnimaniaFood(12, 1f, "cooked_prime_chicken", new PotionEffect(MobEffects.HASTE, 3000, 0, false, false));
        peacockEggBlue = new AnimaniaItem("peacock_egg_blue").setMaxStackSize(16);
        peacockEggWhite = new AnimaniaItem("peacock_egg_white").setMaxStackSize(16);
        rawLargeBlackBacon = new ItemAnimaniaFoodRaw("raw_large_black_bacon");
        rawDurocBacon = new ItemAnimaniaFoodRaw("raw_duroc_bacon");
        rawOldSpotBacon = new ItemAnimaniaFoodRaw("raw_old_spot_bacon");
        rawHampshireBacon = new ItemAnimaniaFoodRaw("raw_hampshire_bacon");

        // SHEEP ITEMS
        rawMutton = new ItemAnimaniaFoodRaw("raw_prime_mutton");
        cookedMutton = new ItemAnimaniaFood(3, 1f, "cooked_prime_mutton", new PotionEffect(MobEffects.INSTANT_HEALTH, 5, 1, false, false));


        // RABBIT ITEMS
        rawRabbit = new ItemAnimaniaFoodRaw("raw_prime_rabbit");
        cookedRabbit = new ItemAnimaniaFood(4, 1f, "cooked_prime_rabbit", new PotionEffect(MobEffects.JUMP_BOOST, 600, 3, false, false));

        // FROG ITEMS
        rawFrogLegs = new ItemAnimaniaFoodRaw("raw_frog_legs");
        cookedFrogLegs = new ItemAnimaniaFood(3, 1f, "cooked_frog_legs", new PotionEffect(MobEffects.JUMP_BOOST, 1200, 2, false, false));

        // HORSE ITEMS
        rawHorse = new ItemAnimaniaFoodRaw("raw_horse");
        cookedHorse = new ItemAnimaniaFood(20, 1f, "cooked_horse", new PotionEffect(MobEffects.STRENGTH, 600, 0, false, false));

        // GOAT ITEMS
        rawChevon = new ItemAnimaniaFoodRaw("raw_chevon");
        cookedChevon = new ItemAnimaniaFood(3, 1f, "cooked_chevon", new PotionEffect(MobEffects.RESISTANCE, 600, 0, false, false));
        rawPrimeChevon = new ItemAnimaniaFoodRaw("raw_prime_chevon");
        cookedPrimeChevon = new ItemAnimaniaFood(3, 1f, "cooked_prime_chevon", new PotionEffect(MobEffects.RESISTANCE, 1200, 1, false, false));

        // CHEESE
        cheeseWedgeFriesian = new ItemAnimaniaFood(2, 2f, "friesian_cheese_wedge", new PotionEffect(MobEffects.INSTANT_HEALTH, 6, 2, false, false));
        cheeseWedgeHolstein = new ItemAnimaniaFood(2, 2f, "holstein_cheese_wedge", new PotionEffect(MobEffects.INSTANT_HEALTH, 12, 2, false, false));
        cheeseWedgeJersey = new ItemAnimaniaFood(2, 2f, "jersey_cheese_wedge", new PotionEffect(MobEffects.INSTANT_HEALTH, 10, 2, false, false));
        cheeseWedgeGoat = new ItemAnimaniaFood(2, 2f, "goat_cheese_wedge", new PotionEffect(MobEffects.RESISTANCE, 1200, 0, false, false));
        cheeseWedgeSheep = new ItemAnimaniaFood(2, 2f, "sheep_cheese_wedge", new PotionEffect(MobEffects.INSTANT_HEALTH, 10, 0, false, false));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

}
