package net.hdt.neutronia.modules.world.client.sound;

import net.minecraft.client.audio.GuardianSound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.player.EntityPlayer;

public class GuardianSound2UnderwaterBoogaloo extends GuardianSound {

	EntityGuardian visibleGuardian;

	public GuardianSound2UnderwaterBoogaloo(EntityGuardian guardian) {
		super(guardian);
		visibleGuardian = guardian;
	}

	@Override
	public void update() {
		EntityLivingBase target = visibleGuardian.getTargetedEntity();
		if(target == null || !(target instanceof EntityPlayer)) {
			donePlaying = true;
			return;
		}

		super.update();
	}

}