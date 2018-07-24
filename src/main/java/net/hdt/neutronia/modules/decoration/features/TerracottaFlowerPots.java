package net.hdt.neutronia.modules.decoration.features;

import net.hdt.huskylib2.recipe.RecipeHandler;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.lib.LibMisc;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.modules.decoration.blocks.BlockTerracottaFlowerPot;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class TerracottaFlowerPots extends Feature {

	private static BlockTerracottaFlowerPot[] pots = new BlockTerracottaFlowerPot[16];
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		for(EnumDyeColor color : EnumDyeColor.values()) {
			pots[color.getMetadata()] = new BlockTerracottaFlowerPot(color);
			RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(pots[color.getMetadata()]), ProxyRegistry.newStack(Items.FLOWER_POT), LibMisc.OREDICT_DYES.get(color.getDyeDamage()));
		}
	}

	@Override
	public void initClient(FMLInitializationEvent event) {
        ItemColors items = Minecraft.getMinecraft().getItemColors();
        BlockColors blocks = Minecraft.getMinecraft().getBlockColors();

        IBlockColor handlerBlocks = (s, w, p, t) -> t == 0 ? ((BlockTerracottaFlowerPot) s.getBlock()).color.getColorValue() : 0xFFFFFF;
        IItemColor handlerItems = (s, t) -> blocks.colorMultiplier(((ItemBlock) s.getItem()).getBlock().getDefaultState(), null, null, t);
        Block[][] toColor = new Block[][] {
                pots
        };
        Block[] coloredStuff = new Block[16 * toColor.length];

        for(int i = 0; i < toColor.length; i++) {
            Block[] colored = toColor[i];
            System.arraycopy(colored, 0, coloredStuff, i * 16, 16);
        }
        blocks.registerBlockColorHandler(handlerBlocks, coloredStuff);
        items.registerItemColorHandler(handlerItems, coloredStuff);
	}

}