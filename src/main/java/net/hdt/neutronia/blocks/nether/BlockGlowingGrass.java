package net.hdt.neutronia.blocks.nether;

import net.hdt.neutronia.blocks.base.BlockLightSource;

public class BlockGlowingGrass extends BlockLightSource {

    public BlockGlowingGrass() {
        super("glowing_grass");
        this.setLightLevel(2.0F);
    }

}
