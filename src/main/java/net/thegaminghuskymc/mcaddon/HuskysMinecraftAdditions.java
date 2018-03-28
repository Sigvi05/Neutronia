package net.thegaminghuskymc.mcaddon;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.mcaddon.init.BiomeInit;
import net.thegaminghuskymc.mcaddon.init.MCAddonBlocks;
import net.thegaminghuskymc.mcaddon.proxy.CommonProxy;
import net.thegaminghuskymc.mcaddon.world.gen.WorldGenCustomStructures;
import net.thegaminghuskymc.mcaddon.world.type.WorldTypeBasalt;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class HuskysMinecraftAdditions {

    @Mod.Instance
    public static HuskysMinecraftAdditions instance;

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
            return new ItemStack(Item.getItemFromBlock(Blocks.END_BRICKS));
        }
    };

    public static final CreativeTabs WEAPON_EXPANSION_TAB = new CreativeTabs("weapons_expansion") {
        @Override
        public ItemStack getTabIconItem() {
            return ItemStack.EMPTY;
        }
    };

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        MinecraftForge.TERRAIN_GEN_BUS.register(new TerrainEventHandlers());
        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
        BiomeInit.registerBiomes();
        proxy.init(event);
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        WorldType BASALT = new WorldTypeBasalt();
        proxy.postInit(event);
    }

}
