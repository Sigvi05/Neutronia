package net.hdt.neutronia.blocks.end;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.neutronia.base.util.Reference;
import net.minecraft.block.material.Material;

public class BlockEndBase extends BlockMod {

    public BlockEndBase(Material material, String name) {
        super(material, Reference.MOD_ID, name);
//        setCreativeTab(NeutroniaMain.END_EXPANSION_TAB);
        setHardness(3.0F);
        setResistance(15.0F);
    }

}
