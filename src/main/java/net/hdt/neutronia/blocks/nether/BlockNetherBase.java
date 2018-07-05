package net.hdt.neutronia.blocks.nether;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.neutronia.init.NCreativeTabs;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.material.Material;

public class BlockNetherBase extends BlockMod {

    public BlockNetherBase(Material material, String name) {
        super(material, Reference.MOD_ID, name);
        setCreativeTab(NCreativeTabs.NETHER_EXPANSION_TAB);
    }

}
