package net.hdt.neutronia.dying_system_rewamp;

import net.hdt.huskylib2.blocks.BlockMod;
import net.minecraft.block.material.Material;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockWool extends BlockMod {

    public BlockWool(EnumDyeColor color) {
        super(Material.CLOTH, MOD_ID, color.getChatColor() + String.format(color.getName(), "_wool"));
    }

}
