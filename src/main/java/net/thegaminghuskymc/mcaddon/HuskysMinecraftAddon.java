package net.thegaminghuskymc.mcaddon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thegaminghuskymc.mcaddon.init.MCAddonBlocks;
import net.thegaminghuskymc.mcaddon.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class HuskysMinecraftAddon {

    @Mod.Instance
    public static HuskysMinecraftAddon instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    public static final CreativeTabs OVERWORLD_EXPANSION_TAB = new CreativeTabs("overworld_expansion") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(MCAddonBlocks.brain_coral[0]));
        }
    };

    public static final CreativeTabs NETHER_EXPANSION_TAB = new CreativeTabs("nether_expansion") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(Blocks.NETHER_BRICK));
        }
    };

    public static final CreativeTabs END_EXPANSION_TAB = new CreativeTabs("end_expansion") {
        @Override
        public ItemStack getTabIconItem() {
            return ItemStack.EMPTY;
        }
    };

    public static final CreativeTabs WEAPON_EXPANSION_TAB = new CreativeTabs("weapons_expansion") {
        @Override
        public ItemStack getTabIconItem() {
            return ItemStack.EMPTY;
        }
    };

    @SubscribeEvent
    public static void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @SubscribeEvent
    public static void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @SubscribeEvent
    public static void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}
