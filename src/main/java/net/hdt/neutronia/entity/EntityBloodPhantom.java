package net.hdt.neutronia.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EntityBloodPhantom extends EntityLiving {

    public EntityBloodPhantom(World worldIn) {
        super(worldIn);
        this.setHealth(this.getMaxHealth());
        setSize(0.5F, 0.5F);
    }

    protected void entityInit() {
        super.entityInit();
    }

}