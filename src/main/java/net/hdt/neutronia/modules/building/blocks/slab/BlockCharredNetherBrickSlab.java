package net.hdt.neutronia.modules.building.blocks.slab;

import net.hdt.neutronia.blocks.nether.BlockNetherSlabBase;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCharredNetherBrickSlab extends BlockNetherSlabBase {

    public BlockCharredNetherBrickSlab(boolean doubleSlab) {
        super("charred_nether_brick_slab", doubleSlab);
        setHardness(2.0F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }


}
