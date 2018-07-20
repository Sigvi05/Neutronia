/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 *
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 *
 * File Created @ [20/03/2016, 19:58:13 (GMT)]
 */
package net.hdt.neutronia.modules.building.blocks;

import net.hdt.huskylib2.blocks.BlockMetaVariants;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.base.module.ModuleLoader;
import net.hdt.neutronia.modules.building.features.WorldStoneBricks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.function.Supplier;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class BlockWorldStoneBricks extends BlockMetaVariants implements INeutroniaBlock {

	public BlockWorldStoneBricks() {
		super("world_stone_bricks", MOD_ID, Material.ROCK, Variants.class);
		setHardness(1.5F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	@Override
	public boolean shouldDisplayVariant(int variant) {
		return Variants.class.getEnumConstants()[variant].isEnabled();
	}

	public enum Variants implements EnumBase {
		
		STONE_GRANITE_BRICKS(WorldStoneBricks.class),
		STONE_DIORITE_BRICKS(WorldStoneBricks.class),
		STONE_ANDESITE_BRICKS(WorldStoneBricks.class);
		
		private Variants(Class<? extends Feature> clazz) {
			this(clazz, () -> true);
		}
		
		private Variants(Class<? extends Feature> clazz, Supplier<Boolean> enabledCond) {
			featureLink = clazz;
			this.enabledCond = enabledCond;
		}
		
		public final Class<? extends Feature> featureLink;
		private final Supplier<Boolean> enabledCond;
		
		public boolean isEnabled() {
			return ModuleLoader.isFeatureEnabled(featureLink) && enabledCond.get();
		}
		
	}

}
