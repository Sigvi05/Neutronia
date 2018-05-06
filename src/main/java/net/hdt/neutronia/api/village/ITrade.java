package net.hdt.neutronia.api.village;

import net.minecraft.village.MerchantRecipe;

public interface ITrade {
    MerchantRecipe randomize();

    int getTradeLevel();
}
