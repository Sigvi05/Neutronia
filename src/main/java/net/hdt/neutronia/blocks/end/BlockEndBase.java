package net.hdt.neutronia.blocks.end;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;

public class BlockEndBase extends BlockMod {

    public BlockEndBase(Material material, String name) {
        super(material, Reference.MOD_ID, name);
        setCreativeTab(Main.END_EXPANSION_TAB);
        setHardness(3.0F);
        setResistance(15.0F);
    }

}
