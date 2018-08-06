package net.hdt.neutronia.groups.tweaks.features;

import net.hdt.neutronia.base.BWMRecipes;
import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.groups.tweaks.items.ItemWoolArmor;
import net.hdt.neutronia.registry.crafting.RecipeArmorDye;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class WoolArmor extends Component {

    public static final Item WOOL_HELMET = new ItemWoolArmor(EntityEquipmentSlot.HEAD).setRegistryName("wool_helmet");
    public static final Item WOOL_CHEST = new ItemWoolArmor(EntityEquipmentSlot.CHEST).setRegistryName("wool_chest");
    public static final Item WOOL_PANTS = new ItemWoolArmor(EntityEquipmentSlot.LEGS).setRegistryName("wool_pants");
    public static final Item WOOL_BOOTS = new ItemWoolArmor(EntityEquipmentSlot.FEET).setRegistryName("wool_boots");

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        BWMRecipes.addRecipe(new RecipeArmorDye(Ingredient.fromItems(WOOL_HELMET, WOOL_CHEST, WOOL_PANTS, WOOL_BOOTS)));
    }

    @Override
    public String getFeatureDescription() {
        return "Add Wool Armor";
    }
}
