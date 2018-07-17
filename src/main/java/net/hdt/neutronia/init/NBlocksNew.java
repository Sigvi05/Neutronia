package net.hdt.neutronia.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

//@AutoRegister(value = MOD_ID)
public class NBlocksNew {

    public static final Block black_sand = new BlockFalling().setTranslationKey("black_sand").setCreativeTab(NCreativeTabs.OVERWORLD_EXPANSION_TAB);
    public static final Block smooth_quartz = new Block(Material.ROCK).setTranslationKey("smooth_quartz").setCreativeTab(NCreativeTabs.OVERWORLD_EXPANSION_TAB);
    public static final Block smooth_sandstone = new Block(Material.ROCK).setTranslationKey("smooth_sandstone").setCreativeTab(NCreativeTabs.OVERWORLD_EXPANSION_TAB);
    public static final Block smooth_red_sandstone = new Block(Material.ROCK).setTranslationKey("smooth_red_sandstone").setCreativeTab(NCreativeTabs.OVERWORLD_EXPANSION_TAB);
    public static final Block quartz_bricks = new Block(Material.ROCK).setTranslationKey("quartz_bricks").setCreativeTab(NCreativeTabs.OVERWORLD_EXPANSION_TAB);
    public static final Block sandstone_bricks = new Block(Material.ROCK).setTranslationKey("sandstone_bricks").setCreativeTab(NCreativeTabs.OVERWORLD_EXPANSION_TAB);
    public static final Block red_sandstone_bricks = new Block(Material.ROCK).setTranslationKey("red_sandstone_bricks").setCreativeTab(NCreativeTabs.OVERWORLD_EXPANSION_TAB);

}
