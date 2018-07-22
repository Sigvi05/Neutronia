package net.hdt.neutronia.modules.tweaks;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.tweaks.features.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class NeutroniaTweaks extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new ArmedArmorStands());
        registerFeature(new BabyZombiesBurn());
        registerFeature(new CompassesWorkEverywhere());
        registerFeature(new HoeSickle());
        registerFeature(new ImprovedSleeping());
        registerFeature(new ImprovedStoneToolCrafting());
        registerFeature(new RemoveSnowLayers());
        registerFeature(new SlabsToBlocks());
        registerFeature(new SquidsInkYou());
        registerFeature(new StackableItems());
        registerFeature(new StairsMakeMore());
        registerFeature(new TorchesBurnInFurnaces());
        registerFeature(new BlastproofShulkerBoxes());
        registerFeature(new ChickensShedFeathers());
        registerFeature(new AxesBreakLeaves());
        registerFeature(new ConvertClay());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Items.IRON_PICKAXE);
    }

}