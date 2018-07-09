package net.hdt.neutronia.blocks.nether;

import net.hdt.huskylib2.blocks.BlockLightSource;
import net.hdt.neutronia.util.Reference;

public class BlockGlowingGrass extends BlockLightSource {

    public BlockGlowingGrass() {
        super(Reference.MOD_ID, "glowing_grass");
        this.setLightLevel(2.0F);
    }

}
