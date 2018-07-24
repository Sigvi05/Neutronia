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
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NItems {

    public static final Item.ToolMaterial CAXE = EnumHelper.addToolMaterial("caxe", 3, 350, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CPICK = EnumHelper.addToolMaterial("cpick", 3, 350, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CHOE = EnumHelper.addToolMaterial("choe", 3, 325, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CSHOVEL = EnumHelper.addToolMaterial("cshovel", 3, 325, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CSWORD = EnumHelper.addToolMaterial("csword", 3, 325, 7.0F, 8.0F, 12);

    public static final Item.ToolMaterial OBSDIDIAN = EnumHelper.addToolMaterial("obsidian", 3, 1561 * 2, 10F, 6.0F, 22);

    public static final Item ancientSword, bandage, /*witherBone, witherBonemeal, driedKelp, stinger, chitin, */ phantomMembrane, nautilusShell, heartOfTheSea, heartOfTheNether, heartOfTheEnd, scute;
//    public static final Item rawSeaweed;

//    public static final Item AXE_CHITIN, PICKAXE_CHITIN, HOE_CHITIN, SHOVEL_CHITIN, SWORD_CHITIN;
    public static final Item OBSIDIAN_AXE, OBSIDIAN_PICKAXE,  OBSIDIAN_SHOVEL, OBSIDIAN_SWORD;

    public static final Item woodSpear;
    public static final Item stoneSpear;
    public static final Item ironSpear;
    public static final Item goldSpear;
    public static final Item diamondSpear;

    public static final Item trident;
    public static final Item anchor;
    public static final Item chisel;
    public static final Item logStripper;

//    public static final Item rawDragonMeat, cookedDragonMeat;

    public static Item[] barkItem = new Item[6];
    public static Item[] logShields = new Item[6];
    public static Item[] planksShields = new Item[6];

    public static Item[] jellybean = new Item[23];

    static {

        CreativeTabs tab = NCreativeTabs.ITEM_EXPANSION_TAB;

        ancientSword = new ItemAncientSword();
        bandage = new ItemBandage();
//        witherBone = new ItemBase("wither_bone", tab);
//        witherBonemeal = new ItemBase("wither_bonemeal", tab);
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

        OBSIDIAN_AXE = new BaseAxe("obsidian_axe", OBSDIDIAN).setCreativeTab(tab);
        OBSIDIAN_PICKAXE = new BasePickaxe("obsidian_pickaxe", OBSDIDIAN).setCreativeTab(tab);
        OBSIDIAN_SHOVEL = new BaseShovel("obsidian_shovel", OBSDIDIAN).setCreativeTab(tab);
        OBSIDIAN_SWORD = new BaseSword("obsidian_sword", OBSDIDIAN).setCreativeTab(tab);

        woodSpear = new ItemSpear("wood_spear", Item.ToolMaterial.WOOD).setCreativeTab(null);
        stoneSpear = new ItemSpear("stone_spear", Item.ToolMaterial.STONE).setCreativeTab(null);
        ironSpear = new ItemSpear("iron_spear", Item.ToolMaterial.IRON).setCreativeTab(null);
        goldSpear = new ItemSpear("gold_spear", Item.ToolMaterial.GOLD).setCreativeTab(null);
        diamondSpear = new ItemSpear("diamond_spear", Item.ToolMaterial.DIAMOND).setCreativeTab(null);
        trident = new ItemSpear("trident", Item.ToolMaterial.DIAMOND).setCreativeTab(null);
        anchor = new ItemSpear("anchor", Item.ToolMaterial.IRON).setCreativeTab(null);

        for(BlockPlanks.EnumType woodTypes : BlockPlanks.EnumType.values()) {
//            logShields[woodTypes.getMetadata()] = new ItemShieldBase(String.format("shield_log_%s", woodTypes.getName()));
//            planksShields[woodTypes.getMetadata()] = new ItemShieldBase(String.format("shield_planks_%s", woodTypes.getName()));
            barkItem[woodTypes.getMetadata()] = new ItemBase(String.format("%s_bark_item", woodTypes.getName()), tab);
        }

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

}
