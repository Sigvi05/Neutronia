package net.hdt.neutronia.init;

import net.hdt.huskylib2.recipe.RecipeHandler;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.items.*;
import net.hdt.neutronia.items.base.tools.BaseAxe;
import net.hdt.neutronia.items.base.tools.BasePickaxe;
import net.hdt.neutronia.items.base.tools.BaseShovel;
import net.hdt.neutronia.items.base.tools.BaseSword;
import net.minecraft.block.BlockPlanks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NItems {

    public static final Item.ToolMaterial OBSIDIAN = EnumHelper.addToolMaterial("obsidian", 3, 1561 * 2, 10F, 6.0F, 22);
    public static final Item.ToolMaterial BRASS = EnumHelper.addToolMaterial("brass", 3, 1561 * 2, 10F, 6.0F, 22);
    public static final Item.ToolMaterial STEEL = EnumHelper.addToolMaterial("steel", 3, 1561 * 2, 10F, 6.0F, 22);
    public static final Item.ToolMaterial COPPER = EnumHelper.addToolMaterial("copper", 3, 1561 * 2, 10F, 6.0F, 22);
    public static final Item.ToolMaterial ZINC = EnumHelper.addToolMaterial("zinc", 3, 1561 * 2, 10F, 6.0F, 22);

    public static final ItemArmor.ArmorMaterial BRASS_ARMOR = EnumHelper.addArmorMaterial("brass", "brass", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    public static final ItemArmor.ArmorMaterial STEEL_ARMOR = EnumHelper.addArmorMaterial("steel", "steel", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    public static final ItemArmor.ArmorMaterial COPPER_ARMOR = EnumHelper.addArmorMaterial("copper", "copper", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    public static final ItemArmor.ArmorMaterial ZINC_ARMOR = EnumHelper.addArmorMaterial("zinc", "zinc", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

    public static final ItemArmor.ArmorMaterial ACACIA_ARMOR = EnumHelper.addArmorMaterial("acacia", "acacia", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor.ArmorMaterial DARK_OAK_ARMOR = EnumHelper.addArmorMaterial("dark_oak", "big_oak", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor.ArmorMaterial BIRCH_ARMOR = EnumHelper.addArmorMaterial("birch", "birch", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor.ArmorMaterial JUNGLE_ARMOR = EnumHelper.addArmorMaterial("jungle", "jungle", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor.ArmorMaterial OAK_ARMOR = EnumHelper.addArmorMaterial("oak", "oak", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor.ArmorMaterial SPRUCE_ARMOR = EnumHelper.addArmorMaterial("spruce", "spruce", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

    public static final Item ancientSword, bandage, witherBone, witherBonemeal, /*driedKelp, stinger, chitin, */
            phantomMembrane, nautilusShell, heartOfTheSea, heartOfTheNether, heartOfTheEnd, scute;
//    public static final Item rawSeaweed;

    //    public static final Item AXE_CHITIN, PICKAXE_CHITIN, HOE_CHITIN, SHOVEL_CHITIN, SWORD_CHITIN;
    public static final Item OBSIDIAN_AXE, OBSIDIAN_PICKAXE, OBSIDIAN_SHOVEL, OBSIDIAN_SWORD;

    public static final Item BRASS_AXE, BRASS_PICKAXE, BRASS_SHOVEL, BRASS_SWORD;
    public static final Item STEEL_AXE, STEEL_PICKAXE, STEEL_SHOVEL, STEEL_SWORD;
    public static final Item COPPER_AXE, COPPER_PICKAXE, COPPER_SHOVEL, COPPER_SWORD;
    public static final Item ZINC_AXE, ZINC_PICKAXE, ZINC_SHOVEL, ZINC_SWORD;
    public static final Item brassIngot, brassNugget;
    public static final Item copperIngot, copperNugget;
    public static final Item steelIngot, steelNugget;
    public static final Item zincChunk;
    public static final Item bronzeIngot, bronzeNugget;
    public static final Item tinIngot, tinNugget;

    public static final Item BRASS_HELMET, BRASS_CHESTPLATE, BRASS_LEGGINGS, BRASS_BOOTS;
    /*public static final Item STEEL_HELMET, STEEL_CHESTPLATE, STEEL_LEGGINGS, STEEL_BOOTS;
    public static final Item COPPER_HELMET, COPPER_CHESTPLATE, COPPER_LEGGINGS, COPPER_BOOTS;
    public static final Item ZINC_HELMET, ZINC_CHESTPLATE, ZINC_LEGGINGS, ZINC_BOOTS;

    public static final Item ACACIA_HELMET, ACACIA_CHESTPLATE, ACACIA_LEGGINGS, ACACIA_BOOTS;
    public static final Item DARK_OAK_HELMET, DARK_OAK_CHESTPLATE, DARK_OAK_LEGGINGS, DARK_OAK_BOOTS;
    public static final Item BIRCH__HELMET, BIRCH__CHESTPLATE, BIRCH__LEGGINGS, BIRCH__BOOTS;
    public static final Item JUNGLE_HELMET, JUNGLE_CHESTPLATE, JUNGLE_LEGGINGS, JUNGLE_BOOTS;
    public static final Item OAK_HELMET, OAK_CHESTPLATE, OAK_LEGGINGS, OAK_BOOTS;
    public static final Item SPRUCE_HELMET, SPRUCE_CHESTPLATE, SPRUCE_LEGGINGS, SPRUCE_BOOTS;*/

    public static final Item woodSpear;
    public static final Item stoneSpear;
    public static final Item ironSpear;
    public static final Item goldSpear;
    public static final Item diamondSpear;

    public static final Item trident;
    public static final Item anchor;
    public static final Item chisel;
    public static final Item logStripper;
    public static final Item easter_egg;

//    public static final Item rawDragonMeat, cookedDragonMeat;

    public static Item[] barkItem = new Item[6];
    public static Item[] logShields = new Item[6];
    public static Item[] planksShields = new Item[6];

    public static Item[] jellybean = new Item[23];

    static {

        CreativeTabs tab = NCreativeTabs.ITEM_EXPANSION_TAB;

        ancientSword = new ItemAncientSword();
        bandage = new ItemBandage();
        witherBone = new ItemBase("wither_bone", tab);
        witherBonemeal = new ItemBase("wither_bonemeal", tab);
//        driedKelp = new ItemFood("dried_kelp", tab, 1, false);
//        stinger = new ItemBase("stinger", tab);
//        chitin = new ItemBase("chitin", tab);
        phantomMembrane = new ItemPhantomMembrane();
        nautilusShell = new ItemBase("nautilus_shell", tab);
        heartOfTheSea = new ItemBase("heart_of_the_sea", tab);
        heartOfTheNether = new ItemBase("heart_of_the_nether", tab);
        heartOfTheEnd = new ItemBase("heart_of_the_end", tab);
        scute = new ItemBase("scute", tab);
        chisel = new ItemBase("chisel", tab);
        logStripper = new ItemBase("log_stripper", tab);
        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(chisel, 1), "I", "S", 'I', Items.IRON_INGOT, 'S', Items.STICK);
        RecipeHandler.addShapedRecipe(ProxyRegistry.newStack(logStripper, 1), "II ", " I ", " S ", 'I', Items.IRON_INGOT, 'S', Items.STICK);

        OBSIDIAN_AXE = new BaseAxe("obsidian_axe", OBSIDIAN).setCreativeTab(tab);
        OBSIDIAN_PICKAXE = new BasePickaxe("obsidian_pickaxe", OBSIDIAN).setCreativeTab(tab);
        OBSIDIAN_SHOVEL = new BaseShovel("obsidian_shovel", OBSIDIAN).setCreativeTab(tab);
        OBSIDIAN_SWORD = new BaseSword("obsidian_sword", OBSIDIAN).setCreativeTab(tab);

        BRASS_AXE = new BaseAxe("brass_axe", BRASS).setCreativeTab(tab);
        BRASS_PICKAXE = new BasePickaxe("brass_pickaxe", BRASS).setCreativeTab(tab);
        BRASS_SHOVEL = new BaseShovel("brass_shovel", BRASS).setCreativeTab(tab);
        BRASS_SWORD = new BaseSword("brass_sword", BRASS).setCreativeTab(tab);

        STEEL_AXE = new BaseAxe("steel_axe", STEEL).setCreativeTab(tab);
        STEEL_PICKAXE = new BasePickaxe("steel_pickaxe", STEEL).setCreativeTab(tab);
        STEEL_SHOVEL = new BaseShovel("steel_shovel", STEEL).setCreativeTab(tab);
        STEEL_SWORD = new BaseSword("steel_sword", STEEL).setCreativeTab(tab);

        COPPER_AXE = new BaseAxe("copper_axe", COPPER).setCreativeTab(tab);
        COPPER_PICKAXE = new BasePickaxe("copper_pickaxe", COPPER).setCreativeTab(tab);
        COPPER_SHOVEL = new BaseShovel("copper_shovel", COPPER).setCreativeTab(tab);
        COPPER_SWORD = new BaseSword("copper_sword", COPPER).setCreativeTab(tab);

        ZINC_AXE = new BaseAxe("zinc_axe", ZINC).setCreativeTab(tab);
        ZINC_PICKAXE = new BasePickaxe("zinc_pickaxe", ZINC).setCreativeTab(tab);
        ZINC_SHOVEL = new BaseShovel("zinc_shovel", ZINC).setCreativeTab(tab);
        ZINC_SWORD = new BaseSword("zinc_sword", ZINC).setCreativeTab(tab);

        BRASS_HELMET = new ItemArmorTestBase("brass", BRASS_ARMOR, 0, EntityEquipmentSlot.HEAD);
        BRASS_CHESTPLATE = new ItemArmorTestBase("brass", BRASS_ARMOR, 0, EntityEquipmentSlot.CHEST);
        BRASS_LEGGINGS = new ItemArmorTestBase("brass", BRASS_ARMOR, 1, EntityEquipmentSlot.LEGS);
        BRASS_BOOTS = new ItemArmorTestBase("brass", BRASS_ARMOR, 1, EntityEquipmentSlot.FEET);

        brassIngot = new ItemBase("brass_ingot", NCreativeTabs.ITEM_EXPANSION_TAB);
        brassNugget = new ItemBase("brass_nugget", NCreativeTabs.ITEM_EXPANSION_TAB);
        copperIngot = new ItemBase("copper_ingot", NCreativeTabs.ITEM_EXPANSION_TAB);
        copperNugget = new ItemBase("copper_nugget", NCreativeTabs.ITEM_EXPANSION_TAB);
        steelIngot = new ItemBase("steel_ingot", NCreativeTabs.ITEM_EXPANSION_TAB);
        steelNugget = new ItemBase("steel_nugget", NCreativeTabs.ITEM_EXPANSION_TAB);
        zincChunk = new ItemBase("zinc_chunk", NCreativeTabs.ITEM_EXPANSION_TAB);
        tinIngot = new ItemBase("tin_ingot", NCreativeTabs.ITEM_EXPANSION_TAB);
        tinNugget = new ItemBase("tin_nugget", NCreativeTabs.ITEM_EXPANSION_TAB);
        bronzeIngot = new ItemBase("bronze_ingot", NCreativeTabs.ITEM_EXPANSION_TAB);
        bronzeNugget = new ItemBase("bronze_nugget", NCreativeTabs.ITEM_EXPANSION_TAB);

        woodSpear = new ItemSpear("wood_spear", Item.ToolMaterial.WOOD).setCreativeTab(null);
        stoneSpear = new ItemSpear("stone_spear", Item.ToolMaterial.STONE).setCreativeTab(null);
        ironSpear = new ItemSpear("iron_spear", Item.ToolMaterial.IRON).setCreativeTab(null);
        goldSpear = new ItemSpear("gold_spear", Item.ToolMaterial.GOLD).setCreativeTab(null);
        diamondSpear = new ItemSpear("diamond_spear", Item.ToolMaterial.DIAMOND).setCreativeTab(null);
        trident = new ItemTrident().setCreativeTab(NCreativeTabs.ITEM_EXPANSION_TAB);
        anchor = new ItemSpear("anchor", Item.ToolMaterial.IRON).setCreativeTab(null);
        easter_egg = new ItemEasterEgg();

        for (BlockPlanks.EnumType woodTypes : BlockPlanks.EnumType.values()) {
//            logShields[woodTypes.getMetadata()] = new ItemShieldBase(String.format("shield_log_%s", woodTypes.getName()));
//            planksShields[woodTypes.getMetadata()] = new ItemShieldBase(String.format("shield_planks_%s", woodTypes.getName()));
            barkItem[woodTypes.getMetadata()] = new ItemBase(String.format("%s_bark_item", woodTypes.getName()), tab);
        }

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

}
