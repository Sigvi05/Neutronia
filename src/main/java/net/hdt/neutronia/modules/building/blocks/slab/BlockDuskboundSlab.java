package net.hdt.neutronia.modules.building.blocks.slab;

import net.hdt.neutronia.blocks.nether.BlockNetherSlabBase;
import net.minecraft.block.SoundType;

public class BlockDuskboundSlab extends BlockNetherSlabBase {

    public BlockDuskboundSlab(boolean doubleSlab) {
        super("duskbound_block_slab", doubleSlab);
        setHardness(1.5F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
    }

}
