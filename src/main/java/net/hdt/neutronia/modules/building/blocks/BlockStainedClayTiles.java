/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * <p>
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * <p>
 * File Created @ [19/03/2016, 01:43:43 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMetaVariants;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockStainedClayTiles extends BlockMetaVariants implements IModBlock {

    public BlockStainedClayTiles() {
        super("stained_clay_tiles", MOD_ID, Material.ROCK, Variants.class);
        setHardness(1.25F);
        setResistance(7.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public enum Variants implements EnumBase {
        STAINED_CLAY_TILES_WHITE,
        STAINED_CLAY_TILES_ORANGE,
        STAINED_CLAY_TILES_MAGENTA,
        STAINED_CLAY_TILES_LIGHT_BLUE,
        STAINED_CLAY_TILES_YELLOW,
        STAINED_CLAY_TILES_LIME,
        STAINED_CLAY_TILES_PINK,
        STAINED_CLAY_TILES_GRAY,
        STAINED_CLAY_TILES_SILVER,
        STAINED_CLAY_TILES_CYAN,
        STAINED_CLAY_TILES_PURPLE,
        STAINED_CLAY_TILES_BLUE,
        STAINED_CLAY_TILES_BROWN,
        STAINED_CLAY_TILES_GREEN,
        STAINED_CLAY_TILES_RED,
        STAINED_CLAY_TILES_BLACK
    }

}
