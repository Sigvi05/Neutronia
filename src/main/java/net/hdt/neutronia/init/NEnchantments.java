package net.hdt.neutronia.init;

import net.hdt.neutronia.enchantments.EnchantmentLavaWalker;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.hdt.neutronia.base.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class NEnchantments {

    public static final Enchantment LAVA_WALKER;

    static {
        LAVA_WALKER = new EnchantmentLavaWalker(Enchantment.Rarity.VERY_RARE, EntityEquipmentSlot.FEET).setRegistryName(new ResourceLocation(MOD_ID, "lava_walker"));
    }

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().register(LAVA_WALKER);
    }

}
