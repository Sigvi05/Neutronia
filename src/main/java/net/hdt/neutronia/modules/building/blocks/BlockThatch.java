/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [20/03/2016, 22:41:27 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks;

import net.hdt.neutronia.modules.building.features.Thatch;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockThatch extends BlockMod implements IModBlock {

    public BlockThatch() {
        super(Material.GRASS, MOD_ID, "thatch");
        setHardness(0.5F);
        setSoundType(SoundType.PLANT);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        entityIn.fall(fallDistance, Thatch.fallDamageMultiplier);
    }

}
