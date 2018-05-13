/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [06/06/2016, 23:10:28 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks;

import net.hdt.neutronia.modules.building.features.SoulSandstone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMetaVariants;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;
import net.thegaminghuskymc.huskylib2.module.ModuleLoader;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockNewSandstone extends BlockMetaVariants implements IModBlock {

    public BlockNewSandstone() {
        super("sandstone_new", MOD_ID, Material.ROCK, Variants.class);
        setHardness(0.8F);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public boolean shouldDisplayVariant(int variant) {
        return ModuleLoader.isFeatureEnabled(SoulSandstone.class) || variant < 4;
    }

    public enum Variants implements EnumBase {
        SANDSTONE_SMOOTH(false, true),
        SANDSTONE_BRICKS(true, true),
        RED_SANDSTONE_SMOOTH(false, true),
        RED_SANDSTONE_BRICKS(true, true),
        SOUL_SANDSTONE_SMOOTH(false, true),
        SOUL_SANDSTONE_BRICKS(true, true);

        public final boolean stairs, slabs;

        Variants(boolean stairs, boolean slabs) {
            this.stairs = stairs;
            this.slabs = slabs;
        }
    }

}
