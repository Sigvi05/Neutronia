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

    public static final Item WOOL_HELMET = new ItemWoolArmor("wool_helmet", EntityEquipmentSlot.HEAD);
    public static final Item WOOL_CHEST = new ItemWoolArmor("wool_chest", EntityEquipmentSlot.CHEST);
    public static final Item WOOL_PANTS = new ItemWoolArmor("wool_pants", EntityEquipmentSlot.LEGS);
    public static final Item WOOL_BOOTS = new ItemWoolArmor("wool_boots", EntityEquipmentSlot.FEET);

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        BWMRecipes.addRecipe(new RecipeArmorDye(Ingredient.fromItems(WOOL_HELMET, WOOL_CHEST, WOOL_PANTS, WOOL_BOOTS)));
    }

    @Override
    public String getFeatureDescription() {
        return "Add Wool Armor";
    }
}
