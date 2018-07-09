package net.hdt.neutronia.init;

import net.hdt.neutronia.fluids.FluidTropicsWater;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;

import static net.hdt.neutronia.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class NFluids {

	public static final Fluid tropicsWater = new FluidTropicsWater("water");

	public static void preInit() {
		registerFluid(tropicsWater);
	}

	/**
	 * Initialization, called after TCBlockRegistry.init so the blocks are not null when
	 * matched up with the fluids
	 */
	public static void postInit() {
		NFluids.registerFluid(tropicsWater);
	}

	private static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
	}

}