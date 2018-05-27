package net.hdt.neutronia.items;

import net.hdt.neutronia.proxy.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class ArmorTM extends ItemModArmor {

    private boolean hasOverlay;

    public ArmorTM(String name, boolean hasOverlay, ArmorMaterial material, int renderindex, EntityEquipmentSlot type) {
        super(name, MOD_ID, material, renderindex, type);
        this.hasOverlay = hasOverlay;
        this.setMaxStackSize(1);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return String.format("item.%s", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf('.') + 1);
    }

    @Nullable
    @Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        ModelBiped armorModel = ClientProxy.armorModels.get(this);
        if (armorModel != null) {
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
        String normal = String.format("%s:textures/models/armor/%s_layer_%d.png", MOD_ID, name, slot == EntityEquipmentSlot.LEGS ? 2 : 1);
        String overlay = String.format("%s:textures/models/armor/%s_layer_%d_overlay.png", MOD_ID, name, slot == EntityEquipmentSlot.LEGS ? 2 : 1);
        if(hasOverlay) {
            return overlay;
        } else
            return normal;
    }

    @Override
    public boolean hasOverlay(ItemStack stack) {
        return hasOverlay;
    }

}