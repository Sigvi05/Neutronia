package net.hdt.neutronia.init;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.items.*;
import net.hdt.neutronia.items.base.tools.BaseAxe;
import net.hdt.neutronia.items.base.tools.BasePickaxe;
import net.hdt.neutronia.items.base.tools.BaseShovel;
import net.hdt.neutronia.items.base.tools.BaseSword;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Calendar;

import static net.hdt.neutronia.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
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

    public static final Item ancientSword, bandage, /*witherBone, witherBonemeal, driedKelp, stinger, chitin, */nautilusShell, heartOfTheSea, heartOfTheNether, heartOfTheEnd, scute;

//    public static final Item AXE_CHITIN, PICKAXE_CHITIN, HOE_CHITIN, SHOVEL_CHITIN, SWORD_CHITIN;
    public static final Item OBSIDIAN_AXE, OBSIDIAN_PICKAXE,  OBSIDIAN_SHOVEL, OBSIDIAN_SWORD;

    public static final Item freddyClaw;

    public static final Item woodSpear;
    public static final Item stoneSpear;
    public static final Item ironSpear;
    public static final Item goldSpear;
    public static final Item diamondSpear;

    public static final Item trident;
    public static final Item anchor;

    private static Item[] barkItem = new Item[6];

    private static final Item doveWings, ravenWings, enderdragonWings, vexWings;
    private static Item[] woodenShields = new Item[6];
    private static final Item armorScarecrowHealmet, armorScarecrowChestplate, armorScarecrowLeggings,
            armorGhostHealmet, armorGhostChestplate, armorGhostLeggings,
            armorWerewolfHealmet, armorWerewolfChestplate, armorWerewolfLeggings,
            armorWitchHealmet, armorWitchChestplate, armorWitchLeggings, armorWitchBoots,
            armorJasonHealmet, armorJasonChestplate, armorJasonLeggings, armorJasonBoots,
            armorBansheeHealmet, armorBansheeChestplate, armorBansheeLeggings;

    public static Item[] jellybean = new Item[23];

    static {
        ancientSword = new ItemAncientSword();
        bandage = new ItemBandage();
//        witherBone = new ItemBase("wither_bone", Main.ITEM_EXPANSION_TAB);
//        witherBonemeal = new ItemBase("wither_bonemeal", Main.ITEM_EXPANSION_TAB);
//        driedKelp = new ItemFood("dried_kelp", Main.ITEM_EXPANSION_TAB, 1, false);
//        stinger = new ItemBase("stinger", Main.ITEM_EXPANSION_TAB);
//        chitin = new ItemBase("chitin", Main.ITEM_EXPANSION_TAB);
        nautilusShell = new ItemBase("nautilus_shell", Main.ITEM_EXPANSION_TAB);
        heartOfTheSea = new ItemBase("heart_of_the_sea", Main.ITEM_EXPANSION_TAB);
        heartOfTheNether = new ItemBase("heart_of_the_nether", Main.ITEM_EXPANSION_TAB);
        heartOfTheEnd = new ItemBase("heart_of_the_end", Main.ITEM_EXPANSION_TAB);
        scute = new ItemBase("scute", Main.ITEM_EXPANSION_TAB);

        /*AXE_CHITIN = new BaseAxe("axe_chitin", CAXE);
        PICKAXE_CHITIN = new BasePickaxe("pickaxe_chitin", CPICK);
        HOE_CHITIN = new BaseHoe("hoe_chitin", CHOE);
        SHOVEL_CHITIN = new BaseShovel("shovel_chitin", CSHOVEL);
        SWORD_CHITIN = new BaseSword("sword_chitin", CSWORD);*/

        OBSIDIAN_AXE = new BaseAxe("obsidian_axe", OBSDIDIAN);
        OBSIDIAN_PICKAXE = new BasePickaxe("obsidian_pickaxe", OBSDIDIAN);
        OBSIDIAN_SHOVEL = new BaseShovel("obsidian_shovel", OBSDIDIAN);
        OBSIDIAN_SWORD = new BaseSword("obsidian_sword", OBSDIDIAN);

        freddyClaw = new ItemBase("freddy_claw", Main.ITEM_EXPANSION_TAB);

        woodSpear = new ItemSpear("wood_spear", Item.ToolMaterial.WOOD).setCreativeTab(null);
        stoneSpear = new ItemSpear("stone_spear", Item.ToolMaterial.STONE).setCreativeTab(null);
        ironSpear = new ItemSpear("iron_spear", Item.ToolMaterial.IRON).setCreativeTab(null);
        goldSpear = new ItemSpear("gold_spear", Item.ToolMaterial.GOLD).setCreativeTab(null);
        diamondSpear = new ItemSpear("diamond_spear", Item.ToolMaterial.DIAMOND).setCreativeTab(null);
        trident = new ItemSpear("trident", Item.ToolMaterial.DIAMOND).setCreativeTab(null);
        anchor = new ItemSpear("anchor", Item.ToolMaterial.IRON).setCreativeTab(null);

        doveWings = new ItemWingBase("dove_wings");
        ravenWings = new ItemWingBase("raven_wings");
        enderdragonWings = new ItemWingBase("enderdragon_wings");
        vexWings = new ItemWingBase("vex_wings");

        /*for(BlockPlanks.EnumType woodTypes : BlockPlanks.EnumType.values()) {
            woodenShields[woodTypes.getMetadata()] = new ItemShieldBase(String.format("shield_log_%s", woodTypes.getName()));
        }*/

        armorScarecrowHealmet = new ItemArmorTestBase("scarecrow_head", scarecrow, 1, EntityEquipmentSlot.HEAD);
        ((ItemArmorTestBase) armorScarecrowHealmet).setHasColor(true);
        ((ItemArmorTestBase) armorScarecrowHealmet).setHasOverlay(true);
        armorScarecrowChestplate = new ItemArmorTestBase("scarecrow_shirt", scarecrow, 1, EntityEquipmentSlot.CHEST);
        ((ItemArmorTestBase) armorScarecrowChestplate).setHasColor(true);
        ((ItemArmorTestBase) armorScarecrowChestplate).setHasOverlay(true);
        armorScarecrowLeggings = new ItemArmorTestBase("scarecrow_pants", scarecrow, 2, EntityEquipmentSlot.LEGS);
        ((ItemArmorTestBase) armorScarecrowLeggings).setHasColor(true);
        ((ItemArmorTestBase) armorScarecrowLeggings).setHasOverlay(true);

        armorGhostHealmet = new ItemArmorTestBase("ghost_head", ghost, 1, EntityEquipmentSlot.HEAD);
        armorGhostChestplate = new ItemArmorTestBase("ghost_top", ghost, 1, EntityEquipmentSlot.CHEST);
        armorGhostLeggings = new ItemArmorTestBase("ghost_bottom", ghost, 2, EntityEquipmentSlot.LEGS);

        armorWerewolfHealmet = new ItemArmorTestBase("werewolf_head", werewolf, 1, EntityEquipmentSlot.HEAD);
        armorWerewolfChestplate = new ItemArmorTestBase("werewolf_shirt", werewolf, 1, EntityEquipmentSlot.CHEST);
        armorWerewolfLeggings = new ItemArmorTestBase("werewolf_pants", werewolf, 2, EntityEquipmentSlot.LEGS);

        armorWitchHealmet = new ItemArmorTestBase("witch_hat", witch, 1, EntityEquipmentSlot.HEAD);
        armorWitchChestplate = new ItemArmorTestBase("witch_top", witch, 1, EntityEquipmentSlot.CHEST);
        armorWitchLeggings = new ItemArmorTestBase("witch_bottom", witch, 2, EntityEquipmentSlot.LEGS);
        armorWitchBoots = new ItemArmorTestBase("witch_boots", witch, 1, EntityEquipmentSlot.FEET);

        armorJasonHealmet = new ItemArmorTestBase("jason_mask", jason, 1, EntityEquipmentSlot.HEAD);
        armorJasonChestplate = new ItemArmorTestBase("jason_jacket", jason, 1, EntityEquipmentSlot.CHEST);
        armorJasonLeggings = new ItemArmorTestBase("jason_pants", jason, 2, EntityEquipmentSlot.LEGS);
        armorJasonBoots = new ItemArmorTestBase("jason_boots", jason, 1, EntityEquipmentSlot.FEET);

        armorBansheeHealmet = new ItemArmorTestBase("banshee_head", banshee, 1, EntityEquipmentSlot.HEAD);
        armorBansheeChestplate = new ItemArmorTestBase("banshee_shawl", banshee, 1, EntityEquipmentSlot.CHEST);
        armorBansheeLeggings = new ItemArmorTestBase("banshee_dress", banshee, 2, EntityEquipmentSlot.LEGS);

        if(Calendar.DATE == 31 && Calendar.MONTH == Calendar.OCTOBER) {

            doveWings.setCreativeTab(CreativeTabs.TRANSPORTATION);
            ravenWings.setCreativeTab(CreativeTabs.TRANSPORTATION);
            enderdragonWings.setCreativeTab(CreativeTabs.TRANSPORTATION);
            vexWings.setCreativeTab(CreativeTabs.TRANSPORTATION);

            armorScarecrowHealmet.setCreativeTab(CreativeTabs.COMBAT);
            armorScarecrowChestplate.setCreativeTab(CreativeTabs.COMBAT);
            armorScarecrowLeggings.setCreativeTab(CreativeTabs.COMBAT);

            armorGhostHealmet.setCreativeTab(CreativeTabs.COMBAT);
            armorGhostChestplate.setCreativeTab(CreativeTabs.COMBAT);
            armorGhostLeggings.setCreativeTab(CreativeTabs.COMBAT);

            armorWerewolfHealmet.setCreativeTab(CreativeTabs.COMBAT);
            armorWerewolfChestplate.setCreativeTab(CreativeTabs.COMBAT);
            armorWerewolfLeggings.setCreativeTab(CreativeTabs.COMBAT);

            armorWitchHealmet.setCreativeTab(CreativeTabs.COMBAT);
            armorWitchChestplate.setCreativeTab(CreativeTabs.COMBAT);
            armorWitchLeggings.setCreativeTab(CreativeTabs.COMBAT);
            armorWitchBoots.setCreativeTab(CreativeTabs.COMBAT);

            armorJasonHealmet.setCreativeTab(CreativeTabs.COMBAT);
            armorJasonChestplate.setCreativeTab(CreativeTabs.COMBAT);
            armorJasonLeggings.setCreativeTab(CreativeTabs.COMBAT);
            armorJasonBoots.setCreativeTab(CreativeTabs.COMBAT);

            armorBansheeHealmet.setCreativeTab(CreativeTabs.COMBAT);
            armorBansheeChestplate.setCreativeTab(CreativeTabs.COMBAT);
            armorBansheeLeggings.setCreativeTab(CreativeTabs.COMBAT);
        } else {
            doveWings.setCreativeTab(null);
            ravenWings.setCreativeTab(null);
            enderdragonWings.setCreativeTab(null);
            vexWings.setCreativeTab(null);

            armorScarecrowHealmet.setCreativeTab(null);
            armorScarecrowChestplate.setCreativeTab(null);
            armorScarecrowLeggings.setCreativeTab(null);

            armorGhostHealmet.setCreativeTab(null);
            armorGhostChestplate.setCreativeTab(null);
            armorGhostLeggings.setCreativeTab(null);

            armorWerewolfHealmet.setCreativeTab(null);
            armorWerewolfChestplate.setCreativeTab(null);
            armorWerewolfLeggings.setCreativeTab(null);

            armorWitchHealmet.setCreativeTab(null);
            armorWitchChestplate.setCreativeTab(null);
            armorWitchLeggings.setCreativeTab(null);
            armorWitchBoots.setCreativeTab(null);

            armorJasonHealmet.setCreativeTab(null);
            armorJasonChestplate.setCreativeTab(null);
            armorJasonLeggings.setCreativeTab(null);
            armorJasonBoots.setCreativeTab(null);

            armorBansheeHealmet.setCreativeTab(null);
            armorBansheeChestplate.setCreativeTab(null);
            armorBansheeLeggings.setCreativeTab(null);
        }

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

}
