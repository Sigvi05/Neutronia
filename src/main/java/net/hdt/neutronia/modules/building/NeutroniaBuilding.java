package net.hdt.neutronia.modules.building;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.building.features.*;
import net.minecraft.item.ItemStack;

public class NeutroniaBuilding extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new BarkBlocks());
        registerFeature(new CarvedWood());
        registerFeature(new SoulSandstone());
        registerFeature(new VanillaStairsAndSlabs());
        registerFeature(new VanillaWalls());
        registerFeature(new WorldStoneBricks());
        registerFeature(new LogBlocks());
        registerFeature(new WoodBlocks());
    }

    @Override
    public ItemStack getIconStack() {
        return super.getIconStack();
    }

}
