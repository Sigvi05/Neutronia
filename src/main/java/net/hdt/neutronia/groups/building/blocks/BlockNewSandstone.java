package net.hdt.neutronia.groups.building.blocks;

import net.hdt.huskylib2.block.BlockMetaVariants;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockNewSandstone extends BlockMetaVariants implements INeutroniaBlock {

    public BlockNewSandstone() {
        super("sandstone_new", Material.ROCK, Variants.class);
        setHardness(0.8F);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public boolean shouldDisplayVariant(int variant) {
        return variant < 4;
    }

    public enum Variants implements EnumBase {
        SANDSTONE_SMOOTH(false, true),
        SANDSTONE_BRICKS(true, true),
        RED_SANDSTONE_SMOOTH(false, true),
        RED_SANDSTONE_BRICKS(true, true);

        public final boolean stairs, slabs;

        Variants(boolean stairs, boolean slabs) {
            this.stairs = stairs;
            this.slabs = slabs;
        }
    }

}
