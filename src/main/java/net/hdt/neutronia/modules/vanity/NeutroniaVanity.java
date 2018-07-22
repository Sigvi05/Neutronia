package net.hdt.neutronia.modules.vanity;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.vanity.feature.DyableElytra;
import net.hdt.neutronia.modules.vanity.feature.DyeItemNames;
import net.minecraft.item.ItemStack;

public class NeutroniaVanity extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new DyableElytra());
        registerFeature(new DyeItemNames());
    }

    @Override
    public ItemStack getIconStack() {
        return super.getIconStack();
    }

}
