package net.hdt.neutronia.blocks.overworld;

import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.neutronia.Main;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BlockOverworldBase extends BlockMod {

    public BlockOverworldBase(Material material, String name, boolean flammable) {
        super(material, Reference.MOD_ID, name);
        setCreativeTab(Main.OVERWORLD_EXPANSION_TAB);

        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 0);
        if(flammable) {
            addFlammable(this);
        }
    }

    public static void addFlammable(Block block) {
        Blocks.FIRE.setFireInfo(block, 5, 20);
    }

}
