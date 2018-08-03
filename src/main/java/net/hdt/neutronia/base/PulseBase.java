package net.hdt.neutronia.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Locale;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class PulseBase {
	/* Normal registration */
	protected static <T extends Block> T registerBlock(IForgeRegistry<Block> registry, T block, String name) {
		if(!name.equals(name.toLowerCase(Locale.US))) {
			throw new IllegalArgumentException(
					String.format("Unlocalized names need to be all lowercase! Block: %s", name));
		}

		String prefixedName = Util.prefix(name);
		block.setTranslationKey(prefixedName);

		register(registry, block, name);
		return block;
	}

	/**
	 * Sets the correct unlocalized name and registers the item.
	 */
	protected static <T extends Item> T registerItem(IForgeRegistry<Item> registry, T item, String name) {
		if(!name.equals(name.toLowerCase(Locale.US))) {
			throw new IllegalArgumentException(
					String.format("Unlocalized names need to be all lowercase! Item: %s", name));
		}
		item.setTranslationKey(Util.prefix(name));

		register(registry, item, name);
		return item;
	}

	/* Base methods */
	protected static <C extends T, T extends IForgeRegistryEntry<T>> C register(IForgeRegistry<T> registry, C thing, String name) {
		return register(registry, thing, Util.getResource(name));
	}

	protected static <C extends T, T extends IForgeRegistryEntry<T>> C register(IForgeRegistry<T> registry, C thing, ResourceLocation name) {
		thing.setRegistryName(name);
		registry.register(thing);
		return thing;
	}


	/* Tile Entity & Entity */
	protected static <T extends Entity> EntityEntryBuilder<T> getEntityBuilder(Class<T> clazz, String name, int id) {
		return EntityEntryBuilder.<T>create()
				.entity(clazz)
				.id(Util.getResource(name), id)
				.name(Util.prefix(name));
	}

	protected static void registerTE(Class<? extends TileEntity> teClazz, String name) {
		if(!name.equals(name.toLowerCase(Locale.US))) {
			throw new IllegalArgumentException(
					String.format("Unlocalized names need to be all lowercase! TE: %s", name));
		}

		GameRegistry.registerTileEntity(teClazz, Util.resource(name));
	}

	/* Other */
	protected static Fluid registerColoredFluid(String name, int color) {
		Fluid fluid = registerFluid(new Fluid(name, Util.getResource("blocks/fluid_colorless"), Util.getResource("blocks/fluid_colorless_flow"), color));
		FluidRegistry.addBucketForFluid(fluid);
		return fluid;
	}
	protected static <T extends Fluid> T registerFluid(T fluid) {
		fluid.setUnlocalizedName(Util.prefix(fluid.getName()));
		FluidRegistry.registerFluid(fluid);

		return fluid;
	}

	protected static void registerDispenserBehavior(Block block, IBehaviorDispenseItem behavior) {
		if(block != null) {
			registerDispenserBehavior(Item.getItemFromBlock(block), behavior);
		}
	}
	protected static void registerDispenserBehavior(Item item, IBehaviorDispenseItem behavior) {
		if(item != null) {
			BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(item, behavior);
		}
	}

	/**
	 * Adds entries from a loot table in the inspirations directory to a vanilla loot table
	 * @param event  LootTableLoadEvent
	 * @param name   Name of vanilla table and the inspirations table
	 */
	protected static void addToVanillaLoot(LootTableLoadEvent event, String name) {
		ResourceLocation extra = Util.getResource(name);
		event.getTable().addPool(new LootPool(
				new LootEntry[]{new LootEntryTable(extra, 1, 0, new LootCondition[0], MOD_ID)},
				new LootCondition[0],
				new RandomValueRange(1.0f),
				new RandomValueRange(0.0F),
				MOD_ID
				));
	}
}