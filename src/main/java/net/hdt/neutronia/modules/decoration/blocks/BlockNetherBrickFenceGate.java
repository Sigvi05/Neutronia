package net.hdt.neutronia.modules.decoration.blocks;

import net.hdt.neutronia.base.blocks.BlockNeutroniaFenceGate;
import net.minecraft.block.SoundType;

public class BlockNetherBrickFenceGate extends BlockNeutroniaFenceGate {

	public BlockNetherBrickFenceGate() {
		super("nether_brick_fence_gate");
		setHardness(2.0F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);
	}

}