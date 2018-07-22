package net.hdt.neutronia.modules.world;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.world.features.Corals;
import net.hdt.neutronia.modules.world.features.NaturalAquamarine;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class NeutroniaWorld extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new Corals());
        registerFeature(new NaturalAquamarine());
//        registerFeature(new SeaPickles());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Blocks.IRON_ORE);
    }

}