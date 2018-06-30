package net.hdt.neutronia.dying_system_rewamp;

import net.hdt.neutronia.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//@Mod(name = "Revamped Dying System", modid = "rds", version = "0.0.1")
public class RevampedColoringSystemMod {

    public static final Logger LOGGER = LogManager.getLogger("Revamped Dying System");
    public static CreativeTab BLOCKS = new CreativeTab("RDS: Blocks");
    public static CreativeTab ITEMS = new CreativeTab("RDS: Items");

    @Mod.Instance
    public static RevampedColoringSystemMod instance;

    public static final Block[] testWool = new Block[5];
    public static final Item[] testDye = new Item[5];

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        for(EnumDyeColor color : EnumDyeColor.values()) {
            testWool[color.getDyeDamage()] = new BlockWool(color);
            testDye[color.getDyeDamage()] = new ItemDye(color);
        }
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }

}
