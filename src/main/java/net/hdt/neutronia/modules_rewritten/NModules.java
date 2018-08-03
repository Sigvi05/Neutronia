package net.hdt.neutronia.modules_rewritten;

import net.hdt.neutronia.base.module_rewrite.Module;
import net.hdt.neutronia.modules_rewritten.building.features.TestBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class NModules {

    public static Module testBuilding;

    public static void registerModules() {
        testBuilding = Module.builder()
                .withName("Test Building")
                .withDesc("This is the building module")
                .withIcon(new ItemStack(Blocks.STONE))
                .withFeature(new TestBlocks())
                .register();
//        testBuilding.registerFeature(new TestBlocks());
    }

}
