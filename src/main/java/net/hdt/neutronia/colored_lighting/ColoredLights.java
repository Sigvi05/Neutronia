package net.hdt.neutronia.colored_lighting;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ColoredLights {

	public static boolean simulateTravel = false;

	public static void putColorsFlat(IBlockAccess world, IBlockState state, BlockPos pos, BufferBuilder buffer, BakedQuad quad, int lightColor) {
		BlockTinter.tintBlockFlat(world, state, pos, buffer, quad, lightColor);
	}
	
	public static void addLightSource(IBlockAccess access, BlockPos pos, IBlockState state) {
		ColoredLightSystem.addLightSource(access, pos, state);
	}

	@SubscribeEvent
	public void preRenderTick(TickEvent.RenderTickEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
		if(event.phase != TickEvent.Phase.START)
			return;
		
		ColoredLightSystem.tick(mc);
	}

}