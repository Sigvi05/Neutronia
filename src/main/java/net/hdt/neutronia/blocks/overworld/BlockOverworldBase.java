package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.material.Material;
import net.hdt.huskylib2.blocks.BlockMod;

public class BlockOverworldBase extends BlockMod {

    public BlockOverworldBase(Material material, String name) {
        super(material, Reference.MOD_ID, name);
        setCreativeTab(Main.OVERWORLD_EXPANSION_TAB);
    }

}
