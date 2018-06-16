package net.hdt.neutronia.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class FluidTropicsWater extends Fluid {

	public FluidTropicsWater(String fluidName) {
		super(fluidName, new ResourceLocation(MOD_ID + ":blocks/tropics_water_still"),
				new ResourceLocation(MOD_ID + ":blocks/tropics_water_flowing"));
	}

}