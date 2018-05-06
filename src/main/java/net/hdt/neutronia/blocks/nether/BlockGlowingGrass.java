package net.hdt.neutronia.blocks.nether;

import net.hdt.neutronia.util.Reference;
import net.thegaminghuskymc.huskylib2.blocks.BlockLightSource;

public class BlockGlowingGrass extends BlockLightSource {

    public BlockGlowingGrass() {
        super(Reference.MOD_ID, "glowing_grass");
        this.setLightLevel(2.0F);
    }

}
