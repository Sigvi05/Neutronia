package net.hdt.neutronia.modules.building.blocks.slab;

import net.hdt.neutronia.blocks.nether.BlockNetherSlabBase;
import net.minecraft.block.SoundType;

public class BlockSoulSandstoneSlab extends BlockNetherSlabBase {

    public BlockSoulSandstoneSlab(boolean doubleSlab) {
        super("soul_sandstone_slab", doubleSlab);
        setHardness(1F);
        setSoundType(SoundType.STONE);
    }

}
