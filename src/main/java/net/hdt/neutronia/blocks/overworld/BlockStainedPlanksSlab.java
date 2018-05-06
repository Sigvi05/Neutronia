package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.modules.building.blocks.BlockStainedPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.huskylib2.interf.IRecipeGrouped;

public class BlockStainedPlanksSlab extends BlockOverworldSlabBase implements IRecipeGrouped {

    public BlockStainedPlanksSlab(BlockStainedPlanks.Variants variant, boolean doubleSlab) {
        super(variant.getName() + "_slab", Material.WOOD, doubleSlab);
        setHardness(2.0F);
        setResistance(5.0F);
        setSoundType(SoundType.WOOD);
    }

    @Override
    public String getRecipeGroup() {
        return "stained_planks_slab";
    }

}