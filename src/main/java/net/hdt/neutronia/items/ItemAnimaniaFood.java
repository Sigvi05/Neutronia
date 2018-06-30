package net.hdt.neutronia.items;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.util.idk.FoodValueHandler;
import net.hdt.neutronia.util.idk.RomanNumberHelper;
import net.hdt.neutronia.util.idk.TimeHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import java.util.List;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class ItemAnimaniaFood extends ItemModFood {

    private PotionEffect[] effects;
    private String name;

    public ItemAnimaniaFood(int amount, float saturation, boolean isWolfFood, String name, PotionEffect... potionEffects) {
        super(MOD_ID, name, Main.ITEM_EXPANSION_TAB, amount, saturation, isWolfFood);
        this.effects = potionEffects;
        this.name = name;
        this.setAlwaysEdible();

    }

    public ItemAnimaniaFood(int amount, float saturation, String name) {
        this(amount, saturation, true, name);
    }

    public ItemAnimaniaFood(int amount, float saturation, String name, PotionEffect... potionEffects) {
        this(amount, saturation, true, name, potionEffects);
    }

    @Override
    public int getHealAmount(ItemStack stack) {
        Item item = stack.getItem();
        if (FoodValueHandler.hasOverride(item))
            return FoodValueHandler.getHealAmount(item);
        else
            return super.getHealAmount(stack);
    }

    @Override
    public float getSaturationModifier(ItemStack stack) {
        Item item = stack.getItem();
        if (FoodValueHandler.hasOverride(item))
            return FoodValueHandler.getSaturation(item);
        else
            return super.getSaturationModifier(stack);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemstack) {
        return EnumAction.EAT;
    }

    public String getName() {
        return this.name;
    }

    @Override
    protected void onFoodEaten(ItemStack itemstack, World worldObj, EntityPlayer entityplayer) {
        if (!worldObj.isRemote && /*AnimaniaConfig.gameRules.foodsGiveBonusEffects && */this.effects != null)
            for (PotionEffect effect : this.effects.clone()) {
                Potion pot = effect.getPotion();
                int duration = effect.getDuration();
                int amplifier = effect.getAmplifier();
                boolean isAmbient = effect.getIsAmbient();
                entityplayer.addPotionEffect(new PotionEffect(pot, duration, amplifier, isAmbient, false));
            }
    }


    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
//        if (AnimaniaConfig.gameRules.foodsGiveBonusEffects && this.effects != null)
            for (PotionEffect effect : this.effects.clone()) {
                Potion pot = effect.getPotion();
                int duration = effect.getDuration();
                int amplifier = effect.getAmplifier();
                boolean isInstant = pot.isInstant();
                boolean isPositive = pot.isBeneficial();
                String name = pot.getRegistryName().getResourcePath().replace("_", "");
                if (isPositive)
                    tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("tooltip.an." + name) + " " + RomanNumberHelper.toRoman(amplifier + 1) + (!isInstant ? " (" + TimeHelper.getTime(duration) + ")" : ""));
            }

        tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.an.edibleanytime"));

    }

}