/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [30/06/2016, 14:42:34 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMetaVariants;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockIronPlate extends BlockMetaVariants implements IModBlock {

    public BlockIronPlate() {
        super("iron_plate", MOD_ID, Material.IRON, Variants.class);
        setHardness(5.0F);
        setResistance(10.0F);
        setSoundType(SoundType.METAL);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public enum Variants implements BlockMetaVariants.EnumBase {
        IRON_PLATE,
        RUSTY_IRON_PLATE
    }

}
