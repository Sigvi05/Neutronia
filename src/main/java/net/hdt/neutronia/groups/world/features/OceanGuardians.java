package net.hdt.neutronia.groups.world.features;

import com.google.common.collect.ImmutableSet;
import net.hdt.neutronia.base.lib.LibObfuscation;
import net.hdt.neutronia.base.groups.Feature;
import net.hdt.neutronia.groups.world.client.sound.GuardianSound2UnderwaterBoogaloo;
import net.minecraft.client.audio.GuardianSound;
import net.minecraft.client.audio.ISound;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;

public class OceanGuardians extends Feature {

	boolean deepOceanOnly;
	int weight, min, max;
	boolean tweakSound;

	@Override
	public void setupConfig() {
		deepOceanOnly = loadPropBool("Deep ocean only", "", true);
		weight = loadPropInt("Spawn Weight", "Squids have 10. The higher, the more will spawn. (Note that guardians only spawn 5% of the time, so the default 4 is actually 0.8)", 4);
		min = loadPropInt("Smallest spawn group", "", 1);
		max = loadPropInt("Largest spawn group", "", 3);
		tweakSound = loadPropBool("Shut Guardians Up", "Disables guardians' attack sound if they aren't attacking a player", true);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Set<Biome> set = deepOceanOnly ? ImmutableSet.of(Biomes.DEEP_OCEAN) : ImmutableSet.of(Biomes.OCEAN, Biomes.DEEP_OCEAN);

		for(Biome b : set)
			b.getSpawnableList(EnumCreatureType.MONSTER).add(new SpawnListEntry(EntityGuardian.class, weight, min, max));
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onSound(PlaySoundEvent event) {
		if(!tweakSound)
			return;

		ISound sound = event.getSound();
		if(sound instanceof GuardianSound) {
			GuardianSound gsound = (GuardianSound) sound;
			EntityGuardian guardian = ReflectionHelper.getPrivateValue(GuardianSound.class, gsound, LibObfuscation.GUARDIAN);
			event.setResultSound(new GuardianSound2UnderwaterBoogaloo(guardian));
		}
	}

	@Override
	public boolean hasSubscriptions() {
		return isClient();
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

}
