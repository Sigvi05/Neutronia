package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;
import net.thegaminghuskymc.mcaddon.items.ItemAncientSword;
import net.thegaminghuskymc.mcaddon.items.ItemBandage;
import net.thegaminghuskymc.mcaddon.items.ItemBase;
import net.thegaminghuskymc.mcaddon.items.ItemTest;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MCAddonItems {

    public static final Item test;
    public static final Item ANCIENT_SWORD;
    public static final Item BANDAGE;
    public static final Item witherBone, witherBonemeal;

    static {
        test = new ItemTest();
        ANCIENT_SWORD = new ItemAncientSword();
        BANDAGE = new ItemBandage();
        witherBone = new ItemBase("wither_bone", HuskysMinecraftAdditions.NETHER_EXPANSION_TAB);
        witherBonemeal = new ItemBase("wither_bonemeal", HuskysMinecraftAdditions.NETHER_EXPANSION_TAB);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

}
