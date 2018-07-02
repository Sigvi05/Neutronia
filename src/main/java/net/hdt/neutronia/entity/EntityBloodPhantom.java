package net.hdt.neutronia.entity;

import net.minecraft.entity.EntityFlying;
import net.minecraft.world.World;

public class EntityBloodPhantom extends EntityFlying {

    public EntityBloodPhantom(World worldIn) {
        super(worldIn);
        this.setHealth(this.getMaxHealth());
        setSize(0.5F, 0.5F);
    }

    protected void entityInit() {
        super.entityInit();
    }

}