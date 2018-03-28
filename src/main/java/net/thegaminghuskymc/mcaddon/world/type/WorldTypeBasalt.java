package net.thegaminghuskymc.mcaddon.world.type;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.thegaminghuskymc.mcaddon.init.BiomeInit;

public class WorldTypeBasalt extends WorldType {

	public WorldTypeBasalt()
	{
		super("basalt");
	}

	@Override
	public BiomeProvider getBiomeProvider(World world)
	{
		return new BiomeProviderSingle(BiomeInit.BASALT);
	}

}