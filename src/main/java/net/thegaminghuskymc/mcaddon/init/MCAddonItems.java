package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;
import net.thegaminghuskymc.mcaddon.items.*;
import net.thegaminghuskymc.mcaddon.items.base.tools.*;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MCAddonItems
{
    public static final Item.ToolMaterial CAXE = EnumHelper.addToolMaterial("caxe", 3, 350, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CPICK = EnumHelper.addToolMaterial("cpick", 3, 350, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CHOE = EnumHelper.addToolMaterial("choe", 3, 325, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CSHOVEL = EnumHelper.addToolMaterial("cshovel", 3, 325, 7.0F, 4.0F, 12);
    public static final Item.ToolMaterial CSWORD = EnumHelper.addToolMaterial("csword", 3, 325, 7.0F, 8.0F, 12);

    public static final Item ANCIENT_SWORD;
    public static final Item BANDAGE;
    public static final Item witherBone, witherBonemeal;
    public static final Item driedKelp;
    public static final Item STINGER;
    public static final Item CHITIN;

    public static final Item AXE_CHITIN;
    public static final Item PICKAXE_CHITIN;
    public static final Item HOE_CHITIN;
    public static final Item SHOVEL_CHITIN;
    public static final Item SWORD_CHITIN;

    static {
        ANCIENT_SWORD = new ItemAncientSword();
        BANDAGE = new ItemBandage();
        witherBone = new ItemBase("wither_bone", HuskysMinecraftAdditions.NETHER_EXPANSION_TAB);
        witherBonemeal = new ItemBase("wither_bonemeal", HuskysMinecraftAdditions.NETHER_EXPANSION_TAB);
        driedKelp = new ItemFood("dried_kelp", HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
        STINGER = new ItemBase("stinger", HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
        CHITIN = new ItemBase("chitin", HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);

        AXE_CHITIN = new BaseAxe("axe_chitin", CAXE);
        PICKAXE_CHITIN = new BasePickaxe("pickaxe_chitin", CPICK);
        HOE_CHITIN = new BaseHoe("hoe_chitin", CHOE);
        SHOVEL_CHITIN = new BaseShovel("shovel_chitin", CSHOVEL);
        SWORD_CHITIN = new BaseSword("sword_chitin", CSWORD);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

}
