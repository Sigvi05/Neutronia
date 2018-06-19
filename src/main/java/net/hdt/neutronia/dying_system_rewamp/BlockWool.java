package net.hdt.neutronia.dying_system_rewamp;

import net.hdt.huskylib2.blocks.BlockMod;
import net.minecraft.block.material.Material;

public class BlockWool extends BlockMod {

    public BlockWool(EnumDyeColor color) {
        super(Material.CLOTH, "rds", String.format(color.getName(), "_wool"));
        setCreativeTab(RevampedColoringSystemMod.BLOCKS);
    }

}
