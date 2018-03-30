package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;
import net.thegaminghuskymc.mcaddon.items.ItemAncientSword;
import net.thegaminghuskymc.mcaddon.items.ItemBandage;
import net.thegaminghuskymc.mcaddon.items.ItemBase;
import net.thegaminghuskymc.mcaddon.items.ItemTest;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MCAddonItems
{
    public static final Item test;
    public static final Item ANCIENT_SWORD;
    public static final Item BANDAGE;
    public static final Item witherBone, witherBonemeal;
    public static final Item STINGER;
    public static final Item CHITIN;

    public static final Item AXE_CHITIN;
    public static final Item PICKAXE_CHITIN;
    public static final Item HOE_CHITIN;
    public static final Item SHOVEL_CHITIN;
    public static final Item SWORD_CHITIN;

    static {
        test = new ItemTest();
        ANCIENT_SWORD = new ItemAncientSword();
        BANDAGE = new ItemBandage();
        witherBone = new ItemBase("wither_bone", HuskysMinecraftAdditions.NETHER_EXPANSION_TAB);
        witherBonemeal = new ItemBase("wither_bonemeal", HuskysMinecraftAdditions.NETHER_EXPANSION_TAB);
        STINGER = new ItemBase("stinger", HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
        CHITIN = new ItemBase("chitin", HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);

        AXE_CHITIN = new ItemBase("axe_chitin", HuskysMinecraftAdditions.WEAPON_EXPANSION_TAB);
        PICKAXE_CHITIN = new ItemBase("pickaxe_chitin", HuskysMinecraftAdditions.WEAPON_EXPANSION_TAB);
        HOE_CHITIN = new ItemBase("hoe_chitin", HuskysMinecraftAdditions.WEAPON_EXPANSION_TAB);
        SHOVEL_CHITIN = new ItemBase("shovel_chitin", HuskysMinecraftAdditions.WEAPON_EXPANSION_TAB);
        SWORD_CHITIN = new ItemBase("sword_chitin", HuskysMinecraftAdditions.WEAPON_EXPANSION_TAB);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

}
