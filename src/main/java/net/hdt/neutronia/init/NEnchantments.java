package net.hdt.neutronia.init;

import net.hdt.neutronia.enchantments.EnchantmentChanneling;
import net.hdt.neutronia.enchantments.EnchantmentImpaling;
import net.hdt.neutronia.enchantments.EnchantmentLoyalty;
import net.hdt.neutronia.enchantments.EnchantmentRiptide;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class NEnchantments {

    public static final Enchantment field_203193_C;
    public static final Enchantment field_203194_D;
    public static final Enchantment field_203195_E;
    public static final Enchantment field_203196_F;

    static {
        field_203193_C = new EnchantmentLoyalty(Enchantment.Rarity.UNCOMMON, EntityEquipmentSlot.MAINHAND).setRegistryName(new ResourceLocation(MOD_ID, "loyalty"));
        field_203194_D = new EnchantmentImpaling(Enchantment.Rarity.RARE, EntityEquipmentSlot.MAINHAND).setRegistryName(new ResourceLocation(MOD_ID, "impaling"));
        field_203195_E = new EnchantmentRiptide(Enchantment.Rarity.RARE, EntityEquipmentSlot.MAINHAND).setRegistryName(new ResourceLocation(MOD_ID, "riptide"));
        field_203196_F = new EnchantmentChanneling(Enchantment.Rarity.VERY_RARE, EntityEquipmentSlot.MAINHAND).setRegistryName(new ResourceLocation(MOD_ID, "channeling"));
    }

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll(field_203193_C, field_203194_D, field_203195_E, field_203196_F);
    }

}
