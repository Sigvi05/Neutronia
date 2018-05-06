package net.hdt.neutronia.blocks.nether;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;

public class BlockNetherBase extends BlockMod {

    public BlockNetherBase(Material material, String name) {
        super(material, Reference.MOD_ID, name);
        setCreativeTab(Main.NETHER_EXPANSION_TAB);
    }

}
