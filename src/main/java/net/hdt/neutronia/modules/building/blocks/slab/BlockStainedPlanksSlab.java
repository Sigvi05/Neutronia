/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [20/03/2016, 18:31:18 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks.slab;

import net.hdt.neutronia.blocks.overworld.BlockOverworldSlabBase;
import net.hdt.neutronia.modules.building.blocks.BlockStainedPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.interf.IRecipeGrouped;

public class BlockStainedPlanksSlab extends BlockOverworldSlabBase implements IRecipeGrouped {

    public BlockStainedPlanksSlab(BlockStainedPlanks.Variants variant, boolean doubleSlab) {
        super(variant.getName() + "_slab", Material.WOOD, doubleSlab);
        setHardness(2.0F);
        setResistance(5.0F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public String getRecipeGroup() {
        return "stained_planks_slab";
    }

}
