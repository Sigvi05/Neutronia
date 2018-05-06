package net.hdt.neutronia.properties;

import com.google.common.collect.Maps;
import net.hdt.neutronia.items.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

import java.util.Map;

public enum FishType implements IStringSerializable {
    COD(0, "cod", 2, 0.1F, 5, 0.6F),
    SALMON(1, "salmon", 2, 0.1F, 6, 0.8F),
    CLOWNFISH(2, "clownfish", 1, 0.1F),
    PUFFERFISH(3, "pufferfish", 1, 0.1F);

    /**
     * Maps an item damage value for an ItemStack to the corresponding FishType value.
     */
    private static final Map<Integer, FishType> META_LOOKUP = Maps.newHashMap();

    static {
        for (FishType itemfishfood$fishtype : values()) {
            META_LOOKUP.put(itemfishfood$fishtype.getMetadata(), itemfishfood$fishtype);
        }
    }

    /**
     * The item damage value on an ItemStack that represents this fish type
     */
    private final int meta;
    /**
     * The value that this fish type uses to replace "XYZ" in: "fish.XYZ.raw" / "fish.XYZ.cooked" for the
     * unlocalized name and "fish_XYZ_raw" / "fish_XYZ_cooked" for the icon string.
     */
    private final String unlocalizedName;
    /**
     * The amount that eating the uncooked version of this fish should heal the player.
     */
    private final int uncookedHealAmount;
    /**
     * The saturation modifier to apply to the heal amount when the player eats the uncooked version of this fish.
     */
    private final float uncookedSaturationModifier;
    /**
     * The amount that eating the cooked version of this fish should heal the player.
     */
    private final int cookedHealAmount;
    /**
     * The saturation modifier to apply to the heal amount when the player eats the cooked version of this fish.
     */
    private final float cookedSaturationModifier;
    /**
     * Indicates whether this type of fish has "raw" and "cooked" variants
     */
    private final boolean cookable;

    FishType(int meta, String unlocalizedName, int uncookedHeal, float uncookedSaturation, int cookedHeal, float cookedSaturation) {
        this.meta = meta;
        this.unlocalizedName = unlocalizedName;
        this.uncookedHealAmount = uncookedHeal;
        this.uncookedSaturationModifier = uncookedSaturation;
        this.cookedHealAmount = cookedHeal;
        this.cookedSaturationModifier = cookedSaturation;
        this.cookable = true;
    }

    FishType(int meta, String unlocalizedName, int uncookedHeal, float uncookedSaturation) {
        this.meta = meta;
        this.unlocalizedName = unlocalizedName;
        this.uncookedHealAmount = uncookedHeal;
        this.uncookedSaturationModifier = uncookedSaturation;
        this.cookedHealAmount = 0;
        this.cookedSaturationModifier = 0.0F;
        this.cookable = false;
    }

    /**
     * Gets the corresponding FishType value for the given item damage value of an ItemStack, defaulting to COD for
     * unrecognized damage values.
     */
    public static FishType byMetadata(int meta) {
        FishType itemfishfood$fishtype = META_LOOKUP.get(meta);
        return itemfishfood$fishtype == null ? COD : itemfishfood$fishtype;
    }

    /**
     * Gets the FishType that corresponds to the given ItemStack, defaulting to COD if the given ItemStack does not
     * actually contain a fish.
     */
    public static FishType byItemStack(ItemStack stack) {
        return stack.getItem() instanceof ItemFishFood ? byMetadata(stack.getMetadata()) : COD;
    }

    /**
     * Gets the item damage value on an ItemStack that represents this fish type
     */
    public int getMetadata() {
        return this.meta;
    }

    /**
     * Gets the value that this fish type uses to replace "XYZ" in: "fish.XYZ.raw" / "fish.XYZ.cooked" for the
     * unlocalized name and "fish_XYZ_raw" / "fish_XYZ_cooked" for the icon string.
     */
    public String getName() {
        return this.unlocalizedName;
    }

    /**
     * Gets the amount that eating the uncooked version of this fish should heal the player.
     */
    public int getUncookedHealAmount() {
        return this.uncookedHealAmount;
    }

    /**
     * Gets the saturation modifier to apply to the heal amount when the player eats the uncooked version of this
     * fish.
     */
    public float getUncookedSaturationModifier() {
        return this.uncookedSaturationModifier;
    }

    /**
     * Gets the amount that eating the cooked version of this fish should heal the player.
     */
    public int getCookedHealAmount() {
        return this.cookedHealAmount;
    }

    /**
     * Gets the saturation modifier to apply to the heal amount when the player eats the cooked version of this
     * fish.
     */
    public float getCookedSaturationModifier() {
        return this.cookedSaturationModifier;
    }

    /**
     * Gets a value indicating whether this type of fish has "raw" and "cooked" variants.
     */
    public boolean canCook() {
        return this.cookable;
    }
}