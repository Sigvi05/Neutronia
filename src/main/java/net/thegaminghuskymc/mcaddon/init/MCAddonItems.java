package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thegaminghuskymc.mcaddon.items.ItemTest;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MCAddonItems {

    private static final Item test;

    static {
        test = new ItemTest();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Item> event) {

    }

}
