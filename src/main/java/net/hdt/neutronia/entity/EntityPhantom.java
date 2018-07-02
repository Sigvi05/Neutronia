package net.hdt.neutronia.entity;

import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityPhantom extends EntityFlying {

    public EntityPhantom(World worldIn) {
        super(worldIn);
        this.setHealth(this.getMaxHealth());
        setSize(0.5F, 0.5F);
    }

    protected float getSoundVolume() {
        return 1.0F;
    }

    public boolean canAttackClass(Class<? extends EntityLivingBase> var1) {
        return true;
    }

}