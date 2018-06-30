package net.hdt.neutronia.init;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.items.*;
import net.hdt.neutronia.items.base.tools.BaseAxe;
import net.hdt.neutronia.items.base.tools.BasePickaxe;
import net.hdt.neutronia.items.base.tools.BaseShovel;
import net.hdt.neutronia.items.base.tools.BaseSword;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class NItems {

    public static final Item.ToolMaterial CAXE = EnumHelper.addToolMaterial("caxe", 3, 350, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CPICK = EnumHelper.addToolMaterial("cpick", 3, 350, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CHOE = EnumHelper.addToolMaterial("choe", 3, 325, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CSHOVEL = EnumHelper.addToolMaterial("cshovel", 3, 325, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CSWORD = EnumHelper.addToolMaterial("csword", 3, 325, 7.0F, 8.0F, 12);

    public static final Item.ToolMaterial OBSDIDIAN = EnumHelper.addToolMaterial("obsidian", 3, 1561 * 2, 10F, 6.0F, 22);

    public static final ItemArmor.ArmorMaterial ghost = EnumHelper.addArmorMaterial("ghost", MOD_ID + ":ghost", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor.ArmorMaterial werewolf = EnumHelper.addArmorMaterial("werewolf", MOD_ID + ":werewolf", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor.ArmorMaterial scarecrow = EnumHelper.addArmorMaterial("scarecrow", MOD_ID + ":scarecrow", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor.ArmorMaterial witch = EnumHelper.addArmorMaterial("witch", MOD_ID + ":witch", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor.ArmorMaterial jason = EnumHelper.addArmorMaterial("jason", MOD_ID + ":jason", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor.ArmorMaterial banshee = EnumHelper.addArmorMaterial("banshee", MOD_ID + ":banshee", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

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

//    public static final Item rawDragonMeat, cookedDragonMeat;

    public static Item[] barkItem = new Item[6];
    public static Item[] logShields = new Item[6];
    public static Item[] planksShields = new Item[6];

    public static Item[] jellybean = new Item[23];

    static {
        ancientSword = new ItemAncientSword();
        bandage = new ItemBandage();
//        witherBone = new ItemBase("wither_bone", Main.ITEM_EXPANSION_TAB);
//        witherBonemeal = new ItemBase("wither_bonemeal", Main.ITEM_EXPANSION_TAB);
//        driedKelp = new ItemFood("dried_kelp", Main.ITEM_EXPANSION_TAB, 1, false);
//        stinger = new ItemBase("stinger", Main.ITEM_EXPANSION_TAB);
//        chitin = new ItemBase("chitin", Main.ITEM_EXPANSION_TAB);
        phantomMembrane = new ItemPhantomMembrane();
        nautilusShell = new ItemBase("nautilus_shell", Main.ITEM_EXPANSION_TAB);
        heartOfTheSea = new ItemBase("heart_of_the_sea", Main.ITEM_EXPANSION_TAB);
        heartOfTheNether = new ItemBase("heart_of_the_nether", Main.ITEM_EXPANSION_TAB);
        heartOfTheEnd = new ItemBase("heart_of_the_end", Main.ITEM_EXPANSION_TAB);
        scute = new ItemBase("scute", Main.ITEM_EXPANSION_TAB);
//        rawSeaweed = new ItemBase("raw_seaweed", Main.ITEM_EXPANSION_TAB);

        /*AXE_CHITIN = new BaseAxe("axe_chitin", CAXE);
        PICKAXE_CHITIN = new BasePickaxe("pickaxe_chitin", CPICK);
        HOE_CHITIN = new BaseHoe("hoe_chitin", CHOE);
        SHOVEL_CHITIN = new BaseShovel("shovel_chitin", CSHOVEL);
        SWORD_CHITIN = new BaseSword("sword_chitin", CSWORD);*/

        OBSIDIAN_AXE = new BaseAxe("obsidian_axe", OBSDIDIAN);
        OBSIDIAN_PICKAXE = new BasePickaxe("obsidian_pickaxe", OBSDIDIAN);
        OBSIDIAN_SHOVEL = new BaseShovel("obsidian_shovel", OBSDIDIAN);
        OBSIDIAN_SWORD = new BaseSword("obsidian_sword", OBSDIDIAN);

//        rawDragonMeat = new ItemModFood(MOD_ID, "dragon_meat_raw", Main.ITEM_EXPANSION_TAB, 10, 9.6F, true);
//        cookedDragonMeat = new ItemModFood(MOD_ID, "dragon_meat_cooked", Main.ITEM_EXPANSION_TAB, 20, 20F, true);

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
            barkItem[woodTypes.getMetadata()] = new ItemBase(String.format("%s_bark_item", woodTypes.getName()), Main.ITEM_EXPANSION_TAB);
        }

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

}
