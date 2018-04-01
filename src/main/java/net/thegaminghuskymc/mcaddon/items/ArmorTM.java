package net.thegaminghuskymc.mcaddon.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.huskylib2.items.ItemModArmor;
import net.thegaminghuskymc.mcaddon.proxy.ClientProxy;

import javax.annotation.Nullable;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class ArmorTM extends ItemModArmor {

	public ArmorTM(String name, ArmorMaterial material, int renderindex, EntityEquipmentSlot type) {
		super(name, MOD_ID, material, renderindex, type);
		
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.COMBAT);
		
	}
	
	@Override
	public String getUnlocalizedName(){
		return String.format("item.%s%s", MOD_ID, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack){
		return String.format("item.%s%s", MOD_ID, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName){		
		return unlocalizedName.substring(unlocalizedName.indexOf('.') + 1);
	}

	@Nullable
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

		ModelBiped armorModel = ClientProxy.armorModels.get(this);

        if(armorModel != null){
            armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            armorModel.bipedHeadwear.showModel = false;
            armorModel.bipedBody.showModel = armorSlot == EntityEquipmentSlot.FEET || armorSlot == EntityEquipmentSlot.LEGS;
            armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.FEET;
            armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.FEET;
            armorModel.bipedRightLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.CHEST;
            armorModel.bipedLeftLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.CHEST;

            armorModel.isSneak = entityLiving.isSneaking();
            armorModel.isRiding = entityLiving.isRiding();
            armorModel.isChild = entityLiving.isChild();

        }


        return armorModel;
	}

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        String name = this.getUnwrappedUnlocalizedName(super.getUnlocalizedName());
        name = name.substring(0, name.indexOf('_'));

        return String.format("%s:textures/models/armor/%s_layer_%d.png", MOD_ID, name, slot == EntityEquipmentSlot.LEGS ? 2 : 1);
    }
	
	
	
}