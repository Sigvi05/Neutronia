/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [29/06/2016, 17:48:35 (GMT)]
 */
package net.hdt.neutronia.modules.building.features;

import net.hdt.neutronia.modules.building.blocks.BlockMidori;
import net.hdt.neutronia.modules.building.blocks.BlockMidoriPillar;
import net.hdt.neutronia.modules.building.blocks.slab.BlockMidoriSlab;
import net.hdt.neutronia.modules.building.blocks.stairs.BlockMidoriStairs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.GlobalConfig;

public class MidoriBlocks extends Feature {

    public static Block midori_block;
    public static Block midori_pillar;

    boolean enableWalls;

    @Override
    public void setupConfig() {
        enableWalls = loadPropBool("Enable walls", "", true) && GlobalConfig.enableVariants;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        midori_block = new BlockMidori();
        midori_pillar = new BlockMidoriPillar();

        BlockModSlab slab = new BlockMidoriSlab(false);
        BlockModStairs.initStairs(midori_block, 0, new BlockMidoriStairs());
        BlockModSlab.initSlab(midori_block, 0, slab, new BlockMidoriSlab(true));

        VanillaWalls.add("midori_block", midori_block, 0, enableWalls);

		/*RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(midori_block, 4),
				"GG", "GG",
				'G', ProxyRegistry.newStack(Items.DYE, 1, 2));
		RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(midori_pillar),
				"S", "S",
				'S', ProxyRegistry.newStack(slab));*/
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
